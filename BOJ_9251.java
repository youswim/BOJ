package main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = " " + br.readLine();
        String b = " " + br.readLine();
        // 편의를 위해서, 한칸은 패딩해둔다

        int[][] dp = new int[a.length()][b.length()];

        int max = 0;

        // LCS 알고리즘 시작
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) { // 편의상 0으로 패딩
                    dp[i][j] = 0;
                } else if (a.charAt(i) == b.charAt(j)) { // 같은 경우, 대각선에서 값을 가져온다.
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    // 다른 경우, 오른쪽이나 상단에서 값을 가져온다.
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    // 최댓값 기록
                }
            }
        }
        System.out.println(max);
    }
}