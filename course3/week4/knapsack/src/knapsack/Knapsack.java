/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

/**
 *
 * @author veer6182
 */
import java.io.*;
import java.util.*;

public class Knapsack {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\veer6182\\Downloads\\algorithms_course\\algorithms_veer\\course3\\week4\\knapsack\\src\\knapsack\\knapsack.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int capacity = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int w[] = new int[n + 1];
        long val[] = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            val[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        long dp[][] = new long[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= capacity; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i] + dp[i - 1][j - w[i]]);
                }
            }
        }

        System.out.println(dp[n][capacity]);

    }

}
