import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static int [] numbers;
    public static boolean [] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        numbers = new int[m];
        isSelected = new boolean[n + 1]; // 각 수들이 뽑혔는지 상태 플래그 저장 (1: 숫자1 선택여부, 2:숫자2 선택여부, ...)

        permutation(0);
    }

    public static void permutation(int cnt) { // cnt : 이전까지 뽑은 수들의 개수
        if (cnt == m) { // 뽑는 개수만큼 다 뽑았다면,
            String test = "";
            for (int i = 0; i < numbers.length; i++) { // 음..
                System.out.print(numbers[i]+ " ");
            }
            System.out.println(test);
            return;
        }

        // 가능한 모든 수를 해당 자리에서 시도
        for (int i = 1; i <= n; i++) { // 1 ~ N 까지 자리수 도전!
            // 이미 선택된 수는 패스 (기저조건)
            if (isSelected[i])    continue;
            numbers[cnt] = i; // 해당 자리에 수 i 저장  ( 1 ~ n)
            isSelected[i] = true; // 수의 선택여부를 체크해둠 ( 이 수는 사용중!)
            permutation(cnt+1); // 하나 뽑았으니, 다음 자리수를 넣어줌 (1,o,o) 재귀!
            isSelected[i] = false;
        }
    }
}