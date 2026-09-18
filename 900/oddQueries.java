import java.io.*;
import java.util.*;

public class oddQueries {
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
        int q = sc.nextInt();

        long[] pref = new long[n+1];

        for (int i = 1; i <= n; i++) {
            long a = sc.nextLong();
            pref[i] = pref[i-1] + a;
        }

        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            long k = sc.nextLong();

            long curr = pref[n] - (pref[r] - pref[l-1]);
            curr += (k * (r - l + 1));

            out.println(curr % 2 != 0 ? "Yes" : "No");
        }
    }
}