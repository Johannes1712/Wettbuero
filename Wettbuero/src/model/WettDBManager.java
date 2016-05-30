/**
 * 
 * @author Michael Krapf
 *
 */

package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WettDBManager 
{
	private Connection conn;
	
	public WettDBManager() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/wettmanager", "root", "");
	}
	
	public ArrayList<Account> getAccounts() throws SQLException
	{
		Account account = null;
		ArrayList<Account> accounts = new ArrayList<Account>();
		String sql = "SELECT * FROM account";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			int kontostand = rs.getInt("kontostand");
			int accountID = rs.getInt("accountID");
			String vorname = rs.getString("vorname");
			String nachname = rs.getString("nachname");
			String email = rs.getString("email");
			account = new Account(kontostand, accountID, vorname, nachname, email);
			accounts.add(account);
		}
		rs.close();
		stmt.close();
		
		return accounts;
	}
	
	public Wette getWette(Wette wette) throws SQLException
	{
		Wette wette1 = null;
		String sql = "SELECT * FROM wette WHERE accountID = " + wette.getAccountID();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			// int wettID = rs.getInt("wettID");
			int accountID = rs.getInt("accountID");
			double wetteinsatz = rs.getDouble("wetteinsatz");
			String tipp = rs.getString("tipp");
			double erloes = rs.getDouble("erloes");
			wette1 = new Wette(accountID, wetteinsatz, tipp, erloes);
		}
		rs.close();
		stmt.close();
		
		return wette1;
	}
	
	public Wettobjekt_Observeable getWettobjekt(Wettobjekt_Observeable wettobjekt) throws SQLException
	{
		Wettobjekt_Observeable wettobjekt1 = null;
		String sql = "SELECT * FROM wettobjekt WHERE wettobjektID = " + wettobjekt.getWettobjektID();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			int wettobjektID = rs.getInt("wettobjektID");
			String beschreibung = rs.getString("beschreibung");
			Date wettstart = rs.getDate("wettstart");
			Date wettende = rs.getDate("wettende");
			int wettID = rs.getInt("wettID");
			String ergebnis = rs.getString("ergebnis");
			wettobjekt1 = new Wettobjekt_Observeable(wettobjektID, beschreibung, wettstart, wettende, wettID, ergebnis);
		}
		rs.close();
		stmt.close();
		
		return wettobjekt1;
	}
	
	public void setAccount(Account account) throws SQLException
	{
		String sql = "INSERT INTO account VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, account.getKontonummer());
		stmt.setString(2, account.getEmail());
		stmt.setString(4, account.getNachname());
		stmt.setString(5, account.getVorname());
		stmt.setInt(6, account.getKontobetrag());
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void setWette(Wette wette) throws SQLException
	{
		String sql = "INSERT INTO wette VALUES(?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		// stmt.setInt(1, wette.getWettID());
		stmt.setInt(2, wette.getAccountID());
		stmt.setDouble(3, wette.getWetteinsatz());
		stmt.setString(4, wette.getTipp());
		stmt.setDouble(5, wette.getErloes());
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void setWettobjekte(Wettobjekt_Observeable wettobjekt) throws SQLException
	{
		String sql = "INSERT INTO wettobjekt VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, wettobjekt.getWettobjektID());
		stmt.setString(2, wettobjekt.getBeschreibung());
		stmt.setDate(3, wettobjekt.getWettstart());
		stmt.setDate(4, wettobjekt.getWettende());
		stmt.setInt(5, wettobjekt.getWettID());
		stmt.setString(6, wettobjekt.getErgebnis());
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void close() throws SQLException
	{
		conn.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		WettDBManager db = new WettDBManager();
		
		db.close();
	}
}