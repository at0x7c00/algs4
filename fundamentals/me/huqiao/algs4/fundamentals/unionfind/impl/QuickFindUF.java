package me.huqiao.algs4.fundamentals.unionfind.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import me.huqiao.algs4.fundamentals.unionfind.UF;
import me.huqiao.algs4.fundamentals.util.StopWatch;
import me.huqiao.algs4.stdlib.StdIn;
import me.huqiao.algs4.stdlib.StdOut;

public class QuickFindUF extends AbstractUF implements UF {

	public QuickFindUF(int N) {
		super(N);
	}

	@Override
	public int find(int p) {
		return d[p];
	}

	@Override
	public void union(int p, int q) {
		int pId = d[p];  
		int qId = d[q];
		if(pId == qId){
			return;
		}
		//change all node with qId to pId
		for(int i = 0;i<d.length;i++){
			if(d[i] == qId){
				d[i] = pId;
			}
		}
		count--;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./data/tinyUF.txt"));
		StopWatch w = new StopWatch();
		int n = StdIn.readInt();
		StdOut.println(n);
        QuickFindUF uf = new QuickFindUF(n);
		
       // StdOut.print("Init:");
        //for(int i : uf.d){
			//StdOut.print(i + "\t");
		//}
        //StdOut.println("\r\n-----------------------------------------------------------------------------");
		while(!StdIn.isEmpty()){ 
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(!uf.isconnected(p, q)){
				uf.union(p, q);
				//StdOut.print(p + "->" + q+":");
				
				//for(int i : uf.d){
					//StdOut.print(i + "\t");
				//}
				//StdOut.println();
			}
		}
		//StdOut.println("-----------------------------------------------------------------------------");
		//for(int i : uf.d){
			//StdOut.print(i + "\t");
		//}
		System.out.println("time:" + w.stop() + "ms");
		StdOut.println("\r\nResult:" + uf.count);
	}

}
