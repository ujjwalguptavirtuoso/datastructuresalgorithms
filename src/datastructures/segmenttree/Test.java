package datastructures.segmenttree;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Test {

   private static String temp = "1";
   /* T value;
    public Test(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }*/

   /* public static void main(String[] args) {
        Test<String> first = new Test<>("a string");
        Test<Integer> two = new Test<>(123);
        System.out.println(first.getValue());
        System.out.println(two.getValue());

    }*/

    private void firstMethod(){
        try{
           secondMethod();
        }catch (Exception e){
            temp +=5;
        }
    }
    private void secondMethod() throws Exception{
        try{
           thirdMethod();
           temp += 3;
        }catch (Exception e){
            throw new Exception();
        }finally {
            temp +=4;
        }
        temp+=5;
    }

    private void thirdMethod() throws Exception{
        throw new Exception();
    }

    public static void main(String[] args) {
      /*  Map<Color, String> map = new HashMap<>();
        map.put(new Color("Red"), "Red");
        map.put(new Color("Blue"), "Blue");
        map.put(new Color("Green"), "Green");
        System.out.println(map.get(new Color("Blue")));*/

        /*Comparator<Integer> numberComparator = (number1, number2) -> number2.compareTo(number1);
        Integer arr [] = {1, 4, 3, 2};
        Arrays.sort(arr, numberComparator);
        for(Integer num : arr){
            System.out.println(num);
        }
*/
        new Test().firstMethod();
        System.out.println(temp);

       // Set<? super IOException> set = new TreeSet<FileNotFoundException>();
    }

   /* public static void main(String[] args) {
       // System.out.println(method());
        //int sum = Arrays.stream(new int[]{1, 2, 3, 4, 5}).filter(i-> i%2 ==0).map(i -> i*2).sum();
        //System.out.println(sum);
       // Test test = new Test();
       // MyInnerClass inner = test.new MyInnerClass();
    }*/

    private static Object method(){
        try{
            int i = 10/0;
            return i;
        } catch (ArithmeticException e){
            return "catch";
        }finally {

            return "finally";
        }
    }

    private class MyInnerClass{

    }
}
