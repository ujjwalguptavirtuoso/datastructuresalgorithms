

import java.util.Scanner;

public class WoodCutters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int trees[] = new int[n];
        int heights[] = new int[n];

        for(int i = 0; i < n;i++){
            trees[i] = sc.nextInt();
            heights[i] = sc.nextInt();
        }

        if(trees.length == 1){
            System.out.println(1);
            return;
        }

        int count = 2; // greedily making leftmost tree fall left, and rightmost tree right
        int tillOccupied = trees[0];
        for(int i = 1; i < trees.length - 1; i++){
            if(trees[i] - tillOccupied > heights[i]){
                count++;
                tillOccupied = trees[i];
                continue;
            }
            if(trees[i+1] - trees[i] > heights[i]){
                count++;
                tillOccupied = trees[i] + heights[i];
                continue;
            }
            tillOccupied = trees[i];
        }
        System.out.println(count);
    }
}
