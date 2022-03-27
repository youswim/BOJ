package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dp;
    static int mod = 15746;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();

        if (N < 3) {
            System.out.println(N);
            return;
        }

        dp = new int[N+1];
        makeDp(N);

        System.out.println(dp[N]);
    }

    static void makeDp(int a) {

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (a = 3; a < dp.length; a++) {
            dp[a] = (dp[a - 1] + dp[a - 2]) % mod;
            // 모듈러 연산은 이곳에서 하는게 맞다.
            // 오버플로가 발생하기 때문!!
        }
    }

}
