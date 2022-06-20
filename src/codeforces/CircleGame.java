
import java.util.Scanner;

public class CircleGame {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
           int n = sc.nextInt();
           int [] arr = new int[n];
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
           for(int i = 0; i < arr.length; i ++){
               arr[i] = sc.nextInt();
               if(arr[i]< min){
                   min = arr[i];
                   minIndex = i + 1;
               }
           }
            if(n%2 != 0){
                System.out.println("Mike");
                continue;
            }
            if(minIndex%2!= 0){
                System.out.println("Joe");
            }else{
                System.out.println("Mike");
            }

        }
    }
}
