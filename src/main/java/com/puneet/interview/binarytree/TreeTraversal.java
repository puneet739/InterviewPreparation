package com.puneet.interview.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
		printrightSideView(head);
		printdownView(head);
	}

	
	private static void printdownView(Node head) {
		// TODO Auto-generated method stub
		
	}


	private static void printrightSideView(Node head) {
		Queue<Element> queue = new LinkedList<Element>();
		queue.add(new TreeTraversal().new Element(head, 1));
		
		Map<Integer, Integer> levelMapping = new HashMap();
		while(queue.peek()!=null) {
			Element current = queue.poll();
			//System.out.println(current.getNode().getNumber());
			if (levelMapping.get(current.getLevel()) == null ){
				System.out.println(current.getNode().getNumber());
				levelMapping.put(current.getLevel(), current.getNode().getNumber());
			}
			if (current.getNode().getRight()!=null)
				queue.add(new TreeTraversal().new Element(current.getNode().getRight(), current.getLevel()+1));
			if (current.getNode().getLeft()!=null)
				queue.add(new TreeTraversal().new Element(current.getNode().getLeft(), current.getLevel()+1));
		}
	}
	
	private static void printLeftSideView(Node head) {
		Queue<Element> queue = new LinkedList<Element>();
		queue.add(new TreeTraversal().new Element(head, 1));
		
		Map<Integer, Integer> levelMapping = new HashMap();
		while(queue.peek()!=null) {
			Element current = queue.poll();
			//System.out.println(current.getNode().getNumber());
			if (levelMapping.get(current.getLevel()) == null ){
				System.out.println(current.getNode().getNumber());
				levelMapping.put(current.getLevel(), current.getNode().getNumber());
			}
			if (current.getNode().getLeft()!=null)
				queue.add(new TreeTraversal().new Element(current.getNode().getLeft(), current.getLevel()+1));
			if (current.getNode().getRight()!=null)
				queue.add(new TreeTraversal().new Element(current.getNode().getRight(), current.getLevel()+1));
		}
	}
	
	class Element{
		Node node;
		int level;
		public Element(Node node, int level) {
			this.node=node;
			this.level=level;
		}
		public Node getNode() {
			return node;
		}
		public void setNode(Node node) {
			this.node = node;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		
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
