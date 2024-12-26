package com.dsa.practice.trees;

public class PrintKDist {
	
	static int printKDistantfromLeaf(Node root, int k)
    {
        int count = 0;
        if(root ==null)
            return count;
            
       
        
        if(root.left !=null) {
        	if(isLeafNodeSpecial(root.right, k))
        		count++;
        	else
        		printKDistantfromLeaf(root.left,k-1);
        }
        	
            
        if(root.right !=null &&
        		isLeafNodeSpecial(root.right, k-1))
        	count++;
            
        return count;
    }
    static boolean isLeafNodeSpecial(Node root , int k){
        if(root.left == null && root.right ==null && k==0)
            return true;
        return false;
    }
	public static void main(String[] args) {

  		Node root = new Node(1);
  		root.left = new Node(2);
  		root.right = new Node(3);
  		root.left.left = new Node(4);
  		root.left.right = new Node(5);
  		root.right.left = new Node(6);
  		root.right.right = new Node(7);
  		root.right.left.right = new Node(8);
  		
  		System.out.print(printKDistantfromLeaf(root, 2));
	}
		

}
