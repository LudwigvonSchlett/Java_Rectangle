package simpleform;

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
	public abstract int belong(int x, int y);

	@Override
	public void move(int dx, int dy) {
		if((x1+dx>=0)&&(y1+dy>=0)) {
			this.x1=this.x1+dx;
			this.y1=this.y1+dy;
			this.x2=this.x2+dx;
			this.y2=this.y2+dy;
			Lleaf.move(dx, dy);
			Rleaf.move(dx, dy);
		}
	}

	@Override
	public abstract String toString();

}
