package me.huqiao.algs4.sort;

import me.huqiao.algs4.stdlib.StdDraw;
import me.huqiao.algs4.stdlib.StdOut;

public abstract class AbstractSortor implements Sortor{

	static{
		StdDraw.setCanvasSize(1000, 500);
	}
	
	@Override
	public boolean less(Comparable i1, Comparable i2) {
		return i1.compareTo(i2) < 0;
	}

	@Override
	public void exchange(Comparable[] items, int i, int j) {
		Comparable tmp = items[i];
		items[i] = items[j];
		items[j] = tmp;
	}

	@Override
	public abstract void doSort(Comparable[] items);

	@Override
	public boolean isSorted(Comparable[] items) {
		for(int i = 0; i < items.length - 1; i++){
			if(!less(items[i],items[i+1])){
				return false;
			}
		}
		return true;
	}

	@Override
	public void printAll(Comparable[] items) {
		int i = 0;
		for(Comparable item : items){
			i++;
			StdOut.print(item + "\t");
			if(i%20==0){
				StdOut.println();
			}
		}
	}
	
	public void printPic(Comparable[] items,int i,int xScale,int yScale,int pause){
		StdDraw.setXscale(0, xScale);
		StdDraw.setYscale(0, yScale);
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.enableDoubleBuffering();
		
		int xIncrement = xScale/items.length;
		
		for(int x = 0; x<items.length; x++){
			if(x>i){
				StdDraw.setPenColor(StdDraw.GRAY);
			}
			Double v = Double.parseDouble(items[x].toString());
			StdDraw.filledRectangle(x * xIncrement,0,(xIncrement - .5)/2, v);
		}
		StdDraw.pause(pause);
		StdDraw.show();
	}

}
