package me.huqiao.algs4.graph.impl;

import java.io.InputStream;

public class DFSSearchTest {

	public static void main(String[] args)throws Exception {
		InputStream in =  DFSSearchTest.class.getResourceAsStream("/tinyG.txt");
		ArrayListGraph g = new ArrayListGraph(in);
		
		int s = 9;
		System.out.println(g);
		ArrayListGraphSearch search = new ArrayListGraphSearch(g, s);
		
		for(int v = 0;v<g.V();v++){
			if(search.marked(v)){
				System.out.print(v+" ");
			}
		}
		System.out.println();
		if(search.count()!=g.V()){
			System.out.print("NOT ");
		}
		System.out.println(" Connected");
		
		
	}
}
