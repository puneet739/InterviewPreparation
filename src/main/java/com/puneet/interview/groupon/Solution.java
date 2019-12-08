package com.puneet.interview.groupon;

import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution gp = new Solution();
		gp.doSomething();
	}

	private void doSomething() {
		System.out.println("Puneet Rocks");
		Solution.minNum(4, Arrays.asList(5));
	}
	
	static int threshold =0; 
	public static int minNum(int threshold, List<Integer> happy) {
		
		Solution.threshold= threshold;
		
		Tree t = getTree(happy.get(0));
		t.setIndex(0);
		t.setCurrentDepth(1);
		t.setCurrentAnswer(happy.get(0));
		System.out.println("ANSWER IS " +doIteration(t,happy));
		
		return 0;
	}
	
	private static int doIteration(Tree t, List<Integer> happy) {
		int baseIndex = t.getIndex();
		if (happy.get(baseIndex+1) ==null ) { return Integer.MAX_VALUE;};
		
		Tree leftTree = new Solution().new Tree(happy.get(baseIndex+1));
		leftTree.setIndex(baseIndex+1);
		leftTree.setCurrentDepth(t.getCurrentDepth()+1);
		leftTree.setCurrentAnswer(t.getCurrentAnswer()+happy.get(baseIndex+1));
		if (leftTree.getCurrentAnswer()>threshold) return leftTree.getCurrentDepth();
		
		
		Tree rightTree = new Solution().new Tree(happy.get(baseIndex+2));
		rightTree.setIndex(baseIndex+2);
		rightTree.setCurrentDepth(t.getCurrentDepth()+1);
		rightTree.setCurrentAnswer(t.getCurrentAnswer()+happy.get(baseIndex+2));
		if (rightTree.getCurrentAnswer()>threshold) return rightTree.getCurrentDepth();
		
		int leftAnswer = doIteration(leftTree, happy);
		int rightAnswer  = doIteration(rightTree, happy);
		
		return (leftAnswer<rightAnswer ? leftAnswer : rightAnswer);
		
	}

	public static Tree getTree(int number) {
		Tree t = new Solution().new Tree(10);
		t.setCurrentAnswer(number);
		return t;
	}
	
	public class Tree {
		public Tree(int current) {
			this.CurrentAnswer=current;
		}
		Tree left;
		Tree Right;
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		int index;
		int CurrentAnswer;
		int currentDepth;
		
		public int getCurrentDepth() {
			return currentDepth;
		}
		public void setCurrentDepth(int currentDepth) {
			this.currentDepth = currentDepth;
		}
		public Tree getLeft() {
			return left;
		}
		public void setLeft(Tree left) {
			this.left = left;
		}
		public Tree getRight() {
			return Right;
		}
		public void setRight(Tree right) {
			Right = right;
		}
		public int getCurrentAnswer() {
			return CurrentAnswer;
		}
		public void setCurrentAnswer(int currentAnswer) {
			CurrentAnswer = currentAnswer;
		}
	}
	
	
}
