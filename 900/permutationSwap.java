import java.io.*;
import java.util.*;

public class permutationSwap {
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
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (Math.abs(a[i] - i) != 0) {
                list.add(Math.abs(a[i] - i));
            }
        }

        int ans = 0;
        for (int num : list) ans = gcd(ans, num);

        out.println(ans);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}