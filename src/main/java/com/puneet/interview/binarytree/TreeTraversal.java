package com.puneet.interview.binarytree;

public class TreeTraversal {

	public static void main(String[] args) {
		/*
		 *    	 1
               /   \
              2     3
             / \     \
            4   5     6   
		 */
		Node head = new Node(1);
		head.left= new Node(2);
		head.left.left= new Node(4);
		head.left.right= new Node(5);
		head.right=new Node(3);
		head.right.right=new Node(6);

		
		printLeftSideView(head);
	
	}

	private static void printLeftSideView(Node head) {
		// TODO Auto-generated method stub
	}
	
	
}

class Node{
	int number;
	Node left;
	Node right;
	public Node(int number) {
		this.number=number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
}
