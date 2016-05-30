package model;
public class Lottowette extends Wette{
	
	protected int[] wette;
	protected int zaehler=0;
	
	public Lottowette(Account accountID, int wetteinsatz,int tipp,int erloes)
	{
		super(accountID, wetteinsatz,tipp,erloes);
	}
	public Lottowette(String pars, Account accountID, int wetteinsatz,int tipp,int erloes)
	{
		super(accountID, wetteinsatz,tipp,erloes);
		wette[zaehler]=Integer.parseInt(pars);
		zaehler++;
	}
	public Lottowette(int [] wette, Account accountID, int wetteinsatz,int tipp,int erloes)
	{
		super(accountID, wetteinsatz,tipp,erloes);
		this.wette=wette;
	}

}
