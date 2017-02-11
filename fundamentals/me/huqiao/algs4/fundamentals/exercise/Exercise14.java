package me.huqiao.algs4.fundamentals.exercise;

import java.util.Arrays;

public class Exercise14 {

	public static void main(String[] args) {
		
		int[] a = new int[]{10,16,13,22,23};

		int[] res = longestPair(a);
		System.out.println("longest distant elements is " + res[0] + " and " + res[1]);
		int[] res2 = shortestPair(a);
		System.out.println("longest distant elements is " + res2[0] + " and " + res2[1]);
	}
	
	public static int[] longestPair(int[] a){
		Arrays.sort(a);
		return new int[]{a[0],a[a.length - 1]};
	}
	public static int[] shortestPair(int[] a){
		Arrays.sort(a);
		int x = 0;
		int res = 0;
		for(int i = 0; i<a.length - 1; i++){
			int y = a[i] - a[i+1];
			if(y<0){
				y = -y;
			}
			if(y<x){
				res = i;
			}
		}
		return new int[]{a[res],a[res + 1]};
	}
	
	
	
}
