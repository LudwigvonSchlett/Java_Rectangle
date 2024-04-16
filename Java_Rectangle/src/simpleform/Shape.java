package simpleform;

import java.io.Serializable;

public abstract class Shape implements Serializable{
	
	protected int x1=-1;
	
	public int getX1() {
		return this.x1;
	}
	
	public void setX1(int x) {
		this.x1 = x;
	}
	
	protected int y1=-1;
	
	public int getY1() {
		return this.y1;
	}
	
	public void setY1(int y) {
		this.y1 = y;
	}
	
	protected int x2=-1;
	
	public int getX2() {
		return this.x2;
	}
	
	public void setX2(int x) {
		this.x2 = x;
	}
	
	protected int y2=-1;
	
	public int getY2() {
		return this.y2;
	}
	
	public void setY2(int y) {
		this.y2 = y;
	}
	
	public abstract int belong(int x, int y);
	
	public abstract void move(int dx, int dy);
		
	public abstract String toString();
	
}