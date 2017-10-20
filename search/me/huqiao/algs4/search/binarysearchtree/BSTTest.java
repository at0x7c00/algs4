package me.huqiao.algs4.search.binarysearchtree;

import java.util.Random;

public class BSTTest {

	public static void main(String[] args) {
		BST<Integer,Integer> bst = new BST<Integer,Integer>();
		int last = 0;
		for(int i = 0;i<10;i++){
			int r = new Random().nextInt(100);
			System.out.print(r + "\t");
			bst.put(r, r);
			last = i;
		}
		//System.out.println("last=" + last);
		//bst.deleteMin();
		
		bst.print();
		bst.delete(last);
		//bst.print();
		//System.out.println(bst.size());
		//System.out.println("depth = " + bst.depth());
		
	}
	
}
