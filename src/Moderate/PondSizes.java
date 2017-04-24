package Moderate;

import java.util.LinkedList;
import java.util.List;

public class PondSizes {

	public List<Integer> getPonds(int[][] plot) {
		List<Integer> ponds = new LinkedList<Integer>();

		int n = plot.length;
		if (n == 0) {
			return ponds;
		}
		int m = plot[0].length;

		boolean[][] visited = new boolean[n][m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if (plot[i][j] == 0 && !visited[i][j]) {
					int size = getPondSize(plot, visited, i, j);
					ponds.add(size);
				}
			}
		}

		return ponds;
	}

	public int getPondSize(int[][] plot, boolean[][] visited, int i, int j) {

		if (plot[i][j] != 0) {
			return 0;
		}

		if (plot[i][j] == 0) {
			visited[i][j] = true;
		}

		int n = plot.length;
		int m = plot[0].length;

		int bottomLeft = 0;
		int bottomRight = 0;
		int bottom = 0;
		int right = 0;

		if (i < n-1 && j > 0) {
			bottomLeft = getPondSize(plot, visited, i+1, j-1);
		}
		if (i < n-1 && j < m-1) {
			bottomRight = getPondSize(plot, visited, i+1, j+1);
		}
		if (i < n-1) {
			bottom = getPondSize(plot, visited, i+1, j);
		}
		if (j < m-1) {
			right = getPondSize(plot, visited, i, j+1);
		}


		return 1 + bottomLeft + bottomRight + bottom + right;
	}

	public static void main(String[] args) {
		PondSizes p = new PondSizes();
		int[][] plot = new int[][] {{0,2,1,0}, {0,1,0,1}, {1,1,0,1}, {0,1,0,1}};
		List<Integer> answer = p.getPonds(plot);
		for (int i: answer) {
			System.out.print(i + " ");
		}
	}

}
