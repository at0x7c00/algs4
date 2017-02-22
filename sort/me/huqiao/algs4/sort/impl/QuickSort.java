package me.huqiao.algs4.sort.impl;

import java.awt.Color;
import java.util.List;

import me.huqiao.algs4.sort.AbstractSortor;
import me.huqiao.algs4.sort.Sortor;
import me.huqiao.algs4.stdlib.StdDraw;
import me.huqiao.algs4.stdlib.StdOut;
import me.huqiao.algs4.stdlib.StdRandom;

public class QuickSort extends AbstractSortor implements Sortor {

	int arrayAccessCount = 0;
	int arrayOperateCount = 0;
	
	@Override
	public void doSort(Comparable[] items) {
		sort(items,0,items.length - 1);
	}
	
	private void sort(Comparable[] items,int lo,int hi){
		if(hi<=lo) return;
		int j = paratition(items,lo,hi);
		sort(items,lo,j);
		sort(items,j+1,hi);
	}

	private int paratition(Comparable[] items, int lo, int hi) {
		
		int i = lo;
		int j = hi + 1;
		Comparable v = items[lo];
		
		while(true){
			
			while(less(items[++i],v) && (++arrayAccessCount>0)) if(i==hi) break;
			while(less(v,items[--j]) && (++arrayAccessCount>0)) if(j==lo) break;
			
			if(i>=j) break;
			exchange(items, i, j);
			arrayOperateCount++;
			printPic2(items, 100, 100, 100, arrayAccessCount, arrayOperateCount,lo,hi,j,false);
			
		}
		arrayOperateCount++;
		exchange(items, lo, j);
		printPic2(items, 100, 100, 100, arrayAccessCount, arrayOperateCount,lo,hi,j,true);
		return j;
	}
	
	
	public void printPic2(Comparable[] items,int xScale,int yScale,int pause,
			long arrayAccessCount,long arrayOperateCount,int lo,int hi,int j,boolean ok){
		StdDraw.setXscale(0, xScale);
		StdDraw.setYscale(0, yScale + 10);
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.enableDoubleBuffering();
		
		int xIncrement = xScale/items.length;
		
		for(int x = 0; x<items.length; x++){
			if(x>=lo && x<=hi){
				StdDraw.setPenColor(StdDraw.GRAY);
			}else{
				StdDraw.setPenColor(StdDraw.BLACK);
			}
			Color c = StdDraw.getPenColor();
			if(x==j){
				if(ok){
					StdDraw.setPenColor(StdDraw.RED);
				}else{
					StdDraw.setPenColor(StdDraw.BLUE);
				}
			}else{
				StdDraw.setPenColor(c);
			}
			Double v = Double.parseDouble(items[x].toString());
			StdDraw.filledRectangle(x * xIncrement,0,(xIncrement - .5)/2, v);
		}
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.text(xScale/2, yScale - 5, "lo:" + lo + "    j:" + j + "     hi:" + hi);
		StdDraw.text(xScale/2, yScale, "array size:" + items.length+",array access:" + arrayAccessCount + " array operate:" + arrayOperateCount);
		StdDraw.pause(pause);
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Integer[] data = StdRandom.randomData(100);
		
		QuickSort sort = new QuickSort();
		sort.doSort(data);
		
		for(int i : data){
			StdOut.println(i);
		}
		
	}

}
