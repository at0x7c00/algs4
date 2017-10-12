package me.huqiao.algs4.search.binarysearchtree.redblacktree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.huqiao.algs4.search.AbstractST;
import me.huqiao.algs4.search.Node;
import me.huqiao.algs4.search.ST;

public class RedBlackTree<K extends Comparable<K>,V> extends AbstractST<K,V> implements ST<K,V> {
	
	private Node<K,V> root = null;

	@Override
	public Iterator<Node<K, V>> iterator() {
		final List<Node<K,V>> nodes = new ArrayList<Node<K,V>>();
		searchNode(root,nodes);
		return new Iterator<Node<K,V>>() {
			
			int index = 0;
			int total = nodes.size();

			@Override
			public boolean hasNext() {
				return index < total;
			}

			@Override
			public Node<K, V> next() {
				return nodes.get(index++);
			}

			@Override
			public void remove() {
			}
		};
	}
	private void searchNode(Node<K, V> root, List<Node<K, V>> nodes) {
		if(root==null){
			return;
		}
		if(root.left!=null){
			searchNode(root.left,nodes);
		}
		nodes.add(root);
		if(root.right!=null){
			searchNode(root.right,nodes);
		}
	}

	@Override
	public void put(K key, V value) {
		
	}
	
	public Node<K,V> rotateLeft(Node<K,V> h){
		Node<K,V> x = h.right;
		//旋转调整节点位置
		h.right = x.left;
		x.left  = h;
		//颜色
		x.color = h.color;
		h.color = Node.COLOR_RED;
		return x;
	}
	
	public Node<K,V> rotateRight(Node<K,V> h){
		Node<K,V> x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = Node.COLOR_RED;
		return x;
	}

	@Override
	public K get(K key) {
		Node<K,V> res = get(root,key);
		return res==null ? null : res.key;
	}

	public Node<K,V> get(Node<K,V> root,K key){
		if(root==null){
			return null;
		}
		int com = root.key.compareTo(key);
		if(com<0){
			return get(root.left,key);
		}else if(com>0){
			return get(root.right,key);
		}
		return root;
	}
	
	@Override
	public int size() {
		return root == null ? 0 : root.getSize();
	}

	@Override
	public void delete(K key) {
		
	}

	@Override
	public K min() {
		return null;
	}

	@Override
	public K max() {
		return null;
	}

	@Override
	public int depth() {
		return 0;
	}

}
