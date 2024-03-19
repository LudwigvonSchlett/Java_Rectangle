package form;

import java.awt.Graphics;

public class Rectangle extends Shape{
		
	private static final long serialVersionUID = 1L;

	public Rectangle(int x, int y, int dx, int dy) {
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=dy;
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

	@Override
	public int Isin(int x, int y) {
		int result = 1;
			if ((this.x<=x)&&((this.dx+this.x)>x)&&(this.y<=y)&&((this.dy+this.y)>y)) {
				result = 0;
			}
		return result;
	}

}

