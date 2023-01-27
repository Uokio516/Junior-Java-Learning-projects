import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class graph {
    private int[][] G;
    private int[][] W;
    private vertex[] Map;

    public graph(int[][] G, int[][] W) {
        this.G = G;
        this.W = W;
        this.Map = new vertex[G[0].length];
        for(int i=0;i<G[0].length;i++){
            Map[i] = new vertex();
        }
    }

    public void DIJKSTRA() {
        INITIALIZE_SINGLE_SOURCE();
        ArrayList<Integer> S = new ArrayList<Integer>();
        ArrayList<Integer> Q = new ArrayList<Integer>();
        Map[0].setShorest(0);
        for (int i = 0; i < G[0].length; i++) {
            Q.add(i);
        }
        
        while (!Q.isEmpty()) {
            // u is index of Q to remove, Q.get(u) is index of Map
            int u = findMin(Q); 
            S.add(Q.get(u));
            int[] con = findConnect2(Q.get(u));
            for (int i=0;i<con.length;i++){
                RELAX(Q.get(u),con[i],W[Q.get(u)][con[i]]);
            }
            Q.remove(u);
        }
    }

    private void INITIALIZE_SINGLE_SOURCE() {
        for (int i = 0; i < Map.length; i++) {
            Map[i].setShorest(Integer.MAX_VALUE);
            Map[i].setPrevious(-1);
        }
    }

    private void RELAX(int u, int v, int w) {
        if (Map[v].getShorest() > Map[u].getShorest() + w) {
            Map[v].setShorest(Map[u].getShorest() + w);
            Map[v].setPrevious(u);
        }
    }

    private int findMin(ArrayList<Integer> Q) {
        int min = Integer.MAX_VALUE;
        int Min = Integer.MAX_VALUE;
        for (int i = 0; i < Q.size(); i++) {
            if (Map[Q.get(i)].getShorest() < min) {
                min = Map[Q.get(i)].getShorest();
                Min = i;
            }
        }
        return Min; // index of Q
    }

    private int[] findConnect2(int u) {
        ArrayList<Integer> con = new ArrayList<Integer>();
        for (int i = 0; i < G[0].length; i++) {
            if (G[u][i] != 0) {
                con.add(i);
            }
        }
        int[] newCon = new int[con.size()];
        for (int i = 0; i < newCon.length; i++) {newCon[i] = con.get(i);}
        return newCon;// index of Map
    }

    public ArrayList getSolutionFrom(int A, int B){
        ArrayList solution = new ArrayList();
        int s = B-1;
        solution.add(A);
        do{
            solution.add(1,s+1);
            s = Map[s].getPrevious();
        }while(s!=-1 & s!=(A-1));
        return solution;
    }
    public int getCostFrom(int A, int B){
        return Map[B-1].getShorest()-Map[A-1].getShorest();
    }
}

class vertex{
    private int shorest;
    private int previous;

    public void setShorest(int s){
        shorest = s;
    }
    public void setPrevious(int p){
        previous = p;
    }

    public int getShorest(){
        return shorest;
    }
    public int getPrevious(){
        return previous;
    }
}