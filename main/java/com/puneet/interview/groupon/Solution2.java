package com.puneet.interview.groupon;

import java.util.Arrays;
import java.util.List;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 gp = new Solution2();
		System.out.println(gp.minimumMoves(Arrays.asList(103) , Arrays.asList(301)));
	}

	  public static int minimumMoves(List<Integer> a, List<Integer> m) {
		  int result =0;
		  for (int i=0; i< a.size(); i++) {
			int firstnumber =  a.get(i) ;
			int secondNumber =  m.get(i) ;
			result  += movesRequired(firstnumber,secondNumber, 0, 1);
		  }
		  System.out.println("Final Result = "+result);
		  return result;
	  }

	private static int movesRequired(int firstnumber, int secondNumber, int count, int index ) {
		int testFirst = firstnumber%(10);
		int testSecond = secondNumber%(10);
		if (firstnumber>0 || secondNumber>0) {
			int movesCount = Math.abs(testFirst-testSecond);
			return movesRequired(firstnumber/10, secondNumber/10, movesCount+count,  index*10 );
		}
		return count;
	}
	  
	  
}
