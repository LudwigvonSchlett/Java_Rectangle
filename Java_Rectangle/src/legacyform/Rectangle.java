package legacyform;

import java.awt.Graphics;
import java.util.List;

public class Rectangle extends Shape{
		
	private static final long serialVersionUID = 1L;

	public Rectangle() {}
	
	public Rectangle(int x, int y, int dx, int dy) {
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=dy;
	}
	
	public static Rectangle createRectangle(int x, int y, int dx, int dy) {
		Rectangle result = new Rectangle();
		result.setX(x);
		result.setY(y);
		result.setDX(dx);
		result.setDY(dy);
		return result;
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

	@Override
	public Group Intersect(Shape s1) {
		
		Group result = new Group();
		if (s1 instanceof Group) {
			List<Shape> s1Gcontent = ((Group) s1).getGcontent();
			for (Shape s1c:s1Gcontent) {
				result.Unite2G(Intersect(s1c));
			}
		}
		
		else if (s1 instanceof Rectangle) {
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
			
			if((resultx!=-1)&&(resulty!=-1)&&(resultdx!=-1)&&(resultdy!=-1)) {
				result.add(createRectangle(resultx,resulty,resultdx,resultdy));
			}
			
						
		}
		
		return result;
	}

}