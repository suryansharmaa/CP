import java.io.*;
import java.util.*;

public class comparisonString {
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
        String s = sc.next();

        int cnt1 = 1, cnt2 = 1, max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '<' && s.charAt(i-1) == '<') {
                cnt1++;
            } else if (s.charAt(i) == '>' && s.charAt(i-1) == '>') {
                cnt2++;
            } else {
                max = Math.max(max, Math.max(cnt1, cnt2));
                cnt1 = 1;
                cnt2 = 1;
            }
        }

        max = Math.max(max, Math.max(cnt1, cnt2));
        out.println(max+1);
    }
}