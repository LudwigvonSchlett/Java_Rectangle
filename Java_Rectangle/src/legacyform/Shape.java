package legacyform;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	protected int x=-1;
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	protected int y=-1;
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	protected int dx=-1;
	
	public int getDX() {
		return this.dx;
	}
	
	public void setDX(int dx) {
		this.dx = dx;
	}
	
	protected int dy=-1;
	
	public int getDY() {
		return this.dy;
	}
	
	public void setDY(int dy) {
		this.dy = dy;
	}
	
	public abstract int Isin(int x, int y);
	
	public abstract void move(int dx, int dy);
		
	public abstract String toString();
	
	public abstract void draw(Graphics g);
	
	public Group Union(Shape s1) {
		Group g2 = new Group();
		g2.add(this);
		g2.add(s1);
		g2.updateCoord();
		return g2;
	}
	
	public abstract Group Intersect(Shape s1);

}