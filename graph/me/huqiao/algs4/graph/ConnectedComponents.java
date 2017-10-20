package me.huqiao.algs4.graph;

public abstract class ConnectedComponents {
	
	protected Graph g;

	/**
	 * �ҵ���s����ͨ�����ж���
	 * @param g
	 * @param s
	 */
	public ConnectedComponents(Graph g){
		this.g = g;
	}
	
	/**
	 * �ж�v��w�Ƿ���ͨ
	 * @param v
	 * @param w
	 * @return
	 */
	public abstract boolean connected(int v,int w);
	/**
	 * ��ͨ��������
	 * @return
	 */
	public abstract int count();
	/**
	 * v���ڷ�����id
	 * @param v
	 * @return
	 */
	public abstract int id(int v);

}
