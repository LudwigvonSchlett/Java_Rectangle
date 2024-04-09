package simpleform;

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
			if ((this.x<=x)&&((this.dx+this.x)>x)&&(this.y<=y)&&((this.dy+this.y)>y)) {
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
	public int getminX() {
		return this.x;
	}

	@Override
	public int getminY() {
		return this.y;
	}

}
