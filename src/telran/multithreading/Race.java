package telran.multithreading;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

public class Race {
	private int nRunners;
	private int distance;
	private Instant start;
	protected int winnerId = -1;
	protected long[] tableWinners = new long[11];
	
	public Race(int nRunners, int distance) {
		this.nRunners = nRunners;
		this.distance = distance;
	}

	public int getWinnerId() {
		return winnerId;
	}

	synchronized protected void setWinnerId(int winnerId, Instant instant) {
		if (this.winnerId < 0){
			this.winnerId = winnerId;
		}
		tableWinners[winnerId] = ChronoUnit.MILLIS.between(start, instant);
	}
	
	private HashSet<Runner> party = new HashSet<>();
	
	public void startRacing() {
		start = Instant.now();
		for (int i = 0; i < nRunners; i++) {
			party.add(new Runner(i + 1, distance, this));
		}
		party.forEach(Runner::start);
		for (Runner runner : party) {
			try {
				runner.join();
			} catch (InterruptedException e) {
				
			}
		}
		displayTable();
	}

	private void displayTable() {
		System.out.printf("  Runner   |   Time  \n");
		for (int i = 1; i < tableWinners.length; i++) {
			System.out.printf("%5d      %7d\n", i, tableWinners[i]);
		}
		System.out.println(" |||| WINNER #" + winnerId + " ||||");
	}
}
