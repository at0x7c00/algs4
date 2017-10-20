package me.huqiao.algs4.graph;

public abstract class ConnectedComponents {
	
	protected Graph g;

	/**
	 * 找到与s点连通的所有顶点
	 * @param g
	 * @param s
	 */
	public ConnectedComponents(Graph g){
		this.g = g;
	}
	
	/**
	 * 判断v与w是否连通
	 * @param v
	 * @param w
	 * @return
	 */
	public abstract boolean connected(int v,int w);
	/**
	 * 连通分量数量
	 * @return
	 */
	public abstract int count();
	/**
	 * v所在分量的id
	 * @param v
	 * @return
	 */
	public abstract int id(int v);

}
