import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numOfMeeting = sc.nextInt();

        int[][] timeTable = new int[numOfMeeting][2];

        for (int i = 0; i < numOfMeeting; i++) {
            timeTable[i][0] = sc.nextInt();
            timeTable[i][1] = sc.nextInt();
        }

        Arrays.sort(timeTable,
                (t1, t2) -> {
            if(t1[1]==t2[1]) //종료 시간이 같다면, 시작 시간이 늦은 경우가 먼저 온다.
                return t1[0]-t2[0];
            else
                return t1[1]-t2[1]; //종료 시간이 빠른 경우가 먼저 온다.
                });


//        for (int[] ints : timeTable) {
//            System.out.println(Arrays.toString(ints));
//        }

        int max = 0;
        int tmpEndTime = 0;

        for (int i = 0; i < numOfMeeting; i++) {

            if (tmpEndTime <= timeTable[i][0]) {
                tmpEndTime = timeTable[i][1];
                max++;
            }
        }
        System.out.println(max);
    }
}
