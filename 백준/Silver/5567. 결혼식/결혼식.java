import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    int N, M;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());

    int[] visited = new int[N+1];
    
    // 리스트 생성
    List<Integer>[] array = new ArrayList[N+1];
    for (int i = 0; i < N+1; i++) {
      array[i] = new ArrayList<>();
    }

    int result = 0;
    // 친구관계
    for (int i = 0; i < M; i++) {
      int a, b;
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      array[a].add(b);
      array[b].add(a);
    }
    
    Queue<Integer> queue = new ArrayDeque<>();
    Arrays.fill(visited, -1);

    visited[1] = 0; // 시작점 
    queue.offer(1);

    while (!queue.isEmpty()) {
      int nowNode = queue.poll();
      if (visited[nowNode] == 2)  continue;

      for (int node : array[nowNode]) {
        if (visited[node] == -1) {
          visited[node] = visited[nowNode] + 1;
          queue.offer(node);
        }
      }
    }


    
    for ( int i = 0 ; i <= N; i++) {
      if (visited[i] != -1 && visited[i] <= 2) {
        result++;
      }
    }
    // System.out.println(Arrays.toString(visited));
    System.out.println(result-1);
  }
}



