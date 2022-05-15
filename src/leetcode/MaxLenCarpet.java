package leetcode;

/**
 * ujjwal.gupta
 *
 * @version $Id: MaxLenCarpet.java, v 0.1 2022-05-14
 */
public class MaxLenCarpet {

    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {

        for(int i = 0 ; i < tiles.length; i++){
            int index = i;
            int min = tiles[i][0];
            for(int j = i; j< tiles.length; j++){
                if(tiles[j][0] < min){
                    min = tiles[j][0];
                    index = j;
                }
            }
            int[] temp = tiles[index];
            tiles[index] = tiles[i];
            tiles[i] = temp;
        }

        int totalTileArea = 0;
        for(int i=0; i< tiles.length; i++){
            totalTileArea = totalTileArea + tiles[i][1] - tiles[i][0] + 1 ;
        }
        if(totalTileArea< carpetLen){
            return totalTileArea;
        }
        int lonConsTiles = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < tiles.length - 1; i ++){
            if(tiles[i+1][0] != tiles[i][1] + 1){
                sum = 0;
            }

            if(tiles[i+1][0] == tiles[i][1] + 1){
                sum = sum + tiles[i+1][1] - tiles[i][0] + 1;
                if(sum > lonConsTiles){
                    lonConsTiles = sum;
                }
            }
        }
        int maxLengthTile = Integer.MIN_VALUE;
        for(int i = 0; i < tiles.length; i ++ ){
            if(tiles[i][1] - tiles[i][0] + 1 > maxLengthTile){
                maxLengthTile = tiles[i][1] - tiles[i][0] + 1;
            }
        }

        int maxConsecutive = Math.max(maxLengthTile, lonConsTiles);


        return Math.min(carpetLen, maxConsecutive);
    }

    public static void main(String[] args) {
        int[][] tiles = {{8051,8057},{8074,8089},{7994,7995},{7969,7987},{8013,8020},{8123,8139},{7930,7950},{8096,8104},{7917,7925},{8027,8035},{8003,8011}};
        System.out.println(maximumWhiteTiles(tiles, 9854));
    }
}
