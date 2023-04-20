package telran.multithreading;

import java.util.HashSet;

public class Race {
	private int nRunners;
	private int distance;
	protected int winnerId = -1;
	
	public Race(int nRunners, int distance) {
		this.nRunners = nRunners;
		this.distance = distance;
	}

	public int getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(int winnerId) {
		if (this.winnerId < 0){
			this.winnerId = winnerId;
		}
	}
	private HashSet<Runner> party = new HashSet<>();
	
	public void startRacing() {		
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
		System.out.println("Winner - #" + getWinnerId());
	}
}
