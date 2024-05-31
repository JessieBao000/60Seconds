import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Randomized {
	
	
	public static String disasterName;
	public static int savedEnding; //ends at step 4
	public static int catEnding; //ends at step 4
	public static int runEnding; // ends at step 4
	
	public boolean savedCont;
	public boolean catCont;
	public boolean runCont;
	
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
		
		savedCont =false;
		catCont=false;
		runCont=false;
		
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

	public Image getOption1() {
		return option1;
	}



	public void setOption1(Image option1) {
		this.option1 = option1;
	}



	public Image getOption2() {
		return option2;
	}



	public void setOption2(Image option2) {
		this.option2 = option2;
	}



	public void savedEnding(int chance){
		if(savedEnding==0 && checkAvailable("radio")) {
				text="You hear a government broadcast on your radio,";
				secondText ="Maybe you should go outside to find help?";
				thirdText = "";
				if(chance ==0) {
					afterText ="You hear that soldiers are coming by!";
					//savedEnding=1;
					savedCont=true;
				}
		}else if(savedEnding ==1&& checkAvailable("radio")) {
			text="You hear to meet in a specific location for supplies...";
			secondText = "";
			thirdText = "";
			option1 = getImage("/imgs/"+"map.png");
			option2=getImage("/imgs/"+"xmark.png");
			if(chance ==0) {
				if(checkAvailable("map")) {
					//use map
					afterText = "You found lots of supplies!";
					//savedEnding=2;
					savedCont=true;
					
					Item food = new Item();
					food.dir=0;
					food.setName("food");
					Base.inventory.add(food);
					
					Item food2 = new Item();
					food2.dir=0;
					food2.setName("food");
					Base.inventory.add(food2);
					
					Item water = new Item();
					water.dir=0;
					water.setName("water");
					Base.inventory.add(water);
					
					Item gloves = new Item();
					gloves.dir=0;
					gloves.setName("gloves");
					Base.inventory.add(gloves);
					
					Item knife = new Item();
					knife.dir=0;
					knife.setName("knife");
					Base.inventory.add(knife);
					
					Item flashlight = new Item();
					flashlight.dir=0;
					flashlight.setName("flashlight");
					Base.inventory.add(flashlight);
					
					Item gas = new Item();
					gas.dir=0;
					gas.setName("gasoline");
					Base.inventory.add(gas);
				}else {
					JOptionPane.showMessageDialog(null, "No map in your inventory!",
				            "No Map", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				afterText = "Close enough...";
				//savedEnding=2;
				savedCont=true;
			}
		}else if(savedEnding ==2&& checkAvailable("radio")) {
			option1 = getImage("/imgs/"+"cloth.png");
			option2 = getImage("/imgs/"+"gloves.png");
			text="You're thinking about decorating the outside ";
			secondText = "to catch the attention of the army.";
			thirdText = "";
			if(chance ==0) {
				//use cloth
				
				if(checkAvailable("clothing")) {
					afterText = "♪";
					//savedEnding=3;
					savedCont=true;
					remove("clothing");
				}else {
					JOptionPane.showMessageDialog(null, "No cloth in your inventory!",
				            "No Cloth", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}else if(chance ==1) {
				
				if(checkAvailable("gloves")) {
					afterText = "♪";
					//savedEnding=3;
					savedCont=true;
					remove("gloves");
				}else {
					JOptionPane.showMessageDialog(null, "No gloves in your inventory!",
				            "No gloves", JOptionPane.WARNING_MESSAGE);
				}
			}
				
				else {
				afterText = "♪";
				//savedEnding=3;
			}
			
		}else if(savedEnding ==3&& checkAvailable("radio")) {
			text="You hear knocking on your door, open it?";
			option1=getImage("/imgs/"+"checkmark.png");
			option2=getImage("/imgs/"+"xmark.png");
			secondText = "";
			thirdText = "";
			if(chance ==0) {
				//yes
				//savedEnding=4;
				savedCont=true;
			}else { 
				afterText = "♪";
			}
		}else if(savedEnding==4){
			System.out.println("save end");
		}else {
			text = "Do you hear that too?";
			afterText = "♪";
			option1 = null;
			option2 = null;
		}
	}
	
	public void catEnding(int chance){
		if(catEnding==0) {
			text="You hear soft scratching on the basement door...";
			secondText=	"Could it be a cat needing help?";
			thirdText = "";
			if(chance ==0) {
				afterText ="You hear soft scratching in the walls now...";
				//catEnding=1;
				catCont=true;
			}else {
				afterText = "♪";
			}
		}else if(catEnding ==1) {
			text="You noticed another cat outside...";
			secondText = "";
			thirdText = "";
			if(chance ==0) {
				afterText = "MORE CATS!";
				//catEnding=2;
				catCont=true;
			}else {
				afterText = "It walked in anyway...right?";
				//catEnding=2;
				catCont=true;
			}
		}else if(catEnding ==2) {
			text="You see a hoard of cats outside!";
			secondText = "";
			thirdText = "";
				afterText = "They're living in the drywall...";
				//catEnding=3;
				catCont=true;
		}else if(catEnding ==3) {
			text="Everything you see is cats, ";
			secondText = "you aren't sure what to do...";
			thirdText = "";
			//catEnding=4;
			catCont=true;
		}else {
			System.out.println("cat end");
		}
	}
	
	
	public void runEnding(int chance){
		if(runEnding==0) {
			text="You're bunker is feeling a little bit crowded,";
			secondText=	"Maybe its time to find a new place to call home?";
			thirdText = "";
			option1=getImage("/imgs/"+"map.png");
			if(chance ==0) {
				if(checkAvailable("map")) {
					afterText = "♪";
					//runEnding=1;
					runCont=true;
				}else {
					JOptionPane.showMessageDialog(null, "No map in your inventory!",
				            "No Map", JOptionPane.WARNING_MESSAGE);
				}
			}
			afterText = "♪";
		}else if(runEnding ==1) {
			text="Lets start building a vehicle to travel far!";
			secondText = "";
			thirdText = "";
			option1=getImage("/imgs/"+"generator.png");
			option2=getImage("/imgs/"+"gas.png");
			if(chance ==0) {
				
				
				if(checkAvailable("generator")) {
					afterText = "You feel a little confident";
					player.mentalScore+=10;
					//runEnding=2;
					runCont=true;
					remove("generator");
				}else {
					JOptionPane.showMessageDialog(null, "No generator in your inventory!",
				            "No Generator", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}else if(chance==1) {
				
				if(checkAvailable("gasoline")) {
					afterText = "You feel a little confident";
					player.mentalScore+=10;
					//runEnding=2;
					runCont=true;
					remove("gasoline");
				}else {
					JOptionPane.showMessageDialog(null, "No gas in your inventory!",
				            "No Gas", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			
			else {
				afterText = "♪";
				//runEnding=2;
			}
		}else if(runEnding ==2) {
			text="Make sure you are stocked up!";
			secondText = "";
			thirdText = "";
			option1=getImage("/imgs/"+"campbell.png");
			option2=getImage("/imgs/"+"water.png");
			if(chance==0) {
				
				if(checkAvailable("food")) {
					afterText = "♪";
					option1=null;
					remove("food");
				}else {
					JOptionPane.showMessageDialog(null, "No soup! Get some more!",
				            "No Soup", JOptionPane.WARNING_MESSAGE);
				}
			}else if(chance==1) {
				
				if(checkAvailable("water")) {
					afterText = "♪";
					option2=null;
					remove("water");
				}else {
					JOptionPane.showMessageDialog(null, "No water! Get some more!",
				            "No Water", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			
			if(option1 ==null || option2 ==null) {
				//runEnding=3;
				runCont=true;
			}
		}else if(runEnding==3) {
			text="Ready to leave?";
			secondText = "";
			thirdText = "";
			option1=getImage("/imgs/"+"cloth.png");
			option2=getImage("/imgs/"+"cat.png");
			
			if(chance==0) {
				
				if(checkAvailable("clothing")) {
					afterText = "♪";
					//runEnding=4;
					runCont=true;
					remove("clothing");
				}else {
					JOptionPane.showMessageDialog(null, "No clothes in inventory!",
				            "No Cloth", JOptionPane.WARNING_MESSAGE);
				}
			}else if(chance==1) {
				
				if(checkAvailable("familyphotos")) {
					afterText = "♪";
					//runEnding=4;
					runCont=true;
					remove("familyphotos");
				}else {
					JOptionPane.showMessageDialog(null, "No cat pics in inventory!",
				            "No cat pics", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			afterText = "♪";
			
		}else {
			System.out.println("save end");
		}
	}
	
	

	public boolean isSavedCont() {
		return savedCont;
	}



	public void setSavedCont(boolean savedCont) {
		this.savedCont = savedCont;
	}



	public boolean isCatCont() {
		return catCont;
	}



	public void setCatCont(boolean catCont) {
		this.catCont = catCont;
	}



	public boolean isRunCont() {
		return runCont;
	}



	public void setRunCont(boolean runCont) {
		this.runCont = runCont;
	}



	public void robbers1(int chance) {
		text = "You hear someone trying to sell soup and supplies";
		secondText = "to you from outside, open the door?";
		thirdText = "";
		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
		if(chance ==0) {
			afterText = "You got robbed lol";
			if(Base.inventory.size()>0) {
				Base.inventory.remove(0);
			}else {
				player.setHealthScore(player.getHealthScore()-10);
			}
		}else {
			afterText = "Close call...";
		}
	}
	
	public void robbers2(int chance) {
		text = "Someone's knocking on the door, saying FBI open up";
		secondText = "open the door?";
		thirdText = "";
		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
		if(chance ==0) {
			if(Base.inventory.size()>0) {
				Base.inventory.remove(0);
			}else {
				player.setHealthScore(player.getHealthScore()-10);
			}
			
			afterText = "You got robbed lol";
		}else {
			afterText = "Congrats you're not stupid";
		}
	}
	
	public void freeFood(int chance) {
		text = "You remember you had some soup in the attic" ;
		secondText="should you try to get it?";
		thirdText = "";
		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
		if(chance ==0) {
			afterText = "MORE SOUP!!!!!!";
			Item food = new Item();
			food.dir=0;
			food.setName("food");
			Base.inventory.add(food);
		}else {
			afterText = "♪";
		}
	}
	
	public void freeWater(int chance) {
		text = "You remember you left some water near the door,";
		secondText="should you try to get it?";
		thirdText = "";
		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
		if(chance ==0) {
			afterText = "MORE WATER!!!!!!!";
			Item water = new Item();
			water.dir=1;
			water.setName("water");
			Base.inventory.add(water);
		}else {
			afterText = "♪";
		}
	}
	
	public void freeStuff(int chance) {
		text = "You notice a closed box in the corner,";
		secondText="should you open it?";
		thirdText = "";
		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
		if(chance ==0) {
			afterText = "FREE STUFF!";
			Item aid = new Item();
			aid.dir=0;
			aid.setName("firstaidkit");
			Base.inventory.add(aid);
		}else {
			afterText = "♪";
		}
	}
	public void infestation(int chance) {
	    text = "There is an infestation of rats, what to do?";
	    secondText = "";
	    thirdText = "";
	    option1 = getImage("/imgs/" + "knife.png");
	    option2 = getImage("/imgs/" + "xmark.png");

	    if (chance == 0) {
	        if (checkAvailable("knife")) {
	            afterText = "♪";
	            remove("knife");
	        } else {
	            JOptionPane.showMessageDialog(null, "No knife in your inventory!",
	                    "No Knife", JOptionPane.WARNING_MESSAGE);
	        }
	        // picked something
	    } else {
	        if (!player.isIllScoreDecreased()) {
	            int temp = player.getIllScore() - 20;
	            player.setIllScore(temp);
	            player.setIllScoreDecreased(true);
	            System.out.println(player.getIllScore());
	        }
	        afterText = "Crazy? I Was Crazy Once";
	    }
	}

	
	public void scammer(int chance) {
		text = "Someone is knocking on the door ";
		secondText = "offering 100 soup cans for any free item!";
		thirdText = "";
		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
		if(chance ==0) {
			afterText = "You got scammed lol";
			Base.inventory.clear();
		}else {
			afterText = "♪";
		}
	}
	
	
	
	public void redHerring(int chance) {
		text = "There's a big commotion out on the street,";
		secondText = "Maybe someone found help? Or getting attacked?";
		thirdText = "";
		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
		if(chance ==0) {
			afterText = "You got beat up!";
			statChange = -30;
			player.healthScore-=30;
		}else {
			afterText = "They were definetly getting killed ¯\\_(ツ)_//¯";
		}
	}
	
	
	
	public void sick(int chance) {
	    text = "You feel a little soreness in your throat";
	    secondText = "It's probably just the flu.";
	    thirdText = "";
	    option1 = getImage("/imgs/" + "aid.png");
	    option2 = getImage("/imgs/" + "soap.png");
	    
	    if (chance == 0) {
	        if (checkAvailable("firstaidkit")) {
	            afterText = "You feel a lot better!";
	            statChange = 20;
	            player.illScore += 20;
	            player.setIllScoreDecreased(false);  // Reset the flag
	            remove("firstaidkit");
	        } else {
	            JOptionPane.showMessageDialog(null, "No aid in your inventory!",
	                    "No Aid", JOptionPane.WARNING_MESSAGE);
	        }
	    } else if (chance == 1) {
	        if (checkAvailable("soap")) {
	            afterText = "You feel a lot better!";
	            statChange = 20;
	            player.illScore += 20;
	            player.setIllScoreDecreased(false);  // Reset the flag
	            remove("soap");
	        } else {
	            JOptionPane.showMessageDialog(null, "No soap in your inventory!",
	                    "No Soap", JOptionPane.WARNING_MESSAGE);
	        }
	    } else {
	        if (!player.isIllScoreDecreased()) {
	            afterText = "*Cough Cough*";
	            statChange = -10;
	            player.setIllScore(player.getIllScore() - 10);
	            player.setIllScoreDecreased(true);  // Set the flag
	        } else {
	            afterText = "*Cough Cough*";
	            statChange = 0;  
	        }
	    }
	}

	
	
	public void wounded(int chance){
		text = "You found a pretty bad gash on your back";
		secondText = "what should you do?";
		thirdText = "";
		option1=getImage("/imgs/"+"aid.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
		if(chance ==0) {
			
			if(checkAvailable("firstaidkit")) {
				afterText = "It worked!";
				statChange = 10;
				player.healthScore+=10;
				
				remove("firstaidkit");
			}else {
				JOptionPane.showMessageDialog(null, "No aid in your inventory!",
			            "No Aid", JOptionPane.WARNING_MESSAGE);
			}
			
		}else {
			
			if (!player.isHealthScoreDecreased()) {
				afterText = "Fine, right...";
				statChange = -10;
	            player.setHealthScore(player.getHealthScore() - 10);
	            player.setHealthScoreDecreased(true);  
	        } else {
	        	afterText = "Fine, right...";
	            statChange = 0;  
	        }
		}
		
		//first aid
	}

	public void blackHole(int chance ) {
		text = "You've noticed an opening in the back";
		secondText="You think it's calling for your name!";
		thirdText ="Reach for it?";
		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
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
		text = "You remember that your neighbor had soups,";
		secondText ="Sharing is caring, right?";
		thirdText = "";
		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
		if(chance ==0) {
			
			int random = (int)(Math.random())*2;
			if(random==0) {
				afterText = "You got beat up!";
				statChange = -30;
				player.healthScore-=statChange;
			}else {
				afterText = "You got free food!";
				Item food = new Item();
				food.dir=0;
				food.setName("food");
				Base.inventory.add(food);
				
				Item food2 = new Item();
				food2.dir=0;
				food2.setName("food");
				Base.inventory.add(food2);
			}
			
		}else {
			afterText = "♪";
		}
		
		// y/n
	}
	
	public void sanityHelp(int chance){
		text = "You've been spending your past time starring at walls.";
		secondText = "Maybe its time to do something interesting...";
		thirdText = "";
		option1 = getImage("/imgs/"+"book.png"); 
		option2 = getImage("/imgs/"+"knife.png"); 
		if(chance ==0) {
			if(checkAvailable("boyscoutbook")) {
				afterText = "You feel a little better about your situation!";
				// use boy scout book
				
				statChange = 20;
				player.mentalScore+=statChange;
				remove("boyscoutbook");
			}else {
				JOptionPane.showMessageDialog(null, "No book in your inventory!",
			            "No Book", JOptionPane.WARNING_MESSAGE);
			}
		}else if(chance ==1){
			if(checkAvailable("knife")) {
				afterText = "You feel a little better about your situation!";
				// knife
				
				statChange = 25;
				player.mentalScore+=statChange;
				remove("knife");
			}else {
				JOptionPane.showMessageDialog(null, "No knife in your inventory!",
			            "No Knife", JOptionPane.WARNING_MESSAGE);
			}
		}else {
			afterText = "♪";
		}
	}
	
	

	public void nothing1(){
		text = "You really miss your dog, Peanuts.";
		secondText = "Maybe he'll come back...";
		thirdText = "";
		afterText = "♪";

		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
		
	}
	
	public void nothing2(){
		text = "How much wood could a woodchuck chuck, ";
		secondText ="if a woodchuck could chuck wood.";
		thirdText = "";
		afterText = "♪";

		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
	}
	
	public void nothing3(){
		text = "Do you hear that too?";
		secondText = "";
		thirdText = "";
		afterText = "♪";

		option1=getImage("/imgs/"+"checkmark.png"); 
		option2=getImage("/imgs/"+"xmark.png"); 
	}
	
	
	public static boolean checkAvailable(String itemName) {
	    for (int i = 0; i < Base.inventory.size(); i++) {
	        if (Base.inventory.get(i).getName().equalsIgnoreCase(itemName)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	
	public static void remove(String itemName) {
	    for (int i = 0; i < Base.inventory.size(); i++) {
	        if (Base.inventory.get(i).getName().equalsIgnoreCase(itemName)) {
	            Base.inventory.remove(i);
	        }
	    }
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


