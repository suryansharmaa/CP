import java.io.*;
import java.util.*;

public class makeItZero {
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

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (isZero(a)) {
            out.println(0);
            return;
        }

        if (n % 2 == 0) {
            out.println("2");
            out.println("1 "+n);
            out.println("1 "+n);
        }
        else {
            out.println("4");
            out.println("1 "+(n-1));
            out.println("1 "+ (n-1));
            out.println((n-1) + " " + n);
            out.println("1 " + n);
        }
    }

    private static boolean isZero(int[] a) {
        for (int j : a) {
            if (j != 0) return false;
        }

        return true;
    }
}