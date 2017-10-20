package me.huqiao.algs4.graph.impl;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponentsTest {

	public static void main(String[] args) throws Exception {
		ArrayListGraph g = new ArrayListGraph(ConnectedComponentsTest.class.getResourceAsStream("/tinyG.txt"));
		
		System.out.println(g);
		ArrayListGraphCC cc = new ArrayListGraphCC(g);
		
		System.out.println(cc.count() + " Connected Components");
		List<List<Integer>> ccRecords = new ArrayList<List<Integer>>();
		for(int i = 0;i<cc.count();i++){
			List<Integer> nodes = new ArrayList<Integer>();
			ccRecords.add(nodes);
		}

		for(int v = 0;v<g.V();v++){
			ccRecords.get(cc.id(v)).add(v);
		}
		
		for(List<Integer> nodes : ccRecords){
			for(Integer node : nodes){
				System.out.print(node+" ");
			}
			System.out.println();
		}
		
	}
	
}
