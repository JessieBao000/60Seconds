import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Event {

	private Image living, garage, stewie, attic, kitchen, black; 
	private AffineTransform tx, tx2,txn;
	String dialog = "peepee poopoo caca";
	
	public int dir=0;
	public int maxDir=4;
	int width, height;
	int x, y, vx, vy, ax;	
	double scaleNormal=1;
	double scaleWidth = 0.75;		
	double scaleHeight = 0.75;
	double scaleWidth2 = 0.6;		
	double scaleHeight2 = 0.6;
	
	public Event() {
		
		living 	= getImage("/imgs/"+"familyguyroom.PNG"); 
		garage 	= getImage("/imgs/"+"garage.PNG"); 
		stewie 	= getImage("/imgs/"+"stewie.png"); 
		attic 	= getImage("/imgs/"+"houseattic.PNG"); 
		kitchen 	= getImage("/imgs/"+"kitchen.png"); 
		black = getImage("/imgs/"+"black.jpg");
		width = 900;
		height = 600;
		x = 0;
		y = 0;
		vx=0;
		vy=0;
		ax=0;
		tx = AffineTransform.getTranslateInstance(0, 0);
		tx2 = AffineTransform.getTranslateInstance(0, 0);
		txn = AffineTransform.getTranslateInstance(0, 0);
		
		//init(x, y); 
		
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		g.drawRect(x, y, width, height);

		
		switch(dir) {
			case 0:
				init2(x,y);
				g2.drawImage(living, tx2, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 1:
				init2(x,y);
				g2.drawImage(garage, tx2, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 2:
				init(x, y); 
				g2.drawImage(stewie, tx, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 3:
				init(x, y);  
				g2.drawImage(attic, tx, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 4:
				init(x, y); 
				g2.drawImage(kitchen, tx, null);
				g.drawRect(x, y, width, height);
				break;
			case 5: //closing
				init(x,y);

				break;
			case 6:
				
				initn(x, y); 
				g2.drawImage(black, txn, null);
				g.drawRect(x, y, width, height);
				break;
				
		}
		


	}
	
	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	public int getAx() {
		return ax;
	}

	public void setAx(int ax) {
		this.ax = ax;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}
	
	
	private void init2(double a, double b) {
		tx2.setToTranslation(a, b);
		tx2.scale(scaleWidth2, scaleHeight2);
	}
	
	private void initn(double a, double b) {
		txn.setToTranslation(a, b);
		txn.scale(scaleNormal, scaleNormal);
	}

	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Event.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	
	
	
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Event f = new Event();
	}

}
