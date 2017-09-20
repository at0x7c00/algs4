package me.huqiao.algs4.search;

import java.util.Iterator;

public abstract class AbstractST<K extends Comparable<K>,V> implements ST<K,V>{
	
	public boolean contains(K key){
		return get(key)!=null;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public void print(){
		Iterator<Node<K,V>> iterator = this.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next().key+"\t");
		}
	}

}
