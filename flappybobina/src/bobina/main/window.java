package bobina.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class window extends Canvas{
	private static final long serialVersionUID = 145153135131L;
    public JFrame frame;
    private JFrame game;
    public boolean fullscreen;
    
    public window(final int width, final int height, final String title, final Main M) {
        this.fullscreen = false;
        this.game = new JFrame(title);
        this.frame = this.game;
        this.game.setPreferredSize(new Dimension(width, height));
        this.game.setMaximumSize(new Dimension(width, height));
        this.game.setMinimumSize(new Dimension(width, height));
        this.game.setDefaultCloseOperation(3);
        this.game.setResizable(false);
        this.game.setLocationRelativeTo(null);
        this.game.add(M);
        this.game.setVisible(true);
        M.start();
    }
}
