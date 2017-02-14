package me.huqiao.algs4.sort.impl;

import me.huqiao.algs4.sort.AbstractSortor;
import me.huqiao.algs4.sort.Sortor;
import me.huqiao.algs4.stdlib.StdRandom;

public class SelectSort extends AbstractSortor implements Sortor {

	@Override
	public void doSort(Comparable[] items) {
		for(int i = 0; i<items.length; i++){
			int minIndex = i;
			for(int j = i + 1;j<items.length; j++){
				if(less(items[j],items[minIndex])){
					minIndex = j;
				}
			}
			exchange(items, i, minIndex);
			printPic(items,i,100,100,100);
		}
	}
	
	public static void main(String[] args) {
		int N = 100;
		Integer[] a = StdRandom.randomData(N);
		
		SelectSort sortor = new SelectSort();
		sortor.doSort(a);
		sortor.printAll(a);
	}

}
