package com.puneet.interview.amazon;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class SolutionNumberParking
{        
	
	public static void main(String[] args) {
		List<Integer> row1 = Arrays.asList(1,1,0,0);
		List<Integer> row2 = Arrays.asList(0,0,1,1);
		List<Integer> row3 = Arrays.asList(1,1,1,0);
		
		List<List<Integer>> grid = new LinkedList<List<Integer>>();
		grid.add(row1);
		grid.add(row2);
		grid.add(row3);
		SolutionNumberParking sol = new SolutionNumberParking();
		System.out.println(sol.numberAmazonTreasureTrucks(3, 4, grid));
		
	}
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int numberAmazonTreasureTrucks(int rows, int column,
								   List<List<Integer> > grid)
    {
    	int currentParkCount = 0;
    	Map<String,String> parkMap =new HashMap();
    	
        int area[][] = new int[rows][column];
        int i=0, j=0;
        for (List<Integer> gridRow: grid) {
        	j=0;
        	for (Integer current: gridRow) {
        		area[i][j]=current;
        		j++;
        	}
        	i++;
        }
        
        for(int x=0;x<rows; x++){
            for (int y=0; y<column; y++) {
            	if (area[x][y]== 1 ) {
            		int number=area[x][y];
            		//This is a park 
            		if (parkMap.get(x+","+y) == null ) {
            			++currentParkCount;
            			addAllPark(area, x, y, parkMap, currentParkCount , rows, column);
            		}
            	}
            }
        }
        
        return currentParkCount; 
        
    }
    
	public void addAllPark(int[][] area, int x, int y,Map map,int currentParkCount, int row, int column) {
    	if (map.get(x+","+y) == null) {
    		map.put(x+","+y, "park"+ currentParkCount);
    	}else { 
    		return;
    	}
    	if (x<row-1 && area[x+1][y] == 1) {
    		addAllPark(area, x+1, y, map, currentParkCount,row, column);
    	}
    	
    	if (y < column-1 && area[x][y+1] == 1) {
    		addAllPark(area, x, y+1, map, currentParkCount,row, column);
    	}
    	
    	if (y>=1 && area[x][y-1] == 1) {
    		addAllPark(area, x, y-1, map, currentParkCount,row, column);
    	}
    }
    // METHOD SIGNATURE ENDS
}