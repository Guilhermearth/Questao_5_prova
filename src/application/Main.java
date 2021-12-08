package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane anchorPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/gui/View.fxml"));
		Scene scene = new Scene(anchorPane);
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("formulario");
		primaryStage.show();
		
	}
}
