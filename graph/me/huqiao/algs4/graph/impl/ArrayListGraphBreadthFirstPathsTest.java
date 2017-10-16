package me.huqiao.algs4.graph.impl;

public class ArrayListGraphBreadthFirstPathsTest {

	public static void main(String[] args) throws Exception {
		ArrayListGraph g = new ArrayListGraph(PathsTest.class.getResourceAsStream("/tinyCG.txt"));
		
		System.out.println(g);
		int s = 0;
		ArrayListGraphBreadthFirstPaths path = new ArrayListGraphBreadthFirstPaths(g, s);
		for(int v = 0;v<g.V();v++){
			System.out.print(s + " to " + v+":");
			if(path.hasPathTo(v)){
				for(String p : path.pathTo(v)){
					System.out.print(p +"\t");
				}
			}
			System.out.println();
		}
	}
}
