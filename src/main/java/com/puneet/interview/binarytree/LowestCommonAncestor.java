package com.puneet.interview.binarytree;import javax.swing.text.AbstractDocument.LeafElement;

public class LowestCommonAncestor {

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
		
		
		Node lcaNode = LCA(head, head.left.right, head.left);
		System.out.println("Lowest Common Ancestor is : "+lcaNode.number);
	}

	private static Node LCA(Node tree, Node first, Node second) {
		if (tree == null)
			return null;
		
		if (tree == first || tree == second) {
			return tree;
		}

		Node leftLCA = LCA(tree.left, first, second);
		Node rightLCA = LCA(tree.right, first, second);

		if (leftLCA != null && rightLCA != null) {
			return tree;
		}

		return (leftLCA != null) ? leftLCA : rightLCA;
	}
}
