package leetcode;

public class NextGreater3 {

   static boolean checkDigitFrequency(int [] numCount, int num){
        int tempNumCount[] = new int[10];

        while(num!=0){
            int temp = num%10;
            tempNumCount[temp]++;
            num = num/10;
        }

        for(int i =0; i < numCount.length; i++){
            if(numCount[i] != tempNumCount[i]){
                return false;
            }
        }
        return true;
    }

    public static  int nextGreaterElement(int n) {
        int actualN = n;
        int [] numCount = new int[10];
        int digits = 0;
        while(n!=0){
            int temp = n%10;
            numCount[temp]++;
            n = n/10;
            digits++;
        }
        //now numCount is storing the count of all digits in the given number
        int num = actualN + 1;
        long limit = (long)Math.pow(10, digits);
        int actualLimit = 0;
        if(limit > Integer.MAX_VALUE){
            actualLimit = Integer.MAX_VALUE;
        }else{
            actualLimit = (int)limit;
        }
        while(num <= actualLimit){
            if(checkDigitFrequency(numCount, num)){
                return num;
            }
            num++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 2147483486;
        nextGreaterElement(n);
    }
}
