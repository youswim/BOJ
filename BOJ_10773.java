package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        long tot = 0;

        for (int i = 0; i < K; i++) {
            int inpt = Integer.parseInt(br.readLine());
            if (inpt == 0) {
                if(stack.empty())
                    continue;
                tot -= stack.pop();
            }
            else {
                stack.push(inpt);
                tot += inpt;
            }
        }
        br.close();
        System.out.println(tot);

    }
}