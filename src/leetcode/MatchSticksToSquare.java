package leetcode;

public class MatchSticksToSquare {
    boolean resultFound = false;
    void solve(int index, boolean[] visited, int [] matchsticks, int target, int sumTillNow){
        if(resultFound){
            return;
        }
        visited[index] = true;
        // System.out.println("target = "+ target);
        //  System.out.println("index"+ index);
        //   System.out.println(sumTillNow);
        if(sumTillNow == target){
            resultFound = true;
            return;

        }

        for(int k = 0; k < matchsticks.length; k++){
            if(k!= index && !visited[k] && (sumTillNow + matchsticks[k] <= target)){
                solve(k, visited, matchsticks, target, sumTillNow + matchsticks[k]);
            }
        }
    }

    public boolean makesquare(int[] matchsticks) {
        int sum = 0 ;
        for(int length : matchsticks){
            sum += length;
        }

        if(sum%4 != 0){
            // System.out.println("here");
            return false;
        }
        //System.out.println(sum/4);
        boolean[] visited = new boolean[matchsticks.length];
        int count = 0;
        for(int i = 0; i < matchsticks.length; i++){
            if(!visited[i] && matchsticks[i] <= sum/4){
                resultFound = false;
                solve(i, visited, matchsticks, sum/4, matchsticks[i]);
                count++;
            }
        }

        if(count != 4){
            System.out.println(count);
            return false;
        }

        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {3,3,3,3,4,2,4,2};
        MatchSticksToSquare obj = new MatchSticksToSquare();
        System.out.println(obj.makesquare(arr));
    }
}
