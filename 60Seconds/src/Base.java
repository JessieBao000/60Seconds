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
	
	Map map;
	
	int day = 1;
	JButton button;
	static int disaster = 0;
	Player player;
	JFrame f = new JFrame("Survive!");


	ArrayList<Item> inventory = new ArrayList<Item>();
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		player.paint(g);
		button.paint(g);
		map.paint(g);
		}
 
	
	
	public static void main(String[] arg) throws Exception{
		
					
			

	 }
	
	
	public Base(int danger, ArrayList<Item> i) {
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

		disaster = danger;
		inventory = i;
		map = new Map();
		map.setDir(5);
		
		player = new Player();
		
		
		button = new JButton("Click Me");
        button.setBounds(10, 10, 100, 30); 
        button.addActionListener(this);
        add(button);
		
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
	   public void mouseDragged(MouseEvent e) {}
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