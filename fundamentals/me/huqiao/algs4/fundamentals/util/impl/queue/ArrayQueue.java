package me.huqiao.algs4.fundamentals.util.impl.queue;

import me.huqiao.algs4.fundamentals.util.Queue;

/**
 *  a queue implemention use array
 * @author huqiao
 * @param <Item>
 */
public class ArrayQueue<Item> implements Queue<Item> {

	private Item[] items = (Item[])new Object[20];
	private int index = -1;
	private int size = 0;
	
	@Override
	public void enqueue(Item item) {
		if( items.length-1 < index ){
			increaseArray();
			//StdOut.println("extend queye array size to " + items.length);
		}
		items[++index] = item;
		size++;
	}
	
	private void increaseArray() {
		Item[] newArray = (Item[])new Object[items.length*2];
		for(int i = 0; i<items.length; i++){
			newArray[i] = items[i];
		}
		items = newArray;
	}

	@Override
	public Item dequeue() {
		
		size--;
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return size;
	}

}
