package com.puneet.interview.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*
 * Server Upgrade mechanism u have to create. Servers are parked in 2D array mechanism. 
		
		A server which is upgrade represented by 1 and outdated server are 0. 
		Upgraded Server=1;
		OutDated Server=0
		
		Upgraded servers can upgrade there neighbours in 1 day, and neighours are left, right, top and bottom. not the diagnol servers. 
		
		How many days required to upgrade all servers. 
		
		Exampls: 
		
		Grid: 
		0	1	1	0	1
		0	1	0	1	0
		0	0	0	0	1
		0	1	0	0	0
		
		After Day 1	: 
		1	1	1	1	1
		1	1	1	1	1
		0	1	0	1	1
		1	1	1	0	1	
		
		
		After Day 2:
		1	1	1	1	1
		1	1	1	1	1
		1	1	1	1	1
		1	1	1	1	1
		
		
		Thus all servers are upgraded by EOD 2 day. 
		
		so output is 2
		
		
		Write a code for this, or suggest approach first. 
		
		Regards
		Puneet Behl
		0-9711616135
 */
public class ServerUpgrade {

	public static void main(String[] args) {
		List<Integer> row1 = Arrays.asList(0,1,1,0,1);
		List<Integer> row2 = Arrays.asList(0,1,0,1,0);
		List<Integer> row3 = Arrays.asList(0,0,0,0,1);
		List<Integer> row4 = Arrays.asList(0,1,0,0,0);

		List<List<Integer>> grid = new LinkedList<List<Integer>>();
		grid.add(row1);
		grid.add(row2);
		grid.add(row3);
		grid.add(row4);
		ServerUpgrade sol = new ServerUpgrade();
		System.out.println(sol.minimumDays(4, 5, grid));

	}

	int minimumDays(int rows, int column, List<List<Integer>> grid) {
		int area[][] = new int[rows][column];
		int i = 0, j = 0;
		for (List<Integer> gridRow : grid) {
			j = 0;
			for (Integer current : gridRow) {
				area[i][j] = current;
				j++;
			}
			i++;
		}
		
		int currentDay=0;
		return resultAfterDay(rows, column, area,currentDay);
	}

	int resultAfterDay(int row, int column, int[][] area, int currentDay) {
		boolean isUpgraded=false;
		Map<String,Boolean> cantUpgrade = new HashMap();
		for (int i=0; i<row; i++) {
			for (int j=0; j<column; j++) {
				if (area[i][j] == 1 && !cantUpgrade.containsKey(i+""+j)) { 
					//This is a server, can provide upgrade
					//upgradeNeighbour();
					if (i+1<row && area[i+1][j] == 0) {
			    		area[i+1][j] = 1;
			    		cantUpgrade.put(i+1+""+j, true);
			    		isUpgraded=true;
			    	}
					
					if (i-1 >= 0 && i-1<row && area[i-1][j] == 0) {
			    		area[i-1][j] = 1;
			    		cantUpgrade.put((i-1)+""+j, true);
			    		isUpgraded=true;
			    	}
					
					if (j-1 >= 0 && j-1<column && area[i][j-1] == 0) {
						area[i][j-1] = 1;
						cantUpgrade.put(i+""+(j-1), true);
						isUpgraded=true;
			    	}
					
					if (j+1<column && area[i][j+1] == 0) {
						area[i][j+1] = 1;
						cantUpgrade.put(i+""+(j+1), true);
						isUpgraded=true;
			    	}
				}
			}
		}
		if (isUpgraded) {
			return resultAfterDay(row, column, area,currentDay+1);
		}else {
			return currentDay;
		}
		
	}


}
