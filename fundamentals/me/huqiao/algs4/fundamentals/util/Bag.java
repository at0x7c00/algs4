package me.huqiao.algs4.fundamentals.util;

/**
 * @author huqiao
 */
public interface Bag<Item> extends Iterable<Item>{

	void add(Item item);
	boolean isEmpty();
	int size();
	
}
