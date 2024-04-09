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
	
	public int getminX() {
		if (Lleaf.getminX()<=Rleaf.getminX()) {
			return Lleaf.getminX();
		}
		return Rleaf.getminX();
	}
	
	public int getminY() {
		if (Lleaf.getminY()<=Rleaf.getminY()) {
			return Lleaf.getminY();
		}
		return Rleaf.getminY();
	}
	
	@Override
	public abstract int belong(int x, int y);

	@Override
	public abstract void move(int dx, int dy);

	@Override
	public abstract String toString();

}
