import java.util.ArrayList;

public class Randomized {
	
	
	public static String disasterName;
	public static int savedEnding; //ends at step 5
	public static int catEnding; //ends at step 8
	public static int runEnding; // ends at step 6
	public String text;
	ArrayList<Item> inventory;
	
	public Randomized(String name, ArrayList<Item> items) {
		disasterName = name;
		savedEnding = 0;
		catEnding = 0;
		runEnding=0;
		text = "";
		inventory = items;
	}
	
	public void randomEvent() {
		int chance = (int) (Math.random() * 8);
		switch(chance) {
			case 0:
				break;
			case 1:
				break;
			case 2: 
				break;
			case 3:
				break;
			case 4:
				break;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
