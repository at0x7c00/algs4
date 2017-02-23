package me.huqiao.algs4.sort.impl;

import me.huqiao.algs4.sort.AbstractSortor;
import me.huqiao.algs4.sort.Sortor;
import me.huqiao.algs4.stdlib.StdDraw;
import me.huqiao.algs4.stdlib.StdRandom;

public class InsertSort extends AbstractSortor implements Sortor {

	@Override
	public void doSort(Comparable[] items) {
		long accessCount = 0;
		long operateCount = 0;
		for(int i = 1; i<items.length; i++){
			for(int j = i;j > 0 && (++accessCount >0 && less(items[j],items[j-1])); j--){
				exchange(items, j, j - 1); 
				operateCount++;
				printPic(items,i,100,100,10,j - 1,accessCount,operateCount);
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
