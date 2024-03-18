package vn.maize.TimeCounter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    private static Stage stage;

    @Override
    public void start(Stage appStage) throws IOException {
    	stage = appStage;
        scene = new Scene(loadFXML("start"), -1, -1);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    	
    	// Uncomment For Application build
//    	  URL url = App.class.getResource("/resources/vn/maize/TimeCounter/" + fxml + ".fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(url);
        return fxmlLoader.load();
    }
    
    public static void updateSceneSize(float w, float h) {
//    	scene.changedSize(w, h);

    }
    
    public static Stage getStage() {
    	return stage;
    }

    public static void main(String[] args) {
        launch();
    }

}