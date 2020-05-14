package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import model.Coliseum;
import threads.ArrayListThread;
import threads.BSTThread;
import threads.CircleThread;
import threads.ClockThread;
import threads.InitializerThread;
import threads.LinkedListThread;

public class MenuGUI {

	@FXML
	private TextField nNumbers;

	@FXML
	private ToggleGroup algorithm;

	@FXML
	private ToggleGroup mode;

	@FXML
	private Label timeKeeper;

	@FXML
	private Circle ball0;

	@FXML
	private Circle ball1;

	@FXML
	private Label arrayTIme;

	@FXML
	private Label listTime;

	@FXML
	private Label treeTime;
	
	private Coliseum coliseum;

	public MenuGUI() {
		coliseum = new Coliseum();
	}
	
	public void initialize() {
		coliseum.addCircle(ball0.getRadius());
		coliseum.addCircle(ball1.getRadius());

	}
	
	@FXML
	void run(ActionEvent event) {
		try {
			if(mode.getSelectedToggle()!=null && algorithm.getSelectedToggle()!=null && !nNumbers.getText().isEmpty()) {
				coliseum.reset();
				resetTimes();
				int numbers = Integer.parseInt(nNumbers.getText());
				long seed = System.currentTimeMillis();
				String modeSelected = ((RadioButton)mode.getSelectedToggle()).getText();
				String algorithmSelected = ((RadioButton)algorithm.getSelectedToggle()).getText();
				
				
				if(modeSelected.equalsIgnoreCase("Recursive")) {
					if(algorithmSelected.equalsIgnoreCase("add")) {
						initAddRecursive(seed,numbers);
						
					}else if(algorithmSelected.equalsIgnoreCase("search")) {
						InitializerThread it = new InitializerThread(this, coliseum, numbers, 1);
						it.start();
						starting();
					}else {
						InitializerThread it = new InitializerThread(this, coliseum, numbers, 3);
						it.start();
						starting();
					}
					
				}else {
					if(algorithmSelected.equalsIgnoreCase("add")) {
						initAddIterative(seed, numbers);
					}else if(algorithmSelected.equalsIgnoreCase("search")) {
						InitializerThread it = new InitializerThread(this, coliseum, numbers, 0);
						it.start();
						starting();
					}else {
						InitializerThread it = new InitializerThread(this, coliseum, numbers, 2);
						it.start();
						starting();
					}
					
				}	
				

				
			}else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Alert");
				alert.setContentText("algunos campos estan vacios");
				alert.showAndWait();
			}
		}catch(NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Alert");
			alert.setContentText("por favor, ingrese un numero valido en N");
			alert.showAndWait();
		}
		
	}
	
	public void setChronometer(String time) {
		timeKeeper.setText(time);
	}
	
	public boolean isNotFinished() {
		if(arrayTIme.getText().isEmpty() || treeTime.getText().isEmpty() || listTime.getText().isEmpty()) {
			return true;
		}else {
			return false;
		}  
	}
	
	public void setArrayListTime() {
		arrayTIme.setText(timeKeeper.getText());
	}
	
	public void setLinkedListTime() {
		listTime.setText(timeKeeper.getText());
	}
	
	public void setBSTTime() {
		treeTime.setText(timeKeeper.getText());
	}
	
	public void lostRace(int structure) {
		switch(structure) {
			case 0:
				arrayTIme.setText("perdio");
				break;
			case 1:
				listTime.setText("perdio");
				break;
			case 2:
				treeTime.setText("perdio");
				break;
		
		}
		
	}
	
	public void initAddRecursive(long seed, int numbers) {
		resetTimes();
		CircleThread circleThread = new CircleThread(this,coliseum);
		circleThread.start();
		ClockThread ct = new ClockThread(this,coliseum);
		ArrayListThread alt = new ArrayListThread(seed, this, coliseum, numbers, 0);
		LinkedListThread llt = new LinkedListThread(seed, this, coliseum, numbers, 1);
		BSTThread bstt = new BSTThread(seed, this, coliseum, numbers, 1);
		ct.start();
		alt.start();
		llt.start();
		bstt.start();
	}
	
	public void initAddIterative(long seed, int numbers) {
		resetTimes();
		CircleThread circleThread = new CircleThread(this,coliseum);
		circleThread.start();
		ClockThread ct = new ClockThread(this,coliseum);
		ArrayListThread alt = new ArrayListThread(seed, this, coliseum, numbers, 0);
		LinkedListThread llt = new LinkedListThread(seed, this, coliseum, numbers, 0);
		BSTThread bstt = new BSTThread(seed, this, coliseum, numbers, 0);
		ct.start();
		alt.start();
		llt.start();
		bstt.start();
	}
	
	public void initSearchRecursive(long seed, int numbers) {
		resetTimes();
		CircleThread circleThread = new CircleThread(this,coliseum);
		circleThread.start();
		ClockThread ct = new ClockThread(this,coliseum);
		ArrayListThread alt = new ArrayListThread(seed, this, coliseum, numbers, 3);
		LinkedListThread llt = new LinkedListThread(seed, this, coliseum, numbers, 3);
		BSTThread bstt = new BSTThread(seed, this, coliseum, numbers, 3);
		ct.start();
		alt.start();
		llt.start();
		bstt.start();
	}
	
	public void initSearchIterative(long seed, int numbers) {
		resetTimes();
		CircleThread circleThread = new CircleThread(this,coliseum);
		circleThread.start();
		ClockThread ct = new ClockThread(this,coliseum);
		ArrayListThread alt = new ArrayListThread(seed, this, coliseum, numbers, 1);
		LinkedListThread llt = new LinkedListThread(seed, this, coliseum, numbers, 2);
		BSTThread bstt = new BSTThread(seed, this, coliseum, numbers, 2);
		ct.start();
		alt.start();
		llt.start();
		bstt.start();
		
	}
	////
	public void initDeleteRecursive(long seed, int numbers) {
		resetTimes();
		CircleThread circleThread = new CircleThread(this,coliseum);
		circleThread.start();
		ClockThread ct = new ClockThread(this,coliseum);
		ArrayListThread alt = new ArrayListThread(seed, this, coliseum, numbers, 4);
		LinkedListThread llt = new LinkedListThread(seed, this, coliseum, numbers, 5);
		BSTThread bstt = new BSTThread(seed, this, coliseum, numbers, 5);
		ct.start();
		alt.start();
		llt.start();
		bstt.start();
	}
	
	public void initDeleteIterative(long seed, int numbers) {
		resetTimes();
		CircleThread circleThread = new CircleThread(this,coliseum);
		circleThread.start();
		ClockThread ct = new ClockThread(this,coliseum);
		ArrayListThread alt = new ArrayListThread(seed, this, coliseum, numbers, 2);
		LinkedListThread llt = new LinkedListThread(seed, this, coliseum, numbers, 4);
		BSTThread bstt = new BSTThread(seed, this, coliseum, numbers, 4);
		ct.start();
		alt.start();
		llt.start();
		bstt.start();
	}

	public void resetTimes() {
		arrayTIme.setText("");
		listTime.setText("");
		treeTime.setText("");
		timeKeeper.setText("iniciando");
	}
	
	public void starting() {
		arrayTIme.setText("iniciando");
		listTime.setText("iniciando");
		treeTime.setText("iniciando");
		timeKeeper.setText("iniciando");
	}
	
	public void updateCircles() {
		ball0.setRadius(coliseum.getCircles().get(0).getRadius());
		ball1.setRadius(coliseum.getCircles().get(1).getRadius());
		
	}
}
