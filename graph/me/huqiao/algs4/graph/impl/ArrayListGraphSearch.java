package me.huqiao.algs4.graph.impl;

import me.huqiao.algs4.graph.Graph;
import me.huqiao.algs4.graph.Search;

/**
 * 深度优先搜索
 * @author huqiao
 */
public class ArrayListGraphSearch extends Search {

	private int count;
	private boolean[] marked;
	
	public ArrayListGraphSearch(Graph g, int s) {
		super(g, s);
		marked = new boolean[g.V()];
		dfs(g,s);
	}

	/**
	 * 执行深度优先搜索
	 * @param g
	 * @param v
	 */
	private void dfs(Graph g, int v) {
		marked[v] = true;
		count++;
		for(int w : g.adj(v)){
			if(!marked[w]) dfs(g,w);
		}
	}

	@Override
	public boolean marked(int v) {
		return marked[v];
	}

	@Override
	public int count() {
		return count;
	}

}
