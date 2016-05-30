public class Wette {
	protected Account account;
	protected Wette einstatz;
	
	public Wette(int kontobetrag, String vorname, String nachname, String email,Wette einsatz) 
	{
		account=new Account(kontobetrag,vorname,nachname,email);
		this.einstatz=einsatz;
	}

}
