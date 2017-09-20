package me.huqiao.algs4.search;

public class Node<K extends Comparable,V> {
	
	public K key;
	public V value;
	
	public Node(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Node<K,V> left;
	public Node<K,V> right;
	
	public int getSize(){
		int s = 1;
		if(left!=null){
			s += left.getSize();
		}
		if(right!=null){
			s += right.getSize();
		}
		return s;
	}
	
}
