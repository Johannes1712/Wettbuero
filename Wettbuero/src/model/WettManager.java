/**
 * 
 * @author Michael Krapf
 *
 */

package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class WettManager 
{
	private WettDBManager wettDBManager;
	public ArrayList<Account> accountListe;
	
	public void wetteSetzen(Wette wette) throws SQLException
	{
		wettDBManager.setWette(wette);
	}
	
	public void accountsErstellen(Account account) throws SQLException
	{
		wettDBManager.setAccount(account);
	}
	
	public void wettObjektSetzen(Wettobjekt_Observeable wettobjekt) throws SQLException
	{
		wettDBManager.setWettobjekte(wettobjekt);
	}
}