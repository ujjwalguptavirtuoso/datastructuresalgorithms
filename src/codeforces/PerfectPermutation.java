

import java.util.Scanner;

public class PerfectPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
              int n = sc.nextInt();
              int arr[] = new int[n  + 1];

              if(n %2 == 1){
                  arr[1] = 1;
                  int num = 3;
                  int index  = 2;
                  while(index <= n){
                      arr[index] = num;
                      if(index % 2 == 0) num--;
                      else num = num + 3;
                      index++;
                  }
              }else{
                  int index = 1;
                  int num = 2;
                  while(index <= n){
                      arr[index] = num;
                      if(index % 2 == 1){
                          num--;
                      }else{
                          num +=3;
                      }
                      index++;
                  }
              }
              for(int i = 1; i < arr.length; i++){
                  System.out.print(arr[i] + " ");
              }
            System.out.println();
        }
    }
}
