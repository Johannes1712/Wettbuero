package model;

import java.sql.Date;

public class ZahlenWettObjekt extends Wettobjekt_Observeable {

	int zahl;
	
	public ZahlenWettObjekt(Date begin, Date end,String beschreibung, String pars){
		super(begin,end,beschreibung);
		this.zahl=Integer.parseInt(pars);
	}
	public ZahlenWettObjekt(Date begin, Date end, String beschreibung, int zahl){
		super(begin,end,beschreibung);
		this.zahl=zahl;
	}


	@Override
	void end() {
		this.ziehung();
	}
	
	public  void ziehung(){
		
		System.out.println("======================================================");
		System.out.println("Die Ziehung beginnt:");
		
		//int zufallszahl= (int) (Math.random()*100)+1;
		int zufallszahl= zahl;
		
		gewinnErmittlung(zufallszahl);
		
		
		System.out.println("Die Ziehung ist beendet:");
		System.out.println("Die Zahl lautet:"+ zufallszahl);
		System.out.println("======================================================");
			
	}
	
	public void gewinnErmittlung(int zufallszahl){
		
		for(Wette wette: wettenliste){
			
			Account account=wette.getAccount();
			Zahlenwette wette_1=(Zahlenwette)wette;
			
			if(wette instanceof Zahlenwette){
				
				int tipp=wette_1.getWette();
				if(tipp>95 && zufallszahl<4){
					int zahl=100+zufallszahl;
					if((zahl-tipp)<=2){account.einzahlung(account.getKontobetrag()*5); continue;}
					if((zahl-tipp)<=5){account.einzahlung(account.getKontobetrag()*2); continue;}
				}
				if(zufallszahl>95 && tipp<4){
					int zahl=100+tipp;
					if((zahl-zufallszahl)<=2){account.einzahlung(account.getKontobetrag()*5); continue;}
					if((zahl-zufallszahl)<=5){account.einzahlung(account.getKontobetrag()*2); continue;}
				}
			
				if(zufallszahl<10)
				if(tipp < (zufallszahl % 100) +2  && tipp > (zufallszahl % 100)-2) {
					{account.einzahlung(account.getKontobetrag()*5); continue;}
				}
				if(tipp < (zufallszahl % 100)+5 && tipp > (zufallszahl % 100)-5){
					{account.einzahlung(account.getKontobetrag()*2); continue;}
				}			
			}
		}		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
