package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int[] arr;
    static int size;

    public static void main(String[] args) throws IOException {
        getDp();

        setDp();

        calcDp();

        printMax();
    }

    static void getDp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        arr = new int[size];
        dp = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    static void setDp() {
        dp[0] = arr[0];
        if (size > 1) {
            dp[1] = arr[0] + arr[1];
        }
    }

    static void calcDp() {
        for (int i = 2; i < size; i++) {
            if (i == 2) {
                dp[2] = Math.max(arr[0], arr[1]) + arr[2];
                continue;
            }
            dp[i] = Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]) + arr[i];
        }
    }

    static void printMax() {
        System.out.println(dp[size-1]);
    }
}
