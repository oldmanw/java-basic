package test;

import java.util.ArrayList;
import java.util.Collections;

public class DungeonGame174 {
    
    public static int calculateMinimumHP(int[][] dungeon) {
    	ArrayList<Integer> list = new ArrayList<>();
        recursion(dungeon, 0, 0, 0, 0, list);
        Collections.sort(list);
        return list.get(0);
    }
    
    private static void recursion(int[][] dungeon, int i, int j, int sum, int res, ArrayList<Integer> list) {
    	sum += dungeon[i][j];
    	if (sum < 0) res = Math.max(res, -sum + 1);
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
        	list.add(res);
        }
        if (i < dungeon.length - 1) recursion(dungeon, i + 1, j, sum, res, list);
        if (j < dungeon[0].length - 1) recursion(dungeon, i, j + 1, sum, res, list);
    }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dungeon = {{-2, -3, 3},{-5, -10, 1},{10, 30, -5}};
		int result = calculateMinimumHP(dungeon);
		System.out.println(result);
	}

}
