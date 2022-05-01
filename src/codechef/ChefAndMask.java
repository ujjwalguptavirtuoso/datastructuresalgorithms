/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package codechef;

import java.util.Scanner;

/**
 * @author wb-ujjwalgup584692
 * @version $Id: ChefAndMask.java, v 0.1 2022-05-01 20:23 wb-ujjwalgup584692 Exp $$
 */
public class ChefAndMask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x * 100 == y * 10) {
                System.out.println("Cloth");
            }
            if (x * 100 > y * 10) {
                System.out.println("Cloth");
            }
            if (x * 100 < y * 10) {
                System.out.println("Disposable");
            }
        }
    }
}
