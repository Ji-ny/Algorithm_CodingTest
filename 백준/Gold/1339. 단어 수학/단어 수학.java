import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 단어의 개수 N
        int N = Integer.parseInt(st.nextToken());
        Integer[] array = new Integer[26]; // 알파벳 개수 
        Arrays.fill(array, 0);

        // N개의 줄에 단어가 한줄에 하나씩 주어진다. (String 배열 )
        for (int i = 0; i < N; i++) {
            // st = new StringTokenizer(br.readLine());
            String str = br.readLine();
            // str의 길이만큼 가중치를 구한다.
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                // 구한 가중치를 배열에 넣는다.
                // 1의 자리면 1, 100의 자리면 100을 만들어줘야함 
                array[c - 'A'] += (int) Math.pow(10, str.length() - 1 - j); // 지수 함수 
            }
        }

        // 2. 큰값기준이니 내림차순 정렬 
        Arrays.sort(array, (a,b) -> b - a);

        // * 3. 9부터 1씩 빼면서 높은 수 넣기 (2까지)
        // * 25번 (알파벳 개수만큼 돈다.)
        int number = 9;
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (array[i] == 0) { // 0이 들어온거면 이제 더할거 없으니 종료
                break;
            }

            answer += array[i] * number; // 결과에 현재 가중치 * 숫자
            number--; // 9, 8, 7... 이렇게 값을 넣어줄것 

        }

        System.out.println(answer);
        // System.out.println(Arrays.toString(array));


        
    }
}
