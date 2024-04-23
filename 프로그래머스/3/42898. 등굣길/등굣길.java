import java.io.*;
import java.util.*;

class Solution {
    
    static final int MOD = 1_000_000_007;
    static int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n + 1][m + 1];
        for(int i = 0; i < puddles.length; i++){
            int[] puddle = puddles[i];
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(dp[i][j] == -1) continue;
                if(dp[i - 1][j] > 0) dp[i][j] += dp[i - 1][j] % MOD;
                if(dp[i][j - 1] > 0) dp[i][j] += dp[i][j - 1] % MOD;
            }
        }
        
        return dp[n][m] % MOD;
    }
}