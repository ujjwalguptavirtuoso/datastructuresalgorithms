

import java.util.*;

public class FightingTournament {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n = sc.nextInt();
            int q = sc.nextInt();
           // int arr[] = new int[n];
            Deque<PlayerObject> dq = new LinkedList<>();
            for(int i = 0 ; i < n; i++ ){
               // arr[i] = sc.nextInt();
                dq.offerLast(new PlayerObject(i + 1, sc.nextInt()));
            }
            Map<Integer, Map<Integer, Integer>> roundMap = new HashMap<>();
            int k = 1;
            while(dq.peekFirst().playerScore!= n){
                PlayerObject player1 = dq.pollFirst();
                PlayerObject player2 = dq.pollFirst();
                if(player1.playerScore > player2.playerScore){
                    dq.offerLast(player2);
                    dq.offerFirst(player1);
                    if(k == 1){
                        HashMap<Integer, Integer> map = new HashMap<>();
                        map.put(player1.playerId, map.getOrDefault(player1.playerId, 0) + 1);
                        roundMap.put(k, map);
                    }else{
                        Map<Integer, Integer> prevMap = roundMap.get(k - 1);
                        HashMap<Integer, Integer> map = new HashMap<>();
                        for(Integer key : prevMap.keySet()){
                            map.put(key, prevMap.get(key));
                        }
                        map.put(player1.playerId, map.getOrDefault(player1.playerId, 0) + 1);
                        roundMap.put(k, map);
                    }
                }else{
                    dq.offerFirst(player2);
                    dq.offerLast(player1);

                    if(k == 1){
                        HashMap<Integer, Integer> map = new HashMap<>();
                        map.put(player2.playerId, map.getOrDefault(player2.playerId, 0) + 1);
                        roundMap.put(k, map);
                    }else{
                        Map<Integer, Integer> prevMap = roundMap.get(k - 1);
                        HashMap<Integer, Integer> map = new HashMap<>();
                        for(Integer key : prevMap.keySet()){
                            map.put(key, prevMap.get(key));
                        }
                        map.put(player2.playerId, map.getOrDefault(player2.playerId, 0) + 1);
                        roundMap.put(k, map);
                    }
                }
                k++;
            }
            for(int i = 0; i < q; i++){
                int a = sc.nextInt();
                int round = sc.nextInt();
                if(roundMap.containsKey(round)){
                    if(roundMap.get(round).containsKey(a)){
                        System.out.println(roundMap.get(round).get(a));
                    }else{
                        System.out.println(0);
                    }
                }else if(!roundMap.containsKey(round) && dq.peekFirst().playerId == a){
                    int val = 0;
                    if(roundMap.get( k - 1)!= null && roundMap.get(k - 1).get(a) != null){
                         val = 1;
                    }
                    System.out.println(round - k + 1 + val);
                }else if(!roundMap.containsKey(round) && dq.peekFirst().playerId != a){
                    int roundTill = k - 1;
                    if(roundMap.get(roundTill).containsKey(a)){
                        System.out.println(roundMap.get(round).get(a));
                    }else{
                        System.out.println(0);
                    }
                }
            }
        }
    }
}

class PlayerObject{
    int playerId;
    int playerScore;

    public PlayerObject(int playerId, int playerScore) {
        this.playerId = playerId;
        this.playerScore = playerScore;
    }
}
