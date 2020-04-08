package bobina.main;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import bobina.a.type;

public abstract class GameObject {
    private int x;
    private int y;
    private type type;
    
    public GameObject(int x, int y, type type) {
        this.setType(type);
        this.setX(x);
        this.setY(y);
    }
    
    public abstract void tick();
    
    public abstract void Render(Graphics p0);
    
    public abstract Rectangle2D getBounds();
    
    public int getX() {
        return this.x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public type getType() {
        return this.type;
    }
    
    public void setType(type type) {
        this.type = type;
    }
}
