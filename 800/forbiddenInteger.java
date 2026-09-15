import java.io.*;
import java.util.*;

public class forbiddenInteger {
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
        int x = sc.nextInt();

        if (x != 1) {
            out.println("YES");
            out.println(n);
            for (int i = 0; i < n; i++) out.print("1 ");
            out.println();
            return;
        }

        if (k == 1 || (k == 2 && n % 2 != 0)) {
            out.println("NO");
            return;
        }

        out.println("YES");
        out.println(n/2);
        if (n % 2 == 0) {
            for(int i = 0; i < n/2; i++) out.print("2 ");
        } else {
            out.print("3 ");
            for(int i = 0; i < (n - 3)/2; i++) out.print("2 ");
        }
        out.println();
    }
}