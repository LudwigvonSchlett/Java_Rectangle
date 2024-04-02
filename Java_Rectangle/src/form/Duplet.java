package form;

import java.awt.Graphics;

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
	public int belong(int x, int y) {
		int result = 1; 
		if (this.visibility!=0) {
			if (Lleaf.belong(x, y)==0) {
				result = 0;
			}	
			if (Rleaf.belong(x, y)==0) {
				result = 0;
			}
		}
			
		return result;
	}

	@Override
	public void move(int dx, int dy) {
		if ((this.x+dx>=0) && (this.y+dy>=0)) {
			this.x=this.x+dx;
			this.y=this.y+dy;
			Lleaf.move(dx, dy);
			Rleaf.move(dx, dy);
		}
	}

	@Override
	public String toString() {
		String result = "Duplet : x = " + this.x +" y = " + this.y + " dx = " + this.dx + " dy = "+ this.dy + "\n";
	    if (!(this.Lleaf instanceof Duplet)) {
	            result += "|-----";
	            result += " " + this.Lleaf.toString() + "\n";
	    } else {
	        	result += "|----- ";
	            String[] lines = this.Lleaf.toString().split("\\r?\\n");
	            
	            for (int i = 1; i < lines.length; i++) {
	            	lines[i] = "|      " + lines[i];
	            }
	            result += String.join(System.lineSeparator(), lines);
	            result += "\n|\n";	            
	    }
	    if (!(this.Rleaf instanceof Duplet)) {
            	result += "|-----";
            	result += " " + this.Rleaf.toString() + "\n";
	    } else {
        		result += "|----- ";
        		String[] lines = this.Rleaf.toString().split("\\r?\\n");
            
        		for (int i = 1; i < lines.length; i++) {
        			lines[i] = "|      " + lines[i];
        		}
        		result += String.join(System.lineSeparator(), lines);
        		result += "\n|\n";	            
	    }
	    return result;
	}

	@Override
	public void draw(Graphics g) {
		Lleaf.draw(g);
		Rleaf.draw(g);
	}
	
}
