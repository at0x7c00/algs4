package me.huqiao.algs4.fundamentals.util;

/**
 * FIFO Queue
 * @author huqiao
 */
public interface Queue<Item> {

	/**
	 * add item
	 * @param item
	 */
	void enqueue(Item item);
	/**
	 * get item from queue
	 * @return
	 */
	Item dequeue();
	
	boolean isEmpty();
	
	int size();
}
