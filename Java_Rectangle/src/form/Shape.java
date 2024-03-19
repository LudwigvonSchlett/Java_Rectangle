package form;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	protected int x;
	
	public int getX() {
		return this.x;
	}
	
	protected int y;
	
	public int getY() {
		return this.x;
	}
	
	protected int dx;
	
	public int getDX() {
		return this.dx;
	}
	
	protected int dy;
	
	public int getDY() {
		return this.dy;
	}
	
	public abstract int Isin(int x, int y);
	
	public abstract void move(int dx, int dy);
		
	public abstract String toString();
	
	public abstract void draw(Graphics g);

}
