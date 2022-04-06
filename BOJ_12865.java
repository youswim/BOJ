package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");


        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1]; // 가치
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            str = br.readLine().split(" ");
            W[i] = Integer.parseInt(str[0]);
            V[i] = Integer.parseInt(str[1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                if(W[i] > j) { // w[i]를 가방에 담을 수 없는 무게라면
                    dp[i][j] = dp[i - 1][j]; // 이전에 담은 것을 그대로 가져간다
                }
                // w[i]를 가방에 넣을 수 있다면
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                    // 이전에 담은 것 vs W[i] + 남은 무게의 최대 적재량
                }

            }
        }
        System.out.println(dp[N][K]);
    }
}