import java.io.*;
import java.util.*;

public class balancedRound {
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
        long k = sc.nextLong();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();

        Arrays.sort(a);

        int cnt = 1, max = 1;
        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i] - a[i-1]) <= k) cnt++;
            else {
                max = Math.max(cnt, max);
                cnt = 1;
            }

            max = Math.max(max, cnt);
        }

        out.println(n - max);
    }
}