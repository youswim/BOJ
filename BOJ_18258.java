package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        long beforeTime = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        String[] str;
        int last = 0;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");

            switch (str[0]) {
                case "push":
                    last = Integer.parseInt(str[1]);
                    queue.add(last);
                    break;
                case "pop":
                    if (queue.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty())
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;
                case "front":
                    if (queue.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(queue.peek()).append("\n");
                    break;
                case "back":
                    if (queue.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(last).append("\n");
                    break;
            }

        }
        System.out.println(sb);
        long afterTime = System.currentTimeMillis();
        System.out.println(afterTime - beforeTime);
    }
}
