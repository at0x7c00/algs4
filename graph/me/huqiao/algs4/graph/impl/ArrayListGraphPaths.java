package me.huqiao.algs4.graph.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import me.huqiao.algs4.graph.Graph;
import me.huqiao.algs4.graph.Paths;

/**
 * 邻接表图的路径寻找
 * @author huqiao
 */
public class ArrayListGraphPaths extends Paths{
	
	private boolean[] marked;
	private Set<String> paths;
	
	public ArrayListGraphPaths(Graph g, int s) {
		super(g, s);
		marked = new boolean[g.V()];
		paths = new HashSet<String>();
		dfs(g,s,"");
		
	}
	
	/**
	 * 执行深度优先搜索
	 * @param g
	 * @param v
	 */
	private void dfs(Graph g, int v,String basePath) {
		marked[v] = true;
		if(basePath.contains(v + "")){
			return;
		}
		basePath += v + "-";
		paths.add(basePath);
		for(int w : g.adj(v)){
			//if(!marked[w]){
				dfs(g,w,basePath);
			//}
		}
	}

	@Override
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	@Override
	public Iterable<String> pathTo(int v) {
		Set<String> res = new HashSet<String>();
		String node = v + "";
		for(String path : paths){
			//System.out.println(">"+path);
			int i = path.indexOf(node); 
			if(i>=0){
				path = path.substring(0,i+1);
				res.add(path);
			}
		}
		return res;
	}

}
