package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int[] findArr = new int[M];
        str = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            findArr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N - 1;
            int key = findArr[i];
            int mid;
            int chk = 0;
            while (start <= end) {
                // arr에 key값이 없다면, start와 end값이 역전되는 순간이 생긴다
                mid = (start + end) / 2;
                if (key < arr[mid]) {
                    end = mid - 1;
                } else if (key > arr[mid]) {
                    start = mid + 1;
                } else {
                    chk = 1;
                    break;
                }
            }
            sb.append(chk).append("\n");
        }
        System.out.println(sb);
    }
}
