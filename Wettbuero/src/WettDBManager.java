/**
 * 
 * @author Michael Krapf
 *
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class WettDBManager 
{
	private Connection conn;
	
	public WettDBManager()
	{
		
	}
	
	public ArrayList<Account> getAccounts()
	{
		
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