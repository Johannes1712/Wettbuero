package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUI extends Application {

	 private Stage primaryStage;

	    @Override
	    public void start(Stage primaryStage) {
	    	// connect primary stage
	        this.primaryStage = primaryStage;
	        mainWindow();
	    }

	    // main window
	    public void mainWindow() {
	        try {
	            // view
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
	            AnchorPane pane = loader.load();
	            // scene on stage
	            Scene scene = new Scene(pane);
	            primaryStage.setScene(scene);
	            primaryStage.show();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}