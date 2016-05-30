package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

abstract class Wettobjekt_Observeable extends TimerTask{
	protected int id;
	protected Date begin;
	protected Date end;
	protected ArrayList<Wette> wettenliste;
	public ArrayList<Observer> observerliste;

	public Wettobjekt_Observeable(Date begin, Date end) {
		
		wettenliste= new ArrayList<Wette>();
		observerliste= new ArrayList<Observer>();
		this.begin=begin;
		this.end=end;
		
		Timer t = WettTimerSingleton.getInstance();
		t.schedule(this, end);
		t.schedule(this, begin);
	}

	public void wetten (Wette wette) {
		wettenliste.add(wette);
	}

	/*public void run() {
		if(Zeit < end){
		  start();
		} else{
			end();
		}
	}*/

	abstract void start();

	abstract void end();

	public void alsObserveableMarkieren (Observer observer){
		observerliste.add(observer);
	}

	/*public void alleObserverUpdateSenden () {
		if(this.hasChanged()){
			this.notifyObservers(this);
			this.clearChanged();
		}
	}*/

}