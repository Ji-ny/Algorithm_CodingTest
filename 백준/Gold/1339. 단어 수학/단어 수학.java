import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // 1. 알파벳 개수만큼 배열 선언
        Integer[] alphabet = new Integer[26];
        Arrays.fill(alphabet, 0);

        // 2. 단어의 개수만큼 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            // 알파벳을 순회하며 알파벳 위치에 값 추가
            for (int j = 0; j < str.length(); j++) {
                int index = str.charAt(j) - 'A';
                alphabet[index] += (int) Math.pow(10, str.length() - j - 1);
            }
        }

        // 알파벳 배열 sort
        Arrays.sort(alphabet, (a, b) -> b - a);

        // 9부터 시작해서 값 넣어주기
        int number = 9;
        int answer = 0;
        // 큰수부터 반복 진행
        for (int j = 0; j < alphabet.length; j++) {
            if (alphabet[j] == 0) {
                break;
            }

            answer += alphabet[j] * number; // *number만큼 큰수부터 추가
            number--;
        }

        System.out.println(answer);
    }
}
