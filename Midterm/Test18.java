import java.util.Scanner;
import java.util.Arrays;

public class Test18 {
    public static void main(String[] args) {

        String[][] bloods = {
            {"O O",  "O",       "A,B,AB"},
            {"O A",  "A O",     "B AB"},
            {"O B",  "B O",     "A AB"},
            {"O AB", "A B",     "O AB"},
            {"A A",  "A O",     "B AB"},
            {"A B",  "A B O AB",""},
            {"A AB", "A B AB",  "O"},
            {"B B",  "B O",     "A AB"},
            {"B AB", "A B AB",  "O"},
            {"AB AB","A B AB",  "O"}
        };

        int num = 0;

        System.out.print("測試的資料量: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        num = Integer.parseInt(input);

        String[] lines = new String[num];
        String[] results = new String[num];
        String parents1, parents2;

        for(int i = 0; i < num; i++) {
            System.out.print("請輸入第 " + (i + 1) + " 筆資料: ");
            lines[i] = scanner.nextLine();

            String[] family = lines[i].split(" ");
            for(int j = 0; j < bloods.length; j++) {
                parents1 = family[0].toUpperCase()+" "+family[1].toUpperCase();
                parents2 = family[1].toUpperCase()+" "+family[0].toUpperCase();
                if(parents1.equals(bloods[j][0]) || parents2.equals(bloods[j][0])) {
                    String[] lists = bloods[j][1].split(" ");

                    if(Arrays.asList(lists).contains(family[2].toUpperCase())) {
                        results[i] = "YES";
                    } else {
                        results[i] = "IMPOSSIBLE";
                    }
                }
            }
        }
        scanner.close();
       
        for(int i = 0; i < num; i++) {
            System.out.println(lines[i].toUpperCase()+": "+results[i]);

        }
        
    }
}
