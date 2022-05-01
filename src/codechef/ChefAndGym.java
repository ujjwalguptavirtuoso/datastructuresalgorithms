/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package codechef;

import java.util.Scanner;

/**
 * @author wb-ujjwalgup584692
 * @version $Id: ChefAndGym.java, v 0.1 2022-05-01 20:12 wb-ujjwalgup584692 Exp $$
 */
public class ChefAndGym {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z= sc.nextInt();
            if(z<x)
                System.out.println(0);
            if(z>=(x+y))
                System.out.println(2);
            if(z >= x && z<(y+x))
                System.out.println(1);
        }
    }
}
