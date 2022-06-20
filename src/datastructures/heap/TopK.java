package datastructures.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

class CharacterCount{
    Character ch;
    int count ;

    public CharacterCount(Character ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

public class TopK {


    public static void main(String[] args) {
        String str = "qwerrrttttttyyyyyyyyyyiiiiii";
        printTopKCharacters (str, 3);

    }


   static  void printTopKCharacters(String s, int n){
        int arr [] = new int[26];
        for(int i=0; i< s.length(); i ++){
            int index = (int)(s.charAt(i) - 'a');
            arr[index]++;
        }

        PriorityQueue<CharacterCount> pq = new PriorityQueue<>(new Comparator<CharacterCount>() {
            @Override
            public int compare(CharacterCount o1, CharacterCount o2) {
                if(o1.count < o2.count){
                    return 1;
                }else if(o1.count > o2.count){
                    return -1;
                }
                return 0;
            }
        });

        for(int i=0; i < arr.length; i++){
            pq.offer(new CharacterCount((char)('a' + i), arr[i]));
        }

        for(int i=0; i < n; i ++){
            if(!pq.isEmpty()){
                System.out.println(pq.poll().ch);
            }
        }
    }



}
