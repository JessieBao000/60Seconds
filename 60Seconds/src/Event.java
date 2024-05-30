
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;


public class Event implements MouseListener, KeyListener,Icon, Serializable, Accessible{

	private Image soup,water,aid,shelter,cloth,knife,flashlight,
	 				radio,gas,soap,map,gloves,family,generator,book, notebook, arrow, check, xmark; 
	private String name;
	private AffineTransform tx, tx2,tx3;
	private Image glow;
	public int dir=0;
	public int maxDir=15;
	int width, height;
	int x, y,arrowX,arrowY, itemX, itemY, item2X, item2Y, item3X, item3Y;				
	double scaleWidth = 0.3;		
	double scaleHeight = 0.3;
	double scaleWidth2 = 0.2;		
	double scaleHeight2 = 0.2;
	private boolean mouseOver = false;
	
	public String text="Would you like to use any materials today?";
	public String secondText = "";
	public String thirdText = "";
	
	public Image option1,option2;
	public static Player player;
	ArrayList<Double> itemPercent;
	ImageIcon imageIcon;
	
	Randomized randomed;
	public int chance;
	String afterText;
	int randomInt;
	
	static Timer tick;
	int sec = 3;
	
	Font font;
	
	
	public Event(String name, Player player) {
		
		
		this.player = player;
		this.name=name;
		
		
	    imageIcon = new ImageIcon();
		
		soup 	= getImage("/imgs/"+"campbell.png"); 
		water 	= getImage("/imgs/"+"water.png"); 
		aid 	= getImage("/imgs/"+"aid.png"); 
		shelter = getImage("/imgs/"+"water.png"); 
		cloth 	= getImage("/imgs/"+"cloth.png"); 
		knife 	= getImage("/imgs/"+"knife.png"); 
		flashlight 	= getImage("/imgs/"+"flashlight.png"); 
		radio 	= getImage("/imgs/"+"radio.png"); 
		gas 	= getImage("/imgs/"+"gas.png"); 
		soap 	= getImage("/imgs/"+"soap.png"); 
		map 	= getImage("/imgs/"+"map.png"); 
		gloves 	= getImage("/imgs/"+"gloves.png"); 
		family 	= getImage("/imgs/"+"cat.png"); 
		generator 	= getImage("/imgs/"+"generator.png"); 
		book 	= getImage("/imgs/"+"book.png"); 
		glow = getImage("/imgs/"+"glow.png");
		notebook = getImage("/imgs/"+"notebook.png");
		arrow = getImage("/imgs/"+"arrow.png");
		check = getImage("/imgs/"+"checkmark.png");
		xmark = getImage("/imgs/"+"xmark.png");
		
		option1=getImage("/imgs/"+"checkmark.png");
		option2=getImage("/imgs/"+"xmark.png");
		
		width = 100;
		height = 100;
		x = 500;
		y = 0;
		arrowX = 700;
		arrowY = 480;
		
		//SOUP
		itemX = 290;
		itemY = 400;
		
		//WATER
		item2X = 430;
		item2Y = 400;
		
		//AID
		item3X = 530;
		item3Y = 400;
		
		randomInt=18;
		 //chance = (int) (Math.random() * randomInt);
		chance = 17;
		randomed = new Randomized(Base.inventory);
		afterText = "♪";
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		tx2 = AffineTransform.getTranslateInstance(0, 0);
		tx3 = AffineTransform.getTranslateInstance(0, 0);
		
		itemPercent = new ArrayList<>(Arrays.asList(10.0, 10.0, 10.0, 0.0, 8.0, 8.0, 8.0, 7.0, 5.0, 7.0, 7.0, 2.0, 8.0));

		ArrayList<Double> adjustedPercentages = adjustPercentages(itemPercent, Base.disaster);
		itemPercent = adjustedPercentages;
		//init(x, y); 
		
		
//		try {
//		    //create the font to use. Specify the size!
//		    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts\\whoaskssatan.ttf")).deriveFont(12f);
//		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		    //register the font
//		    ge.registerFont(customFont);
//		} catch (IOException e) {
//		    e.printStackTrace();
//		} catch(FontFormatException e) {
//		    e.printStackTrace();
//		}
		
		font = new Font ("Courier New", 1, 20);
		
		
		
		
	}

	public int getRandomInt() {
		return randomInt;
	}

	public void setRandomInt(int randomInt) {
		this.randomInt = randomInt;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		//init2(x,y);
		g2.drawImage(notebook, 200, 0, 500,600, null);
		g2.drawImage(arrow, arrowX, arrowY, arrow.getWidth(null), arrow.getHeight(null), null);
		g2.setFont(font);
		
		switch(dir) {
			case 0:
				g2.drawString("Would you like to use any materials today?", 300, 200);
				g2.drawImage(soup, itemX, itemY, 80, 110, null);
				g2.drawImage(water, item2X, item2Y, 70, 130, null);
				g2.drawImage(aid, item3X, item3Y, 90, 90, null);
				break;
			case 1:
				text = "Do you want to explore today?";
				g2.drawString(text, 300, 200);
				g2.drawImage(check, itemX, itemY, 80, 80, null);
				g2.drawImage(xmark, item3X, item3Y, 80, 80, null);
				break;
			case 3:
				randomize(2, chance);
				text = randomed.getText();
				secondText = randomed.getSecondText();
				thirdText = randomed.getThirdText();
				g2.drawString(text, 300, 200);
				g2.drawString(secondText, 300, 250);
				g2.drawString(thirdText, 300, 300);
				g2.drawImage(option1, itemX, itemY, 80, 80, null);
				g2.drawImage(option2, item3X, item3Y, 80, 80, null);
				break;
			case 2:
				g2.drawString(afterText, 300, 200);
				break;
			case 4:
				g2.drawString("Press the arrow to continue", 300, 200);
		}

		//g2.drawRect(x, y, width, height)
		
	

	}
	
	


	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.55, 0.55);
	}
	
	public boolean collided(int x, int y, int width, int height) {
		Rectangle otherObject = new Rectangle(x-15,y-20,width,height);
		Rectangle thisObject = new Rectangle(this.x,this.y,this.width,this.height);
		return otherObject.intersects(thisObject);
	}
	
	
	
	private void init2(double a, double b) {
		tx2.setToTranslation(a, b);
		tx2.scale(0.5, 0.5);
	}
	
	private void init3(double a, double b) {
		tx3.setToTranslation(a, b);
		tx3.scale(0.4, 0.4);
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
	
	
	
	public void randomize(int i, int chance) {
		switch(chance) {
			case 0:
				randomed.savedEnding(i);
				break;
			case 1:
				randomed.catEnding(i);
				break;
			case 2: 
				randomed.runEnding(i);
				break;
			case 3:
				randomed.robbers1(i);
				break;
			case 4:
				randomed.robbers2(i);
				break;
			case 5:
				randomed.freeFood(i);
				break;
			case 6:
				randomed.freeWater(i);
				break;
			case 7:
				randomed.freeStuff(i);
				break;
			case 8:
				randomed.infestation(i);
				break;
			case 9:
				randomed.scammer(i);
				break;
			case 10:
				randomed.redHerring(i);
				break;
			case 11: 
				randomed.sick(i);
				break;
			case 12:
				randomed.blackHole(i);
				break;
			case 13:
				randomed.lootNeighbor(i);
				break;
			case 14:
				randomed.sanityHelp(i);
				break;
			case 15:
				randomed.nothing1();
				break;
			case 16:
				randomed.nothing2();
				break;
			case 17:
				randomed.nothing3();
				break;
		}
		
		if (option1 == null || option2 == null) {
            option1=null;
            option2=null;
            System.out.println("all null");
            ///repaint();
        } else {
            option1= randomed.getOption1();
            option2 = randomed.getOption2();
            System.out.println("hihihih");
        }
	}
	
	public static ArrayList<Double> adjustPercentages(ArrayList<Double> percentages, int dangerScore) {
		ArrayList<Double> adjusted = new ArrayList<>();
        int sum = percentages.stream().mapToInt(Double::intValue).sum();

        double adjustmentFactor = 1 + (dangerScore / 10.0);
        double adjustedSum = 0;

        for (double percent : percentages) {
            double adjustedPercent = percent / adjustmentFactor;
            adjusted.add(adjustedPercent);
            adjustedSum += adjustedPercent;
        }

        double nothing = 100.0 - adjustedSum;
//        for (int i = 0; i < adjusted.size(); i++) {
//            adjusted.set(i, (adjusted.get(i) / totalAdjustment) * 100);
//        }
        
        //adjusted.add(nothing);

        return adjusted;
    }
	
	/*
	 * 
	 * 	PICK ITEM BASED ON PERCENTAGES
	 *
	 */
	public static Item pickItem(ArrayList<Double> adjustedPercentages) {
	    ArrayList<Double> totalPercent = new ArrayList<>();
	    double totalSum = 0;

	    // Create cumulative percentage list
	    for (double percentage : adjustedPercentages) {
	        totalSum += percentage;
	        totalPercent.add(totalSum);
	    }

	    // Adjust the range of the random number to the total sum of percentages
	    double random = Math.random() * 100;
	    System.out.println("Random number: " + random);  // For debugging

	    // Find the corresponding item
	    for (int i = 0; i < totalPercent.size(); i++) {
	        if (random <= totalPercent.get(i)) {
	        	System.out.println("got it boss");
	            Item temp = new Item();
	            int dir=i;
	            if(i>=3) {
	            	dir+=1;
	            }
	            temp.setDir(dir);
	            System.out.println(temp.dir);
	            System.out.println(temp.name);
	            return temp;
	        }
	    }

	    return null;
	}

	
	
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Map f = new Map();
	}
	
	
	public void mouseEntered(MouseEvent e) {
       //if(collided(e.getX(), e.getY(), 15, 15)) {
	//		mouseOver = true;
	      // System.out.println("cmon do something");
   //    }
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // mouseOver = false;
    }

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		Rectangle arrowRect = new Rectangle(arrowX, arrowY, arrow.getWidth(null),arrow.getHeight(null));
		Rectangle mRect = new Rectangle(m.getX(),m.getY(),1,1);
		Rectangle soupRect = new Rectangle(itemX,itemY,80,110);
		Rectangle waterRect = new Rectangle(item2X,item2Y,70,130);
		Rectangle aidRect = new Rectangle(item3X,item3Y,90,90);
		Rectangle checkRect = new Rectangle(itemX,itemY,80,80);
		Rectangle xRect = new Rectangle(item3X,item3Y,80,80);
		Rectangle oneRect = new Rectangle(itemX,itemY,80,80);
		Rectangle twoRect = new Rectangle(item3X,item3Y,80,80);
		System.out.println("click");
		if(arrowRect.intersects(mRect)) {
			if(dir==1 && afterText.equals("♪")) {
				dir=2;
			}
			if(dir==2) {
				//chance = (int) (Math.random() * randomInt);
			}
			dir +=1;
		}
		
		//SOUP
		Item soup = new Item();
		soup.dir=0;
		if(mRect.intersects(soupRect)&&dir==0&& Base.eventOpen) {
			
			ArrayList<Item> inventory = Base.inventory;
			Iterator<Item> iterator = inventory.iterator();

			
			boolean foodFound = false;

			while (iterator.hasNext()) {
			    Item item = iterator.next();
			    if (item.getName().equals("food")) {
			        foodFound = true;
			        if (player.getHungerScore() < 100) {
			            statsPopup();
			            player.setHungerScore(player.getHungerScore() + 8);
			            Base.player = this.player;
			            iterator.remove();  // Safely remove the item from the inventory
			        } else {
			            JOptionPane.showMessageDialog(null, "You're already full!",
			                    "Too Full!", JOptionPane.INFORMATION_MESSAGE);
			        }
			        break;  
			    }
			}

			if (!foodFound) {
			    JOptionPane.showMessageDialog(null, "No soup in your inventory!",
			            "No Soup", JOptionPane.WARNING_MESSAGE);
			}


			
		}
		
		
		//WATER
		Item water = new Item();
		water.dir=1;
		if(mRect.intersects(waterRect)&&dir==0) {
			
			ArrayList<Item> inventory = Base.inventory;
			Iterator<Item> iterator = inventory.iterator();

			
			boolean waterFound = false;
			while (iterator.hasNext()&& dir==0 &&Base.eventOpen) {
			    Item item = iterator.next();
			    if (item.getName().equals("water")) {
			    	waterFound = true;
			        if (player.getHungerScore() < 100) {
			            statsPopup();
			            player.setHungerScore(player.getHungerScore() + 8);
			            Base.player = this.player;
			            iterator.remove();  
			        } else {
			            JOptionPane.showMessageDialog(null, "You're already quenched!",
			                    "Too Quenched!", JOptionPane.INFORMATION_MESSAGE);
			        }
			        break;  
			    }
			}
			
			if (!waterFound) {
			    JOptionPane.showMessageDialog(null, "No water in your inventory!",
			            "No Water", JOptionPane.WARNING_MESSAGE);
			}

			
		}
		
		
		
		//AID
				Item aid = new Item();
				aid.dir=2;
				if(mRect.intersects(aidRect)&& dir==0&&Base.eventOpen) {
					
					ArrayList<Item> inventory = Base.inventory;
					Iterator<Item> iterator = inventory.iterator();

					
					boolean aidFound = false;
					while (iterator.hasNext()) {
					    Item item = iterator.next();
					    if (item.getName().equals("aid")) {
					        if (player.getHealthScore() < 100) {
					            statsPopup();
					            player.setHungerScore(player.getHealthScore() + 8);
					            if(player.getIllScore()<100) {
					            	player.setIllScore(player.getIllScore() + 8);
					            }
					            Base.player = this.player;
					            iterator.remove();  
					        } else {
					            JOptionPane.showMessageDialog(null, "You're already healed!",
					                    "Too Healed!", JOptionPane.INFORMATION_MESSAGE);
					        }
					        break;  
					    }
					}
					
					if (!aidFound) {
					    JOptionPane.showMessageDialog(null, "No aid in your inventory!",
					            "No Aid", JOptionPane.WARNING_MESSAGE);
					}

					
				}
		
				
				if(dir==1) {
					if(mRect.intersects(xRect)) {
						if(dir==1 && afterText.equals("♪")) {
							dir=2;
						}
						dir+=1;
					}
					
					if(mRect.intersects(checkRect)) {
						showWindow();
						if(dir==1 && afterText.equals("♪")) {
							dir=2;
						}
						dir+=1;
					}
				}
				
				
				if (dir == 3) {
					if(mRect.intersects(oneRect)) {
						randomize(0, chance);
		                afterText=randomed.getAfterText();
						dir+=1;
					}
					
					if(mRect.intersects(twoRect)) {
		                randomize(1, chance);
		                afterText=randomed.getAfterText();

		                dir+=1;
		            }
	            } 
		
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }
    
	public void statsPopup() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Stat Increased!",
				"Well Done!", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    
	    switch (keyCode) {
	        case KeyEvent.VK_N:
	            // Handle the 'N' key press
	            dir += 1;
	            break;
	        case KeyEvent.VK_Y:
	            if (dir == 1) {
	                showWindow();
	            }
	            dir+=1;
	            break;
	        case KeyEvent.VK_1:
	            if (dir == 3) {
	                randomize(0, chance);
	                afterText=randomed.getAfterText();
	            } else {
	                randomize(1, chance);
	                afterText=randomed.getAfterText();
	            }
	            break;
	    }
	}

	
	
	
	private void showWindow() {
	    // Create the first window with a picture
	    JFrame firstWindow = new JFrame("First Window");
	    firstWindow.setSize(300, 300);

	    // Add a picture to the first window
	    JPanel panel = new JPanel();
	    
	    // Debug statement to check which image is being selected
	    System.out.println("Event name: " + name);

	    if(name.equals("earthquake")) {
	        imageIcon = new ImageIcon(getClass().getResource("/imgs/clownface.png"));
	        System.out.println("Loading clownface.png");
	    } else if(name.equals("volcano")) {
	        imageIcon = new ImageIcon(getClass().getResource("/imgs/cat.png"));
	        System.out.println("Loading cat.png");
	    } else if(name.equals("bomb")) {
	        imageIcon = new ImageIcon(getClass().getResource("/imgs/ashbaby.jpg"));
	        System.out.println("Loading ashbaby.jpg");
	    }

	    // Check if the image was loaded successfully
	    if(imageIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
	        System.out.println("Image not loaded.");
	    } else {
	        JLabel picLabel = new JLabel(imageIcon);
	        panel.add(picLabel);
	        firstWindow.add(panel);
	    }

	    // Center the window
	    firstWindow.setLocationRelativeTo(null);
	    firstWindow.setVisible(true);

	    // Create an ActionListener for the timer
	    ActionListener taskPerformer = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            // Stop the timer
	            tick.stop();

	            // Close the first window
	            firstWindow.dispose();

	            // Pick items
	            Item first = pickItem(itemPercent);
	            Item second = pickItem(itemPercent);
	            Item third = pickItem(itemPercent);

	            // Create the second window
	            JFrame secondWindow = new JFrame("Second Window");
	            secondWindow.setSize(300, 300);

	            // Display items if found
	            if (first != null || second != null || third != null) {
	                StringBuilder message = new StringBuilder("You found:");
	                if (first != null) {
	                    message.append(" ").append(first.getName());
	                    Base.inventory.add(first);
	                }
	                if (second != null) {
	                    message.append(", ").append(second.getName());
	                    Base.inventory.add(second);
	                }
	                if (third != null) {
	                    message.append(", ").append(third.getName());
	                    Base.inventory.add(third);
	                }
	                JOptionPane.showMessageDialog(secondWindow, message.toString(), "Items Found", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                // Display "Absolutely Nothing" if no items found
	                JOptionPane.showMessageDialog(secondWindow, "Absolutely Nothing lol", "No Items Found", JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    };

	    // Create and start the timer for 3 seconds (3000 milliseconds)
	    tick = new Timer(3000, taskPerformer);
	    tick.start();
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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccessibleContext getAccessibleContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public String getAfterText() {
		return afterText;
	}

	public void setAfterText(String afterText) {
		this.afterText = afterText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Randomized getRandomed() {
		return randomed;
	}

	public void setRandomed(Randomized randomed) {
		this.randomed = randomed;
	}
}


