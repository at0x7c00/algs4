package me.huqiao.algs4.graph.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import me.huqiao.algs4.graph.Graph;

public class ArrayListGraph extends Graph {
	
	EdgeRecord[] adj;

	public ArrayListGraph(int V) {
		super(V);
		init();
	}
	
	public ArrayListGraph(InputStream in) throws Exception{
		super(in);
	}

	public void init(){
		adj = new EdgeRecord[V];
		for(int i=0;i<V;i++){
			adj[i] = new EdgeRecord();
		}
		E = 0;
	}
	
	@Override
	public int V() {
		return V;
	}

	@Override
	public int E() {
		return E;
	}

	@Override
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adj[v].vList;
	}
	
	class EdgeRecord{
		public List<Integer> vList;
		public EdgeRecord(){
			vList = new ArrayList<Integer>();
		}
		public void add(Integer w){
			if(!vList.contains(w)){
				vList.add(w);
			}
		}
	}

}
