package threads;

import java.util.Random;
import javafx.application.Platform;
import model.Coliseum;
import ui.MenuGUI;

public class ArrayListThread extends Thread{
	
	private MenuGUI menu;
	private Random random;
	private Coliseum coliseum;
	private int nNumbers;
	private int operation;
	
	public ArrayListThread(long seed,MenuGUI m,Coliseum c,int n,int o) {
		random = new Random(seed);
		menu = m;
		nNumbers = n;
		coliseum = c;
		operation = o;
	}
	
	@Override
	public void run() {
		try {
			switch(operation) {
				case 0:
					for(int i=0;i<nNumbers;i++) {
						coliseum.addArrayList(random.nextLong());
					}
					break;
				case 1:
					for(int i=0;i<nNumbers;i++) {
						coliseum.searchArrayListIterative(random.nextLong());
					}
					break;
				case 2:
					for(int i=0;i<nNumbers;i++) {
						coliseum.deleteArrayListIterative(random.nextLong());
					}
					break;
				case 3:
					for(int i=0;i<nNumbers;i++) {
						coliseum.searchArrayListRecursive(0, random.nextLong());
					}
					break;
				case 4:
					for(int i=0;i<nNumbers;i++) {
						coliseum.deleteArrayListRecursive(random.nextLong());
					}
					break;
			}

			Platform.runLater(new Thread() {

				@Override
				public void run() {
					menu.setArrayListTime();
				}
			});
		} catch (StackOverflowError e) {
			Platform.runLater(new Thread() {

				@Override
				public void run() {
					menu.lostRace(0);
				}

			});
		}
		
	}
	
}
