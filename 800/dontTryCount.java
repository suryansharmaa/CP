import java.io.*;
import java.util.*;

public class dontTryCount {
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
        int m = sc.nextInt();

        String x = sc.next();
        String s = sc.next();

        if (x.contains(s)) {
            out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder(x);

        int count = 0;
        while(n <= m) {
            count++;
            n += n;
            sb.append(sb);
            if (sb.toString().contains(s)) {
                out.println(count);
                return;
            }
        }

        sb.append(sb);
        if (sb.toString().contains(s)) {
            out.println(count + 1);
            return;
        }
        out.println(-1);
    }
}