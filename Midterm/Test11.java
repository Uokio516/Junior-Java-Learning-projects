import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入你想查詢的星座年月日 例如：2002/05/16：");
        String date = sc.nextLine();
        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        String zodiac = "";
        if (month == 3 && day >= 21 || month == 4 && day <= 19) {
            zodiac = "白羊座";
        } else if (month == 4 && day >= 20 || month == 5 && day <= 20) {
            zodiac = "金牛座";
        } else if (month == 5 && day >= 21 || month == 6 && day <= 21) {
            zodiac = "雙子座";
        } else if (month == 6 && day >= 22 || month == 7 && day <= 22) {
            zodiac = "巨蟹座";
        } else if (month == 7 && day >= 23 || month == 8 && day <= 22) {
            zodiac = "獅子座";
        } else if (month == 8 && day >= 23 || month == 9 && day <= 22) {
            zodiac = "處女座";
        } else if (month == 9 && day >= 23 || month == 10 && day <= 22) {
            zodiac = "天秤座";
        } else if (month == 10 && day >= 23 || month == 11 && day <= 21) {
            zodiac = "天蠍座";
        } else if (month == 11 && day >= 22 || month == 12 && day <= 21) {
            zodiac = "射手座";
        } else if (month == 12 && day >= 22 || month == 1 && day <= 19) {
            zodiac = "摩羯座";
        } else if (month == 1 && day >= 20 || month == 2 && day <= 18) {
            zodiac = "水瓶座";
        } else {
            zodiac = "雙魚座";
        }
        System.out.println(zodiac);
    }
}
