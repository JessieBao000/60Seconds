import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

public class Randomized {
	
	
	public static String disasterName;
	public static int savedEnding; //ends at step 4
	public static int catEnding; //ends at step 4
	public static int runEnding; // ends at step 4
	public String text,secondText,thirdText;
	
	public Image option1,option2;
	

	public String afterText;
	public int statChange;
	ArrayList<Item> inventory;
	Player player;
	
	public Randomized(ArrayList<Item> items) {
		//disasterName = name;
		savedEnding = 0;
		catEnding = 0;
		runEnding=0;
		text = "";
		secondText="";
		thirdText = "";
		afterText = "♪";
		inventory = items;
		player = Event.player;
		
		option1=getImage("/imgs/"+"checkmark.png");
		option2=getImage("/imgs/"+"xmark.png");
	}
	
	
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Map.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
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

	public void savedEnding(int chance){
		if(savedEnding==0) {
				text="You remeber seeing a government broadcast on the TV about something,"+"\n"+
						"Maybe you should go outside to find help?";
				if(chance ==0) {
					afterText ="You picked up a flyer for with information on when soldiers are coming by!";
					//savedEnding=1;
				}
		}else if(savedEnding ==1) {
			text="On your paper, it says to meet in a specific location for supplies...";
			if(chance ==0) {
				//use map
				afterText = "You found lots of supplies!";
				//savedEnding=2;
			}else {
				afterText = "Close enough...";
				savedEnding=2;
			}
		}else if(savedEnding ==2) {
			text="You're thinking about decorating the outside to catch the attention of the army.";
			if(chance ==0) {
				//use cloth
				afterText = "♪";
				//savedEnding=3;
			}else {
				afterText = "♪";
				//savedEnding=3;
			}
		}else if(savedEnding ==3) {
			text="You hear knocking on your door, should you open it?";
			if(chance ==0) {
				//yes
				//savedEnding=4;
			}else { 
				afterText = "♪";
			}
		}else {
			System.out.println("save end");
		}
	}
	
	public void catEnding(int chance){
		if(catEnding==0) {
			text="You hear soft scratching on the basement door..."+"\n"+
					"Could it be a cat needing help?";
			if(chance ==0) {
				afterText ="A cat joins the base!";
				//catEnding=1;
			}else {
				afterText = "♪";
			}
		}else if(catEnding ==1) {
			text="You noticed another cat outside...";
			if(chance ==0) {
				//use map
				afterText = "MORE CATS";
				//catEnding=2;
			}else {
				afterText = "It walked in anyway...";
				//catEnding=2;
			}
		}else if(catEnding ==2) {
			text="You see a hoard of cats outside!";
				//use cloth
				afterText = "My god thats a lot of cats";
				//catEnding=3;
		}else if(catEnding ==3) {
			text="Everything you see is cats, you aren't sure what to do...";
			//catEnding=4;
		}else {
			System.out.println("save end");
		}
	}
	
	
	public void runEnding(int chance){
		if(runEnding==0) {
			text="You're bunker is feeling a little bit crowded,"+"\n"+
					"Maybe its time to find a new place to call home?";
			if(chance ==0) {
				//runEnding=1;
			}
			afterText = "♪";
		}else if(runEnding ==1) {
			text="You still aren't too familiar with the area"+"\n"+
					"Should you check it out?";
			if(chance ==0) {
				//use map
				afterText = "You feel a little better";
				player.mentalScore+=10;
				//runEnding=2;
			}else {
				afterText = "♪";
				//runEnding=2;
			}
		}else if(runEnding ==2) {
			text="It's time to start heading out!";
				//use cloth
				///afterText = "My god thats a lot of cats";
				//runEnding=3;
		}else {
			System.out.println("save end");
		}
	}
	
	

	public void robbers1(int chance) {
		text = "You hear someone trying to sell soup and supplies to you from outside," + "\n"+
				"what should you do?";
		
		if(chance ==0) {
			afterText = "You got robbed lol";
		}else {
			afterText = "Close call...";
		}
	}
	
	public void robbers2(int chance) {
		text = "Someone's knocking on the door, saying FBI open up" + "\n"+
				"what should you do?";
		
		if(chance ==0) {
			afterText = "You got robbed lol";
		}else {
			afterText = "Congrats you're not stupid";
		}
	}
	
	public void freeFood(int chance) {
		text = "You remember you had some soup in the attic" + "\n"+
				"should you try to get it?";
		
		if(chance ==0) {
			afterText = "♪";
			//picked nothing
		}else {
			afterText = "MORE SOUP!!!!!!";
		}
	}
	
	public void freeWater(int chance) {
		text = "You remember you left some water near the door," + "\n"+
				"should you try to get it?";
		
		if(chance ==0) {
			afterText = "♪";
			//picked nothing
		}else {
			afterText = "MORE WATER!!!!!!!";
		}
	}
	
	public void freeStuff(int chance) {
		text = "You notice a closed box in the corner," + "\n"+
				"should you open it?";
		
		if(chance ==0) {
			afterText = "♪";
			//picked nothing
		}else {
			afterText = "FREE STUFF!";
		}
	}
	
	public void infestation(int chance) {
		text = "There is an infestation of rats in your bunker,\nwhat to do?";
		
		if(chance ==0) {
			afterText = "♪";
			//picked something
		}else {
			afterText = "Crazy? I Was Crazy Once. They Locked Me In A Room."+ "\n" +"A Rubber Room. A Rubber Room With Rats. \n And Rats Make Me Crazy";
			statChange = -20;
			player.illScore-=20;
		}
	}
	
	public void scammer(int chance) {
		text = "Someone is knocking on the door offering 100 soup cans for any free item!";
		
		if(chance ==0) {
			afterText = "You got scammed lol";
			//everything gone
		}else {
			afterText = "♪";
		}
	}
	
	public void redHerring(int chance) {
		text = "There's a big commotion out on the street," + "\n" + 
				"Maybe someone found help? Maybe someone is getting attack?";
		
		if(chance ==0) {
			afterText = "You got beat up!";
			statChange = -30;
			player.healthScore-=30;
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
			player.illScore+=20;
		}else {
			
			afterText = "*Cough Cough*";
			statChange = -10;
			player.illScore-=10;
		}
		
		//first aid kit
		//soap
		
		
	}
	
	
	public void wounded(int chance){
		text = "You found a pretty bad gash on your back"+"\n"+
				"what should you do?";
		if(chance ==0) {
			afterText = "It worked!";
			statChange = 10;
			player.healthScore+=10;
		}else {
			afterText = "♪";
			statChange = -10;
			player.healthScore-=10;
		}
	}

	public void blackHole(int chance ) {
		text = "You've noticed an opening in the back of the shelter" + "\n" + 
				"You think it's calling for your name!";
		if(chance ==0) {
			afterText = "OWWWWWWWWWWWWWWWWWWWWWWWWWW! You've been hurt significantly!";
			statChange = -30;
			player.healthScore-=30;
			player.illScore-=30;
		}else {
			afterText = "♪";
		}
	}
	
	
	public void lootNeighbor(int chance) {
		text = "You remember that your neighbor had spare soups in his kitchen,";
		secondText ="Sharing is caring, right?";
		
		if(chance ==0) {
			afterText = "You got beat up!";
			statChange = -30;
			player.healthScore-=statChange;
		}else if(chance ==1) {
			afterText = "You got free food!";
		}else {
			afterText = "♪";
		}
		
		// y/n
	}
	
	public void sanityHelp(int chance){
		text = "You've been spending your past time starring at concrete walls.";
		secondText = "Maybe its time to do something interesting with your boring life...";
		option1 = getImage("/imgs/"+"book.png"); 
		option2 = getImage("/imgs/"+"knife.png"); 
		if(chance ==0) {
			afterText = "You feel a little better about your situation!";
			// use boy scout book
			
			statChange = 20;
			player.mentalScore+=statChange;
		}else if(chance ==1){
			afterText = "You feel a little better about your situation!";
			// knife
			
			statChange = 25;
			player.mentalScore+=statChange;
		}else {
			afterText = "♪";
		}
	}
	
	

	public void nothing1(){
		text = "You're getting used to bunker life, but you really miss your dog, Peanuts.";
		secondText = "Maybe he'll come back...";
		afterText = "♪";
		option1 = null;
		option2 = null;
		
	}
	
	public void nothing2(){
		text = "How much wood could a woodchuck chuck, ";
		secondText ="if a woodchuck could chuck wood.";
		afterText = "♪";
		option1 = null;
		option2 = null;
	}
	
	public void nothing3(){
		text = "Do you hear that too?";
		afterText = "♪";
		option1 = null;
		option2 = null;
	}
	
	public String getSecondText() {
		return secondText;
	}

	public void setSecondText(String secondText) {
		this.secondText = secondText;
	}

	public String getThirdText() {
		return thirdText;
	}

	public void setThirdText(String thirdText) {
		this.thirdText = thirdText;
	}
	
	
	public static int getSavedEnding() {
		return savedEnding;
	}

	public static void setSavedEnding(int savedEnding) {
		Randomized.savedEnding = savedEnding;
	}

	public static int getCatEnding() {
		return catEnding;
	}

	public static void setCatEnding(int catEnding) {
		Randomized.catEnding = catEnding;
	}

	public static int getRunEnding() {
		return runEnding;
	}

	public static void setRunEnding(int runEnding) {
		Randomized.runEnding = runEnding;
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


