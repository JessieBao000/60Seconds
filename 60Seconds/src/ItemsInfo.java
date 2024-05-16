
public class ItemsInfo {

	
	
	String name;
	int hunger;
	int saftey;
	int health;
	int sanity;
	
	public ItemsInfo() {
		name = "temp";
		hunger =0;
		saftey =0;
		health=0;
		sanity=0;
	}
	
	public ItemsInfo(String n, int h, int s, int health, int sanity) {
		name = n;
		hunger = h;
		saftey = s;
		this.health = health;
		this.sanity = sanity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getSaftey() {
		return saftey;
	}

	public void setSaftey(int saftey) {
		this.saftey = saftey;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSanity() {
		return sanity;
	}

	public void setSanity(int sanity) {
		this.sanity = sanity;
	}

	
}
