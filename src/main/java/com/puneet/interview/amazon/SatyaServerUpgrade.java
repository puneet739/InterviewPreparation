package com.puneet.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Making a class of graph with bfs function. 
class Graph 
{ 
	// adjacency map to maintain list of adjacent cells of each cell
	Map<Integer, List<Integer>> adjacencyMap;
	int n,m; 
	public Graph(int a, int b) { 
		n = a; 
		m = b;
		adjacencyMap = new HashMap<Integer, List<Integer>>();
		for(int i=1; i<=(n*m); i++){
			adjacencyMap.put(i, new ArrayList());
		}
		buildAdjacency();
	} 
 // Function to create graph with N*M nodes 
 // considering each cell as a node and each 
 // boundary as an edge. 
 void buildAdjacency() {
	 int cell = 1;
     for (int i = 1; i <= n; i++)      { 
         for (int j = 1; j <= m; j++) 
         {
        	 // order: left, up, right & down
        	 // except left column, all other columns will have a left cell
        	 if(j != 1)
        		 adjacencyMap.get(cell).add(cell-1);
        	 //except top row, all other rows will have a upper cell
        	 if(i != 1)
        		 adjacencyMap.get(cell).add(cell-m);
        	 //right
        	 if(j != m)
        		 adjacencyMap.get(cell).add(cell+1);
        	 //down
        	 if(i != n)
        		 adjacencyMap.get(cell).add(cell+m);
        	 cell++;
         } 
     } 
 }
/**
 * @return the adjacencyMap
 */
public Map<Integer, List<Integer>> getAdjacencyMap() {
	return adjacencyMap;
}
 
 // BFS function to find minimum distance 

 void bfs(boolean visit[], int dist[], Queue<Integer> q) { 
     while (!q.isEmpty()) 
     { 
         int cell = q.poll(); 
         //push adjacents of cell, if not visited
         for(Integer k: adjacencyMap.get(cell)){
        	 if(!visit[k]){
        		 q.add(k);
        		 dist[k] = Math.min(dist[k], dist[cell]+1);
        	 }
         }
         //mark current cell as visited
         visit[cell] = true;
     } 
 } 

// Printing the solution. 
 void print(int dist[]) { 
	 System.out.println(Arrays.toString(dist));
 }
}
public class SatyaServerUpgrade {
	// Find minimum distance 
	public static void findMinDistance(int mat[][], int N, int M) 
	{ 

	    // Creating a graph with nodes values assigned 

	    // from 1 to N x M and matrix adjacent. 

	    Graph g1 = new Graph(N, M);
	    int MAX = N*M+1;

	    // To store minimum distance 
	    int[] dist = new int[MAX]; 

	    // To mark each node as visited or not in BFS 
	    boolean[] visit = new boolean[MAX]; 
	    
	    // Initializing the value of distance and visit.
	    Arrays.fill(visit, false);
	    Arrays.fill(dist, Integer.MAX_VALUE);

	    // Inserting nodes whose value in matrix 
	    // is 1 in the queue. 
	    int k = 1; 
	    Queue<Integer> q = new LinkedList();
	    for (int i = 0; i < N; i++) 
	    { 
	        for (int j = 0; j < M; j++) 
	        { 
	            if (mat[i][j] == 1) 
	            { 
	                dist[k] = 0; 
	                visit[k] = true; 
	                q.add(k);
	            } 
	            k++; 
	        } 
	    } 
	    // Calling for Bfs with given Queue. 
	    g1.bfs(visit, dist, q); 
	    // Printing the solution. 
	    g1.print(dist); 
	} 
	
	public static void main(String[] args){
		int[][] matrix = {
				{0, 0 },
				{0, 1 },
				{0, 1, 1}
		};
		System.out.println("Given matrix");
		for(int[] row: matrix){
			System.out.println(Arrays.toString(row));
		}
		
		findMinDistance(matrix, matrix.length, matrix[0].length);
	}

	
	private static int[][] computeNearestCell(int[][] matrix) {
		System.out.println("Distance of nearest cell having 1 in a binary matrix");
		// mxn matrix
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] result= new int[m][n];
		// fill the result with MAX_VALUE
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				result[i][j] = Integer.MAX_VALUE;
			}
		} 
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				//For the given cell[i][j], need to check R,L,U,D directions nearest cell with 1
				//traverse the whole matrix and keep updating the nearest distance
					for(int k=0; k<m; k++){
						for(int l=0; l<n; l++){
							if(matrix[k][l] == 1)
								result[i][j] = Math.min(result[i][j], Math.abs(i-k)+Math.abs(j-l));
						}
				}
		}
	}
		
		
		return result;
	}
}
