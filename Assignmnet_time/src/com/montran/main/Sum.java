package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Time;

public class Sum {

	
	
public static void main(String[] args)
{
	
	Time T1 = new Time();
	T1.settime(1,30,3);
	
	Time T2 = new Time();
	T2.settime(1,35,4);
	
	Time t3= new Time();
	t3=T1.sum(T2);
	
	System.out.println("1st time");
	T1.showtime();
	System.out.println("2st time");
	T2.showtime();
	System.out.println("add");
	t3.showtime();
	
	}
}