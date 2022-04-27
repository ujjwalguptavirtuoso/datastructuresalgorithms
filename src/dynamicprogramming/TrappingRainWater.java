
package dynamicprogramming;

/**
 * @author ujjwal.gupta
 * @version $Id: TrappingRainWater.java, v 0.1 2022-04-27
 */
public class TrappingRainWater {

    /**
     * we are using array pre processing concept here
     *
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
     *
     *
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,
     */

    public static int trap(int[] height) {

        /** solving by array pre processing, making auxilliary left max array, which at ith index keeps max height previous to that element (on left side)
         * and similarly auxilliary right max array and
         * then calculating max water trap possible at each element by taking the min of leftMax[i] and rightMax[i] and subtracting height[i] from it.
         */
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for(int i=1; i < leftMax.length; i++ ){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[rightMax.length-1] = height [height.length - 1];
        for(int i = rightMax.length - 2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int totalTrappedWater = 0;
        for(int i =0; i< height.length; i++){
            totalTrappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalTrappedWater;

    }

    public static void main(String[] args) {
        int[] height1 = {4,2,0,3,2,5};

        int [] height2 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height1));

        System.out.println(trap(height2));



    }
}
