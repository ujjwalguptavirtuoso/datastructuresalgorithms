

import java.util.Scanner;

public class IlyaAndQueries {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        int prefixDp [] = new int[str.length() + 1];
        prefixDp[1] = str.charAt(0) == str.charAt(1) ? 1 : 0;
        for(int i = 2; i <= prefixDp.length - 2; i ++){
            prefixDp[i] = prefixDp[i - 1] + (str.charAt(i-1) == str.charAt(i) ? 1 : 0);
        }
        for(int i = 1;i <=n; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int ans = 0;
            if( l == r -1){
                ans = str.charAt(l- 1) == str.charAt(l) ? 1 : 0;
            }else{
                ans = prefixDp[r-1] - prefixDp[l- 1];
            }
            System.out.println(ans);
        }
    }
}
