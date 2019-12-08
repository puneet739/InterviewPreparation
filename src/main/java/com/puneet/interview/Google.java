package com.puneet.interview;

public class Google {

	public static void main(String[] args) {
	//	Integer A[][] = {{4,2,4,2},{4,null,4,2},{2,null,8,2},{16,null,4,null}};
		Integer A[][] =  {{2,null,2,null}, {2,null,2,null} ,{null,null,null,null}, {null,null,null,null}};
		
		for (int j=0; j<4 ; j++) {
			for (int i=0; i<4 ; i++) {
				if (A[i+1][j] != null) {
					if (A[i+1][j]==A[i][j]) {
						A[i][j]=A[i][j] * 2;
						A[i+1][j]=null;
					}
					if(A[i][j]==null) {
						A[i][j]= A[i+1][j];
						A[i+1][j]= null;
					}
				}
			}
		}
		printA(A);
		
	}

	private static void printA(Integer[][] a) {
		for (int j=0; j<4 ; j++) {
			for (int i=0; i<4 ; i++) {
				System.out.print( " "+a[j][i]);
			}
			System.out.println( );
		}
	}
}
