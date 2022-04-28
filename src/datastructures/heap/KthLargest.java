
package datastructures.heap;

import java.util.PriorityQueue;

/**
 *
 * @version $Id: KthLargest.java, v 0.1 2022-04-27 17:57
 */

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Implement KthLargest class:
 *
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 *
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 *
 * Input
 * ["KthLargest","add","add","add","add","add"]
 * [[1,[]],[-3],[-2],[-4],[0],[4]]
 *
 * Output
 * [null, -3, -2, -2, 0, 4]
 */
public class KthLargest {

        private static int k;
        private PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>();

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for(int i = 0; i<nums.length ; i++){
                pQueue.add(nums[i]);
            }

            while(k < pQueue.size()){
                pQueue.poll();
            }
        }

        public int add(int val) {
            pQueue.add(val);
            if(pQueue.size()> k){
                pQueue.poll();
            }

            return pQueue.peek();
        }

    public static void main(String[] args) {

    }
}
