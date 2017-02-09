package me.huqiao.algs4.fundamentals.util;

/**
 * LIFO
 * @author huqiao
 */
public interface Stack<Item>  extends Iterable<Item>{

	/**
	 * add item
	 * @param item
	 */
	void push(Item item);
	/**
	 * get item from queue
	 * @return
	 */
	Item pop();
	
	boolean isEmpty();
	
	int size();
	
}
