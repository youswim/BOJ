
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int white = 0;
    static int blue = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringTokenizer st;

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paper(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void paper(int row, int col, int size) {
        if (check(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        paper(row, col, newSize);
        paper(row, col + newSize, newSize);
        paper(row + newSize, col, newSize);
        paper(row + newSize, col + newSize, newSize);
    }

    static boolean check(int row, int col, int size) {

        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
