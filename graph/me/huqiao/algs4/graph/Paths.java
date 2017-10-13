package me.huqiao.algs4.graph;

/**
 * Ѱ��·��
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
	 * �Ƿ��������v��·��
	 * @param v
	 * @return
	 */
	public abstract boolean hasPathTo(int v);
	/**
	 * �ҳ���ͨ��v��·��
	 * @param v
	 * @return
	 */
	public abstract Iterable<String> pathTo(int v); 
	
}
