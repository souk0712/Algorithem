import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int INT = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[100_001][4];

        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i < 100_001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % INT;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % INT;
            dp[i][3] = (dp[i - 3][2] + dp[i - 3][1]) % INT;
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append((dp[N][1] + dp[N][2] + dp[N][3]) % INT).append("\n");
        }
        System.out.println(sb);
    }
}