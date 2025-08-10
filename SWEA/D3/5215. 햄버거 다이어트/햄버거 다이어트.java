import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
    
    int T;
		T = Integer.parseInt(st.nextToken());

		for(int test_case = 1; test_case <= T; test_case++)
		{
      int N, L; // 음식 개수, 기준 칼로리
      int maxTaste = 0; // 최대 맛 
      
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken()); // 음식 종류
      L = Integer.parseInt(st.nextToken()); // 기준 칼로리

      int [][] foodArray = new int[N][2]; // 음식 리스트
      
      for (int i = 0; i < N; i++) {
        // String [] input = br.readLine().split(" ");
        
        st = new StringTokenizer(br.readLine());
        int taste = Integer.parseInt(st.nextToken()); // 음식 맛 
        int kcal = Integer.parseInt(st.nextToken());// 칼로리 
        
        foodArray[i][0] = taste; // 맛
        foodArray[i][1] = kcal; // 칼로리 저장 
        // foodArray[i] = new int[]{taste, kcal};
      }

      // 2^N 만큼 찾기 
      for (int i = 1; i < (int) Math.pow(2, N); i++) {

        int sumTaste = 0, sumKcal = 0; // 한 음식의 맛, 칼로리
        for (int j = 0; j < N; j++) {
        
          if ((i & (1 << j)) != 0) { // j번째 음식이 0이 아니라면 
            sumTaste += foodArray[j][0];
            sumKcal  += foodArray[j][1];
            if (sumKcal > L)  break; // 가지치기 (기준치 넘으면 pass)
          }
        }

        // 만약 기준 칼로리가 민기 기준 칼로리보다 이하라면,
        if (sumKcal <= L) {
          // 근데 최대 맛이라면 
          if (maxTaste <= sumTaste) {
            maxTaste = sumTaste;
          }
        }
      }

      System.out.println("#"+test_case+" "+maxTaste);

    }
	}
}



/*
1
5 1000
100 200
300 500
250 300
500 1000
400 400
*/