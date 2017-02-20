package me.huqiao.algs4.sort.impl;

import java.util.ArrayList;
import java.util.List;

import me.huqiao.algs4.sort.AbstractSortor;
import me.huqiao.algs4.sort.Sortor;
import me.huqiao.algs4.stdlib.StdOut;
import me.huqiao.algs4.stdlib.StdRandom;

public class ShellSort extends AbstractSortor implements Sortor {

	@Override
	public void doSort(Comparable[] items) {
		int N = items.length;
		int h = 1;
		while(h<N) h = h*3 + 1;
	    long arrayAccessCount = 0;
	    long arrayOperate = 0;
	    
		while(h>0){
			for(int i = 0;i<N;i++){
				List<Integer> highlight = new ArrayList<Integer>();
				for(int j = i;j>=h && (++arrayAccessCount>0 && less(items[j],items[j - h])); j-=h){
					exchange(items,j,j - h);
					highlight.add(j - h);
					arrayOperate++;
				}
				printPic(items, i,items.length,items.length,10,highlight,arrayAccessCount,arrayOperate);
			}
			h/=3;
		}
		
		
	}
	
	public static void main(String[] args) {
		int N = 100;
		Integer[] a = StdRandom.randomData(N);
		
		ShellSort sortor = new ShellSort();
		sortor.doSort(a);
		sortor.printAll(a);
		
		//shellSort(a);
	}
	
	/* exercise
	 * public static void shellSort(Integer[] a){
		int N = a.length;
		for(int i = 0;i<N; i++){
			System.out.print(a[i] + "\t");
		}
		int h = 1;
		while(h<N) h = h*3 + 1;
		
		while(h>0){
			for(int i = 0; i<N; i++){
				for(int j = i; j>=h && (a[j] < a[j-h]); j-=h){
					int tmp = a[j];
					a[j] = a[j - h];
					a[j - h] = tmp;
				}
			}
			h /= 3;
		}
		System.out.println();
		for(int i = 0;i<N; i++){
			System.out.print(a[i] + "\t");
		}
	}*/

}
