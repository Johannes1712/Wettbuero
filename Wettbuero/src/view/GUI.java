package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("wettbuero.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
        primaryStage.setTitle("Login");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
