package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    static long[] arr; // 문제에 주어진 N의 최대 크기를 수용하려면 long를 사용해야 한다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(br.readLine());
        // 반복횟수 = repeat
        StringBuilder sb = new StringBuilder();
        // 출력값을 모았다가 한번에 출력하기 위함

        int[] input = new int[repeat]; // 반복 횟수만큼의 입력 배열 생성.
        int max = 0; // 입력중에 큰 값 저장
        for (int i = 0; i < repeat; i++) {
            input[i] = Integer.parseInt(br.readLine()); //입력받기
            if (input[i] > max) { //최댓값 저장
                max = input[i];
            }
        }
        br.close();

        arr = new long[max+1];
        setDpArr();
        makeDpArr(max);

        for (int i = 0; i < repeat; i++) {
            sb.append(arr[input[i]]).append("\n");
        }
        System.out.println(sb);
    }

    static void setDpArr() {
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
    }

    static void makeDpArr(int max) {
        for (int i = 6; i <= max; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }
    }

}
