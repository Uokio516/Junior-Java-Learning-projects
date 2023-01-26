
import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in); //初始化 Scanner 物件
            
    int a,b,money;
    System.out.print("輸入月租費型式及通話費時間為:");
    String sc = scanner.next() ;
    scanner.close();
    String[] scratchpad = sc.split(",") ;
    a = Integer.parseInt(scratchpad[0]) ;
    b = Integer.parseInt(scratchpad[1]) ;
    money=0;
    switch (a) {
        case 186:
            money= (int) (Math.round(b*0.09));
            if (a>b) {
                money=a;
            } else if (b/a<=1) {
                money= (int) (money*0.9);
            }
            else {
                money= (int) (money*0.8);
            }
            break;
        case 386:
            money= (int) (Math.round(b*0.08));
            if (a>b) {
                money=a;
            } else if (b/a<=1) {
                money= (int) (money*0.8f);
            }
            else {
                money= (int) (money*0.7f);
            }
            break;
        case 586:
            money= (int) (Math.round(b*0.07));
            if (a>b) {
                money=a;
            } else if (b/a<=1) {
                money= (int) (money*0.7);
            }
            else {
                money= (int) (money*0.6);
            }
            break;
        case 986:
            money= (int) Math.round((b*0.06));
            if (a>b) {
                money=a;
            } else if (b/a<=1) {
                money= (int) (money*0.6);
            }
            else {
                money= (int) (money*0.5);
            }
            break;
        default:
            System.out.println("請輸入正確數值");
    }
    
    System.out.printf("通話費為："+ money);

}




}
