package period8Graphics;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MyWindow extends JFrame implements KeyListener{
	
	int width = 500;
	int height = 500;
	Hero cia;
	Hero bane;
	boolean itemPickedUp;
	BufferedImage landscape;
	public static void main(String[] args){
		new MyWindow();
	}
	
	public MyWindow(){
		cia = new Hero("Big Guy", "/images/heroes/images.jpg", 0, 50);
		bane = new Hero("Bane", "/images/heroes/bane.jpg", 200, 200);
		itemPickedUp = false;
		landscape = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)landscape.getGraphics();
		paintLandscape(g2);
		
		setVisible(true);
		setSize(width,height);//units in pixels.
		setLocation(363,173);//units right, units down.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//static constant reference for special close operation.
		addKeyListener(this);//"Listen up!"
	}
	
	private void paintLandscape(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	public void paint(Graphics g){
		//Graphics is a crayon box.
		//Graphics2D is like an art kit.
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);//this declares a buffered image. "A" makes it transparent.
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		g2.setColor(Color.green);
		g2.fillRect(0, 0, width, height);
		
		g2.drawImage(cia.getImage(), cia.getX(), cia.getY(), null);
		if(Math.abs(cia.getX()-bane.getX()) + Math.abs(cia.getY()-bane.getY()) < 20){
			itemPickedUp = true;
		}
		if(itemPickedUp != true){
			g2.drawImage(bane.getImage(), bane.getX(), bane.getY(), null);
		}
////		int squareD = 3;
////		int margin = 2;
////		int c1=0;
////		for(int x = 0; x < width; x+=squareD+margin){
////			for(int y = 0; y < height; y+=squareD+margin){
////				if(c1>255){
////					c1=0;
////				}
////				g2.setColor(new Color(157, 128, c1));
////				g2.fillRect(x, y, squareD, squareD);
////				c1++;
////			}
////		}
//		g2.fillOval(50, 110, 50, 50);
//		g2.setColor(Color.blue);
//		g2.drawOval(50, 110, 50, 50);
//		g2.setColor(Color.white);
//		g2.fillOval(200, 110, 50, 50);
//		g2.setColor(Color.blue);
//		g2.drawOval(200, 110, 50, 50);
//		//x, y, width, height, startDEG, endDEG
//		g2.drawArc(50, 300, 300, 100, 180, 190);
//		//String, x, y
//		g2.drawString("Wake me up inside", 300, 300);
//		g2.setColor(Color.red);
//		g2.drawLine(0, 0, width, height);
		
		g.drawImage(image, 0, 0, null);//draws the image on canvas.
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			cia.moveUp();
			
		}
		else if(key == KeyEvent.VK_DOWN){
			cia.moveDown();
		}
		else if(key == KeyEvent.VK_RIGHT){
			cia.moveRight();
		}
		else if(key == KeyEvent.VK_LEFT){
			cia.moveLeft();
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
