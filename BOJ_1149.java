package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int col = 3; // 열 갯수 지정

        int N = Integer.parseInt(br.readLine()); // 행 갯수 입력
        arr = new int[N][col];
        dp = new int[N][col];

        String[] str; // 입력값을 위한 string배열 생성
        for (int i = 0; i < N; i++) { // 행의 수만큼 반복
            str = br.readLine().split(" "); // 한개의 행 데이터 입력
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(str[j]); // 입력받은 데이터 int형으로 변환 후 2차원 배열에 저장
            }
        }
        ///////////////////////^^^값 입력^^^/////////////////////

        dp[0] = arr[0]; //첫 행은 같으므로 같은 값 (얕은 복사)
        calc(); // dp로 경로 2차원 배열 계산.

        /////////////////////^^^DP 2차원 배열 계산^^^/////////////////
//        printArr(dp);
        System.out.println(min(dp[N - 1]));

        //////////////////^^^최솟값 출력^^^/////////////////



    }

//    static void printArr(int[][] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//    }

    static void calc() {
        int left, right; // 왼쪽 상위와 오른쪽 상위 열 계산하기 위해 할당

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                left = j - 1; // 왼쪽 상위
                right = j + 1; // 오른쪽 상위
                if (left < 0) // 계산하려는 칸의 왼쪽 상위가 배열을 벗어나는 경우
                    left += 3; // 오른쪽으로 넘긴다
                else if (right > 2)  // 계산하려는 칸의 오른쪽 상위가 배열을 벗어나는 경우
                    right -= 3; // 왼쪽으로 넘긴다
                dp[i][j] = Math.min(dp[i-1][left], dp[i-1][right]) + arr[i][j];
                // 왼쪽 상위 vs 오른쪽 상위 최솟값
                // + 가중치
            }
        }
    }

    static int min(int[] arr) {
        return Math.min(arr[0],Math.min(arr[1], arr[2]));
        // 3항 최솟값 반환
    }
}
