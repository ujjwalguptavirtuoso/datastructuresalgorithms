package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EmptyGraph {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
              int n = sc.nextInt();
              int k = sc.nextInt();
              PriorityQueue<Integer> pq = new PriorityQueue<>();
              for(int i = 0 ; i < n ; i++){
                  pq.offer(sc.nextInt());
              }
              while(k > 0){
                  int temp = pq.poll();
                  temp = 1000000000;
                  pq.offer(temp);
                  k--;
              }
            List<Integer> nums = new ArrayList<>();
              while(!pq.isEmpty()){
                  nums.add(pq.poll());
             }

        }
    }
}
