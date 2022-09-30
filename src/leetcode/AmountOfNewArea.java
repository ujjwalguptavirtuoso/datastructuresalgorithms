package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class AmountOfNewArea {
    public int[] amountPainted(int[][] paint) {
        TreeMap<Integer, Integer> intervals = new TreeMap<>();
        int result[] = new int[paint.length];
        for(int i = 0 ; i < paint.length; i++){
            int start = paint[i][0];
            int end = paint[i][1];
            int modifiedStart = paint[i][0];
            int modifiedEnd = paint[i][1];
            int toPaint = end - start;
            Map.Entry<Integer, Integer> floor = intervals.floorEntry(start);
            if(floor!= null){
                if(floor.getValue() >= start && end > floor.getValue()){
                    toPaint -= floor.getValue() - start;
                    modifiedStart = floor.getKey();
                    intervals.remove(floor.getKey());
                }else if(floor.getValue() >= end){
                    toPaint = 0;
                    result[i] = 0;
                    continue;
                }
            }
            Map.Entry<Integer, Integer> ceiling = intervals.ceilingEntry(start);
            if(ceiling!= null){
                if(end >= ceiling.getKey() && end <= ceiling.getValue()){
                    toPaint -= end - ceiling.getKey();
                    modifiedEnd = ceiling.getValue();
                    intervals.remove(ceiling.getKey());
                }else if(end > ceiling.getValue()){
                    int temp = ceiling.getValue();
                    toPaint -= ceiling.getValue() - ceiling.getKey();
                    intervals.remove(ceiling.getKey());
                    while(intervals.ceilingEntry(temp) != null && intervals.ceilingEntry(temp).getValue() <= end){
                        Map.Entry<Integer, Integer> newCeiling = intervals.ceilingEntry(temp);
                        toPaint -= newCeiling.getValue() - newCeiling.getKey();
                        intervals.remove(newCeiling.getKey());
                    }
                }
            }

            result[i] = toPaint;
            intervals.put(modifiedStart, modifiedEnd);
        }
        return result;
    }

    public static void main(String[] args) {
        int paint[][] = {{4,5},{18,19},{9,11},{8,13},{14,19},{17,19},{6,19},{19,20}};
        AmountOfNewArea obj = new AmountOfNewArea();
        int result[] = obj.amountPainted(paint);
        System.out.println(result);
    }
}
