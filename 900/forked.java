import java.io.*;
import java.util.*;

public class forked {
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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int xK = sc.nextInt();
        int yK = sc.nextInt();
        int xQ = sc.nextInt();
        int yQ = sc.nextInt();

        int[] dX = {a, a, -a, -a, b, b, -b, -b};
        int[] dY = {b, -b, b, -b, a, -a, a, -a};

        HashSet<String> king = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            king.add((xK + dX[i]) + "," + (yK + dY[i]));
        }

        HashSet<String> queen = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            queen.add((xQ + dX[i]) + "," + (yQ + dY[i]));
        }

        int cnt = 0;
        for (String s : king) {
            if (queen.contains(s)) {
                cnt++;
            }
        }

        out.println(cnt);
    }
}