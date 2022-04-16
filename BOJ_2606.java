package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberNode = Integer.parseInt(br.readLine());
        int numberLine = Integer.parseInt(br.readLine());

        ArrayList<LinkedList<Integer>> lineList = new ArrayList<>(numberNode + 1);
        for (int i = 0; i < numberNode + 1; i++) {
            lineList.add(new LinkedList<>());
        }

        String[] str;
        for (int i = 0; i < numberLine; i++) {
            str = br.readLine().split(" ");
            int v1 = Integer.parseInt(str[0]);
            int v2 = Integer.parseInt(str[1]);
            lineList.get(v1).add(v2);
            lineList.get(v2).add(v1);
        }

        boolean[] visited = new boolean[numberNode + 1];
        Queue<Integer> queue = new LinkedList<>();

        int cnt = 0;
        int startNode = 1;
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int w : lineList.get(n)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        }
}