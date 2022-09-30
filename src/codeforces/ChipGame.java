
import java.util.Scanner;

public class ChipGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
              int n = sc.nextInt();
              int m = sc.nextInt();
              if((m + n) % 2 == 0){
                  System.out.println("Tonya");
              }else{
                  System.out.println("Burenka");
              }
        }
    }
}
