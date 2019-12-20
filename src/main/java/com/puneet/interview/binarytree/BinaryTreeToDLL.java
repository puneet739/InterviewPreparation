package com.puneet.interview.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeToDLL {

	
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
		head.right.left=new Node(6);
		printInOrder(head);
		//convertToDLL(head);
	}

	private static void printInOrder(Node head) {
		if (head.left!=null) {
			printInOrder(head.left);
		}
		System.out.println(head.number);
		if (head.right!=null) {
			printInOrder(head.right);
		}
	}

	private static void convertToDLL(Node head) {
		
		
	}
}
