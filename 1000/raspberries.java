import java.io.*;
import java.util.*;

public class raspberries {
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
        int k = sc.nextInt();

        int min = k, even = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();

            int steps =  (a % k == 0) ? 0 : k - (a%k);
            min = Math.min(min, steps);

            if(a % 2 == 0) even++;
        }

        if (k == 4) {
            if (even >= 2) min = 0;
            else if (even == 1) min = Math.min(min, 1);
            else min = Math.min(min, 2);
        }

        out.println(min);
    }
}