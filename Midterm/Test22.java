import java.util.Scanner;
import java.text.DecimalFormat;

public class Test22 {
    public static void main(String[] args) {
        System.out.print("輸入值n為：");
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.#");
        double n = sc.nextDouble();
        while(n != -1) {
            double result = (n*n*n)/3;
            System.out.println(df.format(result));
            System.out.print("輸入值n為：");
            n = sc.nextDouble();
        }
    }
}
