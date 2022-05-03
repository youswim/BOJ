import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());

        Queue<Paper> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        String[] str;

        int N;
        int M;

        for (int i = 0; i < C; i++) {
            str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]); // 문서 갯수
            M = Integer.parseInt(str[1]); // 궁금한 문서 인덱스
            Integer[] arr = new Integer[N];

            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int pri = Integer.parseInt(str[j]); // 문서의 우선순위 정보
                queue.add(new Paper(j, pri)); // 문서의 인덱스 & 우선순위 저장
                arr[j] = pri; // 문서의 우선순위 배열에 저장
            }

            Arrays.sort(arr, (a, b) -> b - a); // 문서의 우선순위 정렬

            int idx = 0;
            int cnt = 0;
            while (!queue.isEmpty()) {
                if (queue.peek().pri >= arr[idx]) { // queue의 맨 앞 값이 최대값보다 크거나 같다면,
                    cnt++;
                    if (queue.peek().idx == M) { // 꺼내려는 문서의 인덱스가 입력 인덱스와 같다면,
                        sb.append(cnt).append("\n");
                        break;
                    } else { // 꺼내려는 문서의 인덱스가 입력 인덱스와 다르다면,
                        idx++;
                        queue.poll(); // 기록하고 꺼낸다.
                    }
                } else { // 최대값보다 queue의 맨 앞 값이 작다면,
                    queue.add(queue.poll()); // 맨 뒤로 보낸다
                }
            }
            queue.clear();
        }
        System.out.println(sb);
    }

    static class Paper {
        int idx;
        int pri;

        Paper(int idx, int pri) {
            this.idx = idx;
            this.pri = pri;
        }
    }


}
