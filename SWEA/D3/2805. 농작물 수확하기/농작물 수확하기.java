import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T;
        T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 농장의 크기

            int result = 0;
            int[][] array = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    array[i][j] = Integer.parseInt(input[j]);
                }
                // System.out.println(Arrays.toString(input));
            }

            int mid = N / 2; // int/int 연산은 내림(floor 연산이 된다.)
            int startCol = N / 2 + 1; // 시작 컬럼
            int colCount = -1; // 시작 컬럼 개수

            for (int row = 0; row < N; row++) {
                if (row <= mid) { // 시작 ~ 중간 위치
                    startCol--;
                    colCount += 2;
                }
                // 중간부터 ~ 끝 위치
                if (row > mid) {
                    startCol++;
                    colCount -= 2;
                }

                for (int col = startCol; col < (startCol + colCount); col++) {
                    result += array[row][col];
                }
            }
            // 가운대 위치 기준으로,
            // 가운대 : Math.floor(N//2)
            // 1. 위는 row : 0 ~ N//2 (0 ~ 3)
            // 1.2. 컬럼은 col : 1 ~ N-1 까지
            // 1.3. 시작지점은 N//2 지점부터 -1씩 진행

            // 2. 아래는 row : N//2 + 1 ~ N
            // 2.1. 컬럼은 col : N-1 ~ 1개 까지
            // 2.2. 시작지점은 N//2 지점부터 0 ~ +1씩 진행
            // for (int i = 0; i < N; i++) {
            // System.out.println(Arrays.toString(array[i]));
            // }
            System.out.println("#" + test_case + " " + result);

        }
    }
}