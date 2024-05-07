package forms;

import java.io.Serializable;

import java.awt.Graphics;

public abstract class Shape implements Serializable{
	
	private static final long serialVersionUID = 3112194870883717506L;
	
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

	/*
	 *  0 : unselected
	 *  1 : selected
	 * -2 : empty
	 * -3 : no change
	 */
	protected int selected = 0;



	public int getSelected(){
		return this.selected;
	}

	public void setSelected(int state){
		this.selected = state;
	}

	public abstract void select();

	public abstract void unselect();

	public abstract void draw(Graphics g);

	public abstract Shape copy();
	
	public abstract int belong(int x, int y);
	
	public abstract void move(int dx, int dy);
		
	public abstract String toString();
	
}