import java.util.Scanner;

public class Test19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groupCount = sc.nextInt(); // 第一行輸入的組數
        int fullPrice = 250; // 全票價格
        int halfPrice = 175; // 半票價格
        for (int i = 0; i < groupCount; i++) {
            int fullCount = sc.nextInt();
            int halfCount = sc.nextInt();
            int totalPrice = fullCount * fullPrice + halfCount * halfPrice;
            System.out.println("應收費用為："+ totalPrice);
        }
    }
}