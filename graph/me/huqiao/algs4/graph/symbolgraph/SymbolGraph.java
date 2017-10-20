package me.huqiao.algs4.graph.symbolgraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import me.huqiao.algs4.graph.Graph;
import me.huqiao.algs4.graph.impl.ArrayListGraph;


/**
 * ·ûºÅÍ¼
 */
public class SymbolGraph {

	private Map<String,Integer> st;
	private Graph graph = null;
	private String[] keys;
	
	public SymbolGraph(String filename,String delim)throws Exception{
		st = new HashMap<String,Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(SymbolGraph.class.getResourceAsStream(filename),"UTF-8"));
		String line = br.readLine();
		int index = 0;
		while(line!=null){
			String[] keys = line.split(delim);
			for(String key : keys){
				st.put(key,index++);
			}
			line = br.readLine();
		}
		
		br.close();
		br = new BufferedReader(new InputStreamReader(SymbolGraph.class.getResourceAsStream(filename),"UTF-8"));
		
		keys = new String[index];
		for(String key : st.keySet()){
			keys[st.get(key)] = key;
		}
		
		graph = new ArrayListGraph(index);
		
		line = br.readLine();
		while(line!=null){
			String[] keys = line.split(delim);
			int v = st.get(keys[0]);
			for(int i = 1;i<keys.length;i++){
				int w = st.get(keys[i]);
				graph.addEdge(v, w);
			}
			line = br.readLine();
		}
		
		br.close();
	}
	
	public boolean contains(String key){
		return st.containsKey(key);
	}
	
	public int index(String key){
		return st.get(key);
	}
	
	public String name(int index){
		return keys[index];
	}
	
	public Graph G(){
		return graph;
	}
	
}
