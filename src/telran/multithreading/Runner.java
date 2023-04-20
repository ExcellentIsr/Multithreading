package telran.multithreading;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Runner extends Thread {
	public Runner(int id, int distance, Race race) {
		this.id = id;
		this.distance = distance;
		this.race = race;
	}
	static private int RNM_DELAY_FROM = 20;
	static private int RNM_DELAY_TO = 500;
	private Race race;
	private int id;
	private int distance;
	private long timeRun; 	
	
	@Override
	public void run() {
		Instant start = Instant.now();
		for (int i = distance; i > 0; i--) {
			System.out.printf("#%d in %d meters from the finish\n", id, i);
			int randomDelay = (int) (Math.random()*(RNM_DELAY_TO - RNM_DELAY_FROM) + RNM_DELAY_FROM);
			try {
				this.sleep(randomDelay);
			} catch (InterruptedException e) {
				
			}
		}
		race.setWinnerId(id);
		System.out.printf("Participant #%d on the finish\n", id);
	}
	
	public long getTimeRun() {
		return timeRun;
	}
}
