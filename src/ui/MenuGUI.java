package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import model.Coliseum;
import threads.ArrayListThread;
import threads.ClockThread;

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
	
	
	@FXML
	void run(ActionEvent event) {
		try {
			if(mode.getSelectedToggle()!=null && algorithm.getSelectedToggle()!=null && !nNumbers.getText().isEmpty()) {
				int numbers = Integer.parseInt(nNumbers.getText());
				
				long seed = System.currentTimeMillis();
				
				ArrayListThread at = new ArrayListThread(seed, this, coliseum, numbers, 0);
				
				at.start();
				
				
				
				
				
				
				
				
				
				
				ClockThread ct = new ClockThread(this,coliseum);
				ct.start();
				
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

}
