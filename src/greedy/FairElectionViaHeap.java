package greedy;

import java.util.*;

/**
 * ujjwal.gupta
 * @version $Id: FairElectionViaHeap.java, v 0.1 2022-04-29
 */

/**
 * Code chef link : https://www.codechef.com/problems/FAIRELCT 
 */
public class FairElectionViaHeap {

    static int noOfSwaps(PriorityQueue<Integer> johnQueue, PriorityQueue<Integer> jackQueue, int johnVoteSum, int jackVoteSum){
        int count = 0;
        while(johnVoteSum <= jackVoteSum){
            int jack_ele = jackQueue.poll();
            int john_ele = johnQueue.poll();
            if(john_ele >=jack_ele){
                break;
            }
            johnVoteSum = johnVoteSum - john_ele + jack_ele;
            jackVoteSum = jackVoteSum - jack_ele + john_ele;
            johnQueue.offer(jack_ele);
            jackQueue.offer(john_ele);
            count++ ;
        }
        if(jackVoteSum >= johnVoteSum) return -1;
        return count;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no of test cases
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();   // john packs
            int b = sc.nextInt();   // jack packs
            PriorityQueue<Integer> johnQueue = new PriorityQueue<>();
            PriorityQueue<Integer> jackQueue = new PriorityQueue<>(Collections.reverseOrder());
            int johnVoteSum = 0;
            int jackVoteSum = 0;

            for (int j = 0; j < a; j++) {
                int c = sc.nextInt();  // values of john packs
                johnQueue.offer(c);
                johnVoteSum += c;
            }
            for (int k = 0; k < b; k++) {
                int d = sc.nextInt();  // values of jack packs
                jackQueue.offer(d);
                jackVoteSum += d;

            }
            System.out.println(noOfSwaps(johnQueue, jackQueue, johnVoteSum, jackVoteSum));
        }
    }

}

