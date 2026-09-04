import java.io.*;
import java.util.*;

public class lineTrip {
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
        int x = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();

        if (n == 1) {
            out.println(Math.max(a[0], 2 * (x - a[0])));
            return;
        }

        int max = a[0];
        for (int i = 1; i < n; i++) {
            int diff = a[i] - a[i-1];
            max = Math.max(max, diff);

            if (i == n-1) {
                diff = 2 * (x - a[i]);
                max = Math.max(max, diff);
            }
        }

        out.println(max);
    }
}