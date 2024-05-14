package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스티커
 */
public class Baekjoon_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] array = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    array[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = array[0][1];
            dp[1][1] = array[1][1];

            for(int j = 2; j<=n; j++){
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + array[1][j];
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + array[0][j];
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }

        System.out.println(sb);
    }
}
