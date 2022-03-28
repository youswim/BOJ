package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int size;

    public static void main(String[] args) throws IOException {

        getArr(); // 2차원 배열을 입력받는 메서드

        getDp(); // dp로 얻어낸 가중치 2차원 배열 계산하는 메서드

        printMax(); // 최댓값 출력하는 메서드

    }

    static void getArr() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        arr = new int[size][size];

        String[] str;
        for (int i = 0; i < size; i++) {
            str = br.readLine().split(" ");

            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        br.close();
    }

    static void getDp() {
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
            }
        }
    }

    static void printMax() {
        System.out.println(arr[0][0]);
    }
}
