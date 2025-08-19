import java.util.Arrays;
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
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution {

  public static int H, W, N;
  public static String [][] array;
  public static String [] userInputArray;
  public static int nowRow, nowCol; // 현재 전차 위치 
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int T;
      T = Integer.parseInt(st.nextToken());
      // int H, W; // 높이, 너비
      // String [][] array;


      // int N; // 사용자 입력 개수 
      // String[] userInputArray; // 사용자 입력 배열 
      
      for(int test_case = 1; test_case <= T; test_case++)
      {
        
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken()); // 배열 높이 
        W = Integer.parseInt(st.nextToken()); // 배열 너비 

        array = new String[H][]; // 배열 선언

        
        // 배열 높이만큼 문자열 받는다.
        for (int i = 0; i < H; i++) {
          st = new StringTokenizer(br.readLine());
          array[i] = st.nextToken().split("");
        }

        // 현재 전차 위치 구하기 
        for (int i = 0; i < H; i++) {
          for (int j = 0; j < W; j++) {
            String now = array[i][j];
            if (now.equals("^") ||
                now.equals("v") ||
                now.equals("<") ||
                now.equals(">")) {
                  nowRow = i;
                  nowCol = j;
                }
          }
        }

        // System.out.println("현재 전차 위치: ("+ nowRow + ", "+ nowCol+")");

        // * 2. 사용자 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사용자 입력 개수 
        st = new StringTokenizer(br.readLine());
        userInputArray = st.nextToken().split("");
        // System.out.println(Arrays.toString(userInputArray));

        // * 3. 입력받은거 처리 시작 .
        for (String input : userInputArray) {
          int nextRow, nextCol; // 다음 이동 위치 
          // System.out.println(input);
          if (input.equals("U")) { // 상 
            nextRow = nowRow - 1;
            nextCol = nowCol + 0;
            // 범위를 벗어나지 않고 평지라면 
            if (nextRow >= 0 && isFlat(nextRow, nextCol)) {
              // 기존 전차 있던 곳은 평지로 변경
              array[nowRow][nowCol] = ".";
              // 새로 이동할 전차 위치를 위로 변경 
              array[nextRow][nextCol] = "^";
              // 위치 이동 
              nowRow = nextRow;
              nowCol = nextCol;
              // 전차 바라보는 방향 변경 
            } else { // 범위를 벗어나 버리면 방향만 바꾼다.
              array[nowRow][nowCol] = "^";
            }
          } else if (input.equals("D")) { // 하
            nextRow = nowRow + 1;
            nextCol = nowCol + 0;
            // 범위를 벗어나지 않고 평지라면 
            if (nextRow < H && isFlat(nextRow, nextCol)) {
              // 기존 전차 있던 곳은 평지로 변경
              array[nowRow][nowCol] = ".";
              // 새로 이동할 전차 위치를 아래로 변경 
              array[nextRow][nextCol] = "v";
              // 위치 이동 
              nowRow = nextRow;
              nowCol = nextCol;
              // 전차 바라보는 방향 변경 
            } else { // 범위를 벗어나 버리면 방향만 바꾼다.
              array[nowRow][nowCol] = "v";
            }

          } else if (input.equals("L")) { //  좌
            nextRow = nowRow + 0;
            nextCol = nowCol - 1;
            // 범위를 벗어나지 않고 평지라면 
            if (nextCol >= 0 && isFlat(nextRow, nextCol)) {
              // 기존 전차 있던 곳은 평지로 변경
              array[nowRow][nowCol] = ".";
              // 새로 이동할 전차 위치를 왼쪽로 변경 
              array[nextRow][nextCol] = "<";
              // 위치 이동 
              nowRow = nextRow;
              nowCol = nextCol;
              // 전차 바라보는 방향 변경 
            } else { // 범위를 벗어나 버리면 방향만 바꾼다.
              array[nowRow][nowCol] = "<";
            }

          } else if (input.equals("R")) { // 우
            nextRow = nowRow + 0;
            nextCol = nowCol + 1;
            // 범위를 벗어나지 않고 평지라면 
            if (nextCol < W && isFlat(nextRow, nextCol)) {
              // 기존 전차 있던 곳은 평지로 변경
              array[nowRow][nowCol] = ".";
              // 새로 이동할 전차 위치를 오른쪽로 변경 
              array[nextRow][nextCol] = ">";
              // 위치 이동 
              nowRow = nextRow;
              nowCol = nextCol;
              // 전차 바라보는 방향 변경 
            } else { // 범위를 벗어나 버리면 방향만 바꾼다.
              array[nowRow][nowCol] = ">";
            }

          } else if (input.equals("S")) { // 슛 ~ 
            // 방향에 따라 슛 하기 
            shoot(nowRow, nowCol);
          }
        }

        System.out.print("#"+test_case+" ");
        
        for (int i = 0 ; i < H ; i++) {
          for(int j = 0; j < W; j++) {
            System.out.print(array[i][j]);
          }
          System.out.println("");
        }
        
      }
  }

  // 현 위치가 평지인지 판단 
  public static boolean isFlat(int row, int col) {
    // 평지라면 return True
    if (array[row][col].equals(".")) {
      // System.out.println("row, col은 평지입니다." + row + " " + col);
      return true;
    }

    // 평지가 아니면 return Fasle; (물이나, .. 등 )
    // System.out.println("row, col은 평지가 아닙니다." + row + " " + col);

    return false; 
  }



  // 현 위치가 벽인지 판단
  public static boolean isWall(int row, int col) {
    // 벽이라면 가능 
    if (array[row][col].equals("*") || array[row][col].equals("#")) { 
      return true;
    } 

    return false;
  }

  // 현 위치가 슛할 수 있는 벽인지 판단
  public static boolean isShootOk(int row, int col) {
    // 벽돌이라면 가능 
    if (array[row][col].equals("*")) { 
      return true;
    } 

    return false;
  }
  public static void shoot(int row, int col) {
    // 상, 하, 좌, 우 방향에 따라 슛 한다.
    String now = array[row][col];

    if (now.equals("^")) { // 상 
      // 위로 쭉 슛 
      for (int nextRow = row; nextRow >= 0; nextRow--) {
        // 벽인지 먼저 판단
        if (isWall(nextRow, col)) {
          // 벽돌인지 판단
          if (isShootOk(nextRow, col)) {
            // 벽돌이면 해당 위치는 평지로 변경
            array[nextRow][col] = ".";
          }
          break;
        }
      } 
    } else if (now.equals("v")) { //하
      // 아래로 쭉 슛 
      for (int nextRow = row; nextRow < H ; nextRow++) {
        // 벽인지 먼저 판단
        if (isWall(nextRow, col)) {
          // 벽돌인지 판단
          if (isShootOk(nextRow, col)) {
            // 벽돌이면 해당 위치는 평지로 변경
            array[nextRow][col] = ".";
          }
          break;
        }
      } 
    } else if (now.equals("<")) { //좌
      // 좌로 쭉 슛 
      for (int nextCol = col; nextCol >= 0 ; nextCol--) {
        // 벽인지 먼저 판단
        if (isWall(row, nextCol)) {
          // 벽돌인지 판단
          if (isShootOk(row, nextCol)) {
            // 벽돌이면 해당 위치는 평지로 변경
            array[row][nextCol] = ".";
          }
          break;
        }
      } 
    } else if (now.equals(">")) { // 우 
      // 우로 쭉 슛 
      for (int nextCol = col; nextCol < W ; nextCol++) {
        // 벽인지 먼저 판단
        if (isWall(row, nextCol)) {
          // 벽돌인지 판단
          if (isShootOk(row, nextCol)) {
            // 벽돌이면 해당 위치는 평지로 변경
            array[row][nextCol] = ".";
          }
          break;
        }
      } 
    } 

  }
}

