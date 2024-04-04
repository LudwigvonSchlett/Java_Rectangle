package form;

import java.awt.Color;
import java.awt.Graphics;

public class Difference extends Triplet {
	
	public Difference() {}
	
	public Difference(Shape Lleaf,Shape Rleaf) {
		this.Lleaf = Lleaf;
		this.Rleaf = Rleaf;
		this.Ileaf = Lleaf.intersect(Rleaf);
		this.x=Lleaf.getX();
		this.y=Lleaf.getY();
		this.dx=Lleaf.getDX();
		this.dy=Lleaf.getDY();
	}
	
	@Override
	public String toString() {
		String result = "Difference : x = " + this.x +" y = " + this.y + " dx = " + this.dx + " dy = "+ this.dy + "\n";
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
	public Shape intersect(Shape s1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int belong(int x, int y) {
		int result = 1; 

		if ((this.visibility!=0)&&(Ileaf.getVisibility()!=0)&&(Lleaf.getVisibility()!=0)&&(Rleaf.belong(x, y)==1)) {
				return Lleaf.belong(x, y);
		}
		
		return result;
	}

	@Override
	public void draw(Graphics g) {
		Lleaf.draw(g);
		g.setColor(Color.WHITE);
		Ileaf.draw(g);
		g.setColor(Color.BLACK);

	}

}
