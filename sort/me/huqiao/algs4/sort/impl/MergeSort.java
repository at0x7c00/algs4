package me.huqiao.algs4.sort.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.huqiao.algs4.sort.AbstractSortor;
import me.huqiao.algs4.sort.Sortor;
import me.huqiao.algs4.stdlib.StdDraw;
import me.huqiao.algs4.stdlib.StdRandom;

public class MergeSort extends AbstractSortor implements Sortor{
	
	Comparable[] aux;

	@Override
	public void doSort(Comparable[] items) {
		aux = new Comparable[items.length];
		sort(items,0,items.length  - 1);
	}
	
	private void sort(Comparable[] items,int lo,int hi){
		if(hi<=lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(items,lo,mid);
		sort(items,mid + 1,hi);
		merge(items,lo,mid,hi);
		List<Integer> hightLight = new ArrayList<Integer>();
		for(int i = lo;i<=hi;i++){
			hightLight.add(i);
		}
		printPic(items,items.length,items.length,items.length,50,hightLight,0,0);
	}
	
	private void merge(Comparable[] items,int lo,int mid,int hi){
		int i = lo,j = mid + 1;
		for(int k = lo; k <= hi; k++){
			aux[k] = items[k];
		}
		for(int k = lo; k <= hi; k++){
			if(i > mid){
				items[k] = aux[j];
				j++;
			}else if(j > hi){
				items[k] = aux[i];
				i++;
			}else if(less(aux[i] , aux[j])){
				items[k] = aux[i];
				i++;
			}else{
				items[k] = aux[j];
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] data = StdRandom.randomData(100);
		MergeSort sort = new MergeSort();
		sort.doSort(data);
		sort.printAll(data);
	}
	
	public void printPic(Comparable[] items,int i,int xScale,int yScale,int pause,List<Integer> highlight,long arrayAccessCount,long arrayOperateCount){
		StdDraw.setXscale(0, xScale);
		StdDraw.setYscale(0, yScale + 10);
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.enableDoubleBuffering();
		
		int xIncrement = xScale/items.length;
		
		for(int x = 0; x<items.length; x++){
			if(x>i){
				StdDraw.setPenColor(StdDraw.GRAY);
			}else{
				StdDraw.setPenColor(StdDraw.BLACK);
			}
			Color c = StdDraw.getPenColor();
			if(highlight!=null && highlight.contains(x)){
				StdDraw.setPenColor(StdDraw.RED);
			}else{
				StdDraw.setPenColor(c);
			}
			Double v = Double.parseDouble(items[x].toString());
			StdDraw.filledRectangle(x * xIncrement,0,(xIncrement - .5)/2, v);
		}
		StdDraw.setPenColor(StdDraw.RED);
		//StdDraw.text(xScale/2, yScale, "array size:" + items.length+",array access:" + arrayAccessCount + " array operate:" + arrayOperateCount);
		StdDraw.pause(pause);
		StdDraw.show();
	}
	
	public void printPic(Comparable[] items,int i,int xScale,int yScale,int pause,Integer highlight,long arrayAccessCount,long arrayOperateCount){
		List<Integer> highlights = new ArrayList<Integer>();
		highlights.add(highlight);
		printPic(items, i, xScale, yScale, pause, highlights,arrayAccessCount,arrayOperateCount);
	}

}
