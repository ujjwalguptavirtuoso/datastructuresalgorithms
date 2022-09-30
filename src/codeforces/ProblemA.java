

import java.util.*;

public class ProblemA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int t = 0; t < test; t++){
              int n = sc.nextInt();
              String[] strArr = new String[n];
              Map<Integer, List<String>> map = new HashMap<>();
              for(int i = 0; i < n; i++){
                  strArr[i] = sc.next();
                  if(map.containsKey(strArr[i].length())){
                      List<String>  list = map.get(strArr[i].length());
                      list.add(strArr[i]);
                  }else{
                      List<String>  list = new ArrayList<>();
                      list.add(strArr[i]);
                      map.put(strArr[i].length(), list);
                  }
              }
              StringBuilder ans = new StringBuilder();
              for(int i = 0; i < strArr.length; i++){
                  for(int j = 1; j < strArr[i].length()/2; j++){
                      StringBuilder tempAns = new StringBuilder();
                      if(map.containsKey(j) && map.containsKey(strArr[i].length() - j)){
                           List<String> list1 = map.get(j);
                           List<String> list2 = map.get(strArr[i].length() - j);
                           for(int u = 0; u < list1.size(); u++){
                               tempAns.append(list1.get(u));
                               for(int v = 0; v < list2.size(); v++){
                                   tempAns.append((list2.get(v)));
                                   if(tempAns.equals(strArr[i])){
                                       ans.append("1");
                                       break;
                                   }
                                   tempAns.delete(strArr[i].length() - j,tempAns.length());
                               }
                           }
                      }
                  }
              }
        }
    }

    static int increment(int num){
        if(num == 9) return 0;
        return num + 1;
    }

    static int decrement(int num){
        if(num == 0) return 9;
        return num - 1;
    }
}
