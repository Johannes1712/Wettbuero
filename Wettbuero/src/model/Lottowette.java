package model;
public class Lottowette extends Wette{
	
	protected int[] wette;
	protected int zaehler=0;
	
	/*public Lottowette(int accountID, double wetteinsatz,String tipp,double erloes)
	{
		super(accountID, wetteinsatz,tipp,erloes);
	}*/
	
	public Lottowette(String pars,int accountID,Account account, double wetteinsatz)
	{
		super(accountID,account, wetteinsatz);
		String []p=pars.split(pars, ',');
		for(int i=0;i<=p.length-1;i++)
		{
			wette[i]=Integer.parseInt(p[i]);
		}
	}
	public Lottowette(int [] wette, int accountID,Account account, double wetteinsatz)
	{
		super(accountID,account, wetteinsatz);
		this.wette=wette;
	}
	
	public int[] getWette(){
		return wette;
	}

}
