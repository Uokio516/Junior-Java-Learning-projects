
import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in); //初始化 Scanner 物件
            
    int a,b,cost;
    System.out.print("輸入月租費型式及通話費時間為:");
    String sc = scanner.next() ;
    scanner.close();
    String[] scratchpad = sc.split(",") ;
    a = Integer.parseInt(scratchpad[0]) ;
    b = Integer.parseInt(scratchpad[1]) ;
    cost=0;
    switch (a) {
        case 186:
            cost= (int) (Math.round(b*0.09));
            if (a>b) {
                cost=a;
            } else if (b/a<=1) {
                cost= (int) (cost*0.9);
            }
            else {
                cost= (int) (cost*0.8);
            }
            break;
        case 386:
            cost= (int) (Math.round(b*0.08));
            if (a>b) {
                cost=a;
            } else if (b/a<=1) {
                cost= (int) (cost*0.8f);
            }
            else {
                cost= (int) (cost*0.7f);
            }
            break;
        case 586:
            cost= (int) (Math.round(b*0.07));
            if (a>b) {
                cost=a;
            } else if (b/a<=1) {
                cost= (int) (cost*0.7);
            }
            else {
                cost= (int) (cost*0.6);
            }
            break;
        case 986:
            cost= (int) Math.round((b*0.06));
            if (a>b) {
                cost=a;
            } else if (b/a<=1) {
                cost= (int) (cost*0.6);
            }
            else {
                cost= (int) (cost*0.5);
            }
            break;
        default:
            System.out.println("請輸入正確數值");
    }
    
    System.out.printf("通話費為："+ cost);

}




}
