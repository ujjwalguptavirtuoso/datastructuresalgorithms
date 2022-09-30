package kickstart;

import java.util.*;


public class StudentsAndMentors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
           int caseNo = t + 1;
            int n = sc.nextInt();
            int arr[] = new int[n];
            List<PQObj> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int rating = sc.nextInt();
                arr[i] = rating;
                list.add(new PQObj(i, rating));
            }
            Collections.sort(list, (a, b) -> a.rating - b.rating);
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int low = 0;
                int high = arr.length - 1;
                int index = -1;
                while(low <= high){
                    int mid = (low + high) >> 1;
                    if(list.get(mid).rating <= 2 * arr[i]){
                         index = mid;
                         low = mid + 1;
                    }else{
                        high = mid  - 1;
                    }
                }

                    if(list.get(index).studentId != i){
                        ans.add(list.get(index).rating);
                    }
                    else if(index == 0 && list.get(index).studentId == i){
                        ans.add(-1);
                    }else {
                        index--;
                        ans.add(list.get(index).rating);
                    }
            }
            System.out.print("Case #" + caseNo + ": ");
            for(Integer num : ans){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

class PQObj{
    int studentId;
    int rating;

    public PQObj(int studentId, int rating) {
        this.studentId = studentId;
        this.rating = rating;
    }
}
