
import java.util.Scanner;

public class Taxi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

             int n = sc.nextInt();
           //  int arr[] = new int [n];
            int a = 0; int b = 0; int c = 0; int d = 0;
             for(int i = 0; i <n; i++){
                 int x = sc.nextInt();
                 if(x == 1){
                     a++;
                 }else if(x == 2) {
                     b++;
                 }else if(x == 3){
                     c++;
                 }else{
                     d++;
                 }
             }
             int numTaxi = 0;
             numTaxi += d; // adding all 4 groups

             int minOfAAndC = Math.min(a, c);
             c = c - minOfAAndC;
             a = a - minOfAAndC;
             numTaxi += minOfAAndC;

             if(c > 0){
                 numTaxi +=c;
             }


             if(b > 0){
                 numTaxi += b/2;
                 b = b%2;
             }

             if(b == 1){
                 numTaxi += b;
                 a = a- 2;
             }
             if(a > 0){
                 numTaxi += a%4 == 0 ? a/4 : a/4 + 1;
             }



             System.out.println(numTaxi);


           /* Arrays.sort(arr);
            int i = 0;
            int j = arr.length - 1;
            int numOfTaxi = 0;
            int carrySum = 0;
            while(i<=j){
                int tempSum = arr[i] + arr[j];
                 carrySum += tempSum;
                if (carrySum == 4){
                    i++;
                    j--;
                    numOfTaxi++;
                    carrySum = 0;
                }
                else if(carrySum > 4){
                    j--;
                    numOfTaxi++;
                    carrySum= 0;
                }else{
                    if(i >= j){
                        numOfTaxi++;
                        break;
                    }
                    i++;
                    j--;
                    if(i>j){
                        numOfTaxi++;
                        break;
                    }
                }
            }
            System.out.println(numOfTaxi);*/

    }


}
