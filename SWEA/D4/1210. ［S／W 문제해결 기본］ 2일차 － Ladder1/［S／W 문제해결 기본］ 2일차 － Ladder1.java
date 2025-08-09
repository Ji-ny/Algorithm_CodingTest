
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		// int T = sc.nextInt();

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		// 0 ~ 9 까지 
		int N = 100; // 배열 크기 
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{

			int tCase = sc.nextInt();
			sc.nextLine();
			
			// 전체 배열 저장할 것 추가 
			int[][] array = new int[N][N];
			// 9x9 만들기 
			for (int i = 0; i < N ; i++){
				
				for (int j = 0; j < N; j++) {
						array[i][j] = sc.nextInt();
						// System.out.println(array[i][j]);
				}
				// System.out.println(Arrays.toString(array[i]));
				
			} 
      
			int startCol = -1; // '2'가 있는 시작 열

			// 1. 맨 아랫줄에서 '2'의 위치(출발할 열)를 찾는다.
			for (int i = 0; i < N; i++) {
					if (array[N - 1][i] == 2) {
							startCol = i;
							break;
					}
			}

			// 0 ~ N 까지 제일 아래줄부터 거슬러 올라가도록 한다.
			// 왼쪽, 오른쪽, 위쪽 
			int [] dRow = {0, 0, -1};
			int [] dCol = {-1, 1, 0};

			// 2일때 거슬러 올라간다.
			int row = N-1; // -2층 부터 실행 
			int col = startCol;
			int nowRow, nowCol;

			while (row > 0 ) { // 0층까지 반복 
				// System.out.println("");
				// for (int i = 0 ; i < N ; i++) {
				// 	System.out.println(Arrays.toString(array[i]));
				// }
				// 방문처리
				array[row][col] = 0;



				for (int j = 0; j < 3; j++) {
					nowRow = row + dRow[j];
					nowCol = col + dCol[j];

					// 범위 체크
					if (nowRow < 0 || nowRow >= N || nowCol < 0 || nowCol >= N) {
						continue;
					}
					// 현 위치가 0이라면, 패스 
					if (array[nowRow][nowCol] == 0) {
						continue;
					}

					// 현 위치가 1이라면, 이동 
					if (array[nowRow][nowCol] == 1) {
						row = nowRow;
						col = nowCol;
						break;
					}



				}
			}


			System.out.println("#" + tCase + " " + col);

			



			


			
		}
	}
}

/*
1
1 0 0 0 1 0 1 0 0 1
1 0 0 0 1 0 1 1 1 1
1 0 0 0 1 0 1 0 0 1
1 0 0 0 1 1 1 0 0 1
1 0 0 0 1 0 1 0 0 1
1 1 1 1 1 0 1 1 1 1
1 0 0 0 1 0 1 0 0 1
1 1 1 1 1 0 1 0 0 1
1 0 0 0 1 1 1 0 0 1
1 0 0 0 1 0 1 0 0 2

*/