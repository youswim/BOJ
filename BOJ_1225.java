package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringTokenizer st;

        st = new StringTokenizer(input);

        String A = st.nextToken();
        String B = st.nextToken();

        long aTot = 0; //long으로 하지 않으면 overflow로 오답!
        long bTot = 0;

        for (int i = 0; i < A.length(); i++) {
            aTot += Character.getNumericValue(A.charAt(i));
        }
        for (int j = 0; j < B.length(); j++){
            bTot += Character.getNumericValue(B.charAt(j));
        }

        System.out.println(aTot * bTot);
    }
}
