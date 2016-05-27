package model;

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
	public void update(Observable o, Object arg) {
		
	}

	@Override
	void start() {
		
	}

	@Override
	void end() {
		
	}

}
