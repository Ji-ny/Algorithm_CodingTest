/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
    
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T(테스트 케이스 수)를 BufferedReader로 읽어옵니다.
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            
            // StringTokenizer st = new StringTokenizer(br.readLine());

            String[] input = br.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            
            int [][] array = new int[N][]; // N*N 배열 생성 
            
            // N개 행 입력 
            for (int i = 0; i < N ; i ++) {
                // System.out.println(i);
                String[] inputLine = br.readLine().split(" ");
                array[i] = Stream.of(inputLine).mapToInt(Integer::parseInt).toArray();
            }


            int maxAnswer = 0; // 최대 파리
            
            // N * N 반복하기 
            for (int row = 0; row <= N-M; row++) { // Row도 M크기까지 가능 
              for (int col = M-1; col < N; col++) { // M 만큼 범위증가 
                int startColIdx = col-M+1;
                int endColIdx = col; // 끝 컬럼이 계속 업데이트된다.
                // 시작값만큼 없애고, 종료값만큼 추가
                int sum = 0; 
                for (int panCol = startColIdx; panCol <= endColIdx; panCol++ ) { // M 크기만큼 줄은 값부터 시작 (0 ~ 3까지)
                  for (int panRow = row; panRow < row + M; panRow++  ){// row도 0 ~ +M까지.
                    // 값 저장 
                    sum += array[panRow][panCol];

                  } 
                }

                // System.out.println("col: "+ startColIdx+" "+endColIdx+" |" + "row: "+ row  +"현재 sum"+sum);
                if (sum > maxAnswer) {
                  maxAnswer = sum;
                }
                
              }
            }
          
            System.out.println("#"+test_case+" "+ maxAnswer);
        }
    }
}

/* 
1
5 2
1 3 3 6 7
8 13 9 12 8
4 16 11 12 6
2 4 1 23 2
9 13 4 7 3
*/