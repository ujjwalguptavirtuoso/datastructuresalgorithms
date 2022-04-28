
package recursion;

/**
 *
 * @version $Id: AToThePowerB.java, v 0.1 2022-04-28
 */
public class AToThePowerB {

    static int power(int a, int b){
        if(b==1){
            return a;
        }
        if(b == 0){
            return 1;
        }

        return a * power(a, b-1);
    }

    public static void main(String[] args) {
        int a= 2;
        int b = 10;

        System.out.println(power(a, b));
    }
}
