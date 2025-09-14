import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N, K; // 물품의 수 N, 배냥의 용량 K

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int [] itemWeightArray = new int[N+1]; // 물건 무게  배열 (0번 포함 (0은 0만 들어가게))
    int [] itemValueArray = new int[N+1]; // 물건 가치 배열 (0번 포함 (0은 0만 들어가게))
    
    
    // N개의 물건 추가 
    for (int i = 1; i < N+1; i++) {
      st = new StringTokenizer(br.readLine());

      itemWeightArray[i] = Integer.parseInt(st.nextToken()); // 물건 무게 배열 
      itemValueArray[i] = Integer.parseInt(st.nextToken()); // 물건 가치 배열 
    }

    // DP 배열 선언 (행 : 0 ~ N번까지 물건의 개수, 열 : 배낭의 용량까지)
    int [][] knapsackArray = new int[N + 1][K + 1]; 

    // 1 ~ N 아이템까지비교
    for (int curItemIndex = 1; curItemIndex < N + 1; curItemIndex++) {
      // 1 ~ K 가방 무게까지 비교 
      for (int weight = 0; weight < K + 1; weight++) {
        // 현재 물건 무게가, 남은 배낭 용량(w)를 넘는다면 못 넣음 
        if (itemWeightArray[curItemIndex] > weight) {
          // 못넣음으로, 기존 아이템으로 그 무게까지의 물건값을 꺼냄 
          knapsackArray[curItemIndex][weight] = knapsackArray[curItemIndex-1][weight];
        } else { // 현재 물건 무게가, 남은 배낭 용량(w)를 넘지 않는다면, 넣을 수 있다
          // max (기존 아이템으로 그 무게까지의 물건값, 내무게 빼고 최대로 넣은 물건까지 + 내 값어치)
          knapsackArray[curItemIndex][weight] = Math.max(knapsackArray[curItemIndex-1][weight], knapsackArray[curItemIndex-1][weight - itemWeightArray[curItemIndex]] + itemValueArray[curItemIndex]);
        }
      }
    }

    System.out.println(knapsackArray[N][K]);

  
  }
}
