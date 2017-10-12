package me.huqiao.algs4.graph;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class Graph {
	
	protected int V;
	protected int E;
	
	public Graph(int V){
		this.V = V;
	}
	
	public abstract void init();
	public Graph(InputStream in)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
		V = Integer.parseInt(br.readLine());
		init();
		br.readLine();
		String line = br.readLine();
		while(line!=null){
			String[] wv = line.split(" ");
			int v = Integer.parseInt(wv[0]);
			int w = Integer.parseInt(wv[1]);
			addEdge(v, w);
			line = br.readLine();
		}
		br.close();
	}
	
	abstract public int V();
	abstract public int E();
	abstract public void addEdge(int v,int w);
	
	/**
	 * 和v相邻的所有顶点
	 * @param v
	 * @return
	 */
	abstract public Iterable<Integer> adj(int v);
	
	public String toString(){
		String str = V() + " verties," + E() + " edges\n";
		for(int v = 0;v<V();v++){
			str += v + ":";
			for(int w : adj(v)){
				str += w + " ";
			}
			str += "\n";
		}
		return str;
	}
}
