package com.puneet.interview;

import java.util.Random;

public class MinimumDitanceMatrix {

	public static MinimumDitanceMatrix thisClass = new MinimumDitanceMatrix();

	public static void main(String[] args) {
		Integer[][] matrix = thisClass.crecreateMatrix(2, 3);
		thisClass.printMatrix(matrix);
		thisClass.printMinimumDistance(matrix, 0, 0);
			
	}

	int result = 0; 

	
	private void printMinimumDistance(Integer[][] matrix, int i, int j) {
	}

	public void printMatrix(Integer mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private Integer[][] crecreateMatrix(int length, int width) {
		Random random = new Random();
		Integer[][] matrix = new Integer[length][width];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = random.nextInt(10);
			}
		}
		return matrix;

	}
}
