package me.huqiao.algs4.graph;

public class GraphUtil {
	
	/**
	 * 计算顶点v的度数
	 * @param g
	 * @param v
	 * @return
	 */
	public static int degree(Graph g,int v){
		int degree = 0;
		for(int w : g.adj(v)) degree++;
		return degree;
	}
	
	/**
	 * 计算所有顶点最大的度数
	 * @param g
	 * @return
	 */
	public static int maxDegree(Graph g){
		int max = 0;
		int v = 0;
		for(;v<g.V();v++){
			int vDegree = degree(g,v);
			if(vDegree>max){
				max = vDegree;
			}
		}
		return max;
	}
	
	/**
	 * 顶点平均度数
	 * @param g
	 * @return
	 */
	public static int avgDegree(Graph g){
		return 2 * g.E() / g.V();
	}
	
	/**
	 * 自环数量
	 * @param g
	 * @return
	 */
	public static int numberOfSelfLoops(Graph g){
		int count = 0;
		for(int v = 0;v<g.V();v++){
			for(int w : g.adj(v)){
				if(w == v) count++;
			}
		}
		return count / 2;
	}

}
