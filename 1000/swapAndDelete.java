import java.io.*;
import java.util.*;

public class swapAndDelete {
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

        int ones = 0, zeroes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zeroes++;
            else ones++;
        }

        int cnt = 0, i = 0;
        while(i < s.length()) {
            if (s.charAt(i) == '0') {
                if (ones > 0) ones--;
                else break;
            }
            else {
                if (zeroes > 0) zeroes--;
                else break;
            }
            cnt++;
            i++;
        }

        out.println(s.length() - cnt);
    }
}