package model;

public class Circle {
	
	public final static double MIN_RADIUS = 7;
	public final static double MAX_RADIUS = 31;
	public final static double STEP = 1;
	private double radius;
	private boolean increase;
	
	public Circle(double r) {
		radius = r;
	}
	
	public void calculateNewRadius() {
		if(increase) {
			radius+=STEP;
			if(radius>=MAX_RADIUS) {
				increase = false;
			}
			
		}else {
			radius-=STEP;
			if(radius<=MIN_RADIUS) {
				increase = true;
			}
		}
	}
	
	public void setIncrease(boolean i) {
		increase = i;
	}
	
	public double getRadius() {
		return radius;
	}
	
}
