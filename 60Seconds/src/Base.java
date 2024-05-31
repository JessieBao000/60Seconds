import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Base extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener {

    Map map = new Map();
    int day = 1;
    String dayText;
    JButton button, statsButton, eventButton, inventoryButton;
    public static int disaster = 0;
    public static Player player = new Player();
    Event event;
    static boolean eventOpen;
    JFrame f;
    public static ArrayList<Double> itemPercent;
    ImageIcon clownIcon;
    static Timer tick;
    int sec = 1;
    boolean time = false;
    int sanityIncrease = 0;
    public String name;
    
    Image cat;
    
    JPanel buttonPanel;
    private boolean isDeadWindowShown = false;
    public static ArrayList<Item> inventory = new ArrayList<Item>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.paint(g);
        g.drawImage(cat, 300, 300, 70, 70, null);
        map.paint(g);
        if (eventOpen) {
            event.paint(g);
        }
        Font myFont = new Font("Courier New", Font.BOLD, 50);
        g.setFont(myFont);
        g.setColor(Color.red);
        g.drawString(dayText, 390, 50);
        
    }

    public static void main(String[] arg) throws Exception {
    }

    public Base(String name, int danger, ArrayList<Item> i) {
        f = new JFrame("Button Example");
        f.setSize(new Dimension(900, 700));
        f.setBackground(Color.cyan);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        
        this.name = name;
        clownIcon = new ImageIcon("clownface.png");

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 10)); 
        buttonPanel.setPreferredSize(new Dimension(150, 100)); 

        button = new JButton("Next Day");
        button.addActionListener(this);
        buttonPanel.add(button);

        statsButton = new JButton("Check Stats");
        statsButton.addActionListener(this);
        buttonPanel.add(statsButton);
        
        eventButton = new JButton("Check Notebook");
        eventButton.addActionListener(this);
        buttonPanel.add(eventButton);
        
        inventoryButton = new JButton("Show Inventory");
        inventoryButton.addActionListener(this);
        buttonPanel.add(inventoryButton);

        f.add(buttonPanel, BorderLayout.NORTH);
        f.setFocusable(true);
        f.requestFocusInWindow();
        f.add(this);
        f.addMouseListener(this);
        f.addKeyListener(this);
        f.setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);

        disaster = danger;
        inventory = i;

        map.x = -1000;
        dayText = "Day: " + day;
        player.dir = 0;
        map.dir = 6;
        eventOpen = false;

        event = new Event(name, player);

        itemPercent = new ArrayList<>(Arrays.asList(10.0, 10.0, 10.0, 0.0, 8.0, 8.0, 8.0, 7.0, 5.0, 7.0, 7.0, 2.0, 8.0));
        ArrayList<Double> adjustedPercentages = adjustPercentages(itemPercent, disaster);
        itemPercent = adjustedPercentages;

        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("placeholder.png").getImage(),
                new Point(0, 0), "custom cursor"));

        Timer t = new Timer(16, this);
        t.start();
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
        adjusted.add(nothing);
        return adjusted;
    }

    public static String pickItem(ArrayList<Double> adjustedPercentages) {
        ArrayList<Double> totalPercent = new ArrayList<>();
        double totalSum = 0;
        for (double percentage : adjustedPercentages) {
            totalSum += percentage;
            totalPercent.add(totalSum);
        }
        double random = Math.random() * 100;
        for (int i = 0; i < totalPercent.size(); i++) {
            if (random <= totalPercent.get(i)) {
                if (i == totalPercent.size() - adjustedPercentages.get(adjustedPercentages.size() - 1)) {
                    return "Nothing";
                } else {
                    return "Item " + (i + 1) + " " + adjustedPercentages.get(i);
                }
            }
        }
        return "HELP";
    }

    public void newDay() {
        eventOpen = false;
        while (map.getX() + 900 < 900) {
            map.setVx(1);
            map.x = map.getX() + map.getVx();
            map.paint(getGraphics());
            repaint();
            System.out.println(map.x);
        }
        System.out.println(map.x);
        map.setVx(0);
        map.x = 0;
        dayText = "";
        event.setAfterText(event.getRandomed().getAfterText());
        event.setDir(-1);
        
        if(day>=10 && event.getRandomed().getSavedEnding()==0&& event.getRandomed().getCatEnding()==0 &&event.getRandomed().getRunEnding()==0) {
        	event.randomInt=10;
        }
        
        
        
        if (event.chance == 0) {
        	  if(event.getRandomed().getSavedEnding()==3) {
        		  f.dispose();
        		   
        		  ImageIcon imageIcon = new ImageIcon();
        		  JFrame window = new JFrame("Saved Ending");
        		    window.setSize(300, 300);

        		    JPanel panel = new JPanel();
        		    
        		    imageIcon = new ImageIcon(getClass().getResource("/imgs/saved.png"));

        		    if(imageIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
        		        System.out.println("Image not loaded.");
        		    } else {
        		        JLabel picLabel = new JLabel(imageIcon);
        		        panel.add(picLabel);
        		        window.add(panel);
        		    }

        		    window.setLocationRelativeTo(null);
        		    window.setVisible(true);

        		  
        		  
        		  
        	  }
        	if(event.getRandomed().isSavedCont()) {
	            int temp = event.getRandomed().getSavedEnding();
	            Randomized rand = event.getRandomed();
	            rand.setSavedEnding(temp + 1);
	            event.setRandomed(rand);
	            event.getRandomed().setSavedCont(false);
        	}
        } else if (event.chance == 1) {
        	
        	if(event.getRandomed().getCatEnding()==3) {
      		  event.chance=1;
    		  f.dispose();
    		  
    		  ImageIcon imageIcon = new ImageIcon();
    		  JFrame window = new JFrame("Cat Ending");
    		    window.setSize(300, 300);

    		    JPanel panel = new JPanel();
    		    
    		    imageIcon = new ImageIcon(getClass().getResource("/imgs/catend.png"));

    		    if(imageIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
    		        System.out.println("Image not loaded.");
    		    } else {
    		        JLabel picLabel = new JLabel(imageIcon);
    		        panel.add(picLabel);
    		        window.add(panel);
    		    }

    		    window.setLocationRelativeTo(null);
    		    window.setVisible(true);

    		  
    		  
    		  
    	  }
        	if(event.getRandomed().isCatCont()) {
	            int temp = event.getRandomed().getCatEnding();
	            Randomized rand = event.getRandomed();
	            rand.setCatEnding(temp + 1);
	            event.setRandomed(rand);
	            event.getRandomed().setCatCont(false);
        	}
        } else if (event.chance == 2) {
        	if(event.getRandomed().getRunEnding()==3) {
	      		  event.chance=2;
	      		  
	      		f.dispose();
	    		  
	    		  ImageIcon imageIcon = new ImageIcon();
	    		  JFrame window = new JFrame("Escape Ending");
	    		    window.setSize(300, 300);

	    		    JPanel panel = new JPanel();
	    		    
	    		    imageIcon = new ImageIcon(getClass().getResource("/imgs/stewieNick.png"));

	    		    if(imageIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
	    		        System.out.println("Image not loaded.");
	    		    } else {
	    		        JLabel picLabel = new JLabel(imageIcon);
	    		        panel.add(picLabel);
	    		        window.add(panel);
	    		    }

	    		    window.setLocationRelativeTo(null);
	    		    window.setVisible(true);

	    		  
	      		  
	      		  
	      	  }
        	if(event.getRandomed().isRunCont()) {
	            int temp = event.getRandomed().getRunEnding();
	            Randomized rand = event.getRandomed();
	            rand.setRunEnding(temp + 1);
	            event.setRandomed(rand);
	            event.getRandomed().setRunCont(false);
        	}
        }
        repaint();
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (sec == 0) {
                    System.out.println("time stop");
                    tick.stop();
                    map.setX(-1000);
                    updateDay(5, 5, 5, 5);
                } else {
                    System.out.println("time go");
                    dayText = "";
                    repaint();
                    sec--;
                }
            }
        };
        tick = new Timer(1000, taskPerformer);
        tick.start();
    }

    public void updateDay(int hunger, int sick, int health, int sanity) {
        day += 1;
        dayText = "Day: " + day;
        if (day % 5 == 0) {
            sanityIncrease += 1;
            sanity += sanityIncrease;
        }
        updateChar(hunger, health, sick, sanity);
        repaint();
    }

    public void updateChar(int hunger, int sick, int health, int sanity) {
        player.setHungerScore(player.getHungerScore() - hunger);
        player.setIllScore(player.getIllScore() - sick);
        player.setHealthScore(player.getHealthScore() - health);
        player.setMentalScore(player.getMentalScore() - sanity);

        int hun = player.getHungerScore();
        int ill = player.getIllScore();
        int hurt = player.getHealthScore();
        int mental = player.getMentalScore();

        int[] numbers = { hun, ill, hurt, mental };
        int smallest = numbers[0];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
                index = i;
            }
        }

        if (hun >= 70 && ill >= 70 && hurt >= 70 && mental >= 70) {
            player.dir = 0;
            return;
        }

        if (index == 0) {
            player.dir = 2;
        } else if (index == 1) {
            player.dir = 3;
        } else if (index == 2) {
            player.dir = 4;
        } else if (index == 3) {
            player.dir = 1;
        }

        if (!isDeadWindowShown && (hun <= 0 || hurt <= 0 || ill <= 0 || mental <= 0)) {
            isDeadWindowShown = true;

            JFrame deadFrame = new JFrame();
            deadFrame.setSize(new Dimension(500, 400));
            deadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            deadFrame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(); 
            panel.setLayout(new BorderLayout());

            JLabel label = new JLabel("You died lol");
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));

            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/imgs/clownface.png"));

            if (imageIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                System.out.println("Image not loaded.");
            } else {
                JLabel picLabel = new JLabel(imageIcon);
                picLabel.setHorizontalAlignment(JLabel.CENTER);
                picLabel.setVerticalAlignment(JLabel.CENTER);
                panel.add(picLabel, BorderLayout.CENTER);
            }

            panel.add(label, BorderLayout.NORTH);
            deadFrame.add(panel);
            deadFrame.setVisible(true);

            f.dispose();
        }
    }

    public void openStats() {
        ImageIcon happy = new ImageIcon("happyhappyhappy.jpg");
        JOptionPane.showMessageDialog(null,
                "Hunger/Thirst: " + player.getHungerScore() + "%" + "\n" + "Injury: " + player.getHealthScore() + "%" + "\n"
                        + "Illness: " + player.getIllScore() + "%" + "\n" + "Sanity: " + player.getMentalScore() + "%" + "\n",
                "Stats", JOptionPane.INFORMATION_MESSAGE, happy);
    }

    public void openInventory() {
        StringBuilder inventoryList = new StringBuilder();
        for (Item item : inventory) {
            inventoryList.append(item.getName()).append("\n");
        }
        
        if(inventory.size()==0) {
        	inventoryList.append("Nothing lol");
        }
        JOptionPane.showMessageDialog(null, "You have: "+inventoryList.toString(), "Inventory", JOptionPane.INFORMATION_MESSAGE);
    }

    public void moveBack() {
    }

    @Override
    public void mouseClicked(MouseEvent m) {
        event.mouseClicked(m);
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

    @Override
    public void mousePressed(MouseEvent m) {
        if (event.getDir() > 3) {
            newDay();
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            newDay();
        } else if (e.getSource() == statsButton) {
            openStats();
        } else if (e.getSource() == eventButton) {
            eventOpen = true;
        } else if (e.getSource() == inventoryButton) {
            openInventory();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent k) {
        System.out.println("Key pressed: " + k.getKeyCode());
        switch (k.getKeyCode()) {
            case KeyEvent.VK_N:
                //newDay();
                break;
            case KeyEvent.VK_Y:
                if (eventOpen) {
                    event.keyPressed(k);
                }
                break;
            case KeyEvent.VK_C:
                //openStats();
                break;
            case KeyEvent.VK_E:
                eventOpen = true;
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent k) {
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    
    
}
