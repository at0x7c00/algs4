package me.huqiao.algs4.fundamentals.util;

public class StopWatch {

	long t;
	public StopWatch(){
		t = System.currentTimeMillis();
	}
	
	public long stop(){
		t = System.currentTimeMillis() - t;
		return t;
	}
}
