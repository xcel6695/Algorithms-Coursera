/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum;

/**
 *
 * @author veer6182
 */
import java.io.*;
import java.util.*;

public class Sum {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\veer6182\\Downloads\\algorithms_course\\algorithms_veer\\course2\\week4\\Sum\\src\\sum\\2sum.txt"));

        int n = 1000000;
        boolean possible[] = new boolean[20001];

        HashSet<Long> set = new HashSet<Long>();

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            System.out.println(i);
            for (long j = -10000; j <= 10000; j++) {
                if (x == j / 2) {
                    continue;
                }

                if (set.contains(j - x)) {
                    possible[(int) j + 10000] = true;
                }

            }
            set.add(x);
        }

        int c = 0;
        for (int i = 0; i <= 20000; i++) {
            if (possible[i]) {
                c++;
            }
        }

        System.out.println(c);
    }

}
