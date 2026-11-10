import java.io.*;
import java.util.*;

public class monsters {
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

    // Custom static class to bind health and original ID
    static class Pair implements Comparable<Pair> {
        int health;
        int id;

        public Pair(int health, int id) {
            this.health = health;
            this.id = id;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.health == other.health) {
                // If health is tied, the smaller index dies first
                return Integer.compare(this.id, other.id);
            }
            // Otherwise, the larger health dies first
            return Integer.compare(other.health, this.health);
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

        Pair[] monsters = new Pair[n];
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt() % k;
            if (h == 0) {
                h = k; // Handle the exact multiple edge case
            }
            monsters[i] = new Pair(h, i + 1);
        }

        Arrays.sort(monsters);

        for (int i = 0; i < n; i++) {
            out.print(monsters[i].id + " ");
        }
        out.println();
    }
}