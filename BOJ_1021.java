import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());	

		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int[] seq = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < M; i++) {
			

			int target_idx = deque.indexOf(seq[i]);
			int half_idx;

			if(deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			}
			else {
				half_idx = deque.size() / 2;
			}
			
			

			if(target_idx <= half_idx) {

				for(int j = 0; j < target_idx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			}
			else {
				for(int j = 0; j < deque.size() - target_idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			
			}
			deque.pollFirst();	
		}
		System.out.println(count);
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        int[] arr = new int[M];

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int stan = 0; // 움직인 정도를 기록한다
        int size = N; // deque의 size
        int tot = 0; // 최소 회전 횟수 합

        for (int i = 0; i < M; i++) {
            int now_idx = arr[i] - 1 + stan;
            if(now_idx < 0)
                now_idx += size;
            else if(now_idx > size)
                now_idx -= size;

            int front = now_idx;
            int back = size - front;

            if (front <= back) { //front가 더 작은 경우
                stan -= front; // stan에 front만큼 앞으로 움직여야 함을 기록
                tot += front; // front로 움직이는 총 횟수를 기록
            }
            else { //back이 더 작은 경우
                stan += back; // stan에 back만틈 뒤로 움직여야 함을 기록
                tot += back; //
            }
            stan %= size;
            
            // pop한 이후
            size--;
            stan--;
        }
        System.out.println(tot);
    }
}
