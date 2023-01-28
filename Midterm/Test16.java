import java.util.Scanner;

public class Test16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("請輸入第一個矩陣的行數和列數 (例如: 2 2): ");
        int row1 = scanner.nextInt();
        int col1 = scanner.nextInt();

        int[][] matrix1 = new int[row1][col1];
        System.out.println("請輸入第一個矩陣的數值 (使用空格區分): ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("請輸入第二個矩陣的行數和列數 (例如: 2 2): ");
        int row2 = scanner.nextInt();
        int col2 = scanner.nextInt();

        int[][] matrix2 = new int[row2][col2];
        System.out.println("請輸入第二個矩陣的數值 (使用空格區分): ");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        if (row1 != row2 || col1 != col2) {
            System.out.println("兩個矩陣無法相加");
            return;
        }

        int[][] resultMatrix = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("相加後的矩陣為: ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
