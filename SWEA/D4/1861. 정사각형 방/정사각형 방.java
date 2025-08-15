import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

  public static int N; // 배열 크기
  public static int [][] array; // int 배열 
  public static boolean [][] visited; // 방문처리 배열 
  public static int count = 0; // 방의 개수 
  public static int maxCount = 0; // 최대 방의 개수 
  public static int maxRoomNumber = 0; // 최대 방 번호 
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 입력
    int T;
    T = Integer.parseInt(st.nextToken());

		for(int test_case = 1; test_case <= T; test_case++)
		{
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      array = new int[N][N];
      visited = new boolean[N][N];
      // N 번 반복하며 배열 입력
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          array[i][j] = Integer.parseInt(st.nextToken());
        }
      } 

      maxCount = 0;
      maxRoomNumber = 0;
      // 완탐 
      for (int i = 0; i < N ; i++) {
        for (int j = 0; j < N; j++) {
          // System.out.println("i "+i+" j: "+j);
          visited = new boolean[N][N]; // 방문처리 초기화 
          // 각 위치별 dfs 돌리기 
          count = 1;
          dfs(i,j);
          

          // 최대 개수 갱신
          if (maxCount < count) {
            maxCount = count;
            maxRoomNumber = array[i][j];
          }

          if (maxCount == count) {
            if (maxRoomNumber > array[i][j]) {
              maxRoomNumber = array[i][j];
            }
          }

          // System.out.println();
          // for (int k = 0; k < N ; k++){
          //   System.out.println(Arrays.toString(visited[k]));
          // }
        }
      }

      System.out.println("#"+test_case+" "+maxRoomNumber+" "+maxCount);
		}


  }

  public static void dfs(int r, int c) {
    Stack<int[]> stack = new Stack<>(); 

    stack.push(new int[]{r, c});

    int [] dRow = {1, -1, 0, 0}; // 상,하,좌,우 이동 배열 
    int [] dCol = {0, 0, -1, 1};
    
    // visited[r][c] = true; // 시작점 방문처리

    while (!stack.isEmpty()) {

      int[] now = stack.pop();
      int row = now[0];
      int col = now[1];
      // 방문 처리
      visited[row][col] = true;

      // 4방향 이동 
      for (int i = 0; i < 4; i++) {
        int nowRow = row + dRow[i];
        int nowCol = col + dCol[i];

        // 범위를 벗어났다면 탈락
        if (nowRow < 0 || nowRow >= N || nowCol < 0 || nowCol >= N) {
          continue;
        }

        // 나보다 정확히 1 커야한다.
        if (!(array[nowRow][nowCol] == (array[row][col]+1))) {
          continue;
        }

        // dfs 작업 수행 
        if (!visited[nowRow][nowCol]) {
          // 아직 방문하지 않았다면
          visited[nowRow][nowCol] = true; // 방문처리 
          count++; // 개수 추가 
          // 스택에 현재위치 추가 
          stack.push(new int[]{nowRow, nowCol});
        }

        // System.out.println();
        // for (int k = 0; k < N ; k++){
        //   System.out.println(Arrays.toString(visited[k]));
        // }
      }
    }
  }

}
