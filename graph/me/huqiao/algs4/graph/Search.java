package me.huqiao.algs4.graph;

public abstract class Search {
	
	protected Graph g;
	protected int s;

	/**
	 * 找到与s点连通的所有顶点
	 * @param g
	 * @param s
	 */
	public Search(Graph g,int s){
		this.g = g;
		this.s = s;
	}
	
	/**
	 * 判断v点是否与s点连通
	 * @param v
	 * @return
	 */
	public abstract boolean marked(int v);
	
	/**
	 * 与s连通的所有顶点数
	 * @return
	 */
	public abstract int count();
	
}
