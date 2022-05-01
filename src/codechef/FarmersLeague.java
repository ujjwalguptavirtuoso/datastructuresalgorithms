/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package codechef;

import java.util.Scanner;

/**
 * @author wb-ujjwalgup584692
 * @version $Id: FarmersLeague.java, v 0.1 2022-05-01 20:35 wb-ujjwalgup584692 Exp $$
 */
public class FarmersLeague {


    static int maxPoints(int noOfTeams ){
        if(noOfTeams == 2){
            return 3;
        }
        int noOfMatches = noOfTeams * (noOfTeams - 1) / 2 ;
        int pointsOfLeadingTeam = 3 * (noOfTeams - 1);
        int pointsOfSecondTeam = 3 * ((noOfMatches - (noOfTeams - 1)) / (noOfTeams - 2));
           return  pointsOfLeadingTeam - pointsOfSecondTeam;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int noOfTeams = sc.nextInt();
           System.out.println(maxPoints(noOfTeams));
        }
    }
}
