package me.huqiao.algs4.graph.impl;

import me.huqiao.algs4.graph.ConnectedComponents;
import me.huqiao.algs4.graph.Graph;

/**
 * 计算连通分量
 * @author huqiao
 */
public class ArrayListGraphCC extends ConnectedComponents{
	
	int[] id;
	boolean[] marked;
	int count;

	public ArrayListGraphCC(Graph g) {
		super(g);
		id = new int[g.V()];
		marked = new boolean[g.V()];
		for(int i = 0;i<g.V();i++){
			if(!marked[i]){
				dfs(g,i);
				count++;
			}
		}
	}

	private void dfs(Graph g,int w){
		marked[w] = true;
		id[w] = count;
		for(int v:g.adj(w)){
			if(!marked[v]){
				dfs(g,v);
			}
		}
	}
	
	@Override
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int id(int v) {
		return id[v];
	}

}
