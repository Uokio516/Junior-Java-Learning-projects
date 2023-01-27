import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inf = 99999999;
        int n, m, key_point = 1;
        int[][] e = new int[11][11];
        int[] dis = new int[11];
        int[] book = new int[11];
        
        // 讀入頂點個數，邊個數
        n = sc.nextInt();
        m = sc.nextInt();
        sc.close();
        // 初始化
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    e[i][j] = 0;
                } else {
                    e[i][j] = inf;
                }
            }
        }

        // 讀入邊
        for (int i = 1; i <= m; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            int t3 = sc.nextInt();
            e[t1][t2] = t3;
        }

        // 初始 dis 陣列，從 key_point 到其餘各點的初始路程
        for (int i = 1; i <= n; i++) {
            dis[i] = e[key_point][i];
        }

        // 初始 book 陣列
        book[key_point] = 1;

        // Dijkstra Algorithm
        for (int i = 1; i < n; i++) {
            // 找到離 key_point 點最近的頂點
            int min = inf;
            int u = 0;
            for (int j = 1; j <= n; j++) {
                if (book[j] == 0 && dis[j] < min) {
                    min = dis[j];
                    u = j;
                }
            }
            book[u] = 1;
            for (int v = 1; v <= n; v++) {
                if (e[u][v] < inf) {
                    if (dis[v] > dis[u] + e[u][v]) {
                        dis[v] = dis[u] + e[u][v];
                    }
                }
            }
        }

        // 輸出
        for (int i = 1; i <= n; i++) {
            System.out.println(dis[i]);
        }
    }
}
