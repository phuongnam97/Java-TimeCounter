package vn.maize.TimeCounter.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import vn.maize.TimeCounter.App;
import vn.maize.TimeCounter.utils.TimeCounter;

public class CounterPaneController {
	
	private boolean pause = false;
	
	private String currentTimeCount = "00:00:00";
	
	@FXML
	private Label time;
	
	@FXML
	private AnchorPane timePane;
	
//	@FXML
//	private AnchorPane controllerPane;
	
	@FXML
	private AnchorPane groupPane;

	private void returnHome() throws IOException {
		App.setRoot("start");
		App.getStage().setAlwaysOnTop(false);
	}
	
	private void pause() {
		if (pause) {
			TimeCounter.continueCounting(System.currentTimeMillis());
			pause = false;
			timenow();
		} else {
//			time.setText(TimeCounter.getTimeSpend());
			TimeCounter.pause(System.currentTimeMillis());
			pause = true;
		}
	}
	
	@FXML
	public void initialize() {
		timenow();
		Stage stage = App.getStage();
		
//		timePane.hoverProperty().addListener((obs, oldVal, newValue) -> {
//			if (newValue) {
//				controllerPane.setVisible(true);
//			} else {
//				controllerPane.setVisible(false);
//			}
//		});
		timePane.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent mouseEvent) {
				// TODO Auto-generated method stub
				if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
					if(mouseEvent.getClickCount() == 1){
						pause();
		            }
		            if(mouseEvent.getClickCount() == 2){
		                try {
							returnHome();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		        }
			}
			
			
		});
//		controllerPane.hoverProperty().addListener((obs, oldVal, newValue) -> {
//			if (newValue) {
//				controllerPane.setVisible(true);
//			} else {
//				controllerPane.setVisible(false);
//			}
//		});
		
		stage.setWidth(156);
		stage.setHeight(76);
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		double x = bounds.getMaxX() - 156 - 30;
		double y = bounds.getMaxY() - 76 - 20;
		
		stage.setX(x);
		stage.setY(y);
	}
	
	private void timenow() {
		Thread t = new Thread(() -> {
			while (!pause) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Thread Failed");
				}
				String newTimeCount = TimeCounter.countTimeSpend(System.currentTimeMillis());
				if (newTimeCount != null) {
					currentTimeCount = newTimeCount;
					StartController.timeSpend = currentTimeCount;
					Platform.runLater(new Runnable() {
					    @Override
					    public void run() {
					        // do your GUI stuff here
					    	time.setText(currentTimeCount);
					    }
					});
				}
				
			}
		});
		t.start();
	}
}
