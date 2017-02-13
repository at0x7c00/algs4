package me.huqiao.algs4.sort.impl;

import me.huqiao.algs4.sort.AbstractSortor;
import me.huqiao.algs4.sort.Sortor;

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
		SelectSort sortor = new SelectSort();
		sortor.doSort(a);
		sortor.printAll(a);
	}

}
