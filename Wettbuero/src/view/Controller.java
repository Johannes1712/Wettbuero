package view;

import java.awt.TextField;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Account;
import model.WettDBManager;


public class Controller 
{
	Account eingeloggterAccount;
	WettDBManager wm;
	@FXML
	private PasswordField passwortFeld;
	@FXML
	private TextField nameFeld;
	@FXML
	private TextField wettID;
	@FXML
	private TextField WettEinsatz;
	@FXML
	private Text vorname;
	@FXML
	private Text nachname;
	@FXML
	private Text email;
	@FXML
	private Text kontostand;
	@FXML
	private TextArea wetten;
	
	
	public void login(ActionEvent e) throws SQLException, ClassNotFoundException, IOException
	{
		wm = new WettDBManager();
		ArrayList<Account> accounts = wm.getAccounts();
		for(Account a : accounts)
		{
			if(a.getVorname() == nameFeld.getText() &&
			   a.getPasswort() == passwortFeld.getText())
			{
				eingeloggterAccount = a;
				Stage stage = (Stage) passwortFeld.getScene().getWindow();
				stage.close();
				break;		
			}
		}
		Parent root = FXMLLoader.load(getClass().getResource("wettbuero.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
        primaryStage.setTitle("Wettb�ro");
        
	}
	
	public void wetteErfassen(ActionEvent e)
	{
	}
	
}
