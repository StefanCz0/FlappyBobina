package bobina.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	public LinkedList<GameObject> GameObject;
    
    public Handler() {
        this.GameObject = new LinkedList<GameObject>();
    }
    
    public void tick() {
        for (int i = 0; i < this.GameObject.size(); ++i) {
            GameObject tempObject = this.GameObject.get(i);
            tempObject.tick();
        }
    }
    
    public void render(Graphics g) {
        for (int i = 0; i < this.GameObject.size(); ++i) {
            GameObject tempObject = this.GameObject.get(i);
            tempObject.Render(g);
        }
    }
    
    public void addObject(GameObject GameObject) {
        this.GameObject.add(GameObject);
    }
    
    public void removeObject(GameObject GameObject) {
        this.GameObject.remove(GameObject);
    }
}
