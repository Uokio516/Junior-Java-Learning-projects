import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] size = sc.nextLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
}
