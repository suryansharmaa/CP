import java.io.*;
import java.util.*;

public class makeItDivisibleBy25 {
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
        String s = sc.next();

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, min(s, "00"));
        ans = Math.min(ans, min(s, "25"));
        ans = Math.min(ans, min(s, "50"));
        ans = Math.min(ans, min(s, "75"));

        out.println(ans);
    }

    public static int min(String s, String t) {
        int i = s.length() - 1;
        int cnt = 0;

        while (i >= 0 && s.charAt(i) != t.charAt(1)) {
            i--;
            cnt++;
        }
        if (i < 0) return Integer.MAX_VALUE;

        i--;

        while (i >= 0 && s.charAt(i) != t.charAt(0)) {
            i--;
            cnt++;
        }
        if (i < 0) return Integer.MAX_VALUE;

        return cnt;
    }
}