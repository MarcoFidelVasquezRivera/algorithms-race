package threads;

import java.util.Random;

import javafx.application.Platform;
import model.Coliseum;
import ui.MenuGUI;

public class BSTThread extends Thread{

	private MenuGUI menu;
	private Random random;
	private Coliseum coliseum;
	private int nNumbers;
	private int operation;
	
	public BSTThread(long seed,MenuGUI m,Coliseum c,int n,int o) {
		random = new Random(seed);
		menu = m;
		nNumbers = n;
		coliseum = c;
		operation = o;
		
	}
	
	@Override
	public void run() {
		
		switch(operation) {
			case 0:
				for(int i=0;i<nNumbers;i++) {
					coliseum.addBSTIterative(random.nextLong());
				}
				break;
			case 1:
				for(int i=0;i<nNumbers;i++) {
					coliseum.addBSTRecursive(random.nextLong());
				}
				break;
			case 2:
				for(int i=0;i<nNumbers;i++) {
					coliseum.searchBSTIterative(random.nextLong());
				}
				break;
			case 3:
				for(int i=0;i<nNumbers;i++) {
					coliseum.searchBSTRecursive(random.nextLong());
				}
				break;
			case 4:
				for(int i=0;i<nNumbers;i++) {
					coliseum.deleteBSTIterative(random.nextLong());
				}
				break;
			case 5:
				for(int i=0;i<nNumbers;i++) {
					coliseum.deleteBSTRecursive(random.nextLong());
				}
				break;
		}
		
		Platform.runLater(new Thread() {
			
			@Override
			public void run() {
				menu.setBSTTime();
			}
			
		});
		
	}
	
}
