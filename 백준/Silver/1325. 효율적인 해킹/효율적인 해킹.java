import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n;    // N개의 컴퓨터의 개수
    int m;    // M개의 신뢰관계의 개수
    ArrayList<Integer>[] list;    // 인접 리스트
    boolean[] visited;    // 방문한 노드 체크
    int[] linked;    // 각 컴퓨터의 신뢰 횟수
    int max = 0;    // 가장 많이 신뢰 받은 횟수

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // N개의 컴퓨터의 개수
        m = Integer.parseInt(st.nextToken());   // M개의 신뢰관계의 개수

        // 배열 및 리스트 초기화
        linked = new int[n+1];
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접 리스트 구성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());    // A 컴퓨터
            int b = Integer.parseInt(st.nextToken());    // B 컴퓨터

            // A가 B를 신뢰한다.
            list[a].add(b);
        }

        // 각 노드에서 시작하여 bfs 탐색
        for (int i = 1; i <= n; i++) {
            if (!list[i].isEmpty()) {
                visited = new boolean[n+1]; // 방문한 노드 목록 초기화

                /* 신뢰 관계 탐색 */
                Queue<Integer> queue = new LinkedList<>();

                // 첫 번째 컴퓨터 탐색
                visited[i] = true;
                queue.add(i);

                // BFS
                while (!queue.isEmpty()) {
                    int now = queue.poll();    // 현재 위치한 컴퓨터

                    // 확인하지 않은 컴퓨터 탐색
                    for (int next : list[now]) {
                        if (!visited[next]) {
                            max = Math.max(max, ++linked[next]);    // 가장 많이 신뢰 받은 횟수

                            // 다음 컴퓨터 방문
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }
            }
        }

        // 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호 찾기
        for (int i = 1; i <= n; i++) {
            if (linked[i] == max) {
                bw.write(i + " ");
            }
        }

        bw.flush();    // 결과 출력
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}