package model;
//Buchis Klasse => finger weck!!!
public class Account 
{
	int kontoBetrag;
	int kontoNummer;
	String vorname;
	String nachname;
	String email;
	public Account(int kontoBetrag,int kontoNummer, String vorname, String nachname, String email)
	{
		this.kontoBetrag = kontoBetrag;
		this.kontoNummer = kontoNummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
	}
	
	public void einzahlung(int betrag)
	{
		kontoBetrag = kontoBetrag + betrag;
	}
	
	public void auszahlung(int betrag)
	{
		kontoBetrag = kontoBetrag - betrag;
	}

// ----------------------------------------------------------------------	
	
	public int getKontonummer() {
		return kontoNummer;
	}

	public String getEmail() {
		return email;
	}

	public String getNachname() {
		return nachname;
	}

	public int getKontobetrag() {
		return kontoBetrag;
	}

	public String getVorname() {
		return vorname;
	}
}