import java.io.BufferedReader;
import java.io.InputStreamReader;
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
      // 재료 개수 (1 ~ N번), M개의 맞지 않는 쌍 
      int N, M;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken()); // 재료 개수 
      M = Integer.parseInt(st.nextToken()); // 안맞는 쌍 개수 

      int [] noFoodMasks = new int[M]; // 들어가면 안되는 재료 쌍 (비트)
      // M개의 줄 : a->b 같은 버거에 들어가면 안됨!
      for (int i = 0; i < M; i++) {
        int food_a, food_b; // a -> b 연결 
        String [] foodsInput = br.readLine().split(" ");
        food_a = Integer.parseInt(foodsInput[0]);
        food_b = Integer.parseInt(foodsInput[1]);

        noFoodMasks[i] = (1 << (food_a-1)) | (1 << (food_b-1)); // 마스크 저장 
        // System.out.println(Integer.toBinaryString(noFoodMasks[i]));
      }


      int result = 0;
      boolean ok = true;
      // 1 ~ N까지 부분집합 비트 찾기 
      for (int i = 0; i < ( 1 << N); i++ ){
        // System.out.println(Integer.toBinaryString(i));
        int nowFood = i; // 현재 음식 조합 
        // 중간에 들어가면 안되는 쌍을 반복해서 체크한다. 
        
        for (int noFoodMask : noFoodMasks) {
          // 만약 들어가면 안되는 쌍이 모두 있다면, 제외! 
          if (( nowFood & noFoodMask) == noFoodMask) { // 연산자 우선순위
            ok = false;
            break;
          }

        }
        
        // 넣을 수 있는 값이라면 
        if (ok) {
          result++;
        }

        ok = true;
        
        
      }
      
      System.out.println("#"+test_case+" "+result);
		}
	}
}

/* 
3
3 2
1 2
2 3

3 0
3 3
1 2
1 3
2 3
*/

/* 
1
3 2
1 2
2 3


*/