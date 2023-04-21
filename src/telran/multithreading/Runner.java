package telran.multithreading;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Runner extends Thread {
	public Runner(int id, int distance, Race race) {
		this.id = id;
		this.distance = distance;
		this.race = race;
	}
	static private int RNM_DELAY_FROM = 2;
	static private int RNM_DELAY_TO = 5;
	private Race race;
	private int id;
	private int distance;
	private long timeRun; 	
	
	@Override
	public void run() {
		for (int i = distance; i > 0; i--) {
			int randomDelay = (int) (Math.random()*(RNM_DELAY_TO - RNM_DELAY_FROM) + RNM_DELAY_FROM);
			try {
				this.sleep(randomDelay);
			} catch (InterruptedException e) {
				
			}
		}
		race.setWinnerId(id, Instant.now());
	}
	
	public long getTimeRun() {
		return timeRun;
	}
}
