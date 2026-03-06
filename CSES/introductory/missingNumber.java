import java.io.*;
import java.util.*;

public class missingNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long total = (long) n * (n + 1) / 2;
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            int m = Integer.parseInt(st.nextToken());

            sum += m;
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(total - sum);
        out.flush();
    }
}