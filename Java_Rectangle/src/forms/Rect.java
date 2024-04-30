package forms;

import java.awt.Color;
import java.awt.Graphics;


public class Rect extends Shape {

	private static final long serialVersionUID = -6729981047980508973L;

	public Rect() {}
	
	public Rect(int x1, int y1, int x2, int y2) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}

	public static Rect RectVD(int x, int y, int dx, int dy) {
		if ((dx<=0)||(dy<=0)) {
			return null;
		}
		return new Rect(x, y, x+dx-1, y+dy-1);
	}

	@Override
	public void select() {
		this.selected = 1;
	}

	@Override
	public void unselect() {
		this.selected = 0;
	}

	@Override
	public void draw(Graphics g) {
		if (this.selected == 1) {
			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.BLACK);
		}
		g.fillRect(this.x1, this.y1, this.x2-this.x1+1, this.y2-this.y1+1);
	}

	@Override
	public Shape copy() {
		Rect result = new Rect(this.x1,this.y1,this.x2,this.y2);
		return result;
	}

	@Override
	public int belong(int x, int y) {
		int result = 1;
			if ((this.x1<=x)&&((this.x2)>=x)&&(this.y1<=y)&&((this.y2)>=y)) {
				result = 0;
			}
		return result;
	}

	@Override
	public void move(int dx, int dy) {
		this.x1=this.x1+dx;
		this.y1=this.y1+dy;
		this.x2=this.x2+dx;
		this.y2=this.y2+dy;			
	}

	@Override
	public String toString() {
		return ("Rectangle : x1 = " + this.x1 +"  y1 = " + this.y1 + "  x2 = " + this.x2 + "  y2 = "+ this.y2);
	}

	

	

}
