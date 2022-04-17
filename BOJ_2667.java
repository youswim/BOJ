package main;

// 완성안됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        String[] str;

        for (int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        boolean[][] visited = new boolean[N][N];

        Queue<Pos> queue = new LinkedList<>();
        Pos now;

        int danjisu = 0;

        int number = 0;

        LinkedList<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    danjisu++;
                    queue.add(new Pos(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        now = queue.poll();
                        if (now.y + 1 < N) {
                            if (arr[now.x][now.y + 1] == 1 && !visited[now.x][now.y + 1]) {
                                queue.add(new Pos(now.x, now.y + 1));
                                visited[now.x][now.y + 1] = true;
                                number++;
                            }
                        }
                        if (now.x + 1 < N) {
                            if (arr[now.x + 1][now.y] == 1 && !visited[now.x + 1][now.y]) {
                                queue.add(new Pos(now.x + 1, now.y));
                                visited[now.x + 1][now.y] = true;
                                number++;
                            }
                        }
                    }
                }
                if (number != 0) {
                    numbers.add(number);
                    number = 0;
                }
            }
        }

        System.out.println(danjisu);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

    static class Pos{
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}