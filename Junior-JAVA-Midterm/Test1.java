import java.util.Scanner;

public class Test1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("請輸入一串數字: ");
    String input = scanner.nextLine();
    scanner.close();
    int largestPrime = -1;

    for (int i = input.length(); i > 0; i--) {

      for (int j = 0; j <= input.length() - i; j++) {
        String subString = input.substring(j, j + i);
        int num = Integer.parseInt(subString);
        if (isPrime(num) && num > largestPrime) {
          largestPrime = num;
        }
      }
    }

    if (largestPrime == -1) {
      System.out.println("No prime found");
    } else {
      System.out.println("最大的質數是: " + largestPrime);
    }
  }

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