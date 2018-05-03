package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int height = matrix.length, width = matrix[0].length;
        int right = width - 1, down = height - 1, left = 0, up = 1, i = 0, j = -1, step = 0;
        while (step < height * width) {
            while (step < height * width && j < right) {
                list.add(matrix[i][++j]);
                step++;
            }
            right--;
            while (step < height * width && i < down) {
                list.add(matrix[++i][j]);
                step++;
            }
            down--;
            while (step < height * width && j > left) {
                list.add(matrix[i][--j]);
                step++;
            }
            left++;
            while (step < height * width && i > up) {
                list.add(matrix[--i][j]);
                step++;
            }
            up++;
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[][] matrix = {{1},{2},{3},{4},{5}};
		System.out.println(new SpiralMatrix54().spiralOrder(matrix));
	}

}
