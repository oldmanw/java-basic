package algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII407 {
	
	public class Node {
		int i;
		int j;
		int height;
		
		public Node (int i, int j, int height) {
			this.i = i;
			this.j = j;
			this.height = height;
		}
	}
	
	public int trapRainWater(int[][] nums) {
		if (nums == null || nums.length < 3 || nums[0].length < 3) return 0;
		int res = 0;
		//int min = Integer.MIN_VALUE;
		//create a priority queue for comparing heights of the nodes
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.height - n2.height;
			}
		});
		
		int m = nums.length, n = nums[0].length;
		boolean[][] visited = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			visited[i][0] = true;
			visited[i][n - 1] = true;
			queue.offer(new Node(i, 0, nums[i][0]));
			queue.offer(new Node(i, n - 1, nums[i][n - 1]));
		}
		
		for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Node(0, i, nums[0][i]));
            queue.offer(new Node(m - 1, i, nums[m - 1][i]));
        }
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			//min = Math.max(min, node.height);
			int[][] skewings = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
			for (int[] skewing : skewings) {
				int i = node.i + skewing[0];
				int j = node.j + skewing[1];
				if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
					visited[i][j] = true;
					res += Math.max(0, node.height - nums[i][j]);
					queue.offer(new Node(i, j, Math.max(node.height, nums[i][j])));
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
		System.out.println(new TrappingRainWaterII407().trapRainWater(nums));
	}

}
