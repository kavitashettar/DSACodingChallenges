package com.faang.practice;

public class Strings {
	public static void main(String[] args) {
		String s= "My name is Kavita";
		String res="";
		String[] split = s.split(" ");
		for(int i=split.length-1 ; i>=0 ;i--) {
			res = res.concat(split[i]+ " ");
		}
		System.out.println(res);
		

	}
}
