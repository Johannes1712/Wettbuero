package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Observer;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

abstract class Wettobjekt_Observeable extends TimerTask{
	protected int id;
	protected String beschreibung;
	protected boolean gestartet;
	protected Date begin;
	protected Date end;
	protected Date date;
	protected ArrayList<Wette> wettenliste;
	public ArrayList<Observer> observerliste;

	public Wettobjekt_Observeable(Date begin, Date end,String beschreibung) {
		
		wettenliste= new ArrayList<Wette>();
		observerliste= new ArrayList<Observer>();
		this.begin=begin;
		this.end=end;
		this.beschreibung=beschreibung;
		
		date = new Date(0);
		Timer t = WettTimerSingleton.getInstance();
		t.schedule(this, end);
	}

	public void wetten (Wette wette) {
		if(!gestartet){
			wettenliste.add(wette);
			//alleObserverUpdateSenden();
		}
	}

	public void run() {
		if( date.before(end) ){
		  start();
		} else{
			end();
			alleObserverUpdateSenden();
		}
	}
	
	public void start(){
		gestartet=true;
	}

	abstract void end();

	public void alsObserveableMarkieren (Observer observer){
		observerliste.add(observer);
	}

	public void alleObserverUpdateSenden() {
		for(Observer observer: observerliste){
			observer.update(null, this);
		}
	}
	
	public Date getEndDate(){
		return end;
	}
	public Date getBeginDate(){
		return begin;
	}
	public int getID(){
		return id;
	}
	
	public String getBeschreibung()
	{
		return beschreibung;
	}

}