package model;
public class Zahlenwette extends Wette {
	
	protected int wette;
	
	/*public Zahlenwette(int accountID,Account account, double wetteinsatz)
	{
		super(accountID,account, wetteinsatz);
	}*/
	public Zahlenwette(String pars, int accountID,Account account, double wetteinsatz)
	{
		super(accountID,account, wetteinsatz);
		this.wette=Integer.parseInt(pars);
	}
	public Zahlenwette(int wette, int accountID,Account account,double wetteinsatz)
	{
		super(accountID, account, wetteinsatz);
		this.wette=wette;
	}
	
	public int getWette(){
		return wette;
	}


}
