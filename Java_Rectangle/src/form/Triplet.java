package form;

public abstract class Triplet extends Duplet {
	
	protected Shape Ileaf = null;
	
	public void setIleaf(Shape s1) {
		this.Ileaf=s1;
	}
	
	public Shape getIleaf() {
		return this.Ileaf;
	}
	
	@Override
	public void setVisibility(int vis) {
		/*
		TODO
		
		this.visibility = vis;
		Rleaf.visibility = vis;
		Lleaf.visibility = vis;
		
		*/
	}
	
	@Override
	public String toString() {
		String result = "Triplet : x = " + this.x +" y = " + this.y + " dx = " + this.dx + " dy = "+ this.dy + "\n";
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
	public void move(int dx, int dy) {
		if ((this.x+dx>=0) && (this.y+dy>=0)) {
			this.x=this.x+dx;
			this.y=this.y+dy;
			Lleaf.move(dx, dy);
			Rleaf.move(dx, dy);
			Ileaf.move(dx, dy);
		}
	}

	@Override
	public abstract Shape intersect(Shape s1);

}
