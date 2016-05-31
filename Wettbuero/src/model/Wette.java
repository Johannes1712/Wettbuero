package model;

abstract class Wette {
	protected int accountID;
	protected Account account;
	protected double wetteinsatz;
	
	public Wette(int accountID,Account account, double wetteinsatz) 
	{
		this.accountID=accountID;
		this.wetteinsatz=wetteinsatz;
		this.account=account;
	}

	public double getWetteinsatz()
	{
		return wetteinsatz;
	}
	public int getAccountID()
	{
		return accountID;
	}
	public Account getAccount()
	{
		return account;
	}
}