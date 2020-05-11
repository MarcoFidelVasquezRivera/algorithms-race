package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock {

	private long millis;
	private long seconds;
	private long minutes;
	private long initTime;
	
	public Clock() {
		millis = 0;
		seconds = 0;
		minutes = 0;
		
	}
	//cambiar por diferencia entre timpos
	
	public void run() {
		reset();
		millis = System.currentTimeMillis()-initTime;
		//System.out.println(millis);
		
		while(millis>999) {
			millis = millis-1000;
			seconds++;
		}

		while(seconds>59) {
			seconds = seconds-60;
			minutes++;
		}
	}
	
	public void setInitTime() {
		initTime = System.currentTimeMillis();
	}
	
	public void reset() {
		millis = 0;
		seconds = 0;
		minutes = 0;
	}
	
	public String toString() {
		String millis = "";
		String seconds = "";
		String minutes = "";
		
		for(int i=0;i<3-Long.toString(this.millis).length();i++) {
			millis = millis + "0";
		}
		millis = millis+this.millis;
		
		if(this.seconds<10) {
			seconds = "0"+this.seconds;
		}else {
			seconds = ""+this.seconds;
		}
		
		if(this.minutes<10) {
			minutes = "0"+this.minutes;
		}else {
			minutes = ""+this.minutes;
		}
		return (minutes+":"+seconds+":"+millis);
	}
	
	
}
