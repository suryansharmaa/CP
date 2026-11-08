import java.io.*;
import java.util.*;

public class olyaAndGameWArrays {
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
        long minOfAll = Long.MAX_VALUE;
        long minOfSecondMins = Long.MAX_VALUE;
        long sumOfSecondMins = 0;

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            long min1 = Long.MAX_VALUE;
            long min2 = Long.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                long x = sc.nextLong();
                if (x <= min1) {
                    min2 = min1;
                    min1 = x;
                } else if (x < min2) {
                    min2 = x;
                }
            }

            minOfAll = Math.min(minOfAll, min1);
            minOfSecondMins = Math.min(minOfSecondMins, min2);
            sumOfSecondMins += min2;
        }

        long ans = sumOfSecondMins - minOfSecondMins + minOfAll;
        out.println(ans);
    }
}