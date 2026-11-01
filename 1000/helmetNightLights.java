import java.io.*;
import java.util.*;

public class helmetNightLights {
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
        int p = sc.nextInt();

        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) a[i][0] = sc.nextInt();
        for (int i = 0; i < n; i++) a[i][1] = sc.nextInt();

        Arrays.sort(a, Comparator.comparingInt(x -> x[1]));

        long sum = p;
        int rem = n - 1;

        for (int i = 0; i < n; i++) {
            if (rem <= 0 || a[i][1] >= p) break;

            int take = Math.min(rem, a[i][0]);
            sum += (long) take * a[i][1];
            rem -= take;
        }

        if (rem > 0) sum += (long) rem * p;
        out.println(sum);
    }
}