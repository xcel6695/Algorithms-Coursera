/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floyd;

/**
 *
 * @author veer6182
 */
import java.io.*;
import java.util.*;

public class Floyd {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\veer6182\\Documents\\NetBeansProjects\\Floyd\\src\\floyd\\g3.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long adj[][] = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = 1000000000L;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            adj[x][y] = c;
        }

        long ans = Long.MAX_VALUE;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    ans = Math.min(adj[i][j], ans);
                }
            }
        }

        boolean cycle = false;

        for (int i = 0; i < n; i++) {
            if (adj[i][i] < 0) {
                cycle = true;
            }
        }

        if (cycle) {
            System.out.println("NULL");
        } else {
            System.out.println(ans);
        }
    }

}
