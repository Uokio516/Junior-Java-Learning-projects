import java.util.Scanner;

public class Test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] nums = input.split(" ");
        int[] intNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            intNums[i] = Integer.parseInt(nums[i]);
        }

        int[] count = new int[intNums.length];
        for (int i = 0; i < intNums.length; i++) {
            for (int j = 0; j < intNums.length; j++) {
                if (intNums[i] == intNums[j]) {
                    count[i]++;
                }
            }
        }

        for (int i = 0; i < intNums.length; i++) {
            if (count[i] > (intNums.length / 2)) {
                System.out.println("過半元素為: " + intNums[i]);
                return;
            }
        }
        System.out.println("NO");
    }
}
