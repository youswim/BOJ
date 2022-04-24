package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        while (!str.equals(".")) {
            boolean flag = false;
            for (int j = 0; j < str.length(); j++) {
                char p = str.charAt(j);
                if (p == '(') {
                    stack.push('(');
                } else if (p == '[') {
                    stack.push('[');
                } else if (p == ')') {
                    if (!stack.isEmpty()) {
                        if(stack.peek()=='(') // 같지 않으면 그냥 넘어감
                            stack.pop();
                        else {
                            flag = true;
                            break;
                        }
                    } else {
                        flag = true;
                        break;
                    }
                } else if (p == ']') {
                    if(!stack.empty()){
                        if(stack.peek()=='[')
                            stack.pop();
                        else {
                            flag = true;
                            break;
                        }
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
            if (stack.empty() && !flag) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
            stack.clear();
            str = br.readLine();
        }
        System.out.println(sb);


        // 문자열 한칸씩 보다가 여는 태그 나오면 push.
        // 닫는 태그 나오면 pop.
        // stack.peek이 현재 pop하려는 거랑 다르면, 오류 체크!
        // pop 하려고 했는데 스택에 없으면 오류 체크!






    }
}