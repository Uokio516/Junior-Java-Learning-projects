import java.util.Scanner;

public class Test20 {
  public static void main(String[] args) {
    // 資料
    String[][] data = {
        {"TOM", "123", "DTGD"},
        {"Cat", "456", "CSIE"},
        {"Nana", "789", "ASIE"},
        {"Lim", "321", "DBA"},
        {"Won", "654", "FDD"}
    };

    // 建立Scanner物件
    Scanner sc = new Scanner(System.in);

    // 輸入學號
    System.out.print("請輸入學號: ");
    String input = sc.nextLine();

    // 搜尋資料
    for (String[] student : data) {
      if (student[1].equals(input)) {
        System.out.println("學生: " + student[0]);
        System.out.println("學號: " + student[1]);
        System.out.println("系別: " + student[2]);
        return;
      }
    }

    // 找不到資料
    System.out.println("沒有找到相關資料");
  }
}
