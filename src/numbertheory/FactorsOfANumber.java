package numbertheory;

import java.util.*;
/**
 * ujjwal.gupta
 *
 * @version $Id: FactorsOfANumber.java, v 0.1 2022-05-08
 */
public class FactorsOfANumber {


   static List<Integer> findFactors(int num){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        // always 1 is a factor for any number , ans its count is always 1.
        map.put(1, 1);
        for(int i=2; i*i <= num; i++){
            int count = 0;
             while(num % i == 0 ){
                 count +=1;
                 map.put(i, count);
                 num = num / i;
             }
        }
        int gCount = 0;
        if(num > 1){
           map.put(num, gCount+1);
        }

        List<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()){
            if(map.get(key) > 0)
            list.add(key);
            map.put(key, map.get(key) - 1 );
        }
        return list;
    }


    static List<Integer> findFactorsinList(int num){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=2; i*i <= num; i++){
            while(num % i == 0 ){
                list.add(i);
                num = num / i;
            }
        }
        if(num > 1)
            list.add(num);
        return list;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(findFactorsinList(num).toString());

        String a = "badboy";

        System.out.println(a.substring(0,0));

        System.out.println(a.substring(0,2));

        System.out.println(a.substring(3));

    }
}
