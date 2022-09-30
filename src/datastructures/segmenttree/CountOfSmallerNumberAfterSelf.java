package datastructures.segmenttree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumberAfterSelf {

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        int countArr[] = new int[2 * 10000 + 1];
        int seg[] = new int[4* countArr.length];
        buildSegmentTree(0, seg, 0, countArr.length - 1, countArr);

        for(int i = nums.length - 1 ; i >= 0; i--){
            //getting range sum with seg tree made till now, from range -10000 to nums[i] - 1
            int rangeSum = rangeSumQuery(0, seg, 0, countArr.length - 1, 0, nums[i] + 10000 - 1);

            // changing the count in buckets
            countArr[nums[i] + 10000]++;

            //after updating count array, update the seg tree
            int index = nums[i] + 10000;
            int val = countArr[nums[i] + 10000];
            update(0, seg, 0, countArr.length - 1, val, index);


            ansList.add(rangeSum);
        }

        Collections.reverse(ansList);
        return ansList;
    }

     static void buildSegmentTree(int index, int [] seg, int low, int high, int [] countArr){
        if(low == high){
            seg[index] = countArr[low];
            return;
        }

        int mid = (low + high) >> 1;
        buildSegmentTree(2* index + 1, seg, low, mid, countArr);
        buildSegmentTree(2 * index + 2, seg, mid + 1, high, countArr);
        seg[index] = seg[2 * index + 1] + seg[2 * index + 2];
    }

    static int rangeSumQuery(int index, int [] seg, int low, int high, int left, int right){
        //left right low high    low high left right
        if(right < low || left  > high){
            return 0;
        }

        if(low >= left && high <= right){
            return seg[index];
        }

        int mid = (low + high) >> 1;
        int leftSum = rangeSumQuery(2*index + 1, seg, low, mid, left, right);
        int rightSum = rangeSumQuery(2*index + 2, seg, mid+1, high, left, right);

        return leftSum + rightSum;
    }

    static void update(int index, int [] seg, int low, int high, int val, int up_index){
        if(up_index < low || up_index > high){
            return;
        }
        if(low == high){
            seg[index]++;
            return;
        }
        int mid = (low + high) >> 1;
        if(up_index <= mid){
            update(2 * index + 1, seg, low, mid, val, up_index);
        }else{
            update(2*index + 2, seg, mid + 1, high, val, up_index);
        }
        seg[index] = seg[2* index + 1] + seg[2 * index + 2];
    }

    public static void main(String[] args) {
        int nums[] = {0,2,1};
        List<Integer> ans = countSmaller(nums);
        System.out.println(ans.toString());

    }
}
