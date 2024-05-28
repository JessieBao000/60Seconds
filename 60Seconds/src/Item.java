
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Item implements MouseListener{

	private Image soup,water,aid,shelter,cloth,knife,flashlight,
	 				radio,gas,soap,map,gloves,family,generator,book; 
	public String name;
	private AffineTransform tx, tx2,tx3;
	private Image glow;
	public int dir=0;
	public int maxDir=15;
	int width, height;
	int x, y;				
	double scaleWidth = 0.3;		
	double scaleHeight = 0.3;
	double scaleWidth2 = 0.2;		
	double scaleHeight2 = 0.2;
	private boolean mouseOver = false;
	
	public Item() {
		
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
		
		width = 100;
		height = 100;
		x = 0;
		y = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		tx2 = AffineTransform.getTranslateInstance(0, 0);
		tx3 = AffineTransform.getTranslateInstance(0, 0);
		
		//init(x, y); 
		
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		

		//g2.drawRect(x, y, width, height)
		
		
		switch(dir) {
			case 0: // SOUP
				if(x!=1000) {
					x = 120;
					y = 190;
					width = 60;
					height = 100;
					
					if (mouseOver) {
						init(x-70,y-50);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(soup, tx2, null);
					name = "food";
				}
				break;
			case 1: //WATER
				if(x!=1000) {
					x = 200;
					y = 300;
					width = 50;
					height = 130;
					if (mouseOver) {
						init(x-80,y-50);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					
					g2.drawImage(water, tx2, null);
					name = "water";
				}
				break;
			case 2: //FIRST AID
				if(x!=1000) {
					x = 80;
					y = 100;
					width = 100;
					height = 80;
					if (mouseOver) {
						init(x-40,y-50);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(aid, tx2, null);
					name = "firstaidkit";
				}
				break;
			case 3:
				init(x,y);
				g2.drawImage(shelter, tx, null);
				name = "peewizz";
				//g2.drawRect(x, y, width, height);
				break;
			case 4: //CLOTHING
				if(x!=1000) {
					x = 530;
					y = 380;
					width = 100;
					height = 60;
					if (mouseOver) {
						init(x-50,y-70);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(cloth, tx2, null);
					name = "clothing";
				}
				break;
			case 5: //KNIFE
				if(x!=1000) {
					x = 470;
					y = 300;
					width = 100;
					height = 50;
					if (mouseOver) {
						init(x-70,y-80);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(knife, tx2, null);
					name = "knife";
				}
				break;
			case 6: //FLASHLIGHT
				if(x!=1000) {
					x = 550;
					y = 500;
					width = 100;
					height = 50;
					if (mouseOver) {
						init(x-40,y-60);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(flashlight, tx2, null);
					name = "flashlights";
				}
				break;
			case 7: //RADIO
				if(x!=1000) {
					x = 50;
					y = 430;
					width = 100;
					height = 80;
					if (mouseOver) {
						init(x-40,y-50);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(radio, tx2, null);
					name = "radio";
				}
				break;
			case 8: //GASOLINE
				if(x!=1000) {
					x = 420;
					y = 320;
					width = 100;
					height = 90;
					if (mouseOver) {
						init(x-30,y-50);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(gas, tx2, null);
					name = "gasoline";
				}
				break;
			case 9: //SOAP
				if(x!=1000) {
					x = 270;
					y = 160;
					width = 100;
					height = 70;
					if (mouseOver) {
						init(x-50,y-50);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(soap, tx2, null);
					name = "soap";
				}
				break;
			case 10: //MAP
				if(x!=1000) {
					x = 300;
					y = 400;
					width = 140;
					height = 100;
					if (mouseOver) {
						init(x-30,y-50);
			            g2.drawImage(glow, tx, null); 
			        }
					init(x,y);
					g2.drawImage(map, tx, null);
					name = "map";
				}
				break;
			case 11: //GLOVES
				if(x!=1000) {
					x = 100;
					y = 450;
					width = 120;
					height = 70;
					if (mouseOver) {
						init(x-40,y-50);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(gloves, tx2, null);
					name = "gloves";
				}
				break;
			case 12: //FAMILY PHOTOS
				if(x!=1000) {
					x = 260;
					y = 230;
					width = 100;
					height = 60;
					if (mouseOver) {
						init(x-40,y-60);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(family, tx2, null);
					name = "familyphotos";
				}
				break;
			case 13: //GENERATOR
				if(x!=1000) {
					x = 600;
					y = 400;
					width = 150;
					height = 130;
					if (mouseOver) {
						init3(x-50,y-50);
			            g2.drawImage(glow, tx3, null); 
			        }
					init(x,y);
					g2.drawImage(generator, tx, null);
					name = "generator";
				}
				break;
			case 14: //BOYSCOUT
				if(x!=1000) {
					x=170;
					y = 400;
					width = 100;
					height = 80;
					if (mouseOver) {
						init(x-40,y-50);
			            g2.drawImage(glow, tx, null); 
			        }
					init2(x,y);
					g2.drawImage(book, tx2, null);
					name = "boyscoutbook";
				}
				break;
			
		}
		


	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}
	
	public boolean collided(int x, int y, int width, int height) {
		Rectangle otherObject = new Rectangle(x-15,y-20,width,height);
		Rectangle thisObject = new Rectangle(this.x,this.y,this.width,this.height);
		return otherObject.intersects(thisObject);
	}
	
	
	
	private void init2(double a, double b) {
		tx2.setToTranslation(a, b);
		tx2.scale(scaleWidth2, scaleHeight2);
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
	
	
	
	
	
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
		updateName();
	}
	
	
	private void updateName() {
        switch (dir) {
            case 0:
                name = "food";
                break;
            case 1:
                name = "water";
                break;
            case 2:
                name = "firstaidkit";
                break;
            case 3:
                name = "shelter";
                break;
            case 4:
                name = "clothing";
                break;
            case 5:
                name = "knife";
                break;
            case 6:
                name = "flashlights";
                break;
            case 7:
                name = "radio";
                break;
            case 8:
                name = "gasoline";
                break;
            case 9:
                name = "soap";
                break;
            case 10:
                name = "map";
                break;
            case 11:
                name = "gloves";
                break;
            case 12:
                name = "familyphotos";
                break;
            case 13:
                name = "generator";
                break;
            default:
                name = null;
        }
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}


