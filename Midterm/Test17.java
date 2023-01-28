import java.util.Scanner;

public class Test17 {
    public static void main(String[] args) {
        
        System.out.println("請輸入五張牌 A, 2~10, J, Q, K: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();        
        String[] cards = input.split(" ");
        int n=0;
        for (int i = 0; i < cards.length; i++) {
            if(cards[i].equals("J") || cards[i].equals("j"))
                n+=11;
            else if(cards[i].equals("Q") || cards[i].equals("q"))
                n+=12;
            else if(cards[i].equals("K") || cards[i].equals("k"))
                n+=13;
            else if(cards[i].equals("A") || cards[i].equals("a"))
                n++;
            else 
                n+=Integer.parseInt(cards[i]);
        }
        System.out.println(n);
    }
}
