import java.io.*;
import java.util.*;

public class mainakAndArrays {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc, out);
        }

        out.flush();
        out.close();
    }

    public static void solve(FastReader sc, PrintWriter out) {
        int n = sc.nextInt();
        int[] a = new int[n];

        int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

            if (a[i] > largest) largest = a[i];
            if (a[i] < smallest) smallest = a[i];
        }

        int first = largest - a[0];
        int second = a[n-1] - smallest;

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) max = Math.max(max, a[i-1]-a[i]);

        out.println(Math.max(max, Math.max(first, second)));
    }
}