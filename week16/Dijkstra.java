

public class Dijkstra {

    static final int totalVertex = 9;

    int minimumDistance(int distance[], Boolean spSet[]) {

        int m = Integer.MAX_VALUE, m_index = -1;

        for (int vx = 0; vx < totalVertex; vx++) {
            if (spSet[vx] == false && distance[vx] <= m) {
                m = distance[vx];
                m_index = vx;
            }
        }
        return m_index;

    }

    void printSolution(int distance[], int n) {
        System.out.println("以下從原點到其他點的最短距離： ");
        for (int j = 0; j < n; j++)
            System.out.println("到" + j + "點的最短距離是" + distance[j]);
    }

    void dijkstra(int graph[][], int s) {
        int distance[] = new int[totalVertex];

        Boolean spSet[] = new Boolean[totalVertex];

        for (int j = 0; j < totalVertex; j++) {
            distance[j] = Integer.MAX_VALUE;
            spSet[j] = false;
        }

        distance[s] = 0;

        for (int cnt = 0; cnt < totalVertex - 1; cnt++) {

            int ux = minimumDistance(distance, spSet);

            spSet[ux] = true;

            for (int vx = 0; vx < totalVertex; vx++)

                if (!spSet[vx] && graph[ux][vx] != -1 && distance[ux] != Integer.MAX_VALUE
                        && distance[ux] + graph[ux][vx] < distance[vx]) {
                    distance[vx] = distance[ux] + graph[ux][vx];
                }
        }

        printSolution(distance, totalVertex);
    }

    public static void main(String argvs[]) {

        int grph[][] = new int[][] { { -1, 3, -1, -1, -1, -1, -1, 7, -1 },
                { 3, -1, 7, -1, -1, -1, -1, 10, 4 },
                { -1, 7, -1, 6, -1, 2, -1, -1, 1 },
                { -1, -1, 6, -1, 8, 13, -1, -1, 3 },
                { -1, -1, -1, 8, -1, 9, -1, -1, -1 },
                { -1, -1, 2, 13, 9, -1, 4, -1, 5 },
                { -1, -1, -1, -1, -1, 4, -1, 2, 5 },
                { 7, 10, -1, -1, -1, -1, 2, -1, 6 },
                { -1, 4, 1, 3, -1, 5, 5, 6, -1 } };

        Dijkstra obj = new Dijkstra();
        obj.dijkstra(grph, 0);
    }
}