/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsph;

/**
 *
 * @author veer6182
 */
import java.io.*;
import java.util.*;

public class Tsph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\veer6182\\Documents\\NetBeansProjects\\tsph\\src\\tsph\\nn.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(n);

        double x[] = new double[n];
        double y[] = new double[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 1; i < n; i++) {
            set.add(i);
        }

        int curr = 0;
        double ans = 0;
        while (set.size() > 0) {
            //System.out.println("loop");
            Iterator<Integer> ir = set.iterator();
            double min = Double.MAX_VALUE;
            int mini = -1;

            while (ir.hasNext()) {
                int j = ir.next();
                double dist = dist(x[curr], y[curr], x[j], y[j]);
                if (dist < min) {
                    min = dist;
                    mini = j;
                } else if (dist == min) {
                    mini = Math.min(mini, j);
                }
            }

            ans += min;
            set.remove(mini);
            curr = mini;

        }

        ans += dist(x[curr], y[curr], x[0], y[0]);
        System.out.println(ans);

    }

    static double dist(double x1, double y1, double x2, double y2) {

        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
