import java.util.Scanner;

public class oneAndTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long[] a = new long[(int) n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            long totalNumberOfTwos = 0;
            long currentNumberOfTwos = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] == 2) {
                    totalNumberOfTwos++;
                }
            }

            long ans = -1;

            for (int i = 0; i < n; i++) {
                if (a[i] == 2) {
                    currentNumberOfTwos++;
                }

                if (currentNumberOfTwos == (totalNumberOfTwos - currentNumberOfTwos)) {
                    ans = i + 1;
                    break;
                }
            }

            System.out.println(ans);
        }
        scanner.close();
    }
}
