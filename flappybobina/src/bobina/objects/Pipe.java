package bobina.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import bobina.main.GameObject;
import bobina.main.Handler;

public class Pipe extends GameObject {
	private boolean vert = false;
	private int velX,velY;
	private Handler h;
	private PipeGenerator gen;
	public Pipe(int x, int y, bobina.a.type type, boolean vert, Handler h,PipeGenerator gen) {
		super(x, y, type);
		// TODO Auto-generated constructor stub
		this.vert=vert;
		this.gen=gen;
		this.h=h;
		
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		setY(getY()+getVelY());
		setX(getX()+getVelX());
		setVelX((int)gen.speed);
		for(int i =0;i<h.GameObject.size();i++) {
			GameObject temp = h.GameObject.get(i);
			if(temp.getType()==bobina.a.type.player) {
				if(temp.getX()+40>getX() && temp.getX()-40<getX()) {
					h.removeObject(this);
					gen.score++;
				}
			}
		}
	}

	@Override
	public void Render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green.darker());
		g.fillRect(getX(), getY(), 80, 590);
		if(!vert) {
			g.fillRect(getX()-8, getY()-2, 96, 20);
		} else {
			g.fillRect(getX()-8, getY()+588, 96, 20);
		}

	}

	@Override
	public Rectangle2D getBounds() {
		// TODO Auto-generated method stub
		if(!vert) {
		return new Rectangle(getX()-8,getY()-2,96,588);
		} else {
			return new Rectangle(getX()-8, getY()-2,96, 610);
		}
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
