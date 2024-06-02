package com.dsa.practice.trees;

import java.awt.List;
import java.util.ArrayList;

class Node {
	int data;
	Node left, right;

	Node(int d) {
		data = d;
		left = right = null;
	}
}
public class TreeTraversal {

	  //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> preOrderList = new ArrayList<Integer>();
        preorder(root , preOrderList);
		return preOrderList;
    }
    
    static void preorder(Node root,ArrayList<Integer> preOrderList){
        if(root != null){
        	preOrderList.add(root.data);
        	preorder(root.left, preOrderList);
        	preorder(root.right,preOrderList);
        }
        
    }
    
    
 // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> inOrderList = new ArrayList<Integer>();
        inorder(root , inOrderList);
		return inOrderList;
    }
    
      void inorder(Node root,ArrayList<Integer> inOrderList){
        if(root != null){
        	inorder(root.left, inOrderList);
        	inOrderList.add(root.data);
        	inorder(root.right,inOrderList);
        }
        
    }
      
	// Function to return a list containing the inorder traversal of the tree.
	ArrayList<Integer> postOrder(Node root) {
		ArrayList<Integer> postOrderList = new ArrayList<Integer>();
		postOrder(root, postOrderList);
		return postOrderList;
	}

	void postOrder(Node root, ArrayList<Integer> postOrderList) {
		if (root != null) {
			postOrder(root.left, postOrderList);
			postOrder(root.right, postOrderList);
			postOrderList.add(root.data);

		}

	}
	
	//Function to find the height of a binary tree.
    int height(Node node) 
    {
        if(node == null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh,rh)+1;
    }
    
  //Function to check if two trees are identical.
  	static boolean isIdentical(Node root1, Node root2)
  	{
  		
  		if(root1 !=null && root2 !=null) {
	        if(root1.data != root2.data) {
	        	return false;
	        }
        	return (isIdentical(root1.left, root2.left) 
        	&& isIdentical(root1.right, root2.right));

  		}else if((root1 !=null && root2 ==null) || (root2 !=null && root1 ==null)){
  		    return false;
  		}
  		return true;
  	    
  	}
  	
  	public static void main(String[] args) {
		
  		Node root1 = new Node(1);
  		root1.left = new Node(2);
  		root1.right = new Node(3);
  		Node root2 = new Node(1);
  		root2.left = new Node(2);
  		root2.right = new Node(3);
  		
  		System.out.print(isIdentical(root1, root2));
	}
}
