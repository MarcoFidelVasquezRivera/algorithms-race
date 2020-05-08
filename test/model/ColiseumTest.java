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
		
		long[] array = {2,5,1,34,5,2,5,235,3};
		
		for(int i=0;i<array.length;i++) {
			c.addBSTRecursive(array[i]);
		}
		System.out.println(c.searchBSTRecursive(235));
	}
	
}
