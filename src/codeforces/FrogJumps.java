package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrogJumps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            String str = sc.next();
            List<Integer> rindices = new ArrayList<>();

            for(int i =0; i < str.length(); i ++) {
                if (str.charAt(i) == 'R') {
                    rindices.add(i + 1);
                }
            }
            if(rindices.size() == 0){
                System.out.println(str.length() + 1);
                continue;
            }
            rindices.add(str.length() + 1);
            int maxDiff = Integer.MIN_VALUE;
            for (int i=0; i < rindices.size(); i++){
                int diff = 0;
                if(i== 0){
                    diff = rindices.get(i) - 0;
                }else{
                 diff = rindices.get(i) - rindices.get(i-1);
                }
                maxDiff = Math.max(diff, maxDiff);
            }
            System.out.println(maxDiff);
        }
    }
}
