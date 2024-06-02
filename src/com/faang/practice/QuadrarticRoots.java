package com.faang.practice;

import java.util.ArrayList;
import java.util.List;

public class QuadrarticRoots {

    public static ArrayList<Integer> quadraticRootsOld(int a, int b, int c) {
       ArrayList<Integer> arrList = new ArrayList<Integer>();
       if((a>=-1000 && a<=1000) && (b>=-1000 && b<=1000) 
            && (c>=1/1000 && c<=1000)){
                double rt= (Math.pow(b,2) - (4 * a * c)); 
                double maxRoot =  (-b + (Math.sqrt(rt))) /2*a;
                double minRoot =  (-b - (Math.sqrt(rt))) /2*a;
                arrList.add((int) Math.round(maxRoot));
                arrList.add((int) Math.round(minRoot));
            
       }
       
       return  arrList;
    }
    
    public static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

    	if (a == 0)
    		return arrList;
    	
        if((a>=-1000 && a<=1000) && (b>=-1000 && b<=1000) 
                && (c>=-1000 && c<=1000)){
        	
            double d= (b * b) - (4 * a * c); 
            double sqrtVal = Math.sqrt(d);
            double root1 = 0d;
            double root2 = 0d;
            if(d >0) {
            	root1 =  (-b + sqrtVal) /(2*a);
            	root2 =  (-b - sqrtVal) /(2*a);
            	  
            }else if(d == 0) {
            	root1 = root2 = -b / (2 * a);
            }
            else {
            	
            	arrList.add(-1);
            }
            int root1i = (int) Math.floor(root1);
            int root2i = (int) Math.floor(root2);
            if(arrList.isEmpty())
            if(root1> root2) {
	            arrList.add(root1i);
	            arrList.add(root2i);
        	}else {
        		arrList.add(root2i);
        		arrList.add(root1i);
        	
           }
        }
        return  arrList;
     }
    
    public static void main(String[] args) {
    	//int a = 1,b = -7,c = 12; 
    	//int a = 1,b = -2,c = 1; 

    	//2 8 8
    	//752 904 164
    	//-264 -750 504
    	//280 399 573
    	//6 -979 -30
    	int a = 6,b = -979,c = -30;
		ArrayList<Integer> ans = quadraticRoots(a,b,c);
		System.out.println(ans);
	}

}
