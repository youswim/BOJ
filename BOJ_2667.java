package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pos> queue;
    static int jipsu = 0;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        set();

        start();

    }

    static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        String[] str;

        for (int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        visited = new boolean[N][N];

        queue = new LinkedList<>();

    }

    static void start() {

        int danjisu = 0; //단지수 카운트를 위한 변수
        LinkedList<Integer> jipsuList = new LinkedList<>();
        // 단지의 아파트 갯수 저장하기 위한 List 할당
        // 몇개의 단지가 있는지 모르므로, 삽입이 용이한 LinkedList로 사용

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) { // map을 돈다
                if (map[i][j] == 1 && !visited[i][j]) { // 아파트가 있고, 방문하지 않았다면,
                    danjisu++; jipsu++;
                    // 단지수 +1, 단지내 집 수 +1

                    queue.add(new Pos(i, j));
                    //queue에 아파트 추가
                    visited[i][j] = true;
                    //아파트 방문 기록
                    bfs(); // bfs시작
                }

                if (jipsu != 0) {
                    // 움직인 map에 집이 없거나 방문한 집이었다면 집의 수가 0일 것임
                    jipsuList.add(jipsu);
                    // 현재 단지의 집 수 list에 저장
                    jipsu = 0;
                    // 집 수 초기화
                }
            }
        }
        Collections.sort(jipsuList); // 집 수를 오름차순으로 보여주기 위한 list 정렬
        sb.append(danjisu); // 단지의 갯수 문자열에 append
        for (Integer num : jipsuList) { //리스트를 돌면서 집 수 가져옴
            sb.append("\n").append(num); // 가져온 집 수 문자열에 append
        }
        System.out.println(sb); // 한꺼번에 출력
    }

    static void bfs(){
        Pos now; // 탐색중인 노드를 표시하기 위함
        while (!queue.isEmpty()) {
            now = queue.poll(); // queue에서 하나를 뺌

            for (int a = 0; a < 4; a++) { // 상하좌우로 탐색
                int nowRow = now.row + dr[a]; // 상 하
                int nowCol = now.col + dc[a]; // 좌 우

                if (nowRow >= 0 && nowRow < N && nowCol >= 0 && nowCol < N) { // map의 범위 내에 있다면
                    if (map[nowRow][nowCol] == 1 && !visited[nowRow][nowCol]) { // 아파트가 있고 방문하지 않았다면
                        queue.add(new Pos(nowRow, nowCol)); // queue에 노드 저장
                        visited[nowRow][nowCol] = true; // 방문 기록
                        jipsu++; // 집 수 +1
                    }
                }
            }
        }
    }

    static class Pos {
        int row;
        int col;

        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
