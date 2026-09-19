import java.io.*;
import java.util.*;

public class deletiveEditing {
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
        String t = sc.next();

        int[] count = new int[26];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'A']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (count[c - 'A'] > 0) {
                sb.append(c);
                count[c - 'A']--;
            }
        }

        sb.reverse();
        out.println(sb.toString().equals(t) ? "YES" : "NO");
    }
}