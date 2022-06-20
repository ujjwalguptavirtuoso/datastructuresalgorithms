package codeforces;

import java.util.PriorityQueue;
import java.util.Scanner;

public class LexString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();

            String str1 = sc.next();
            String str2 = sc.next();

            PriorityQueue<Character> pq1 = new PriorityQueue<>();

            for(int i =0; i < str1.length(); i++){
                pq1.offer(str1.charAt(i));
            }
            PriorityQueue<Character> pq2 = new PriorityQueue<>();
            for(int j =0; j < str2.length(); j++){
                pq2.offer(str2.charAt(j));
            }
            boolean isPq1First = false;
            if(pq1.peek() < pq2.peek()){
                isPq1First = true;
            }

            StringBuilder sb = new StringBuilder();
            while(!pq1.isEmpty() && !pq2.isEmpty()){
                int counter = k;
                if(isPq1First){
                    while(!pq1.isEmpty() && counter > 0){
                        Character polled = pq1.poll();
                        sb.append(polled);
                        counter--;
                        if(!pq2.isEmpty() && pq2.peek() < pq1.peek()){
                            break;
                        }
                    }
                    if(pq1.isEmpty()){
                        System.out.println(sb.toString());
                        break;
                    }
                    counter = k;
                    while(!pq2.isEmpty() && counter > 0){
                        Character polled = pq2.poll();
                        sb.append(polled);
                        counter--;
                        if(!pq1.isEmpty()  && pq1.peek() < pq2.peek()){
                            break;
                        }
                    }
                    if(pq2.isEmpty()){
                        System.out.println(sb.toString());
                        break;
                    }
                }else{
                    while(!pq2.isEmpty() && counter > 0){
                        Character polled = pq2.poll();
                        sb.append(polled);
                        counter--;
                        if(!pq1.isEmpty() && pq1.peek() < pq2.peek()){
                            break;
                        }
                    }
                    if(pq2.isEmpty()){
                        System.out.println(sb.toString());
                        break;
                    }
                    counter = k;
                    while(!pq1.isEmpty() && counter > 0){
                        Character polled = pq1.poll();
                        sb.append(polled);
                        counter--;
                        if( !pq2.isEmpty() && pq2.peek() < pq1.peek()){
                            break;
                        }
                    }
                    if(pq1.isEmpty()){
                        System.out.println(sb.toString());
                        break;
                    }
                }
            }
        }
    }
}
