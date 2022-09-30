

import java.util.Scanner;

public class IQTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

              int n = sc.nextInt();
              int countOdd = 0;
              int countEven = 0;
              int arr[] = new int[n];
              boolean alreadyFound = false;
              for(int i = 0; i < n; i++){
                  arr[i] = sc.nextInt();
                  if(arr[i] % 2 == 1 && countEven > 1){
                      int val = i+ 1;
                      System.out.println(val);
                      alreadyFound = true;
                      break;
                  }else if(arr[i] % 2 == 0 && countOdd > 1) {
                      int val = i+ 1;
                      System.out.println(val);
                      alreadyFound = true;
                      break;
                  }else if(arr[i] % 2 == 1){
                      countOdd++;
                  }else{
                      countEven++;
                  }
              }
              if(!alreadyFound){
                  if(countEven == 1){
                      for(int i = 0; i < arr.length; i++){
                          if(arr[i] % 2 == 0){
                              int val = i+ 1;
                              System.out.println(val);
                              break;
                          }
                      }
                  }else{
                      for(int i = 0; i < arr.length; i++){
                          if(arr[i] % 2 == 1){
                              int val = i+ 1;
                              System.out.println(val);
                              break;
                          }
                      }
                  }
              }

    }
}
