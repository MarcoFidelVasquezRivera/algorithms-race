package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColiseumTest {
	
	private Coliseum c;

	public void setup1() {
		c = new Coliseum();
	}
	
	@Test
	public void lookTest() {
		setup1();
		
		long[] array = {7,5,9,2,6,8,12,3,10};
		
		for(int i=0;i<array.length;i++) {
			c.addBSTRecursive(array[i]);
		}
		c.showBST();
		System.out.println(c.deleteBSTIterative(100));
		System.out.println("n");
		c.showBST();
		//System.out.println(c.deleteBSTIterative(8));
		//System.out.println("n");
		//c.showBST();


	}
	
}
