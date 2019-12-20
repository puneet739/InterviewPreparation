package com.puneet.interview;

public class RodCuttingMaxOutput {

	public static void main(String[] args) {
		int arr[] = new int[] {1,5,8,9,10,17,17,20};
		int size =arr.length;
		System.out.println("Maximum output can be: "+cutRod(arr, size));
	}
	
	public static Integer cutRod(int price[], int n) {
		if (n <= 0) 
            return 0; 
        int max_val = Integer.MIN_VALUE; 
  
        // Recursively cut the rod in different pieces and 
        // compare different configurations 
        for (int i = 0; i<n; i++) 
            max_val = Math.max(max_val, 
                              price[i] + cutRod(price, n-i-1)); 
  
        return max_val; 
	}
}
