package form;

import java.io.Serializable;

public abstract class Shape implements Serializable{
	
	protected int x;
	
	protected int y;
	
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
	
	public abstract void saveBinary(String filename) throws Exception;
	
	public abstract void loadBinary(String filename) throws Exception;
	
	public abstract String toString();
	
	public abstract void move(int dx, int dy);

}
