package me.huqiao.algs4.sort.impl;

import me.huqiao.algs4.sort.AbstractSortor;
import me.huqiao.algs4.sort.Sortor;
import me.huqiao.algs4.stdlib.StdRandom;

public class InsertSort extends AbstractSortor implements Sortor {

	@Override
	public void doSort(Comparable[] items) {
		for(int i = 1; i<items.length; i++){
			for(int j = i;j > 0 && less(items[j],items[j-1]); j--){
				exchange(items, j, j - 1); 
				printPic(items,i,100,100,50,j - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		
		int N = 100;
		Integer[] a = StdRandom.randomData(N);
		
		InsertSort sortor = new InsertSort();
		sortor.doSort(a);
		sortor.printAll(a);
	}

}
