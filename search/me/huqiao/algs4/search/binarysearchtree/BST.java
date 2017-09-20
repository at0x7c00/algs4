package me.huqiao.algs4.search.binarysearchtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import me.huqiao.algs4.search.AbstractST;
import me.huqiao.algs4.search.Node;
import me.huqiao.algs4.search.ST;

public class BST<K extends Comparable<K>,V> extends AbstractST<K,V> implements ST<K,V>{

	private Node<K,V> root = null;
	@Override
	public void put(K key, V value) {
		root = put(root,key,value);
	}
	public Node<K,V> put(Node<K,V> root,K key,V value){
		if(root==null){
			root = new Node<K,V>(key,value);
			return root;
		}
		int com = key.compareTo(root.key);
		if(com<0){
			root.left = put(root.left,key,value);
		}else if(com>0){
			root.right = put(root.right,key,value);
		}else{
			root.value = value;
		}
		return root;
	}
	@Override
	public K get(K key) {
		return null;
	}
	@Override
	public int size() {
		return root == null ? 0 : root.getSize();
	}
	@Override
	public void delete(K key) {
		root = delete(root,key);
	}
	public Node<K,V> delete(Node<K,V> root,K key) {
		if(root==null) return null;
		int com = key.compareTo(root.key);
		if(com<0){
			root.left = delete(root.left,key);
		}else if(com>0){
			root.right = delete(root.right,key);
		}else{//找到了要删除的节点
			//从右子树中找到一个节点作为新节点
			if(root.right==null){
				return null;
			}
			Node<K,V> node = deleteMin(root.right);
			node.left  = root.left;
			return node;
		}
		return root;
	}
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
	public K min() {
		return min(root);
	}
	
	public K min(Node<K,V> root) {
		if(root.left==null) return root.key;
		return min(root.left);
	}
	@Override
	public K max() {
		return null;
	}
	public K max(Node<K,V> root) {
		if(root.right==null) return root.key;
		return min(root.right);
	}
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	
	public Node<K,V> deleteMin(Node<K,V> root){
		if(root.left==null){
			return root.right;
		}
		root.left = deleteMin(root.left);
		return root;
	}
	@Override
	public int depth() {
		return depth(root);
	}
	
	public void print(){
		System.out.println("-----------------------------");
		Map<Integer,String> map = new HashMap<Integer,String>();
		print(root,0,map);
		for(Map.Entry<Integer,String> entry : map.entrySet()){
			System.out.println(entry.getValue());
		}
	}
	
	private void print(Node<K,V> root,int rowIndex,Map<Integer,String> res){
		if(root==null){
			return;
		}
		String row = res.get(rowIndex);
		if(row==null){
			row = "";
		}
		row += root.value + "\t";
		res.put(rowIndex, row);
		print(root.left,rowIndex+1,res);
		print(root.right,rowIndex+1,res);
	}
	
	public int depth(Node<K,V> root) {
		if(root==null){
			return 0;
		}
		int leftSum = 1;
		int rightSum = 1;
		if(root.left!=null){
			leftSum += depth(root.left);
		}
		if(root.right!=null){
			rightSum += depth(root.right);
		}
		int res = leftSum>rightSum ? leftSum:rightSum;
		return res;
	}
	
}
