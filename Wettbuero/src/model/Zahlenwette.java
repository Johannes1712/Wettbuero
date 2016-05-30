package model;
public class Zahlenwette extends Wette {
	
	protected int wette;
	public Zahlenwette()
	{
		
	}
	public Zahlenwette(String pars)
	{
		wette=Integer.parseInt(pars);
	}
	public Zahlenwette(int wette)
	{
		this.wette=wette;
	}

}
