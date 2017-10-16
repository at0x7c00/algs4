package me.huqiao.algs4.fundamentals.util.impl.queue;

import java.util.Iterator;

import me.huqiao.algs4.fundamentals.util.Queue;
import me.huqiao.algs4.stdlib.StdOut;

/**
 *  a queue implemention use array
 * @author huqiao
 * @param <Item>
 */
public class ArrayQueue<Item> implements Queue<Item> {

	private Item[] items = (Item[])new Object[20];
	private int size = 0;
	
	@Override
	public void enqueue(Item item) {
		if( items.length <= size ){
			resize(items.length*2);
		}
		items[size++] = item;
	}
	
	private void resize(int s) { 
		Item[] newArray = (Item[])new Object[s];
		for(int i = 0; i<s && i<items.length; i++){
			newArray[i] = items[i];
		}
		items = newArray;
		//StdOut.println("resize queye array size to " + items.length);
	}

	@Override
	public Item dequeue() {
		Item item = items[0];
		for(int i = 1;i<items.length;i++){
			items[i-1] = items[i];
		}
		size--;
		if(size<items.length/4){
			resize(items.length/2);
		}
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayQueueInterator();
	}
	
	class ArrayQueueInterator implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			return !isEmpty();
		}

		@Override
		public Item next() {
			return dequeue();
		}

		@Override
		public void remove() {
		}
	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		
		for(int i = 1;i<200;i++){
			queue.enqueue(i);
		}
		
		for(Integer s : queue){
			//System.out.println(s);
		}
	}

}
