package form;

import java.awt.Graphics;

public class Rectangle extends Shape {
	
	public Rectangle() {}
	
	public Rectangle(int x, int y, int dx, int dy) {
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=dy;
	}

	@Override
	public int belong(int x, int y) {
		int result = 1;
			if ((this.visibility!=0)&&(this.x<=x)&&((this.dx+this.x)>x)&&(this.y<=y)&&((this.dy+this.y)>y)) {
				result = 0;
			}
		return result;
	}

	@Override
	public void move(int dx, int dy) {
		if ((this.x+dx>=0) && (this.y+dy>=0)) {
			this.x=this.x+dx;
			this.y=this.y+dy;
		}			
	}

	@Override
	public String toString() {
		return ("Rectangle : x = " + this.x +" y = " + this.y + " dx = " + this.dx + " dy = "+ this.dy);
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect(this.x,this.y,this.dx,this.dy);
	}

	@Override
	public Shape intersect(Shape s1) {
		if (s1 instanceof Union) {
			Union s1casted = (Union) s1;
			return new Union(this.intersect(s1casted.getLleaf()),(this.intersect(s1casted.getRleaf())));
		}

		if (s1 instanceof Intersection){
			Intersection s1casted = (Intersection) s1;
			return this.intersect(s1casted.getIleaf());
		}
		
		
		if (s1 instanceof Rectangle) {
			int resultx = -1;
			int resulty = -1;
			int resultdx = -1;
			int resultdy = -1;
			
			if (((this.x+this.dx)>s1.getX())&&(s1.getX()>=this.x)) {
				resultx = s1.getX();
				if((this.dx-(s1.getX()-this.x))<=s1.getDX()) {
					resultdx = this.dx-(s1.getX()-this.x);
				}
				else {
					resultdx = s1.getDX();
				}			
			} else if (((s1.getX()+s1.getDX())>this.x)&&(s1.getX()<=this.x)) {
				resultx = this.x;
				if((s1.getDX()-(this.x-s1.getX()))<=this.x) {
					resultdx = s1.getDX()-(this.x-s1.getX());
				}
				else {
					resultdx = this.dx;
				}
			}
			
			if (((this.y+this.dy)>s1.getY())&&(s1.getY()>=this.y)) {
				resulty = s1.getY(); 
				if((this.dy-(s1.getY()-this.y))<=s1.getDY()) {
					resultdy = this.dy-(s1.getY()-this.y);
				}
				else {
					resultdy = s1.getDY();
				}	
			} else if (((s1.getY()+s1.getDY())>this.y)&&(s1.getY()<=this.y)) {
				resulty = this.y;
				
				if((s1.getDY()-(this.y-s1.getY()))<=this.y) {
					resultdy = s1.getDY()-(this.y-s1.getY());
				}
				else {
					resultdy = this.dy;
				}
			}
	
			return(new Rectangle(resultx,resulty,resultdx,resultdy));
		}
		
		return(new Rectangle(0,0,0,0));
	}

}
