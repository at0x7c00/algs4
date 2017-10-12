package me.huqiao.algs4.graph;

public abstract class Search {
	
	protected Graph g;
	protected int s;

	/**
	 * �ҵ���s����ͨ�����ж���
	 * @param g
	 * @param s
	 */
	public Search(Graph g,int s){
		this.g = g;
		this.s = s;
	}
	
	/**
	 * �ж�v���Ƿ���s����ͨ
	 * @param v
	 * @return
	 */
	public abstract boolean marked(int v);
	
	/**
	 * ��s��ͨ�����ж�����
	 * @return
	 */
	public abstract int count();
	
}
