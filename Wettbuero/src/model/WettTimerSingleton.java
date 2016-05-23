package model;

import java.util.Timer;

public class WettTimerSingleton extends Timer {

  private static final class InstanceHolder 
  {
    static final WettTimerSingleton INSTANCE = new WettTimerSingleton();
  }
  
  private WettTimerSingleton () 
  {	  
  }
  
  public static WettTimerSingleton getInstance () 
  {
    return InstanceHolder.INSTANCE;
  }
}