package me.huqiao.algs4.sort;

/**
 * @author huqiao
 */
public interface Sortor {

	public boolean less(Comparable i1,Comparable i2);
	
	public void exchange(Comparable[] items,int i,int j);
	
	public void doSort(Comparable[] items);
	
	public boolean isSorted(Comparable[] items);
	
	public void printAll(Comparable[] items);
	
	public void printPic(Comparable[] items,int i,int xScale,int yScale,int pause);
	
}
