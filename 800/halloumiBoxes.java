import java.io.*;
import java.util.*;

public class halloumiBoxes {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());

            out.println(solve(a, k));
        }
    }

    private static String solve(int[] a, int k) {
        if (isSorted(a))
            return "YES";
        else if (k >= 2)
            return "YES";
        else {
            return "NO";
        }
    }

    private static boolean isSorted(int[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1])
                return false;
        }
        return true;
    }
}