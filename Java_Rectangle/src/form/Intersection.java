package form;

import java.awt.Graphics;

public class Intersection extends Triplet {
	
	public Intersection() {}
	
	public Intersection(Shape Lleaf,Shape Rleaf) {
		this.Lleaf = Lleaf;
		this.Rleaf = Rleaf;
		this.Ileaf = Lleaf.intersect(Rleaf);
		this.x=Ileaf.getX();
		this.y=Ileaf.getY();
		this.dx=Ileaf.getDX();
		this.dy=Ileaf.getDY();
	}
	
	@Override
	public String toString() {
		String result = "Intersection : x = " + this.x +" y = " + this.y + " dx = " + this.dx + " dy = "+ this.dy + "\n";
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
		if (s1 instanceof Union) {
			Union s1casted = (Union) s1;
			return new Union(this.Ileaf.intersect(s1casted.getLleaf()),(this.Ileaf.intersect(s1casted.getRleaf())));
		}
		if (s1 instanceof Intersection) {
			Intersection s1casted = (Intersection) s1;
			return this.Ileaf.intersect(s1casted.getIleaf());
		}
		if (s1 instanceof Rectangle) {
			return this.Ileaf.intersect(s1);
		}
		
		return(new Rectangle(0,0,0,0));
	}

	@Override
	public int belong(int x, int y) {
		int result = 1; 

		if ((this.visibility!=0)&&(Ileaf.getVisibility()!=0)) {
				return Ileaf.belong(x, y);
		}
		
		return result;
	}

	@Override
	public void draw(Graphics g) {
		Ileaf.draw(g);
	}

}
