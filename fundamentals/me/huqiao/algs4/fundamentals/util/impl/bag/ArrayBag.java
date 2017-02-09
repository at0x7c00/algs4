package me.huqiao.algs4.fundamentals.util.impl.bag;

import java.util.Iterator;

import me.huqiao.algs4.fundamentals.util.Bag;
import me.huqiao.algs4.stdlib.StdOut;

/**
 * a bag implemention use array
 * @author huqiao
 * @param <Item>
 */
public class ArrayBag<Item> implements Bag<Item> {

	private Item[] items;
	private int index = -1;
	
	public ArrayBag(int initSize){
		items = (Item[])new Object[initSize];
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ArrayBagIterator();
	}

	@Override
	public void add(Item item) {
		StdOut.println("add item " + item);
		index++;
		if(items.length-1<index){
			increaseArray();
			StdOut.println("increase array size to " + items.length);
		}
		items[index] = item;
	}

	private void increaseArray() {
		Item[] newArray = (Item[])new Object[items.length*2];
		for(int i = 0;i<items.length;i++){
			newArray[i] = items[i];
		}
		items = newArray;
	}

	@Override
	public boolean isEmpty() {
		return index==-1;
	}

	@Override
	public int size() {
		return index+1;
	}
	
	class ArrayBagIterator implements Iterator<Item>{

		private int iteratorIndex = -1;
		
		@Override
		public boolean hasNext() {
			return iteratorIndex<size()-1;
		}

		@Override
		public Item next() {
			return items[++iteratorIndex];
		}

		@Override
		public void remove() {
			
		}
		
	}
	
	public static void main(String[] args) {
		ArrayBag<Integer> bag = new ArrayBag<Integer>(10);
		for(int i = 0;i<100;i++){
			bag.add(i);
		}
		for(Integer i : bag){
			StdOut.println(i);
		}
	}

}
