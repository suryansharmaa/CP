import java.io.*;
import java.util.*;

public class makeAP {
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
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        boolean ans = false;
        long newA = 2 * b - c;
        if (newA / a > 0 && newA%a == 0) ans = true;

        long newB = (a + c) / 2;
        if (newB / b > 0 && newB%b == 0 && (a+c)%2 == 0) ans = true;

        long newC = 2*b - a;
        if (newC / c > 0 && newC%c == 0) ans = true;

        out.println(ans ? "Yes" : "No");
    }
}