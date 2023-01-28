import java.util.Scanner;
import java.util.Arrays;

public class Test08 {
   
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n, count, max=0;
        String input;
        
        System.out.print("輸入第一行正整數為:");
        input = scanner.nextLine();
        n = Integer.parseInt(input);

        System.out.print("第二行中數列中的數字為:");
        input = scanner.nextLine();
        scanner.close();

        String[] numbers = input.split(" ");
        int[] x = new int[numbers.length];
        int[][] y = new int[numbers.length][2];
        for (int i = 0; i < numbers.length ; i++) {
            x[i] = Integer.parseInt(numbers[i]);
        }
        
        Arrays.sort(x);

        count = 0;
        y[count][0] = x[0];
        y[count][1] = 0;
        for (int i = 0; i < x.length; i++) {
            if( y[count][0] == x[i] )
            {
                y[count][1]++;

                if( y[count][1] > max )
                    max = y[count][1];
            }else
            {
                count++;
                y[count][0] = x[i];
                y[count][1] = 1;
            }
        }

        // Deubg 用
        System.out.println("n="+n);
        System.out.print("X=");
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d ", x[i]);
        }
        System.out.println();
        for (int i = 0; i <= count; i++) {
            System.out.println(y[i][0]+":"+y[i][1]);
        }
        
        if(max == 1)
            System.out.println("每個數字剛好只出現 1 次");
        else
        {
            System.out.print("最大出現次數的數字為：");
            for (int i = 0; i <= count; i++) {
                if(y[i][1] == max)
                    System.out.printf("%d ", y[i][0]);
            }
            System.out.println();
            System.out.println("出現次數為："+max);
        }

    }
}
