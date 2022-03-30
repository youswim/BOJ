package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {

    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        dp[1] = 0;

        calcDp();

        System.out.println(dp[n]);
    }

    static void calcDp() {

        for (int i = 2; i <= n; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(dp[i / 3], Math.min(dp[i / 2], dp[i - 1])) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else
                dp[i] = dp[i-1] + 1;
        }
    }

}