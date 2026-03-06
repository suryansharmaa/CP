import java.io.*;
import java.util.*;

public class weirdAlgorithm {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        List<Long> list = new ArrayList<>();
        list.add(n);

        while (n != 1) {
            n = n % 2 == 0 ? n / 2 : (n * 3) + 1;
            list.add(n);
        }

        PrintWriter out = new PrintWriter(System.out);
        for (long num : list)
            out.print(num + " ");
        out.flush();
    }
}
