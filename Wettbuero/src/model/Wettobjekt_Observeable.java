package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Observer;
import java.util.TimerTask;

abstract class Wettobjekt_Observeable extends TimerTask {
	protected int id;
	protected Date start;
	protected Date end;
	protected ArrayList<Wette> wetten;
	public ArrayList<Observer> observer;

	public Wettobjekt_Observeable() {
		
	}

	public void wetten (Wette wette) {
		
	}

	public void run () {
		
	}

	abstract void start();

	abstract void end();

	public void alsObserveableMarkieren (Observer observer) {
		
	}

	public void alleObserverUpdateSenden () {
		
	}

}