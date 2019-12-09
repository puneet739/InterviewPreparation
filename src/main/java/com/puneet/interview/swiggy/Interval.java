package com.puneet.interview.swiggy;

public class Interval implements Comparable<Interval> {
	private int start;
	private int end;
	
	public Interval() {
		super();
	}

	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + start + "-" + end + "]";
	}

	public int compareTo(Interval o) {
		return this.getStart() - o.getStart();
	}
	
	public boolean isOverlapped(Interval i){
		return ((i.getStart() >= this.getStart() && i.getStart() <= this.getEnd()) ||
				(this.getEnd() >= i.getStart() && this.getEnd() <= i.getEnd()));
	}

	public boolean isDayOverlapped(int day) {
		return (day >= this.start && day <= this.end);
	}
	
}
