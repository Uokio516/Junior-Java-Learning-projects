/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.util.Scanner;
public class Test3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i,x;
        String[] d={"鼠","牛","虎","兔","龍","蛇","馬","羊","猴","雞","狗","豬"};
        System.out.println("請輸入西元年，並計算出生肖。");
        Scanner scanner = new Scanner(System.in);
        i=scanner.nextInt();
        scanner.close();
        if((int) i >=0){
            x=i%12-4;
            System.out.println("你的生肖為："+ d[x]);
        }else{
            System.out.println("請輸入正確數值!!!");
        }      
    }
    
}
