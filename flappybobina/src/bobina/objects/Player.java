package bobina.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bobina.main.GameObject;
import bobina.main.Handler;
import bobina.main.Main;

public class Player extends GameObject {
	private Handler h;
	public Main m;
	public Player(int x, int y, bobina.a.type type, Handler handler, Main m) {
		super(x, y, type);
		this.h=handler;
		this.m=m;
	}
	private int velY;
	private int velX;
	public boolean falling=false;
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		setX(getX()+getVelX());
		setY(getY()+getVelY());
		if(falling) {
			setVelY(12);
		}
		if (this.getY()+40  >= Main.screenSize.height || this.getY() <= 0) {
			lose();
		}
		for(int index=0; index< h.GameObject.size();index++) {
			GameObject temp = h.GameObject.get(index);
			if(temp.getType()==bobina.a.type.pipe) {
				
				if(temp.getBounds().intersects(getBounds())) lose();
			}
		}
	}
	public boolean lost = false;
	public void lose() {
		lost = true;
		m.END=true;
		
	}
	private Thread jump;
	public void jump() {
		jump = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				falling=false;
				setVelY(-18);
				sleepJump(400);
				setVelY(0);
				falling=true;
				jump.stop();
			}

		});
		jump.start();
	}
	private void sleepJump(long millis) {
		try {
			jump.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void Render(Graphics g) {
		if(!lost) {
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("img//bobina.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(img, getX(), getY(),img.getWidth()/3,img.getHeight()/3, null);
			
		} else if(lost) {
			g.setFont(new Font("ComicSans",Font.PLAIN,80));
			g.setColor(Color.BLACK);
			g.drawString("You lose", Main.screenSize.width/2, Main.screenSize.height/2);
			g.setFont(new Font("ComicSans",Font.PLAIN,40));
			g.drawString("Press SPACE to continue", Main.screenSize.width/2-50, Main.screenSize.height/2+50);
			m.pause();
		}

	}

	@Override
	public Rectangle2D getBounds() {
		// TODO Auto-generated method stub
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("img//bobina.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Rectangle(getX(), getY(),img.getWidth()/3,img.getHeight()/3);
	}
	public int getVelY() {
		return velY;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
}
