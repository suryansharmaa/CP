import java.io.*;
import java.util.*;

public class multiply2Divide6 {
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
        long n = sc.nextLong();
        int cnt = 0;

        while (n > 1) {
            if (n % 6 == 0) {
                n /= 6;
                cnt++;
            } else if (n % 3 == 0) {
                n *= 2;
                cnt++;
            } else {
                break;
            }
        }

        if (n == 1) out.println(cnt);
        else out.println("-1");
    }
}