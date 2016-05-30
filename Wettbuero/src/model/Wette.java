package model;

public class Wette {
	protected int accountID;
	protected double wetteinsatz;
	protected String tipp;
	protected double erloes;
	
	
	public Wette(int accountID, double wetteinsatz,String tipp,double erloes) 
	{
		this.accountID=accountID;
		this.wetteinsatz=wetteinsatz;
		this.tipp=tipp;
		this.erloes=erloes;
	}
	public String getTipp()
	{
		return tipp;
	}
	public double getErloes()
	{
		return erloes;
	}
	public double getWetteinsatz()
	{
		return wetteinsatz;
	}
	public int getAccountID()
	{
		return accountID;
	}
	

}
