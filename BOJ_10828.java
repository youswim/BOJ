package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        String[] str;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            switch (str[0]) {
                case "push":
                    int a = Integer.parseInt(str[1]);
                    stack.push(a);
                    break;
                case "pop":
                    if (stack.empty())
                        sb.append(-1).append("\n");
                    else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.empty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "top":
                    if(stack.empty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
