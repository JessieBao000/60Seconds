
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Event implements MouseListener, KeyListener,Icon, Serializable, Accessible{

	private Image soup,water,aid,shelter,cloth,knife,flashlight,
	 				radio,gas,soap,map,gloves,family,generator,book, notebook, arrow; 
	private String name;
	private AffineTransform tx, tx2,tx3;
	private Image glow;
	public int dir=0;
	public int maxDir=15;
	int width, height;
	int x, y,arrowX,arrowY, itemX, itemY, item2X, item2Y;				
	double scaleWidth = 0.3;		
	double scaleHeight = 0.3;
	double scaleWidth2 = 0.2;		
	double scaleHeight2 = 0.2;
	private boolean mouseOver = false;
	private String text="Would you like to use any materials today? (Press C for Char stats)";
	Player player;
	ArrayList<Double> itemPercent;
	ImageIcon imageIcon;
	
	static Timer tick;
	int sec = 3;
	
	public Event(Player player) {
		
		this.player = player;
		
		imageIcon = new ImageIcon("ashbaby.jpg");
		
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
		
		width = 100;
		height = 100;
		x = 500;
		y = 0;
		arrowX = 700;
		arrowY = 480;
		itemX = 250;
		itemY = 400;
		
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		tx2 = AffineTransform.getTranslateInstance(0, 0);
		tx3 = AffineTransform.getTranslateInstance(0, 0);
		
		itemPercent = new ArrayList<>(Arrays.asList(10.0, 10.0, 10.0, 0.0, 8.0, 8.0, 8.0, 7.0, 5.0, 7.0, 7.0, 2.0, 8.0));

		ArrayList<Double> adjustedPercentages = adjustPercentages(itemPercent, Base.disaster);
		itemPercent = adjustedPercentages;
		//init(x, y); 
		
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
		
		
		switch(dir) {
			case 0:
				g2.drawString(text, 300, 100);
				g2.drawImage(soup, itemX, itemY, 80, 110, null);
				break;
			case 1:
				text = "Do you want to explore today?";
				g2.drawString(text, 300, 100);
				g2.drawString("Press Y for Yes!", 250, 400);
				g2.drawString("Press N for No!", 400, 400);
			case 2:
				text = "Do you want to explore today?";
				g2.drawString(text, 300, 100);
				g2.drawString("Press Y for Yes!", 250, 400);
				g2.drawString("Press N for No!", 400, 400);
		}

		//g2.drawRect(x, y, width, height)
		
	

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public static String pickItem(ArrayList<Double> adjustedPercentages) {
		ArrayList<Double> totalPercent = new ArrayList<>();
        double totalSum = 0;
        
        for (double percentage : adjustedPercentages) {
            totalSum += percentage;
            totalPercent.add(totalSum);
        }
        double random = Math.random()*100;
        
        for (int i = 0; i < totalPercent.size(); i++) {
            if (random <= totalPercent.get(i)) {
                //if (i == totalPercent.size() - totalSum) {
                //    return "Nothing";
               // } else {
                    return "Item " + (i + 1) +" " + adjustedPercentages.get(i);
               // }
            }//return "Nothing";
        }
        
        return "Nothing"; 
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
		System.out.println("click");
		if(arrowRect.intersects(mRect)) {
			dir = 1;
		}
		
		Item soup = new Item();
		soup.dir=0;
		if(mRect.intersects(soupRect)) {
			
			ArrayList<Item> temp = Base.inventory;
			for(Item item : temp) {
				if(item.getName().equals("food")) {
					if(player.getHungerScore()<100) {
						statsPopup();
						player.setHungerScore(player.getHungerScore()+8);
						Base.player = this.player;
					}else {
						JOptionPane.showMessageDialog(null, "You're already full!",
								"Too Full!", JOptionPane.INFORMATION_MESSAGE);
					}
				}
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
		//78-n 89-y 
		switch(e.getKeyCode()) {
			case 78:
				dir=2;
				break;
			case 89 :
				showWindow();
				
				
				break;
		}
		
	}
	
	
	
    private void showWindow() {
        // Create the first window with a picture
        JFrame firstWindow = new JFrame("First Window");
        firstWindow.setSize(300, 300);

        // Add a picture to the first window
        JPanel panel = new JPanel();
        JLabel picLabel = new JLabel(imageIcon);
        panel.add(picLabel);
        firstWindow.add(panel);

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

                String first = pickItem(itemPercent);
                String second = pickItem(itemPercent);
                String third = pickItem(itemPercent);
                JFrame found=new JFrame("hi");
                if(first.equals("Nothing")&& second.equals("Nothing")&&third.equals("Nothing")) {
                	found = new JFrame("Absolutely Nothing lool");
                	System.out.println("out here in the HELPPPP HEEELLPPPPPP");
                }
                // Create the second window
                JFrame secondWindow = new JFrame("Second Window");
                secondWindow.setSize(300, 300);
                //secondWindow.add(found);
                secondWindow.setDefaultCloseOperation(secondWindow.DISPOSE_ON_CLOSE);
                secondWindow.setLocationRelativeTo(null);
                secondWindow.setVisible(true);
            }
        };

        // Create and start the timer for 3 seconds (3000 milliseconds)
        tick = new Timer(3000, taskPerformer);
        tick.start();
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
}


