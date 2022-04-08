package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str;
        int[][] arr = new int[N][2];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0])); 
        // 배열을 정렬하면 LIS로 풀이할 수 있다

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1] && dp[i] < dp[j]) {
                    dp[i] = dp[j];
                }
            }
            dp[i]++;
            if(dp[i] > max)
                max = dp[i];
        }
//        printArr(arr);
        System.out.println(N - max);
        // Math.min(max, N-max)를 출력해서 틀렸었음.
        // 앞서 배열을 정렬해둔 상태였기 때문에, max는 최대 연결 숫자가 된다.
    }

    static void printArr(int[][] arr) {
        for(int i=0; i<arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
