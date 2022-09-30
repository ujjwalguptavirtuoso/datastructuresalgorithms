package dynamicprogramming.digitdp;

import java.util.*;

public class CountSpecialNumbers {

    int dp[][][] = new int[2][10][1024];

    int solve(int index, int matchingPrefix, int mask, int [] num){

        if(index == num.length){
            if(mask == 0) return 0;
            return 1;
        }

        if(dp[matchingPrefix][index][mask]!= -1){
            return dp[matchingPrefix][index][mask];
        }

        int ans = 0;

        int start = index == 0 ? 1 : 0;
        int end = matchingPrefix == 1 ? num[index] : 9;

        for(int i = start; i<=end; i++){
            if((mask & (1<< i)) !=0) continue;
            ans +=  solve(index + 1, (matchingPrefix == 0 ? 0 : (num[index] == i ? 1 : 0)), mask|1<<i, num);
        }
        return dp[matchingPrefix][index][mask] = ans;
    }

    public int countSpecialNumbers(int n) {
        int tempNum = n;
        List<Integer> list = new ArrayList<>();
        while(tempNum > 0){
            int val = tempNum % 10;
            list.add(val);

            tempNum /= 10;
        }
        int num[] = new int[list.size()];
        int numIndex = 0;
        for(int i = list.size() - 1; i >= 0; i--){
            num[numIndex] = list.get(i);
            numIndex++;
        }

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                for(int k = 0; k < dp[0][0].length; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 9);
        map.put(2, 81);
        map.put(3, 648);
        map.put(4, 4536);
        map.put(5, 27216);
        map.put(6, 136080);
        map.put(7, 544320);
        map.put(8, 1632960);

        int val = num.length;
        int count = 0;
        for(int i = 1; i < val; i++){
            count += map.get(i);
        }

        count += solve(0, 1, 0, num);

        return count;
    }

    public static void main(String[] args) {
        CountSpecialNumbers obj = new CountSpecialNumbers();
        System.out.println(obj.countSpecialNumbers(200));
        StringBuilder sb = new StringBuilder();
        sb.charAt(sb.length() - 1);
    }
}
