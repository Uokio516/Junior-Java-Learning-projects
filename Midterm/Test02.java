
import java.util.Scanner;

public class Test02 {

    public static void main(String[] args) {
        float sum1,sum2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("輸入一個正整數:");
        int i=scanner.nextInt();
        scanner.close();
        if ((int)i<=120)
        {

            sum1=i*2.1f;
            sum2=i*2.1f;
            System.out.println("夏季電費："+sum1);
            System.out.println("非夏季電費："+sum2);
        }else if(i>=121 && i<=330){

            sum1=(i-120)*3.02f+120*2.1f;
            sum2=(i-120)*2.68f+120*2.1f;
            System.out.println("夏季電費："+sum1);
            System.out.println("非夏季電費："+sum2);
        }else if(i>=331 && i<=500){

            sum1=(i-330)*4.39f+210*3.02f+120*2.1f;
            sum2=(i-330)*3.61f+210*2.68f+120*2.1f;
            System.out.println("夏季電費："+sum1);
            System.out.println("非夏季電費："+sum2);
        }else if(i>=501 && i<=700){

            sum1=(i-500)*4.97f+170*4.39f+210*3.02f+120*2.1f;
            sum2=(i-500)*4.01f+170*3.61f+210*2.68f+120*2.1f;
            System.out.println("夏季電費："+sum1);
            System.out.println("非夏季電費："+sum2);
        }else if(i>=701){

            sum1=(i-700)*5.63f+200*4.97f+170*4.39f+210*3.02f+120*2.1f;
            sum2=(i-700)*4.50f+200*4.01f+170*3.61f+210*2.68f+120*2.1f;
            System.out.println("夏季電費："+sum1);
            System.out.println("非夏季電費："+sum2);
        }else {
            System.out.println("請輸入正確數值");
        }
    }
    
}
