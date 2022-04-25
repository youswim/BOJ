package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int now = 1; // 현재까지 stack에 들어간 최대 숫자 + 1
        for (int i = 0; i < n; i++) {
            int out = Integer.parseInt(br.readLine()); // stack에서 뽑고 싶은 숫자
            for (int j = now; j <= out; j++) {
                stack.push(now);
                sb.append("+").append("\n");
                now = j + 1;
            }
            int chk = stack.pop();
            if (chk != out) {
                System.out.println("NO");
                return;
            }
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}