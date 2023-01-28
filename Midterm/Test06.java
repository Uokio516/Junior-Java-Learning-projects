import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;

public class Test06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int Ans;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("input:");
            String data = sc.next();
            String[] split = data.split(",");
            Arrays.sort(split);
            String min = Arrays.stream(split).collect(Collectors.joining());
            Arrays.sort(split, Collections.reverseOrder());
            String max = Arrays.stream(split).collect(Collectors.joining());
            System.out.println("max:"+max);
            System.out.println("min:"+min);
            //Integer.parseInt字串轉整數型態(S,radix) radix是多少進位
            Ans = Integer.parseInt(max,10)-Integer.parseInt(min,10);
            System.out.println("Ans:"+Ans);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
