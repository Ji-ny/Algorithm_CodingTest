import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt(); // 테스트케이스 수
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 배열 크기
            int M = sc.nextInt(); // 확장 거리
 
            int[][] array = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
 
            int maxSum = 0;
 
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    int sumPlus = array[y][x];
                    int sumX = array[y][x];
 
                    // + 방향 (상하좌우)
                    for (int i = 1; i < M; i++) {
                        int[] dy = {-1, 1, 0, 0};
                        int[] dx = {0, 0, -1, 1};
 
                        for (int d = 0; d < 4; d++) {
                            int ny = y + dy[d] * i;
                            int nx = x + dx[d] * i;
 
                            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                                sumPlus += array[ny][nx];
                            }
                        }
 
                        // X 방향 (대각선)
                        int[] dyy = {-1, 1, -1, 1};
                        int[] dxx = {-1, 1, 1, -1};
 
                        for (int d = 0; d < 4; d++) {
                            int ny = y + dyy[d] * i;
                            int nx = x + dxx[d] * i;
 
                            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                                sumX += array[ny][nx];
                            }
                        }
                    }
 
                    // 두 방향 중 최대값을 결과에 반영
                    maxSum = Math.max(maxSum, Math.max(sumPlus, sumX));
                }
            }
 
            System.out.println("#" + test_case + " " + maxSum);
        }
 
        sc.close();
    }
}