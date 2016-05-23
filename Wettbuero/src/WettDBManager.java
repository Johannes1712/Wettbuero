/**
 * 
 * @author Michael Krapf
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;

public class WettDBManager 
{
	private Connection conn;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	public WettDBManager() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
	}
	
	public ArrayList<Account> getAccounts()
	{
		return accounts;
	}
	
	public Wette getWette(Wette wette)
	{
		
	}
	
	public Wettobjekt getWettobjekt(Wettobjekt wettobjekt)
	{
		
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