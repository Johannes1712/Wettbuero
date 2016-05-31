package model;

import java.sql.Date;

public class LottoWettObjekt extends Wettobjekt_Observeable {
	
	protected int[] zahlen;

	public LottoWettObjekt(Date begin, Date end, String pars){
		super(begin,end);
		
		String []p=pars.split(pars, ',');
		for(int i=0;i<=p.length-1;i++)
		{
			this.zahlen[i]=Integer.parseInt(p[i]);
		}
	}
	
	public LottoWettObjekt(Date begin, Date end,int[] zahl){
		super(begin,end);
		this.zahlen=zahl;
	}

	@Override
	void end(){
		this.ziehung();
	}
	
	public  void ziehung(){
		
		System.out.println("======================================================");
		System.out.println("Die Ziehung beginnt:");
		
		int[] zufallszahlen = zahlen;
		/*for(int i=0;i<=5;i++){
			int zufallszahl=(int) (Math.random()*46)+1;
			zufallszahlen[i]=zufallszahl;
		}*/
		
		gewinnErmittlung();
		
		
		System.out.println("Die Ziehung ist beendet:");
		System.out.println("Die Zahlen lauten:"+ zufallszahlen);
		System.out.println("======================================================");
			
	}
	
	public void gewinnErmittlung(){
		
		for(Wette wette: wettenliste){
			
			Account account=wette.getAccount();
			Lottowette wette_1=(Lottowette)wette;
			
			if(wette instanceof Zahlenwette){
				
				if(richtigeTipps(wette_1)==6){
					account.einzahlung(account.getKontobetrag()*10);
				}
				if(richtigeTipps(wette_1)==5){
					account.einzahlung(account.getKontobetrag()*5);
				}
				if(richtigeTipps(wette_1)==4){
					account.einzahlung(account.getKontobetrag()*3);
				}
				if(richtigeTipps(wette_1)==3){
					account.einzahlung(account.getKontobetrag()*2);
				}
			
			}
		}
	}
	
	public int richtigeTipps(Lottowette wette){
		int anzahl=0;
		
		for(int i=0;i<=5;i++){
			int tipp=((Lottowette) wette).getWette()[i];
			for(int ziehungszahl:zahlen){
				if(ziehungszahl==tipp)anzahl++;
			}
		}
		return anzahl;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
