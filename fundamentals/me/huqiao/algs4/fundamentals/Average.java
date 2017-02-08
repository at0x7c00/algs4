package me.huqiao.algs4.fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import me.huqiao.algs4.stdlib.StdIn;
import me.huqiao.algs4.stdlib.StdOut;

/**
 * 求平均值
 */
public class Average {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./bin/a.txt"));
		int count = 0;
		double sum = 0d;
		while(!StdIn.isEmpty()){
			sum += StdIn.readDouble();
			count++;
		}
		StdOut.println("Average is " + (sum/count));
	}
}
