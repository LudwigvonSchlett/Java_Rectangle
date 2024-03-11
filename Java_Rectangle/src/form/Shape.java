package form;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable{
	
	protected int x;
	
	public int getX() {
		return this.x;
	}
	
	protected int y;
	
	public int getY() {
		return this.x;
	}
	
	protected int dx;
	
	protected int dy;
	
	public abstract void saveBinary(String filename) throws Exception;
	
	public abstract void loadBinary(String filename) throws Exception;
	
	public abstract String toString();
	
	public abstract void draw(Graphics g);
	
	public abstract void move(int dx, int dy);

}
