/**
 * 
 * @author Michael Krapf
 *
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Account;

public class WettDBManager 
{
	private Connection conn;
	
	public WettDBManager() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/wettmanager", "root", "");
	}
	
	public ArrayList<Account> getAccounts()
	{
		ArrayList<Account> accounts = new ArrayList<Account>();
		String sql = "SELECT * FROM account";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			int spielerPassNr = rs.getInt("spielerPassNr");
			accounts.add(holeSpieler(spielerPassNr));
		}
		rs.close();
		return accounts;
	}
	
	public Wette getWette(Wette wette)
	{
		Wette wette1 = null;
		String sql = "SELECT * FROM wette WHERE wette = " + wette;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			int wettID = rs.getInt("wettID");
			int accountID = rs.getInt("accountID");
			double wetteinsatz = rs.getDouble("wetteinsatz");
			String tipp = rs.getString("tipp");
			double erloes = rs.getDouble("erloes");
			wette1 = new Wette(wettID, accountID, wetteinsatz, tipp, erloes);
		}
		rs.close();
		stmt.close();
		
		return wette1;
	}
	
	public Wettobjekt getWettobjekt(Wettobjekt wettobjekt)
	{
		Wettobjekt wettobjekt1 = null;
		String sql = "SELECT * FROM wettobjekt WHERE wettobjektID = " + wettobjekt;
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
			wettobjekt1 = new Wettobjekt(wettobjektID, beschreibung, wettstart, wettende, wettID, ergebnis);
		}
		rs.close();
		stmt.close();
		
		return wettobjekt1;
	}
	
	public void setAccount(Account account)
	{
		
	}
	
	public void setWette(Wette wette)
	{
		
	}
	
	public void setWettobjekte(Wettobjekt wettobjekt)
	{
		
	}
	
	public void close() throws SQLException
	{
		conn.close();
	}
}