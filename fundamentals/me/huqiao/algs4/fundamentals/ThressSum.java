package me.huqiao.algs4.fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import me.huqiao.algs4.stdlib.StdIn;

public class ThressSum {
	
	public static int count(int[]a){
		int N = a.length;
		int cnt = 0;
		for(int i = 0;i < N; i++){
			for(int j = i+1; j< N;j++){
				for(int k = j+1; k < N; k++){
					if(a[i] + a[j] + a[k] == 0){
						cnt ++;
					}
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./bin/4Kints.txt"));
		int[] a = StdIn.readInts();
		System.out.println(count(a));
	}
	
}
