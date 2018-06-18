import java.util.*;

public class Civilization {
	public static final int maxLuck = 20;
	
	public String name;
	public int armies;
	public int coins;
	public List<Civilization> allies;
	public List<Civilization> enemies;
	
	public Civilization(String name, int armies, int coins) {
		this.name = name;
		this.armies = armies;
		this.coins = coins;
	}
	
	public Civilization() {
	}
	
	public void print() {
		System.out.println("\t" + name + " has " + armies + " armies.");
		System.out.println("\t" + name + " has " + coins + " coins.");
	}
	
	// Returns a number > 0 if this civilization wins, < 0 if it loses, 0 if it ties;
	public int war(Civilization other, Random rand) {
		int luck1 = rand.nextInt(maxLuck);
		int total1 = luck1 + armies;
		int luck2 = rand.nextInt(maxLuck);
		int total2 = luck2 + other.armies;
		System.out.println(name + "'s luck score is " + luck1 + " for a total of " + total1 + " points.");
		System.out.println(other.name + "'s luck score is " + luck2 + " for a total of " + total2 + " points.");
		return total1 - total2;
	}
}
