package threads;

import javafx.application.Platform;
import model.Clock;
import model.Coliseum;
import ui.MenuGUI;

public class ClockThread extends Thread{
	private MenuGUI menu;
	private Coliseum coliseum;
	private String time = "";
	
	public ClockThread(MenuGUI m,Coliseum c) {
		menu = m;
		coliseum = c;
	}
	
	@Override
	public void run() {
		coliseum.initClock();
		while(menu.isNotFinished()) {
			time = coliseum.runClock();
			
			Platform.runLater(new Thread() {
				
				@Override
				public void run() {
					menu.setChronometer(time);
				}
				
			});
			
			try {
				Thread.sleep(0, 990);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
