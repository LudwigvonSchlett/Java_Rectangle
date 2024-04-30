package forms;

import java.awt.Graphics;

public class Union extends Duplet {
	
	public Union () {}
	
	public Union (Shape s1,Shape s2) {
		this.Lleaf=s1;
		this.Rleaf=s2;	

		this.x1 = Math.min(s1.getX1(), s2.getX1());
		this.y1 = Math.min(s1.getY1(), s2.getY1());
		this.x2 = Math.max(s1.getX2(), s2.getX2());
		this.y2 = Math.max(s1.getY2(), s2.getY2());
				
	}

	@Override
	public int belong(int x, int y) {
		int result = 1; 
		if ((Lleaf.belong(x, y)==0)||(Rleaf.belong(x, y)==0)) {
			result = 0;
		}	
		return result;
	}

	@Override
	public String toString() {
		String result = "Union :\n";
	    if (!(this.Lleaf instanceof Duplet)) {
	            result += " + " + this.Lleaf.toString() + "\n";
	    } else {
	        	result += " + ";

	            String[] lines = this.Lleaf.toString().split("\\r?\\n");
	            
	            for (int i = 1; i < lines.length; i++) {
	            	lines[i] = "   " + lines[i];
	            }
	            result += String.join(System.lineSeparator(), lines);
				result += "\n";	           
	    }
	    if (!(this.Rleaf instanceof Duplet)) {
            	result += " + " + this.Rleaf.toString() + "\n";
	    } else {
        		result += " + ";

        		String[] lines = this.Rleaf.toString().split("\\r?\\n");
            
        		for (int i = 1; i < lines.length; i++) {
        			lines[i] = "   " + lines[i];
        		}
        		result += String.join(System.lineSeparator(), lines);
				result += "\n";	            
	    }
	    return result;
	}

	@Override
	public void draw(Graphics g){
		Lleaf.draw(g);
		Rleaf.draw(g);
	}

	public Shape copy(){
		Union result = new Union(Lleaf.copy(),Rleaf.copy());
		return result;
	}

}
