package codeforces;

public class MinMaxGame {

    public static  int minMaxGame(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        //   int[] auxNums = new int [nums.length];
        //   Arrays.fill(auxNums, -1);
        StringBuilder sb = new StringBuilder();
        sb.substring(0, 1);
        StringBuilder str = new StringBuilder("hi");
        sb.append(str);
        int index = 0;
        int factor = 1;

        // while(validNum!=1){
        //
        // }
        while((int)(Math.pow(2, factor)) <= nums.length){
            int multiple = (int)(Math.pow(2, factor - 1));
            while(index < nums.length/(int)(Math.pow(2, factor))){
                if(index % 2 == 0){
                    nums[multiple*2*index] = Math.min(nums[multiple*2 * index], nums[(multiple* 2 * index) + (multiple * 1)]);
                }else{
                    nums[multiple*2*index] = Math.max(nums[multiple*2 * index], nums[(multiple* 2 * index) + (multiple * 1)]);
                }
                index++;
            }
            index = 0;
            factor++;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int nums[] ={70,38,21,22};
        System.out.println(minMaxGame(nums));
    }
}
