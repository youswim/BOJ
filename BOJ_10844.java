package hellojpa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    static int N;
    static final int TEN = 10;
    static final int BILLION = 1_000_000_000;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        getInput();

        setDp();

        calcDp();

        getRes();

    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][TEN];
        br.close();
    }

    static void setDp() {
        for (int i = 1; i < TEN; i++) {
            dp[1][i] = 1;
        }
    }

    static void calcDp() {

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < TEN; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j + 1] % BILLION;
                } else if (j == 9) {
                    dp[i][j] = dp[i-1][j - 1] % BILLION;
                }
                else
                    dp[i][j] = (dp[i-1][j - 1] + dp[i-1][j + 1]) % BILLION;
            }
        }
    }

    static void getRes() {
        int res = 0;
        for (int i = 0; i < TEN; i++) {
            res += dp[N][i];
            res %= BILLION;
        }
        System.out.println(res);
    }

}