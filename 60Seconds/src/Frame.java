import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
//<<<<<<< HEAD
	
	
	
	Map map;
//<<<<<<< HEAD
	
//=======
	//Clock clock;

//>>>>>>> branch 'master' of https://github.com/JessieBao000/AP-CSA-Final.git
	static String state = "California";
	
	static HashMap dangers = new HashMap<String, State>();
	static HashMap itemsList = new HashMap<String, ItemsInfo>();
	JFrame f = new JFrame("60 Seconds");

	int disaster = 0;
	
    Item[] items;
	Item test;
	ArrayList<Item> inventory = new ArrayList<Item>();
	String inventoryString = "Inventory: 0/10";
	static Timer tick;
	static int sec = 60;
	int xx = 330,xy= 300,xw = 200,xh= 80; //restart button vals

	//Clock clock = new Clock();

	public void paint(Graphics g) {
		super.paintComponent(g);
		map.paint(g);
		
		//clock.paint(g);

//<<<<<<< HEAD
		
		//living
		if(map.getDir()==0) {
			items[7].paint(g);
			items[12].paint(g);
		}
		//garage
		if(map.getDir()==1) {
			items[2].paint(g);
//<<<<<<< HEAD
			items[8].paint(g);
			items[13].paint(g);
//=======
			
//>>>>>>> branch 'master' of https://github.com/JessieBao000/AP-CSA-Final.git
		}
		//stewie
		if(map.getDir()==2) {
			items[4].paint(g);
			items[14].paint(g);
		}
		//attic
		if(map.getDir()==3) {
			items[6].paint(g);
			items[10].paint(g);
			items[11].paint(g);
		}
		//kitchen
		if(map.getDir()==4) {
			items[0].paint(g);
			items[1].paint(g);
			items[5].paint(g);
			items[9].paint(g);
		}

		
//<<<<<<< HEAD
		
		Font myFont = new Font ("Courier New", 1, 50);
		g.setFont (myFont);
		g.setColor(Color.red);
    	g.drawString(Integer.toString(sec), 390, 50);
    	g.drawString(inventoryString, 390, 500);
    	g.drawRect(disaster, disaster, sec, disaster);
    	
    	//Lazy x & y cords for restart button

    	//END Screen
		if(map.getDir()==5) {
			g.setColor(Color.black);
	        g.fillRect(0,0,1000,1000);
			g.setColor(Color.pink);
	        g.drawString("you" + "won/lost", 390, 50);
	        g.fillRect(xx,xy,xw,xh);
			Font myf = new Font ("Courier New", 6, 30);
			g.setFont (myf);
			g.setColor(Color.white);
	        g.drawString("try again?" , 350, 340);

//wi, he
		}
 
//>>>>>>> branch 'master' of https://github.com/JessieBao000/AP-CSA-Final.git
	    

				
		
//=======
//<<<<<<< HEAD
		//clock.paint(g);
//=======
//>>>>>>> branch 'master' of https://github.com/JessieBao000/AP-CSA-Final.git

//>>>>>>> branch 'master' of https://github.com/JessieBao000/AP-CSA-Final.git
	}
//<<<<<<< HEAD
	
//		public static void main(String[] arg) {
		
		
//=======
	
	
	
	public static void main(String[] arg) throws Exception{
		
		
	        

//>>>>>>> branch 'master' of https://github.com/JessieBao000/AP-CSA-Final.git
		try {
			
			 ActionListener taskPerformer = new ActionListener() {

		            public void actionPerformed(ActionEvent evt) {
		                //...Perform a task...
			          //  tick(sec);
			          //  sec--;
		            }
		            			 
			 };
			 
			// tick = new Timer(1000, taskPerformer);
		//    tick.start();
		    
		    	
		
	
	    
	    
	    
	    
			Scanner scanner = new Scanner(new File("disasters.txt"));
			scanner.next();

			while(scanner.hasNext()) {
				String line = scanner.next();
				String s="";
				int earthquake = 0;
				int volcano=0;
				int bomb=0;
				
				//System.out.println(line);
				String[] arr= line.split(",",5);
				
				for(int i = 0; i<4;i++) {
					
					if(i==0) {
						s = arr[i].trim();
						s = s.toLowerCase();
						state = s;
					}else if(i==1) {
						earthquake = Integer.valueOf(arr[i]);
					}else if(i==2) {
						volcano = Integer.valueOf(arr[i]);
					}else if(i==3) {
						bomb = Integer.valueOf(arr[i]);
					}
					
				}
				
				
				State temp = new State(s, earthquake, volcano, bomb);
				//System.out.println(s + earthquake + volcano + bomb);
				dangers.put(s,temp);
				
				
				
			}
			
			scanner.close();
			
			
			
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		/*
		 * ITEMS HASHMAP
		 */
		try {
			
			
			Scanner scanner = new Scanner(new File("items.txt"));
			scanner.next();
			
			while(scanner.hasNext()) {
				String line = scanner.next();
				String n="";
				int hunger = 0;
				int saftey=0;
				int health=0;
				int sanity = 0;
				
				//System.out.println(line);
				String[] arr= line.split(",",6);
				
				for(int i = 0; i<5;i++) {
					
					if(i==0) {
						n = arr[i].trim();
						n = n.toLowerCase();
					}else if(i==1) {
						hunger = Integer.valueOf(arr[i]);
					}else if(i==2) {
						saftey = Integer.valueOf(arr[i]);
					}else if(i==3) {
						health = Integer.valueOf(arr[i]);
					}else if(i==4) {
						sanity = Integer.valueOf(arr[i]);
					}
					
				}
				
				
				ItemsInfo temp = new ItemsInfo(n, hunger, saftey, health, sanity);
				//System.out.println(s + earthquake + volcano + bomb);
				itemsList.put(n,temp);
				System.out.println(n);
				
				
				
				
			}
			
			scanner.close();
			
			
			
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		
	Frame f = new Frame();	
			
			

	 }
	
	
	public Frame() {
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.cyan);
		f.add(this);
		f.setResizable(false);
 		f.addMouseListener(this);
		f.addKeyListener(this);
		//f.setDefaultCloseOperation(WinndowConstans.EXIT on close);
		//f.add(clock);
		//f.setVisible(true);
		addMouseListener(this);
		addMouseMotionListener(this);


//<<<<<<< HEAD
		map = new Map();
		items = new Item[15];
		for(int i =0; i<items.length;i++) {
			Item a = new Item();
			a.setDir(i);
			items[i] = a;
		}
//=======
//>>>>>>> branch 'master' of https://github.com/JessieBao000/AP-CSA-Final.git

		map = new Map();

//<<<<<<< HEAD

//=======
		statePopup();
		
		openPopup();
		
//>>>>>>> branch 'master' of https://github.com/JessieBao000/AP-CSA-Final.git
//		
		
		//backgroundMusic.play();

	
		
		//the cursor image must be outside of the src folder
		//you will need to import a couple of classes to make it fully 
		//functional! use eclipse quick-fixes
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("placeholder.png").getImage(),
				new Point(0,0),"custom cursor"));	
		
		
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	

//=======
	public void statePopup() {
        // Show input dialog with a message and default value
        String userInput = JOptionPane.showInputDialog(
            null, 
            "Enter a United State:", 
            "User Input", 
            JOptionPane.QUESTION_MESSAGE
        );
		while ((userInput.equals(null) )|| userInput.isEmpty() || !dangers.containsKey(state)) {
       		
            System.out.println("Enter in a new state");
                   
            userInput = JOptionPane.showInputDialog(
                     null, 
                     "Enter a valid United State", 
                     "User Input", 
                     JOptionPane.QUESTION_MESSAGE
                );
            
           state = userInput.toLowerCase();
    		state = userInput.replace(" ", "");
           
       } 
       
       State temp = (State)(dangers.get(state));
  		System.out.println(state + temp.getEarthquake() + " " + temp.getVolcano() + " "+ temp.getBomb());
  		state = temp.getState();
    }
	

	
	
	public void openPopup() {
        // Show input dialog with a message and default value
		    /* Simple JOptionPane ShowOptionDialogJava example */    
		    String[] options = { "Earthquake", "Volcano", "Bomb" };
		    int selection = JOptionPane.showOptionDialog(null, "You have 60 seconds to gather supplies before a disaster, which one will happen?", "Disaster Struck!", 
		                                                      0, 3, null, options, options[0]);
		    if (selection == 0) {
		      disaster = 1;
		    }
		    if (selection == 1) { 
		    	disaster = 2;
		    }
		    if (selection == 2) { 
		    	disaster = 3;
		  }
		    
		    if (selection >= 0) {
	            disaster = selection + 1; // Adjust the disaster variable accordingly
	            ActionListener taskPerformer = new ActionListener() {
	                public void actionPerformed(ActionEvent evt) {
	                	if (sec == 0) {
	        	            System.out.println("complete");
	        	            tick.stop();
	        	            map.dir = 5;
	        	            // Add any additional actions upon completion of the timer
	        	        } else {
	        	            sec--; // Decrease by one every second
	        	            repaint(); // Update the display every second
	        	        }
	                }
	            };
	            tick = new Timer(1000, taskPerformer);
	            tick.start();
	        }
    }
	
	
	 

	
	

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		for(int i =0; i<items.length; i++) {
			if(items[i].collided(m.getX(), m.getY(),15,15)) {
					
				if(inventory.size()<10) {
					inventory.add(items[i]);
					items[i].setX(1000);;
					inventoryString = "Inventory: "+inventory.size()+"/10";
					repaint();
				}
				

			}
		}
		

		if(map.getDir()==5) {//Restart button
			if(((m.getX() >= (double)xx) && (m.getX() <= (double)(xx+xw))) && ((m.getY() >= (double)xy) && (m.getY() < (double)xy+xh))) {
			f.dispose();
			}
			

			}
			
		}
			
		
		
	

	@Override
	public void mouseEntered(MouseEvent m) {
		
		for(int i =0; i<items.length; i++) {
			if(items[i].collided(m.getX(), m.getY(),15,15)) {
					
				items[i].setMouseOver(true);
			}
		}
		
	/*	//living
				if(map.getDir()==0) {
					items[7].paint(g);
					items[12].paint(g);
				}
				//garage
				if(map.getDir()==1) {
					items[2].paint(g);
					items[8].paint(g);
					items[13].paint(g);
				}
				//stewie
				if(map.getDir()==2) {
					items[4].paint(g);
					items[14].paint(g);
				}
				//attic
				if(map.getDir()==3) {
					items[6].paint(g);
					items[10].paint(g);
					items[11].paint(g);
				}
				//kitchen
				if(map.getDir()==4) {
					items[0].paint(g);
					items[1].paint(g);
					items[5].paint(g);
					items[9].paint(g);
				}
		*/
	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub
		for(int i =0; i<items.length; i++) {
			if(items[i].collided(m.getX(), m.getY(),15,15)) {
					
				items[i].setMouseOver(false);
			}
		}
		
	}
	
	
	
	@Override
	   public void mouseDragged(MouseEvent e) {}
	   @Override
	   public void mouseMoved(MouseEvent e) {
	       for(Item i : items) {
	       	if(i.collided(e.getX(), e.getY(), 15, 15)) {
	       		i.setMouseOver(true);
	       	}else {
	       		i.setMouseOver(false);
	       	}
	       }
	      
	   }

	
//>>>>>>> branch 'master' of https://github.com/JessieBao000/AP-CSA-Final.git

	@Override
	public void mousePressed(MouseEvent m) {
		
	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		//87-w 65-a 83-s 68-d
		//37-left 38-up  39-right 40-down  
		
		
		
		switch(k.getKeyCode()){
			case 37: //left
				//map.dir=0;
				if(map.getDir()-1<0) {
					map.dir = map.maxDir;
				}else {
					map.dir = map.getDir()-1;
				}
				
				
				
				break;
				
			case 39: //right
				//map.dir=1;
				if(map.getDir()+1>map.maxDir) {
					map.dir = 0;
				}else {
					map.dir = map.getDir()+1;
				}
				
				break;
				
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	 public static void playSound(String soundFilePath) {
	        try {
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
	                    Frame.class.getClassLoader().getResourceAsStream("sounds/" + soundFilePath)
	            );

	            Clip clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.start();

	        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	
	
	 
	
	
}