package me.huqiao.algs4.search;

public interface ST<K extends Comparable<K>,V> extends Iterable<Node<K,V>>{

	public void put(K key,V value);
	public K get(K key);
	public int size();
	
	public void delete(K key);
	public boolean contains(K key);
	public boolean isEmpty();
	
	public K min();
	public K max();
	
	public void print();
	
	public int depth();
	
}
