package threads;

import java.util.Random;

import javafx.application.Platform;
import model.Coliseum;
import ui.MenuGUI;

public class LinkedListThread extends Thread{

	private MenuGUI menu;
	private Random random;
	private Coliseum coliseum;
	private int nNumbers;
	private int operation;
	
	public LinkedListThread(long seed,MenuGUI m,Coliseum c,int n,int o) {
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
						coliseum.addLinkedListIterative(random.nextLong());
					}
					break;
				case 1:
					for(int i=0;i<nNumbers;i++) {
						coliseum.addLinkedListRecursive(random.nextLong());
					}
					break;
				case 2:
					for(int i=0;i<nNumbers;i++) {
						coliseum.searchLinkedListIterative(random.nextLong());
					}
					break;
				case 3:
					for(int i=0;i<nNumbers;i++) {
						coliseum.searchLinkedListRecursive(random.nextLong());
					}
					break;
				case 4:
					for(int i=0;i<nNumbers;i++) {
						coliseum.deleteLinkedListIterative(random.nextLong());
					}
					break;
				case 5:
					for(int i=0;i<nNumbers;i++) {
						coliseum.deleteLinkedListRecursive(random.nextLong());
					}
					break;
			}

			Platform.runLater(new Thread() {

				@Override
				public void run() {
					menu.setLinkedListTime();
				}

			});
		}catch(StackOverflowError e) {
			Platform.runLater(new Thread() {

				@Override
				public void run() {
					menu.lostRace(1);
				}

			});
		}

	}
}
