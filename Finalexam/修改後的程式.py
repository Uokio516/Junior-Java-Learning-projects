import machine, time
import urequests

#################################
# 開機時，先叫一聲、LED 先閃 1 下
led = machine.Pin(22, machine.Pin.OUT, value=1)
beeper = machine.PWM(machine.Pin(0), freq=523, duty=512)

led.value(1)
time.sleep(0.5)
beeper.deinit()
led.value(0)
time.sleep(1.5)

#################################
# 設定參數
import micropython
Version = micropython.const("main_v15")
VersionTime = micropython.const("2023/01/27 04:00")
SensorUUID = micropython.const("NKUST01")  # 裝置的 UUID
print("************************")
print("Version: "+Version)
print("Date: "+VersionTime)
print("UUID: "+SensorUUID)

SSID=""            # 無線網路 SSID
IP=""              # IP 位址
hasOLED = True     # 是否有偵測到(安裝) OLED
sleepSeconds = 600  # 睡眠幾秒
waterSeconds = 5   # 每次澆水幾秒
soilDry = 668      #土壤溼度值(乾燥)，大於表示過於乾燥
givenWater = False

airTemp = 0  # 空氣溫度
airHum = 0    # 空氣溼度
soilMois = 0 # 土壞溫度
soilTemp = 0 # 土壞溼度
isWatering = 0 # 澆水 (1:澆水，0:沒澆水)
isWaterScarcity = 0  # 缺水警告

# 加入資料結構作法的程式 -- 宣告陣列
array_airTemperature = []
array_airHumidity = []


###########################
# 設定 OLED Pin 腳位
import ssd1306
i2c = machine.SoftI2C(scl=machine.Pin(5), sda=machine.Pin(4), freq=100000)
i2cDevices = i2c.scan()

# 檢查有沒有裝 OLED
if 0x3c in i2cDevices:
    oled = ssd1306.SSD1306_I2C(128, 64, i2c, 0x3c)
    hasOLED = True
else:
    hasOLED = False

###########################
# 進入深度睡眠模式 deep sleep
def deep_sleep(secs):
    # configure input RTC pin with pull-up on boot
    pin = machine.Pin(2, machine.Pin.IN, machine.Pin.PULL_UP)

    # disable pull-up and put the device to sleep for 10 seconds
    pin.init(pull=None)
    machine.deepsleep(secs*1000)

###########################
# 連接 Wifi
import network
def do_connect():
    global SSID, IP
    wlan = network.WLAN(network.STA_IF)
    wlan.active(True)
    # 掃瞄 wifi 品質，並連線最強訊號的 SSID, SSID 的密碼都是 "actubctu"
    connSSID = 'Wifi_IoT'
    connRSSI = -999
    allSSID = ["dlink-50A5", "Wifi_IoT", "PokaiPixel3XL"]
    
    nets = wlan.scan()
    for net in nets:
        if bytes.decode(net[0]) in allSSID:
            print('{} ({})'.format(bytes.decode(net[0]),net[3]))
            
            if net[3] >= connRSSI :
                connSSID = bytes.decode(net[0])
                connRSSI = net[3]
    
    if wlan.isconnected() and wlan.config('essid') != connSSID:
        print("Disconnect ("+wlan.config('essid')+") and reconnect "+connSSID )
        wlan.disconnect()
        
    if not wlan.isconnected():
        print('connecting to network: '+connSSID)
        wlan.connect(connSSID, '27676625')
        while not wlan.isconnected():
            pass
        
    print('network config:', wlan.ifconfig())
    
    SSID = wlan.config('essid')
    IP = wlan.ifconfig()[0]
# 目前不用記錄無線網卡的 MAC Address，所以註解掉
#     import ubinascii
#     MAC = ubinascii.hexlify( wlan.config('mac') ).decode()
    
    try:
        import ntptime     # 連線無線網路時，就同步時間
        ntptime.settime()
    except OSError:
        print("同步時間錯誤。")

################################################
# DHT22 空氣溫溼度 Pin 腳位 D6(GPIO12)
def readDHT():
    import dht
    airDHT = dht.DHT22(machine.Pin(33))
    try:
        airDHT.measure()
        airTemp = round(airDHT.temperature(),1)
        airHum = round(airDHT.humidity(),1)
        return (airTemp, airHum)
    except OSError:
        return [0,0]

###########################
# 設定土壤溫度 Pin 腳位
def readSoilTemp():
    import onewire, ds18x20
    ow = onewire.OneWire(machine.Pin(12)) # create a OneWire bus on GPIO14
    ow.scan()               # return a list of devices on the bus
    ds = ds18x20.DS18X20(ow)
    
    roms = ds.scan()    # scan for devices on the bus
    if roms==[]:
        return (0)
    else:
        ds.convert_temp()
        time.sleep_ms(750)
        
        # 下列 2 行程式，因為只有一個DS18B20，所以直接用 "ds.read_temp(roms[0])" 即可
        #for rom in roms:
        #    print(ds.read_temp(rom))
        soilTemp = round(ds.read_temp(roms[0]),1)
        return (soilTemp)

###########################
# 顯示數值
def showValues(i=0, msg=''):
    if hasOLED:
        oled.fill(0)
        if (msg !=''):
            oled.text(msg, 0, 0)
            oled.text('({})'.format(i), 0, 9)
        else:
            oled.text('ID:{} ({})'.format(SensorUUID,i), 0, 0)
            oled.text('Ver.:' + Version, 0, 9)
            #oled.text( VersionTime, 0, 9)
        
        rtc = machine.RTC().datetime()
        oled.text('{}/{:02}/{:02} {:02}:{:02}'.format(rtc[0],rtc[1],rtc[2],rtc[4]+8,rtc[5]), 0, 17)
        oled.text('Air Temp: {:.1f} C'.format(airTemp), 0, 33)
        oled.text('Air Hum : {:.1f} %'.format(airHum), 0, 41)
        oled.text('SoilTemp: {:.1f} C'.format(soilTemp), 0, 49)
        oled.text('SoilMois: {}'.format(soilMois), 0, 57)
        oled.show()

############################################
# 透過 MQTT 通訊，傳送數據到 ThingSpeak 平台
def sendMQTT(msg=''):
    from umqtt.simple import MQTTClient
    SERVER = "mqtt.thingspeak.com"
    client = MQTTClient("umqtt_client", SERVER)
    # channels/[CHANNEL_ID]/publish/[WRITE_API_KEY]
    topic = "channels/938160/publish/EMMXFFWB80SACYQU"

    if msg=='':
        payload = "field1="+str(airTemp)+"&field2="+str(airHum)+"&field3="+str(soilTemp)+"&field4="+str(soilMois)+"&field5="+str(isWatering)+"&field6="+str(isWaterScarcity)
    else:
        payload = msg
        #payload = "field5="+str(watering)+"&field6="+str(waterScarcity)

    client.connect()
    client.publish(topic, payload)
    client.disconnect()

###########################
# 傳 Line 訊息
def sendLineMsg(msg=""):
    ifttt_url = 'https://maker.ifttt.com/trigger/getmessage/with/key/h9jMlMKIxQhRvEvaofLF3'   # 黃柏凱
    ifttt_url = 'https://maker.ifttt.com/trigger/find_event/with/key/dWwyBf-aB99p64LcD0Kvu9'  # 忠義
    headers = {'Content-Type': "application/json", 'Accept': "application/json"}
    chatMsg = {"value1":""}
    chatMsg['value1'] = msg
    urequests.post(ifttt_url, json=chatMsg, headers=headers)

##################################################
# 加入資料結構作法的程式 -- 快速排序法
def QuickSort(aSort):
    n = len(aSort)
    if n <= 1:
        return aSort
    
    aLeft = []
    aRight = []
    nPivot = aSort[0]
    for i in range(1,n):
        if aSort[i] < nPivot:
            aLeft.append(aSort[i])
        else:
            aRight.append(aSort[i])
    
    return QuickSort(aLeft) + [nPivot] + QuickSort(aRight)
    
##################################################
# 加入資料結構作法的程式 -- 去除極端值後，再求平均數
def Trim_Mean(aSort, fPercentage):
    n = round(len(aSort) * fPercentage / 2)
    nSum = 0
    nCount = 0

    for i in range(n,len(aSort)-n):
        nSum += aSort[i]
        nCount += 1
        
    print("Sum =", nSum)
    print("Count =", nCount)
    return round(nSum/nCount, 1)

###########################
#    Start
###########################
if hasOLED:
    oled.fill(0)
    oled.text('Booting...', 0, 0)
    oled.show()
    print('Booting...')
else:
    print('Booting... without OLED.')

if machine.reset_cause() == machine.DEEPSLEEP_RESET:
    print('The system wakes from a deep sleep.')
    if hasOLED:
        oled.text('The system', 0, 17)
        oled.text('wakes from', 10, 25)
        oled.text('a deep sleep.', 20, 33)
        oled.show()

# 連接無線網路
do_connect()

print("")
count=0
while True:
    count+=1
    print(count)
    #do_connect()   ##  目前不需要每次都測試連 wifi
    
    # 顯示日期/時間
    rtc = machine.RTC().datetime()
    print('{}/{:02}/{:02} {:02}:{:02}'.format(rtc[0],rtc[1],rtc[2],rtc[4]+8,rtc[5]))
    
    # 讀取 DHT22 空氣溫溼度
    (airTemp, airHum) = readDHT()
    print('DHT22 Temperature  : {}{}C'.format(airTemp, '\u00b0'))
    print('DHT22 Humidity     : {}%'.format(airHum))
    # 加入資料結構作法的程式 -- 將感測值加入陣列
    array_airTemperature.append(airTemp)
    array_airHumidity.append(airHum)
    
    # 讀取土壤溫度
    soilTemp = readSoilTemp()
    print('Soil Temp    : {:.1f}{}C'.format(soilTemp, '\u00b0'))
    
    # 讀取土壤溼度 Soil Moisture
    adc = machine.ADC(machine.Pin(32))
    soilMois = adc.read()              # read value, 0-1023
    print('Soil Moisture: {}'.format(soilMois))
    
    print()
    
    # 設定澆水、缺水警告初始值
    isWatering = 0
    #isWaterScarcity = 0

    if hasOLED:
        showValues(count)
    
    if soilMois >= soilDry:
        # 澆水
        print("Start watering {} secs".format(waterSeconds))
        relay = machine.Pin(13, machine.Pin.OUT, value=0)
        #sendMQTT('field5=1')
        isWatering = 1
        if hasOLED:
            showValues(count,'Watering {} secs'.format(waterSeconds))
            
        relay.value(0)
        time.sleep(waterSeconds)
        givenWater = True
        
        print("End watering")
        relay.value(1)
        #sendMQTT('field5=0')
        if hasOLED:
            showValues(count)
        
        print("Waiting 5 secs, then detect [Soil Moisture]")   # 休息5秒，等待水份進入土壞
        time.sleep(5)
        # 讀取土壤溼度
        soilMois = adc.read()              # read value, 0-1023
        
        print("")
        
        # Bug備註：下面這一行 IF 的 soilDry 要改為澆水前的溼度，以判斷澆水後，土壤溼度是否有增加
        if soilMois >= soilDry and count>=2 :
            print("Warning: Water scarcity")  # 缺水警告
            
#             if isWaterScarcity == 0:
#                 sendLineMsg("Water scarcity")     # 傳送 Line 警告訊息

            isWaterScarcity = 1
            if hasOLED:
                showValues(count,'Water scarcity')
                
            for j in range(3):
                beeper = machine.PWM(machine.Pin(0), freq=523, duty=512)
                led.value(1)
                time.sleep(0.5)
                beeper.deinit()
                led.value(0)
                time.sleep(1.5)
            
            #sendMQTT('field6=0')
            if hasOLED:
                showValues(count)
    
#      print("Send data to ThingSpeak")  # 傳送資料到 ThingSpeak 平台
#      sendMQTT()
    
#     # 因為 ThingSpeak 免費版本，只能每隔 15 秒傳送一次資料，所以需休息幾秒
#     t = 15
#     if isWatering :
#         t = t - waterSeconds  # 如果有澆水的話，就減掉澆水時間
#     if isWaterScarcity :
#         t = t - 6  # 如果有缺水的話，就減掉傳送 LINE 警告訊息的時間
#     if count > 0:
#         print("Rest {} secs for upload data to ThingSpeak".format(t))
#         time.sleep(t)
    t = 5
    print("Rest {} secs".format(t))
    time.sleep(t)
    
    print("")
    #  抓 5 次資料後，就進入深度睡眠
    if count >= 5:
        # 加入資料結構作法的程式 -- 剔除兩側極端值再求平均值
        print("airTemperature: {}".format(array_airTemperature))
        array_airTemperature = QuickSort(array_airTemperature)
        print("QuickSort: {}".format(array_airTemperature))
        airTemp = Trim_Mean(array_airTemperature, 0.4)
        print("airTemp: {}".format(airTemp))
        
        print()
        print("airHumidity: {}".format(array_airHumidity))
        array_airHumidity = QuickSort(array_airHumidity)
        print("QuickSort: {}".format(array_airHumidity))
        airHum = Trim_Mean(array_airHumidity, 0.4)
        print("airHum: {}".format(airHum))
        
        print("Send data to ThingSpeak")  # 傳送資料到 ThingSpeak 平台
#         sendMQTT()

        print()
        print("Deep Sleep")
        print("Wake up after {} Sec.".format(sleepSeconds))
        
        if hasOLED:
            oled.fill(0)
            oled.text('Deep Sleep', 0, 0)
            oled.text('Wake up', 0, 17)
            oled.text('after {} Sec.'.format(sleepSeconds), 10, 25)
            oled.show()
            time.sleep(2)
            oled.fill(0)
            oled.show()

        # 進入深度睡眠模式
        deep_sleep(sleepSeconds)
    else:
        time.sleep(5)
