package form;

public class Union extends Duplet {
	
	public Union() {}
	
	public Union(Shape Lleaf,Shape Rleaf) {
		this.Lleaf=Lleaf;
		this.Rleaf=Rleaf;
		if (Rleaf.getX()<=Lleaf.getX()) {
			this.x=Rleaf.getX();
			if (Rleaf.getDX()>(Lleaf.getX()-Rleaf.getX()+Lleaf.getDX())) {
				this.dx=Rleaf.getDX();
			} else {
				this.dx=Lleaf.getX()-Rleaf.getX()+Lleaf.getDX();
			}
		}
		else {
			this.x=Lleaf.getX();
			if (Lleaf.getDX()>(Rleaf.getX()-Lleaf.getX()+Rleaf.getDX())) {
				this.dx=Lleaf.getDX();
			} else {
				this.dx=Rleaf.getX()-Lleaf.getX()+Rleaf.getDX();
			}
		}
		if (Rleaf.getY()<=Lleaf.getY()) {
			this.y=Rleaf.getY();
			if (Rleaf.getDY()>(Lleaf.getY()-Rleaf.getY()+Lleaf.getDY())) {
				this.dy=Rleaf.getDY();
			} else {
				this.dy=Lleaf.getY()-Rleaf.getY()+Lleaf.getDY();
			}
		}
		else {
			this.y=Lleaf.getY();
			if (Lleaf.getDY()>(Rleaf.getY()-Lleaf.getY()+Rleaf.getDY())) {
				this.dy=Lleaf.getDY();
			} else {
				this.dy=Rleaf.getY()-Lleaf.getY()+Rleaf.getDY();
			}
		}
	}
	
	@Override
	public String toString() {
		String result = "Union : x = " + this.x +" y = " + this.y + " dx = " + this.dx + " dy = "+ this.dy + "\n";
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
