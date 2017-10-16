package me.huqiao.algs4.graph.impl;


import java.util.ArrayList;
import java.util.List;

import me.huqiao.algs4.fundamentals.util.Queue;
import me.huqiao.algs4.fundamentals.util.impl.queue.ArrayQueue;
import me.huqiao.algs4.graph.Graph;
import me.huqiao.algs4.graph.Paths;

/**
 * 广度优先搜索
 * @author huqiao
 */
public class ArrayListGraphBreadthFirstPaths extends Paths {

	private int count;
	private boolean[] marked;
	private int[] edge;
	
	public ArrayListGraphBreadthFirstPaths(Graph g, int s) {
		super(g, s);
		marked = new boolean[g.V()];
		edge = new int[g.V()];
		bfs(g,s);
	}

	/**
	 * 执行深度优先搜索
	 * @param g
	 * @param v
	 */
	private void bfs(Graph g, int s) {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		marked[s] = true;
		count++;
		queue.enqueue(s);
		while(!queue.isEmpty()){
			int v = queue.dequeue();
			for(int w : g.adj(v)){
				if(!marked[w]) {
					marked[w]  = true;
					edge[w] = v;
					queue.enqueue(w);
				}
			}
		}
	}

	@Override
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	@Override
	public Iterable<String> pathTo(int v) {
		List<String> paths = new ArrayList<String>();
		if(!hasPathTo(v)){
			return paths;
		}
		String p = "";
		int x = v;
		while(x != s){
			p += "-" + x;
			x = edge[x];
		}
		p = s + p;
		paths.add(p);
		return paths;
	}

}
