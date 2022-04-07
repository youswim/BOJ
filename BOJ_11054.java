package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        dp = new int[2][N];
        setDp();

        int max = 0;
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            tmp = leftDp(i) + rightDp(i) - 1;
            if(max < tmp)
                max = tmp;
        }
        System.out.println(max);
        printArr();
    }

    static int leftDp(int idx){
        if (dp[0][idx] != 0) {
            return dp[0][idx];
        }
        int tmpMax = 0;
        int tmp = 0;
        for (int i = idx-1; i >= 0; i--) {
            tmp = leftDp(i);
            if (arr[i] < arr[idx] && tmpMax < tmp)
                tmpMax = tmp;
        }
        tmpMax++;
        return dp[0][idx] = tmpMax;
    }

    static int rightDp(int idx){
        if (dp[1][idx] != 0) {
            return dp[1][idx];
        }
        int tmpMax = 0;
        int tmp = 0;
        for (int i = idx + 1; i < N; i++) {
            tmp = rightDp(i);
            if (arr[i] < arr[idx] && tmpMax < tmp)
                tmpMax = tmp;
        }
        tmpMax++;
        return dp[1][idx] = tmpMax;
    }

    static void setDp() {
        dp[0][0] = 1;
        dp[1][N-1] = 1;
    }

    static void printArr(){
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}