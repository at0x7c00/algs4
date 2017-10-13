package me.huqiao.algs4.graph;

/**
 * 寻找路径
 * @author huqiao
 */
public abstract class Paths {

	protected Graph g;
	protected int s;
	
	public Paths(Graph g,int s){
		this.g = g;
		this.s = s;
	}
	
	/**
	 * 是否存在连到v的路径
	 * @param v
	 * @return
	 */
	public abstract boolean hasPathTo(int v);
	/**
	 * 找出连通到v的路径
	 * @param v
	 * @return
	 */
	public abstract Iterable<String> pathTo(int v); 
	
}
