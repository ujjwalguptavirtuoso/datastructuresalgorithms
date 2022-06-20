package codeforces;


import java.util.*;

public class Laptops {

    static class MyPair{
        int x;
        int y;

        MyPair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int price[] = new int[n];
        int quality[] = new int[n];

        for(int i = 0;i < n; i++){
            price[i] = sc.nextInt();
            quality[i] = sc.nextInt();
        }

        if(n == 1){
            System.out.println("Poor Alex");
        }else {


            List<Laptops.MyPair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Laptops.MyPair mp = new Laptops.MyPair(price[i], quality[i]);
                list.add(mp);
            }
            Collections.sort(list, (a, b) -> a.x - b.x);
            Stack<Integer> st = new Stack<>();
            int[] nextSmallerElement = new int[n];
            nextSmallerElement[n - 1] = -1;
            st.push(list.get(list.size() - 1).y);
            for (int i = n - 2; i >= 0; i--) {
                while (!st.isEmpty() && st.peek() > list.get(i).y) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    if (i == 0) {
                        System.out.println("Poor Alex");
                    }
                    nextSmallerElement[i] = -1;
                } else {
                    nextSmallerElement[i] = st.peek();
                    System.out.println("Happy Alex");
                    break;
                }
                st.push(list.get(i).y);
            }
        }
    }
}
