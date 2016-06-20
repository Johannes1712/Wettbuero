package view;

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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Account;
import model.Lottowette;
import model.WettDBManager;
import model.Zahlenwette;


public class Controller 
{
	Account eingeloggterAccount;
	WettDBManager wm;
	@FXML
	private PasswordField passwortFeld;
	@FXML
	private TextField nameFeld;
	@FXML
	private TextField wettIDlotto;
	@FXML
	private TextField wettIDzahlen;
	@FXML
	private TextField lottotipp;
	@FXML
	private TextField zahlentipp;
	@FXML
	private TextField lottoeinsatz;
	@FXML
	private TextField zahleneinsatz;
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
		Parent root = FXMLLoader.load(getClass().getResource("view/wettbuero.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
        primaryStage.setTitle("Wettbüro");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("wette.png")));  
        String wettenliste = wm.getWetten();
        wetten.setText(wettenliste);
        primaryStage.show();
	}
	public void wetteErfassenLotto(ActionEvent e) throws SQLException
	{
		Lottowette wette = new Lottowette(lottotipp.getText(),eingeloggterAccount.getID(),eingeloggterAccount,Double.parseDouble(lottoeinsatz.getText()));
		wm.setWette(wette);
	}
	public void wetteErfassenZahlen(ActionEvent e) throws SQLException
	{
		Zahlenwette wette = new Zahlenwette(lottotipp.getText(),eingeloggterAccount.getID(),eingeloggterAccount,Double.parseDouble(lottoeinsatz.getText()));
		wm.setWette(wette);
	}
}
