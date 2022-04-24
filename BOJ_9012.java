package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        // 안되는 경우
        // 1. 열지도 않았는데 바로 닫는경우
        // 2. 열기로 시작했는데 더 많이 닫는 경우
        // 3. 열기로 시작, 열기가 남은 경우.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < T; i++) {
            stack.clear();
            String str = br.readLine();
            boolean chk = false;

            for (int j = 0; j < str.length(); j++) {
                char p = str.charAt(j);
                if (p == '(')
                    stack.push(1);
                else if (p == ')') {
                    if (stack.empty()) {
                        chk = true;
                        break;
                    } else
                        stack.pop();
                }
            }

            if (!chk && stack.empty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        br.close();
        System.out.println(sb);
    }


}