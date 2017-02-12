package me.huqiao.algs4.fundamentals.unionfind.impl;

import me.huqiao.algs4.fundamentals.unionfind.UF;

public abstract class AbstractUF implements UF {
	
	protected int[] d;
	protected int count;
	
	public AbstractUF(int N){
		d = new int[N];
		for(int i = 0; i < N; i++){
			d[i] = i;
		}
		count = N;
	}

	@Override
	public abstract int find(int p);

	@Override
	public boolean isconnected(int p, int q) {
		return find(p) == find(q);
	}

	public int count(){
		return count;
	}

	@Override
	public abstract void union(int p, int q);

}
