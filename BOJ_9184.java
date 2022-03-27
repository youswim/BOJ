package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][][] arr = new int[21][21][21];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int res=0;
        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            res = w(a,b,c);
            sb.append("w(" + a + ", " + b + ", " + c + ") = " + res + "\n");
        }
        System.out.println(sb);

    }

    static int w(int a, int b, int c) {

        // if문의 순서를 문제에서 준 것과 다른 순서로 만들어서
        // 수많은 맞왜틀에 빠졌었음.
        // 주어진 문제의 조건을 잘 확인하도록 하자

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (arr[a][b][c] != 0) {
            return arr[a][b][c];
        }
        if (a < b && b < c) {
            arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return arr[a][b][c];
        }
        arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return arr[a][b][c];
    }

}
