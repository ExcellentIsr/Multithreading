package telran.multithreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread {
	private static final String DEFAULT_FORMAT = "HH:mm:ss";
	private static final long DEFAULT_TIMEOUT = 1000;
	DateTimeFormatter dtf;
	long timeout;
	
	public Timer(String formatPattern, long timeout) {
		dtf = DateTimeFormatter.ofPattern(formatPattern);
		this.timeout = timeout;
		setDaemon(true);
	}
	public Timer() {
		this(DEFAULT_FORMAT, DEFAULT_TIMEOUT);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(LocalTime.now().format(dtf));
			try {
				sleep(timeout);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
