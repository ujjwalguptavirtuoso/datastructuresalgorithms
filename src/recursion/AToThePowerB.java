
package recursion;

/**
 *
 * @version $Id: AToThePowerB.java, v 0.1 2022-04-28
 */
public class AToThePowerB {

    static int power(int a, int b){
        // 1. base case
        if(b==1){
            return a;
        }
        if(b == 0){
            return 1;
        }
        // 2. recursive assumption
        int temp = power(a, b-1);

        // 3. self work of function
        return a * temp;
    }


    static int optimizedPower(int a, int b){
        // 1. base case
        if(b==1){
            return a;
        }
        if(b == 0){
            return 1;
        }
        // 2. recursive assumption
        int temp = optimizedPower(a, b/2);

        // 3. self work of function
        if(b%2 == 0 ){
            return temp * temp;
        }else{
            return a * temp * temp;
        }

    }

    public static void main(String[] args) {
        int a= 2;
        int b = 10;


        long start = System.currentTimeMillis();
        int ans = power(a, b);
        long end = System.currentTimeMillis();
        System.out.println(ans + " Executed in: " + (end - start) + "ms");



        long start1 = System.currentTimeMillis();
        int ans1 = optimizedPower(a, b);
        long end1 = System.currentTimeMillis();
        System.out.println(ans1 + " Executed in: " + (end1 - start1) + "ms");
    }
}
