package form;

import java.awt.Graphics;

public class Rectangle extends Shape{
		
	public Rectangle(int x, int y, int dx, int dy) {
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=dy;
	}

	@Override
	public void saveBinary(String filename) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadBinary(String filename) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return ("Rectangle : x = " + this.x +" y = " + this.y + " dx = " + this.dx + " dy = "+ this.dy);
	}

	@Override
	public void move(int dx, int dy) {
		if ((this.x+dx>=0) && (this.y+dy>=0)) {
			this.x=this.x+dx;
			this.y=this.y+dy;
		}
					
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect(this.x,this.y,this.dx,this.dy);
	}

}

