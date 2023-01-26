package test1;
import java.util.Scanner;

public class Test1 {
  public static void main(String[] args) {
    // 從標準輸入讀取字串
    Scanner scanner = new Scanner(System.in);
    System.out.println("請輸入一串數字: ");
    String input = scanner.nextLine();

    // 初始化最大的質數為 -1
    int largestPrime = -1;

    // 循環遍歷字串的每一個長度
    for (int i = input.length(); i > 0; i--) {
      // 循環遍歷字串的每一個子字串
      for (int j = 0; j <= input.length() - i; j++) {
        String subString = input.substring(j, j + i);
        // 將子字串轉換為數字
        int num = Integer.parseInt(subString);
        // 判斷是否是質數
        if (isPrime(num) && num > largestPrime) {
          // 更新最大的質數
          largestPrime = num;
        }
      }
    }

    // 判斷最大的質數是否為 -1
    if (largestPrime == -1) {
      // 如果是，表示字串中沒有質數，顯示 "No prime found"
      System.out.println("No prime found");
    } else {
      // 否則，顯示最大的質數
      System.out.println("最大的質數是: " + largestPrime);
    }
  }

  // 判斷是否是質數的方法
  public static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}