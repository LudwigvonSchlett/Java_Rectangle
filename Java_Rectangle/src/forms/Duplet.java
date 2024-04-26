package forms;

import java.awt.Graphics;

public abstract class Duplet extends Shape {
	
	protected Shape Lleaf = null;
	
	public void setLleaf(Shape s1) {
		this.Lleaf=s1;
	}
	
	public Shape getLleaf() {
		return this.Lleaf;
	}
	
	protected Shape Rleaf = null;
	
	public void setRleaf(Shape s1) {
		this.Rleaf=s1;
	}
	
	public Shape getRleaf() {
		return this.Rleaf;
	}
	
	@Override
	public void select() {
		this.selected = 1;
		Lleaf.select();
		Rleaf.select();
	}

	@Override
	public void unselect() {
		this.selected = 0;
		Lleaf.unselect();
		Rleaf.unselect();
	}

	@Override
	public abstract void draw(Graphics g);

	@Override
	public abstract Shape copy();

	@Override
	public abstract int belong(int x, int y);

	@Override
	public void move(int dx, int dy) {
		this.x1=this.x1+dx;
		this.y1=this.y1+dy;
		this.x2=this.x2+dx;
		this.y2=this.y2+dy;
		Lleaf.move(dx, dy);
		Rleaf.move(dx, dy);
	}

	@Override
	public abstract String toString();

}
