package model;

public class Number {

	private Number prev = null;
	private Number next = null;
	private long number;
	
	public Number(long n) {
		number = n;
	}
	
	public Long getNumber() {
		return number;
	}
	
	public Number getPrev() {
		return prev;
	}
	
	public Number getNext() {
		return next;
	}
	
	public void setPrev(Number p) {
		prev = p;
	}
	
	public void setNext(Number n) {
		next = n;
	}
	
}
