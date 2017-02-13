package me.huqiao.algs4.sort.impl;

import me.huqiao.algs4.sort.AbstractSortor;
import me.huqiao.algs4.sort.Sortor;

public class InsertSort extends AbstractSortor implements Sortor {

	@Override
	public void doSort(Comparable[] items) {
		for(int i = 1; i<items.length; i++){
			for(int j = i;j > 0 && less(items[j],items[j-1]); j--){
				exchange(items, j, j - 1); 
			}
			printPic(items,i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[]{11,2,52,100,9,23,3};
		InsertSort sortor = new InsertSort();
		sortor.doSort(a);
		sortor.printAll(a);
	}

}
