package simpleform;

public class Inter extends Duplet {

	public Inter () {}
	
	public Inter (Shape s1,Shape s2) {
		this.Lleaf=s1;
		this.x=s1.getX();
		this.y=s1.getY();
		this.Rleaf=s2;
		this.dx=s2.getX();
		this.dy=s2.getY();
		
	}

	@Override
	public int belong(int x, int y) {
		int result = 1; 
		if ((Lleaf.belong(x, y)==0) && (Rleaf.belong(x, y)==0)) {
			result = 0;
		}	
		return result;
	}

	@Override
	public void move(int dx, int dy) {
		if((getminX()+dx>=0)&&(getminY()+dy>=0)) {
			this.x=this.x+dx;
			this.y=this.y+dy;
			this.dx=this.dx+dx;
			this.dy=this.dy+dy;
			Lleaf.move(dx, dy);
			Rleaf.move(dx, dy);
		}
	}

	@Override
	public String toString() {
		String result = "Inter :\n";
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
}
