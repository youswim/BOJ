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
            if (str[0] == "push") {
                int a = Integer.parseInt(str[1]);
                stack.push(a);
            } else if (str[0] == "pop") {
                sb.append(stack.pop());
            } else if (str[0] == "size") {

            } else if (str[0] == "empty") {

            }else if (str[0] == "top") {

            }
        }
    }
}