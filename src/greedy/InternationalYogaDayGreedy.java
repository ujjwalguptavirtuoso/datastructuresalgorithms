package greedy;

import java.util.Scanner;

/**
 * ujjwal.gupta
 * @version $Id: InternationalYogaDayGreedy.java, v 0.1 2022-04-29
 */

/**
 *  Link - https://www.codechef.com/problems/RAMDEV
 *
 *  Here greedy step is to choose max between placing horizontally and placing vertically
 */
public class InternationalYogaDayGreedy {

    /* Convert int to long for codechef submission
     */
    static int calculateMatsForAGivenHall(int lengthOfHall, int breadthOfHall, int length, int breadth){
     //   int totalHall = lengthOfHall * breadthOfHall;
         int placingVertically = (lengthOfHall / length) * (breadthOfHall/breadth);
         int placingHorizontally = (breadthOfHall/length) * (lengthOfHall/breadth);
         int noOfMats = Math.max(placingVertically, placingHorizontally);
         return noOfMats;
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int length = sc.nextInt();
       int breadth = sc.nextInt();
       int noOfHalls = sc.nextInt();
       int ans = 0;
       for (int i = 0; i< noOfHalls; i++){
           int lengthOfHall = sc.nextInt();
           int breadthOfHall = sc.nextInt();
            ans = ans + calculateMatsForAGivenHall(lengthOfHall, breadthOfHall, length, breadth);
       }
       System.out.println(ans);
    }
}
