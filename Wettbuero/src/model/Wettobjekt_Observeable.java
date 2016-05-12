package model;

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

	private abstract void start();

	private abstract void end();

	public void alsObserveableMarkieren (Observer observer) {
		
	}

	public void alleObserverUpdateSenden () {
		
	}

}