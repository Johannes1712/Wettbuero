public class Lottowette extends Wette {
	
	protected int[] wette;
	protected int zaehler=0;
	
	public Lottowette(String pars)
	{
		wette[zaehler]=Integer.parseInt(pars);
		zaehler++;
	}
	public Lottowette(int [] wette)
	{
		this.wette=wette;
	}

}
