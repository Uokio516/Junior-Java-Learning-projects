import java.util.Scanner;

public class Test09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("輸入s1為：");
        String s1 = sc.nextLine();
        System.out.print("輸入s2為：");
        String s2 = sc.nextLine();
        sc.close();
        if (s2.contains(s1)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}