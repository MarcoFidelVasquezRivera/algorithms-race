package threads;

import javafx.application.Platform;
import model.Coliseum;
import ui.MenuGUI;

public class InitializerThread extends Thread{
	
	private MenuGUI menu;
	private Coliseum coliseum;
	private int nNumbers;
	private int operation;
	private long seed;
	
	public InitializerThread(MenuGUI m,Coliseum c,int n,int o) {
		menu = m;
		coliseum = c;
		nNumbers = n;
		operation = o;
	}
	
	@Override
	public void run() {
		seed = System.currentTimeMillis();
		ArrayListThread alt = new ArrayListThread(seed, menu, coliseum, nNumbers, 0);
		LinkedListThread llt = new LinkedListThread(seed, menu, coliseum, nNumbers, 0);
		BSTThread bstt = new BSTThread(seed, menu, coliseum, nNumbers, 0);
		alt.start();
		llt.start();
		bstt.start();

		try {
			alt.join();
			llt.join();
			bstt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		seed = System.currentTimeMillis();
		Platform.runLater(new Thread() {

			@Override
			public void run() {
				menu.resetTimes();
				switch(operation) {
				case 0:
					menu.initSearchIterative(seed, nNumbers);
					break;
				case 1:
					menu.initSearchRecursive(seed, nNumbers);
					break;
				case 2:
					menu.initDeleteIterative(seed, nNumbers);
					break;
				case 3:
					menu.initDeleteRecursive(seed, nNumbers);
					break;
				}
			}	
		});
		

	}
	
	
	
}
