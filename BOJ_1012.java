package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
// 틀림
public class Main {

    static int xSize;
    static int ySize;
    static StringBuilder sb;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            boolean[][] farmArr = getInput();
            startExplore(farmArr);
        }
        sb.deleteCharAt(testCaseCount * 2 - 1);
        System.out.println(sb);
        br.close();
    }

    static boolean[][] getInput() throws IOException {
        String[] str;
        str = br.readLine().split(" ");

        xSize = Integer.parseInt(str[0]);
        ySize = Integer.parseInt(str[1]);
        int cabbageCount = Integer.parseInt(str[2]);

        boolean[][] farmArr = new boolean[xSize][ySize];

        for (int j = 0; j < cabbageCount; j++) {
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            farmArr[x][y] = true;
        }
        return farmArr;
    }

    static void startExplore(boolean[][] farmArr) {
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[xSize][ySize];

        int warmCount = 0;
        for (int j = 0; j < xSize; j++) {
            for (int k = 0; k < ySize; k++) {

                if (farmArr[j][k] && !visited[j][k]) {
                    queue.add(new Pos(j, k));
                    visited[j][k] = true;
                    warmCount++;

                    bfs(farmArr, visited, queue);
                }
            }
        }
        sb.append(warmCount).append("\n");
    }

    static void bfs(boolean[][] farmArr, boolean[][] visited, Queue<Pos> queue) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!queue.isEmpty()){
        Pos nowPos = queue.poll();

            for (int a = 0; a < 3; a++) {
                int searchX = nowPos.x + dx[a];
                int searchY = nowPos.y + dy[a];

                if (searchX >= 0 && searchX < xSize && searchY >= 0 && searchY < ySize) {
                    if (farmArr[searchX][searchY] && !visited[searchX][searchY]) {
                        visited[searchX][searchY] = true;
                        queue.add(new Pos(searchX, searchY));
                    }
                }
            }
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