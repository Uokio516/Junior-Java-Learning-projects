import java.util.Scanner;

public class Test21 {
    public static void main(String[] args) {
        System.out.print("請輸入要查詢的筆數：");
        Scanner sc = new Scanner(System.in);

        String[][] accountInfo = {{"123", "456", "9000"},
                                {"456", "789", "5000"},
                                {"789", "888", "6000"},
                                {"336", "558", "10000"},
                                {"775", "666", "12000"},
                                {"566", "221", "7000"}};

        int queryNum = sc.nextInt();
        for (int i = 0; i < queryNum; i++) {
            System.out.print("帳號：");
            String account = sc.next();
            
            System.out.print("密碼：");
            String password = sc.next();
            
            boolean found = false;
            for (int j = 0; j < accountInfo.length; j++) {
                if (accountInfo[j][0].equals(account) && accountInfo[j][1].equals(password)) {
                    System.out.println("該帳戶餘額為："+ accountInfo[j][2]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("error");
            }
        }
    }
}
