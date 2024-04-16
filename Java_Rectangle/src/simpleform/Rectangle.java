package simpleform;

public class Rectangle extends Shape {

public Rectangle() {}
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
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
		if ((this.x1+dx>=0) && (this.y1+dy>=0)) {
			this.x1=this.x1+dx;
			this.y1=this.y1+dy;
			this.x2=this.x2+dx;
			this.y2=this.y2+dy;
		}			
	}

	@Override
	public String toString() {
		return ("Rectangle : x1 = " + this.x1 +" y1 = " + this.y1 + " x2 = " + this.x1 + " y2 = "+ this.y2);
	}

}
