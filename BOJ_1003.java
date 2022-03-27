package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int dp[] = pivo();

        for (int i = 0; i < input; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                System.out.printf("%d %d\n", dp[n+1], dp[n]);
                continue;
            }
            System.out.printf("%d %d\n", dp[n - 1], dp[n]);
        }


    }

    static int[] pivo() {

        int N = 41;

        int[] arr = new int[N];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr;
    }
}
