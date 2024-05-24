import java.util.ArrayList;

public class Randomized {
	
	
	public static String disasterName;
	public static int savedEnding; //ends at step 4
	public static int catEnding; //ends at step 6
	public static int runEnding; // ends at step 5
	public String text;
	public String afterText;
	public int statChange;
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
		/*int chance = (int) (Math.random() * 17);
		switch(chance) {
			case 0:
				savedEnding();
				break;
			case 1:
				catEnding();
				break;
			case 2: 
				runEnding();
				break;
			case 3:
				robbers1();
				break;
			case 4:
				robbers2();
				break;
			case 5:
				freeFood();
				break;
			case 6:
				freeWater();
				break;
			case 7:
				freeStuff();
				break;
			case 8:
				infestation();
				break;
			case 9:
				scammer();
				break;
			case 10:
				redHerring();
				break;
			case 11: 
				sick();
				break;
			case 12:
				blackHole();
				break;
			case 13:
				lootNeighbor();
				break;
			case 14:
				sanityHelp();
				break;
			case 15:
				nothing1();
				break;
			case 16:
				nothing2();
				break;
			case 17:
				nothing3();
				break;
		}*/
	}

	public void savedEnding(){
			if(savedEnding ==0){
		}
	}
	
	public void catEnding(){
			if(catEnding ==0){
		}
	}
	
	
	public void runEnding(){
			if(runEnding ==0){
		}
	}
	
	public void robbers1() {
		
	}
	
	public void robbers2() {
	
	}
	
	public void freeFood() {
		
	}
	
	public void freeWater() {
		
	}
	
	public void freeStuff() {
		
	}
	
	public void infestation() {
		
	}
	
	public void scammer() {
		
	}
	
	public void redHerring(int chance) {
		text = "There's a big commotion out on the street," + "\n" + 
				"Maybe someone found help? Maybe someone is getting attack?";
		
		if(chance ==0) {
			afterText = "You got beat up!";
			statChange = -30;
		}else {
			afterText = "They were definetly getting killed ¯\\_(ツ)_//¯";
		}
	}
	
	public void sick(int chance) {
		text = "You feel a little soreness in the back of your throat" + "\n" + 
				"Its probably just the flu.";
		
		if(chance ==0) {
			afterText = "You feel a lot better!";
			statChange = 20;
		}else {
			afterText = "*Cough Cough*";
			statChange = -10;
		}
		
		//use boy scout book
		//first aid kit
		//water
		//soap
		
		
	}
	
	
	public void wounded(){
		text = "You found a pretty bad gash on your back";
	}

	public void blackHole() {
		text = "You've noticed an opening in the back of the shelter" + "\n" + 
				"You think it's calling for your name!";
		afterText = "OWWWWWWWWWWWWWWWWWWWWWWWWWW! You've been hurt significantly!";
		statChange = -30;
	}
	
	
	public void lootNeighbor(int chance) {
		text = "You remember that your neighbor had spare soups in his kitchen," + "\n" + 
				"Sharing is caring, right?";
		
		if(chance ==0) {
			afterText = "You got beat up!";
			statChange = -30;
		}else {
			afterText = "You got free food!";
		}
		
		// y/n
	}
	
	public void sanityHelp(){
		text = "You've been spending your past time starring at concrete walls." + "\n" + 
				"Maybe its time to do something interesting with your boring life...";
		afterText = "You feel a little better about your situation!";
		// use boy scout book
		// knife
		// map
		
		statChange = 20;
	}
	
	

	public void nothing1(){
		text = "You're getting used to bunker life, but you really miss your dog, Peanuts." + "\n" + "Maybe he'll come back...";
	}
	
	public void nothing2(){
		text = "How much wood could a woodchuck chuck, if a woodchuck could chuck wood.";
	}
	
	public void nothing3(){
		text = "Do you hear that too?";
	}
	
	
	
	
	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

	public String getAfterText() {
		return afterText;
	}

	public void setAfterText(String afterText) {
		this.afterText = afterText;
	}

	public int getstatChange() {
		return statChange;
	}

	public void setstatChange(int statChange) {
		this.statChange = statChange;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


