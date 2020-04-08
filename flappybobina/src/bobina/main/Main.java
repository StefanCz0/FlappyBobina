package bobina.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import bobina.a.type;
import bobina.listeners.key;
import bobina.objects.PipeGenerator;
import bobina.objects.Player;

public class Main extends Canvas implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8645003048058114704L;
	protected static Main m;
	public key key;
	public Handler handler;
	public window window;
	public static Dimension screenSize;
	public boolean running;
	public Thread thread;
	public static int FPS;
	private boolean paused;
	public PipeGenerator gen;
	public boolean END=true;
	public Player p;
	public Main() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		paused = false;
		handler = new Handler();

		window = new window((int)screenSize.getWidth(), (int)screenSize.getHeight(), "FlappyBobina 1.0", this);
		p = new Player(400,400,type.player, handler,this);
		handler.addObject(p);
		key = new key(p,this);
		gen= new PipeGenerator(handler,this);
		gen.generate();
		BufferedImage cursorImg = new BufferedImage(16, 16, 2);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		window.frame.getContentPane().setCursor(blankCursor);
		addKeyListener(key);
	}

	public static void main(String[] args) {
		Main.m = new Main();
	}

	public synchronized void start() {
		(thread = new Thread(this)).start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1.0E9 / amountOfTicks;
		double delta = 0.0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1.0) {
				tick();
				--delta;
			}
			if (running) {
				++frames;
			}
			if (System.currentTimeMillis() - timer > 1000L) {
				timer += 1000L;
				System.out.println("FPS: " + frames);
				Main.FPS = frames;
				frames = 0;
			}
		}
		stop();
	}

	public void pause() {
		paused = true;
	}

	public void play() {
		paused = false;
	}

	private void tick() {
		if (!paused) {
			render();
			gen.tick();
			handler.tick();

		}
		if(p.lost) {
			END=true;
		}
	}

	private void render() {
		BufferStrategy bs=null;
		Graphics g=null;
		try {
			bs = getBufferStrategy();
			if (bs == null) {
				createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics();

			g.setColor(Color.cyan.brighter());
			g.fillRect(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight()); 
			handler.render(g);
			gen.render(g);
			g.dispose();
			bs.show();
		} catch(Exception e) {
			return;
		}


	}
	public void end() {
		System.exit(0);
	}
}


