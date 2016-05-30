package model;

public class Wette {
	protected Account accountID;
	protected int wetteinsatz;
	protected int tipp;
	protected int erloes;
	
	
	public Wette(Account accountID, int wetteinsatz,int tipp,int erloes) 
	{
		this.accountID=accountID;
		this.wetteinsatz=wetteinsatz;
		this.tipp=tipp;
		this.erloes=erloes;
	}
	public int getTipp()
	{
		return tipp;
	}
	public int getErloes()
	{
		return erloes;
	}
	public int getWetteinsatz()
	{
		return wetteinsatz;
	}
	public Account getAccountID()
	{
		return accountID;
	}
	

}
