package model;
public class Zahlenwette extends Wette {
	
	protected int wette;
	public Zahlenwette(Account accountID, int wetteinsatz,int tipp,int erloes)
	{
		super(accountID, wetteinsatz,tipp,erloes);
	}
	public Zahlenwette(String pars, Account accountID, int wetteinsatz,int tipp,int erloes)
	{
		super(accountID, wetteinsatz,tipp,erloes);
		wette=Integer.parseInt(pars);
	}
	public Zahlenwette(int wette, Account accountID, int wetteinsatz,int tipp,int erloes)
	{
		super(accountID, wetteinsatz,tipp,erloes);
		this.wette=wette;
	}


}
