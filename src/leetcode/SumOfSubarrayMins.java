package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumOfSubarrayMins {

    public static int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        Stack<Integer> st =  new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> auxSt = new Stack<>();
        List<Integer> mins = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(st.isEmpty()){
                minStack.push(arr[i]);
            }else{
                if(arr[i] < minStack.peek()){
                    minStack.push(arr[i]);
                }
            }
            st.push(arr[i]);
        }

        boolean flag = true;
        while(flag){
            while(st.size() > 1){
                mins.add(minStack.peek());
                if(st.peek() == minStack.peek()){
                    minStack.pop();
                    auxSt.push(st.pop());
                }else{
                    auxSt.push(st.pop());
                }
            }
            mins.add(st.peek());
            st.pop();
            if(minStack.size() > 0){
                minStack.pop();
            }
            if(auxSt.size() == 0){
                break;
            }
            while(!auxSt.isEmpty()){
                if(st.isEmpty()){
                    minStack.push(auxSt.peek());
                }else{
                    if(auxSt.peek() < minStack.peek()){
                        minStack.push(auxSt.peek());
                    }
                }
                st.push(auxSt.peek());
                auxSt.pop();
            }
        }
        System.out.println(mins.toString());
        int result = 0;
        for(int i=0; i < mins.size(); i++){
            result = (result%mod + mins.get(i)%mod)%mod;
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {3,1,2,4};
        System.out.println(sumSubarrayMins(nums));

    }
}
