package me.huqiao.algs4.fundamentals.unionfind;

public interface UF {

	public int find(int p);
	
	public boolean isconnected(int p,int q);
	
	public int count();
	
	public void union(int p,int q);
	
}
