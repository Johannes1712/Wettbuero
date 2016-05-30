package model;
public class Zahlenwette extends Wette {
	
	protected int wette;
	public Zahlenwette(int accountID, double wetteinsatz,String tipp,double erloes)
	{
		super(accountID, wetteinsatz,tipp,erloes);
	}
	public Zahlenwette(String pars, int accountID, double wetteinsatz,String tipp,double erloes)
	{
		super(accountID, wetteinsatz,tipp,erloes);
		wette=Integer.parseInt(pars);
	}
	public Zahlenwette(int wette, int accountID, double wetteinsatz,String tipp,double erloes)
	{
		super(accountID, wetteinsatz,tipp,erloes);
		this.wette=wette;
	}


}
