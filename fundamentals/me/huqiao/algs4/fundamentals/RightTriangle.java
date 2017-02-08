package me.huqiao.algs4.fundamentals;

import me.huqiao.algs4.stdlib.StdDraw;
import me.huqiao.algs4.stdlib.StdOut;
import me.huqiao.algs4.stdlib.StdRandom;

/**
 * ªÊ÷∆Õº–Œ
 */
public class RightTriangle { 

    public static void main(String[] args) {
    	//line();
    	//block();
    }
    


	private static void block() {
		int N = 3;
		for(int i = 1;i<N;i++){
			double r = StdRandom.random();
			double x = 1.0*i/N;
			double y = r/2.0;
			double w = .5/N;
			double h = r/2.0;
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle(x, y, w, h);
			StdDraw.text(x+0.02, r+0.02, (r+"").substring(0,4));
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(x, y, "("+format(x)+","+format(y)+")");
		}
	}

	private static String format(double d){
		String res = d + "";
		if(res.length()>4){
			return res.substring(0,4);
		}
		return res;
	}
	
	private static void line() {
	   int N = 100;
       StdDraw.setXscale(0,N);
       StdDraw.setYscale(0,N*N);
       StdDraw.setPenRadius(.01);
        
       for(int i = 1;i<=N;i++){
    	   StdDraw.point(i, i);
    	   StdDraw.setPenColor(StdDraw.BLUE);
    	   StdDraw.point(i, i*i);
    	   StdDraw.setPenColor(StdDraw.RED);
    	   StdDraw.point(i, i*Math.log(i));
       }		
	}
}