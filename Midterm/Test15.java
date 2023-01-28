import java.util.Scanner;

public class Test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入要加密的字串：");
        int num = sc.nextInt();

        int a = (num / 1000 + 7) % 10;
        int b = (num / 100 % 10 + 7) % 10;
        int c = (num / 10 % 10 + 7) % 10;
        int d = (num % 10 + 7) % 10;

        int encryptNum = d * 1000 + c * 100 + b * 10 + a;

        System.out.println("加密過後的數字為：" + encryptNum);
    }
}
