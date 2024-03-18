package vn.maize.TimeCounter.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vn.maize.TimeCounter.App;
import vn.maize.TimeCounter.utils.TimeCounter;

public class StartController {
	
	public static String timeSpend = null;
	
	@FXML
	private Label lastSpendTime;
	
	@FXML
	private Label timeSpendLabel;

	@FXML
	private void start() throws IOException {
		App.setRoot("time_counter");
		TimeCounter.startCounting();
		App.getStage().setAlwaysOnTop(true);
	}
	
	@FXML
	public void initialize() {
		App.getStage().setWidth(262);
		App.getStage().setHeight(156);
		
		App.getStage().centerOnScreen();
		
		if (timeSpend != null) {
			timeSpendLabel.setText(timeSpend);
			lastSpendTime.setVisible(true);
			timeSpendLabel.setVisible(true);
		} else {
			lastSpendTime.setVisible(false);
			timeSpendLabel.setVisible(false);
		}
	}
	
	@FXML
	private void close() {
		App.getStage().close();
	}
	
}
