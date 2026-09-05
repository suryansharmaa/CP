import java.io.*;
import java.util.*;

public class minusTwo {
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
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();

        int odds = 0, mod4 = 0, mod2 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != 0) odds++;
            else if (a[i] % 4 == 0) mod4++;
            else mod2++;
        }

        Arrays.sort(a);
        int max = 1, curr = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i-1]) curr++;
            else curr = 1;

            max = Math.max(curr, max);
        }

        int ans = Math.max(max, Math.max(odds, Math.max(mod2, mod4)));
        out.println(ans);
    }
}