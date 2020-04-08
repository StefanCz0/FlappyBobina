package bobina.objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import bobina.a.type;
import bobina.main.Handler;
import bobina.main.Main;

public class PipeGenerator{
	private Handler handler;
	private Main m;
	public PipeGenerator(Handler handler,Main m) {
		// TODO Auto-generated constructor stub
		this.handler=handler;
		this.m=m;
	}
	private Dimension screenSize=Main.screenSize;
	private Pipe pipe1;
	private Pipe pipe2;
	public void generate() {
		Random r = new Random();
		int a = r.nextInt(10);
		if(a==0) {
			pipe1=new Pipe(screenSize.width,-240, type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-440, type.pipe,false, handler,this);
		}
		if(a==1) {
			pipe1=new Pipe(screenSize.width,-180, type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-380, type.pipe,false, handler,this);
		}
		if(a==2) {
			pipe1=new Pipe(screenSize.width,-140 , type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-340, type.pipe,false, handler,this);
		}
		if(a==3) {
			pipe1=new Pipe(screenSize.width,-170, type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-370, type.pipe,false, handler,this);
		}
		if(a==4) {
			pipe1=new Pipe(screenSize.width,-130, type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-330, type.pipe,false, handler,this);
		}
		if(a==5) {
			pipe1=new Pipe(screenSize.width,-50, type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-250, type.pipe,false, handler,this);
		}
		if(a==6) {
			pipe1=new Pipe(screenSize.width,-100, type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-300, type.pipe,false, handler,this);
		}
		if(a==7) {
			pipe1=new Pipe(screenSize.width,-50, type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-250, type.pipe,false, handler,this);
		}
		if(a==8) {
			pipe1=new Pipe(screenSize.width,-200, type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-400, type.pipe,false, handler,this);
		}
		if(a==9) {
			pipe1=new Pipe(screenSize.width,-400, type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-600, type.pipe,false, handler,this);
		}
		if(a==10) {
			pipe1=new Pipe(screenSize.width,-280, type.pipe,true, handler,this);
			pipe2=new Pipe(screenSize.width,screenSize.height-480, type.pipe,false, handler,this);
		}
		
		handler.addObject(pipe1);
		handler.addObject(pipe2);
	}
	private boolean gen;
	public void tick() {
		if(m.END) {
			gen=false;
		}
		if(!gen) {
			if(pipe1.getX()<=Main.screenSize.width-700) {
				generate();
			}
			speed=speed-0.005;
		}
	}
	public double speed =-20;
	public int score = 0;
	public void render(Graphics g) {
		g.setFont(new Font("BodoniMTBlack",Font.BOLD,40));
		g.setColor(Color.black);
		g.drawString(""+score/2, 50, 50);
	}

}
