package simpleform;

public class Diffe extends Duplet {

	public Diffe () {}
	
	public Diffe (Shape s1,Shape s2) {
		this.Lleaf=s1;
		this.Rleaf=s2;

		this.x1=s1.getX1();
		this.x2=s1.getX2();
		this.y1=s1.getY1();
		this.y2=s1.getY2();
		
	}

	@Override
	public int belong(int x, int y) {
		int result = 1; 
		if ((Lleaf.belong(x, y)==0) && (Rleaf.belong(x, y)==1)) {
			result = 0;
		}	
		return result;
	}

	@Override
	public String toString() {
		String result = "Diffe :\n";
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
	            //result += "\n|\n";
				result += "\n";	 	            
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
        		//result += "\n|\n";
				result += "\n";	 	            
	    }
	    return result;
	}
}
