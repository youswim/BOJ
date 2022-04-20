package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class tomato {
    int x; // 세로
    int y; // 가로

    tomato(int x, int y) {
        this.x = x; // 세로
        this.y = y; // 가로
    }
}

public class Main {
    static int M;
    static int N;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int[][] board;

    static Queue<tomato> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        str = br.readLine().split(" ");

        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);

        board = new int[N][M];

        que = new LinkedList<tomato>();

        // 토마토판 입력
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(str[j]);

                if (board[i][j] == 1)
                    que.add(new tomato(i, j));
            }
        }
        System.out.println(BFS());
    }

    static int BFS() {
        while (!que.isEmpty()) {
            tomato t = que.remove();

            int x = t.x;
            int y = t.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (board[nx][ny] == 0) {
                        que.add(new tomato(nx, ny));

                        board[nx][ny] = board[x][y] + 1;
                    }
                }
            }
        }


        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0)
                    return -1;

                result = Math.max(result, board[i][j]);

            }
        }

        if (result == 1)
            return 0;

        else
            return result - 1;
    }
}