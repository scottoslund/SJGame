import java.util.*;
// This is the main class for the game. It is best to leave this
// file relatively empty to make for ease of use and clarity
public class Main {
	public static final int maxArmies = 100;
	public static final int maxCoin = 100;
	public static Random rand;
	private static Map<String, Civilization> civils;
	private static Scanner in;
	
	public static void main(String[] args) {
		rand = new Random();
		System.out.println("Welcome to Jessica and Scott's Game!");
		System.out.println("Let's start by adding as many civilizations as you want");
		System.out.println("When you're finished adding civilizations, enter \"done\"");
		in = new Scanner(System.in);
		civils = new HashMap<String, Civilization>();
		while (true) {
			Civilization curr = new Civilization();
			System.out.print("What will your planet's name be?: ");
			if (in.hasNextLine()) {	
				curr.name = in.nextLine();
				if (curr.name.equals("done")) {
					break;
				}
			}
			curr.armies = rand.nextInt(maxArmies);
			curr.coins = rand.nextInt(maxCoin);
			System.out.println("Planet " + curr.name + " will begin with " + curr.armies 
					+ " armies and " + curr.coins + " coins.");			
			civils.put(curr.name, curr);
		}
		System.out.println("Great! You have entered " + civils.size() + " civilizations.");
		System.out.println("Now time to perform actions. There are 2 options to choose from. They are:");
		System.out.println("War:\"W\", Diplomacy: \"D\"");
		System.out.println("Choose an action by entering the corresponding letter or end game by entering"
				+ "	\"done\"");
		while (true) {
			System.out.print("What action would you like to perform? ");
			if (in.hasNextLine()) {	
				String currAction = in.nextLine();
				if (currAction.equals("done")) {
					break;
				}
				switch (currAction) {
					case "W":
						handleWar();
						break;
					case "D":
						handleDiplomacy();
						break;
					default:
						System.out.println("Not a recognized command, try again.");
				}
			}
		}
		in.close();
		System.out.println("Thanks for playing!");// The civlization with the most armies was " + )
	}
	
	private static void handleWar() {
		System.out.print("A war has begun! Which army was the perpetrator? ");
		String name = in.nextLine();
		Civilization civil1 = null;
		Civilization civil2 = null;
		if (civils.containsKey(name)) {
			civil1 = civils.get(name);
		} else {
			System.out.println("Oh no, that's not a valid name! Can't have a war without an offensive front...");
			return;
		}
		System.out.print("And who did they attack? ");
		name = in.nextLine();
		if (civils.containsKey(name) && !name.equals(civil1.name)) {
			civil2 = civils.get(name);
		} else {
			System.out.println("Oh no, that's not a valid name! Can't have a war without a defensive front...");
		}
		System.out.println(civil1.name + " and " + civil2.name + " are at war! Let's see their stats...");
		civil1.print();
		civil2.print();
		int res = civil1.war(civil2, rand);
		// TODO take away some armies from both sides (more from the losing side)
		if (res > 0) {
			System.out.println(civil1.name + " won the war!");
		} else if (res < 0) {
			System.out.println(civil2.name + " won the war!");
		} else {
			System.out.println("The war was a draw!");
		}
	}
	
	private static void handleDiplomacy() {
		System.out.println("Oh no! This part of the game hasn't been implemented!");
	}
}