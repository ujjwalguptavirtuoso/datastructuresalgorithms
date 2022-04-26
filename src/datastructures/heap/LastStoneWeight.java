package datastructures.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author ujjwal.gupta
 * @version $Id: LastStoneWeight.java, v 0.1 2022-04-26 10:07
 */

/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 */
public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {

        int heavy1 = 0;
        int heavy2 = 0;
        // new stone after smash of heavy1 and heavy2
        int newStone = 0;

        if(stones.length == 0 ){
            return 0;
        }if(stones.length == 1){
            return stones[0];}


        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        for(int i=0; i<stones.length; i++){
            pQueue.add(stones[i]);
        }

        
        while(!pQueue.isEmpty() && pQueue.size()!=1){
            heavy1 = pQueue.poll();
            heavy2 = pQueue.poll();

            if(heavy1>heavy2){
                newStone = heavy1 - heavy2;
                pQueue.add(newStone);
            }
        }
        return pQueue.size() == 0 ? 0 : pQueue.poll();

    }

    public static void main(String[] args) {

        int [] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));

    }
}
