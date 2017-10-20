package me.huqiao.algs4.graph.symbolgraph;

public class SymbolGraphTest {

	public static void main(String[] args) throws Exception{
		SymbolGraph graph = new SymbolGraph("/movies.txt","/");
		for(int i = 0;i<graph.G().V();i++){
			System.out.println(graph.name(i));
			for(int w : graph.G().adj(i)){
				System.out.println("    "+graph.name(w));
			}
		}
	}
}
