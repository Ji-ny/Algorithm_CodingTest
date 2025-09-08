import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] array;

    public static int position = 0;
    // * a, b를 바꾼다. 
    public static void swap(int a, int b, int X) {

        // * index를 바꿔주면 된다.
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

        if (array[a] == X) {
            position = a;
        }
        else if (array[b] == X) {
            position = b;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, K, X;

        N = Integer.parseInt(st.nextToken());// N개의 컵
        X = Integer.parseInt(st.nextToken()); // 처음 들어있는 공이 들어있는 컵의 번호이다.
        K = Integer.parseInt(st.nextToken());// K번에 거쳐 두컵의 위치를 바꾼다.
        // 현재 포지션 변경 
        position = X;

        // array를 1 ~ N까지 넣어주자.
        array = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            array[i] = i;
        }


        int a, b;
        // K번 공 변경
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            //a,b 공 swap
            swap(a, b, X);
        }


        System.out.println(position);
        
        

    }
}
