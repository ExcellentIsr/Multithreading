package telran.multithreading;

import telran.view.*;

public class RacesController {
	public static void main(String[] args) throws InterruptedException {
		InputOutput io = new StandartInputOutput();
		Menu menu = new Menu("Racing", new Item[] {
				Item.of("Start", x -> RacesController.start(io)),
				Item.exit(),
		});
		menu.perform(io);
	}
	
	static void start(InputOutput io) {
		int nRunners = io.readInt("Enter number of runners in the race. *Must be [2-10]", "Must be [2-10]", 2, 10);
		int distance = io.readInt("Enter distance for race", "Wrong data");
		Race race = new Race(nRunners, distance);
		race.startRacing();
	}
}
