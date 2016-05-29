package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

abstract class Wettobjekt_Observeable extends Observable{
	protected int id;
	protected Date begin;
	protected Date end;
	protected ArrayList<Wette> wetten;
	public ArrayList<Observer> observer;

	public Wettobjekt_Observeable() {
		Timer t = WettTimerSingleton.getInstance();
		t.schedule(this, end);
		t.schedule(this, begin);
	}

	public void wetten (Wette wette) {
		
	}

	public void run () {
		if(Zeit < end){
		  start();
		} else{
			end();
		}
	}

	abstract void start();

	abstract void end();

	public void alsObserveableMarkieren (Observer observer){
		this.addObserver(observer);
	}

	public void alleObserverUpdateSenden () {
		if(this.hasChanged()){
			this.notifyObservers(this);
			this.clearChanged();
		}
	}

}