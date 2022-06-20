
import java.util.Scanner;

public class PrisonTransfer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt(); // crime should not greater than this
        int c =sc.nextInt(); // subArraysize

        int arr[] = new int [n];
        int len = 0;
        int count = 0;
        for(int i=0; i < n; i++){
            arr[i] =sc.nextInt();
            if(arr[i] <= t){
                len++;
            }else{
                len = 0;
            }
            if(len >= c){
                count++;
            }
        }
        System.out.println(count);

        /*int startIndex = 0;
        int endIndex = c - 1;
        boolean theseValues = false;
        int index = 0;
        while(index <= endIndex && endIndex < n){
            if(arr[index] > t){
                    startIndex = index + 1;
                    endIndex = startIndex + c - 1;
                    index = startIndex;
                }else{
                index++;
            }

        }

        if(endIndex >= n){
            System.out.println(0);
        }else{
            int count = 0;
            while(endIndex< n){
                if(arr[endIndex] <= t){
                    count++;
                    startIndex++;
                    endIndex++;
                }else{
                    startIndex = endIndex + 1;
                    endIndex = startIndex + c - 1;
                }
            }
            System.out.println(count);
        }
*/
    }
}
