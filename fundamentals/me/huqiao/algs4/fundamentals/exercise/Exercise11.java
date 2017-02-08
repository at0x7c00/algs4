package me.huqiao.algs4.fundamentals.exercise;

import me.huqiao.algs4.stdlib.StdDraw;
import me.huqiao.algs4.stdlib.StdRandom;

public class Exercise11 {

	public static void main(String[] args) throws InterruptedException {
		//lg(16);
		/*for(int i :histogram(new int[]{1,1,1,2,2,0,},5)){
			System.out.println(i);
		}*/
		//System.out.println(gcd(105,24));
		
		/*for(boolean a[] : boolArray(60)){
			for(boolean b:a){
				System.out.print((b? "*":"-") +"\t");
			}
			System.out.println();
		}*/
		
		/*int i = 0;
		while(i<10){
			StdDraw.clear(StdDraw.WHITE);
			rate(200,1);
			Thread.sleep(500);
			i++;
		}*/
		
		bouncingBall();
	}
	
	/**
	 * exercise 1.1.14
	 * 返回不大于log2n的最大整数,不要使用Math库
	 */
	public static void lg(int N) {
		int n = 2;
		int x = n*n;
		int j = 2;
		while(x<=N){
			x *= n;
			j++;
		}
		j--;
		System.out.println("max integer  not bigger than log2^" +N+" is " + j);
	}
	
	/**
	 * exercise 1.1.15
	 * @param a
	 * @param M
	 * @return 返回length为M的数组x，x[i]的值为i在数组a中出现的次数
	 */
	public static int[] histogram(int a[],int M){
		int[] res = new int[M];
		for(int i = 0;i<M;i++){
			int value = 0;
			for(int j = 0;j<a.length;j++){
				if(a[j]==i){
					value++;
				}
			}
			res[i] = value;
		}
		return res;
	}
	
	/**
	 * exercise 1.1.24 
	 * @param a
	 * @param b
	 * @return a和b的最大公约数
	 */
	public static int gcd(int a,int b){
		System.out.println(a + "," + b);
		if(a==0 || b==0 || a%b==0){
			return b;
		}
		return gcd(b,a % b);
	}
	
	/**
	 * exercise 1.1.30 
	 * @param N
	 * @return 返回NxN的二维数组a,a[i][j]仅当i和j互为质数时为真
	 */
	public static boolean[][] boolArray(int N){
		boolean a[][] = new boolean[N][N];
		for(int i = 0;i<N;i++){
			for(int j = 0;j<N;j++){
				a[i][j] = gcd(i,j)==1;
			}
		}
		return a;
	}
	
	public static void rate(int N,double p){
		
		//StdDraw.circle(0.5, 0.5, 0.5);
		
		double x = 0;
		double y = 0;
		for(int i = 0;i<N;i++){
			double x1 = StdRandom.uniform();
			double y1 = StdRandom.uniform();
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledCircle(x1, y1, 0.01);
			double w = StdRandom.uniform();
			if(w<=p && i>0){
				StdDraw.setPenColor(StdDraw.GRAY);
				StdDraw.line(x, y, x1, y1);
			}
			x = x1;
			y = y1;
		}
		
	}
	
	/**
	 * 滚动的球
	 * @throws InterruptedException 
	 */
	public static void bouncingBall() throws InterruptedException{
		double x = StdRandom.uniform();
		double y = StdRandom.uniform();
		
		boolean incressX = x<1;
		boolean incressY = y<1;
		
		double r = 0.05;
		
		double moveIncrement = 0.01;
		double max = 1 - r;
		double min = r;
		
		int speed = 50;
		
		while(true){
			StdDraw.clear();
			StdDraw.filledCircle(x, y,r);
			if(incressX){
				x += moveIncrement;
			}else{
				x -= moveIncrement ;
			}
			if(incressY){
				y += moveIncrement;
			}else{
				y -= moveIncrement;
			}
			if(x >= max || x <= min){
				incressX = !incressX;
			}
			if(y >= max|| y <= min){
				incressY = !incressY;
			}
			StdDraw.pause(1000/speed);
		}
		
	}
	
}
