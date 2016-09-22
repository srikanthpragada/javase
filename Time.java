
public class Time implements Comparable<Time> {
	private int h, m, s;

	public Time(int h, int m, int s) { 
		super();
		this.h = h;
		this.m = m;
		this.s = s;
	}
	public int totalSeconds() {
		return  h * 3600 + m * 60 + s;
	}
	public int hashCode(){
		return 1;
	}
	@Override
	public boolean equals(Object other) {
		System.out.println("Equals");
		Time t2 = (Time) other;
		return  this.totalSeconds() == t2.totalSeconds();
	}

	@Override
	public String toString() {
		return "Time [h=" + h + ", m=" + m + ", s=" + s + "]";
	}
	@Override
	//  0, 
	public int compareTo(Time other) {
	   return  this.totalSeconds() - other.totalSeconds();
	}

}


Testing
========

import java.util.TreeSet;
public class HashDemo {
	public static void main(String[] args) {
		 TreeSet<Time> times = new TreeSet<>();
		 times.add( new Time(13,20,30));
		 times.add( new Time(1,20,30));
		 times.add( new Time(7,20,30));
		 times.add( new Time(10,20,30));
	     for(Time t : times) {
	    	 System.out.println(t);
	     }
	}

}













