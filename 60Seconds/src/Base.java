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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Base extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
//<<<<<<< HEAD
	
	Map map= new Map();;
	
	int day = 1;
	JButton button;
	static int disaster = 0;
	Player player = new Player();
	JFrame f;
	
	
	static Timer tick;
	int sec = 1;
	boolean time = false;
	
	int sanityIncrease=0;
	ArrayList<Item> inventory = new ArrayList<Item>();
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//player.dir=3;
		//player.paint(g);
		map.dir=5;
		map.paint(g);
		
		
		
		Font myFont = new Font ("Courier New", 1, 50);
		g.setFont (myFont);
		g.setColor(Color.red);
    	g.drawString("Day "+day, 390, 50);
		}
 
	
	
	
	public static void main(String[] arg) throws Exception{
		
					
			

	 }
	
	
	public Base(int danger, ArrayList<Item> i) {
		
		
		 f=new JFrame("Button Example");  
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.cyan);
		f.add(this);
		f.setResizable(false);
 		f.addMouseListener(this);
		f.addKeyListener(this);
		//f.setDefaultCloseOperation(WinndowConstans.EXIT on close);
		//f.add(clock);
		f.setVisible(true);
		addMouseListener(this);
		addMouseMotionListener(this);

		disaster = danger;
		inventory = i;
		
		map.x=-1000;
		 
		
		
		
//		button=new JButton("Click Here");  
//		button.setBounds(50,100,95,30);  
//		f.add(button);  
//		f.setLayout(null);  
//		f.setVisible(true); 
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
	
	
	
	public void newDay() {
		while(map.getX()+ 900< 900) {
			map.setVx(1);
			map.x=map.getX()+map.getVx();
			map.paint(getGraphics());
			repaint();
			System.out.println(map.x);
		}
		
		System.out.println(map.x);
		map.setVx(0);
		map.setAx(0);
		map.x=0;
		time = false;
		if(!time) {
			 ActionListener taskPerformer = new ActionListener() {
	             public void actionPerformed(ActionEvent evt) {
	             	if (sec == 0) {
	             		System.out.println("time stop");
	     	            time = true;
	     	            tick.stop();
	     	            
	     	           while(time && map.getX()<= 1000) {
		     	  			map.setVx(1);
		     	  			map.setX(map.getX()+map.getVx());
		     	  			map.paint(getGraphics());
		     	  			repaint();
		     	  			
		     	  			System.out.println(map.x);
	     	           	}
	     	           updateDay(3,3,3,3);
		     	  		map.setVx(0);
		     	  		map.setAx(0);
		     	  		map.setX(-1000);
		     	  		time = false;
	             	} else {
	             		System.out.println("time go");
	     	            sec--; 
	     	        }
	             }
	         };
	         tick = new Timer(1000, taskPerformer);
	         tick.start();
		}
	}
	
	
	public void updateDay(int hunger, int sick, int health, int sanity) {
		day+=1;
		if(day%5==0) {
			sanityIncrease+=3;
			sanity+=sanityIncrease;
		}
		updateChar(hunger, health ,sick, sanity);
		repaint();
	}
	
	
	public void updateChar(int hunger, int sick, int health, int sanity) {
		player.setHungerScore(player.getHungerScore()-hunger);
		player.setIllScore(player.getIllScore()-sick);
		player.setHealthScore(player.getHealthScore()-health);
		player.setMentalScore(player.getMentalScore()-sanity);
		
		
		repaint();
	}
	
	
	public void moveBack() {
		
	}
	

	@Override
	public void mouseClicked(MouseEvent m) {
		
			
		}
			
		
	

	@Override
	public void mouseEntered(MouseEvent m) {
		
	}

	@Override
	public void mouseExited(MouseEvent m) {
		
	}
	
	
	
	@Override
	   public void mouseDragged(MouseEvent e) {
		
	}
	
	
	   @Override
	   public void mouseMoved(MouseEvent e) {
	     
	      
	   }

	
//>>>>>>> branch 'master' of https://github.com/JessieBao000/AP-CSA-Final.git

	@Override
	public void mousePressed(MouseEvent m) {
		
	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
        // Handle button click event here
        if (e.getSource() == button) {
            System.out.println("Button Clicked!");
            day+=1;
        }
        repaint();
    }

	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		//87-w 65-a 83-s 68-d
		//37-left 38-up  39-right 40-down  
		//89-y  78-n
		
		switch(k.getKeyCode()){
			case 78:
				newDay();
				System.out.println("n pressed");
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
	                    Base.class.getClassLoader().getResourceAsStream("sounds/" + soundFilePath)
	            );

	            Clip clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.start();

	        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	
	
	 
	
	
}