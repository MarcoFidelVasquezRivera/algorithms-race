package model;

public class NumberBST {

	private NumberBST parent = null;
	private NumberBST left = null;
	private NumberBST right = null;
	private long number;
	
	public NumberBST(long n) {
		number = n;
	}
	
	public NumberBST getparent() {
		return parent;
	}
	
	public NumberBST getLeft() {
		return left;
	}
	
	public NumberBST getRight() {
		return right;
	}
	
	public long getNumber() {
		return number;
	}
	
	public void setParent(NumberBST p) {
		parent = p;
	}
	
	public void setLeft(NumberBST l) {
		left = l;
	}
	
	public void setRight(NumberBST r) {
		right = r;
	}
	
}
