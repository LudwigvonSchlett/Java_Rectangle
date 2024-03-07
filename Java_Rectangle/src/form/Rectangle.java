package form;

public class Rectangle extends Element{
	
	private int x;
	
	private int y;
	
	private int dx;
	
	private int dy;
	
	public Rectangle(int x, int y, int dx, int dy) {
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=dy;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
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
		this.x=this.x+dx;
		this.y=this.y+dy;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
	}

	@Override
	public void union() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void intersect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void difference() {
		// TODO Auto-generated method stub
		
	}

}

