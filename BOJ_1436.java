package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int row = Integer.parseInt(str[0]);
        int col = Integer.parseInt(str[1]);

        char[][] arr = new char[row][col];
        for (int i = 0; i < row; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int min = row * col;
        int tmp;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                tmp = 0;
                for (int a = i; a < i + 8; a++) {
                    for (int b = j; b < j + 8; b++) {
                        int i1 = (a - i + b - j) % 2;
                        if (i1 == 0 && arr[i][j] != arr[a][b]) {
                            tmp++;
                        } else if (i1 == 1 && arr[i][j] == arr[a][b]) {
                            tmp++;
                        }
                    }
                }
                tmp = Math.min(tmp, 64 - tmp);
                min = Math.min(min, tmp);
            }
        }
        System.out.println(min);
    }
}