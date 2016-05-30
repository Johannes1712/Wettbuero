package model;

import java.util.HashMap;
import java.util.Observable;

public class ZahlenWettObjekt extends Wettobjekt_Observeable {

	int zahl;
	
	public ZahlenWettObjekt(String pars){
		this.zahl=Integer.parseInt(pars);
	}
	public ZahlenWettObjekt(int zahl){
		this.zahl=zahl;
	}

	@Override
	void start() {
		
	}

	@Override
	void end() {
		this.ziehung()
		this.gewinnErmittlung();
	}
	
	public  void ziehung(HashMap<Wette> tipps){
		
		System.out.println("Alle Wettbeteiligten mit Betrag und Tipp:");
		for(Benutzer px: tipps.keySet()){
			
			System.out.println(px + "€ Tipp:"+ tipps.get(px));
		}
		
		
		System.out.println("======================================================");
		System.out.println("Die Ziehung beginnt:");
		
		int zufallszahl= (int) (Math.random()*100)+1;
		
		gewinnErmittlung(zufallszahl,tipps);
		
		
		System.out.println("Die Ziehung ist beendet:");
		System.out.println("Die Zahl lautet:"+ zufallszahl);
		System.out.println("======================================================");
			
	}
	
	public void gewinnErmittlung(int zufallszahl, HashMap<Benutzer,Integer> tipps){
		
		for(Benutzer px: tipps.keySet()){
						
			int tipp= tipps.get(px);
			if(tipp>95 && zufallszahl<4){
				int zahl=100+zufallszahl;
				if((zahl-tipp)<=2){px.setBetrag(px.getBetrag()*5); continue;}
				if((zahl-tipp)<=5){px.setBetrag(px.getBetrag()*2); continue;}
			}
			if(zufallszahl>95 && tipp<4){
				int zahl=100+tipp;
				if((zahl-zufallszahl)<=2){px.setBetrag(px.getBetrag()*5); continue;}
				if((zahl-zufallszahl)<=5){px.setBetrag(px.getBetrag()*2); continue;}
			}
			
			if(zufallszahl<10)
			if(tipp < (zufallszahl % 100) +2  && tipp > (zufallszahl % 100)-2) {
				px.setBetrag(px.getBetrag()*5); continue;
			}
			if(tipp < (zufallszahl % 100)+5 && tipp > (zufallszahl % 100)-5){
				px.setBetrag(px.getBetrag()*2); continue;
			}			
		}
	}

}
