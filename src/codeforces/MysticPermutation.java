package codeforces;
import java.util.*;

public class MysticPermutation {

    static int [] getMysticPermutation(int [] arr, PriorityQueue<Integer> pq){
        Queue<Integer> waitQueue = new LinkedList<>();
        int result[] = new int[arr.length];
        int index = 0;
        while(index < arr.length){
            if(pq.peek() == arr[index] && index!= arr.length - 1){
                waitQueue.offer(pq.poll());
                result[index] = pq.poll();
            }else{
                result[index] = pq.poll();
            }
            index++;
            while(!waitQueue.isEmpty()){
                pq.offer(waitQueue.poll());
            }
        }
        if(result[arr.length - 1] == arr[arr.length - 1]){
            int temp = result[arr.length - 1];
            result[arr.length - 1] = result[arr.length - 2];
            result[arr.length - 2] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
              int n = sc.nextInt();
              int arr[] = new int[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
              for(int i=0; i < n; i ++){
                  arr[i] = sc.nextInt();
                  pq.offer(arr[i]);
              }

            if(n == 1){
                System.out.println(-1);
                continue;
            }

            int result[] = new int[n];
            result =   getMysticPermutation(arr, pq);
            for(int i : result){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
