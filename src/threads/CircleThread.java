package threads;

import javafx.application.Platform;
import model.Coliseum;
import ui.MenuGUI;

public class CircleThread extends Thread{

	private MenuGUI menu;
	private Coliseum coliseum;
	
	
	public CircleThread(MenuGUI m, Coliseum c) {
		menu = m;
		coliseum = c;
	}
	
	
	@Override
	public void run() {
		while(menu.isNotFinished()) {
			
			coliseum.calculateCirclesRadius();
			
			Platform.runLater(new Thread() {
				
				@Override
				public void run() {
					menu.updateCircles();
				}
				
			});
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
