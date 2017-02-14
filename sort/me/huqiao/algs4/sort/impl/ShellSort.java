package me.huqiao.algs4.sort.impl;

import me.huqiao.algs4.sort.AbstractSortor;
import me.huqiao.algs4.sort.Sortor;
import me.huqiao.algs4.stdlib.StdDraw;
import me.huqiao.algs4.stdlib.StdRandom;

public class ShellSort extends AbstractSortor implements Sortor {

	@Override
	public void doSort(Comparable[] items) {
		int N = items.length;
		int h = 1;
		while(h<N) h = h*3 + 1;
		while(h>0){
			
			for(int i = 0;i<N;i++){
				for(int j = i;j>=h && less(items[j],items[j - h]); j-=h){
					exchange(items,j,j - h);
				}
				printPic(items, i,100,100,10);
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
		
	}

}
