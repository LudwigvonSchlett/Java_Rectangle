package simpleform;

public class Union extends Duplet {
	
	public Union () {}
	
	public Union (Shape s1,Shape s2) {
		this.Lleaf=s1;
		this.Rleaf=s2;

		/*
		if(((s1.getX1()<0)||(s2.getX1()<0))&&((s1.getY1()<0)||(s2.getY1()<0))){
			this.x1=-1;
			this.x2=-1;
			this.y1=-1;
			this.y2=-1;
			return;
		}
		if((s2.getX1()<0)||(s2.getY1()<0)){
			this.x1=s1.getX1();
			this.x2=s1.getX2();
			this.y1=s1.getY1();
			this.y2=s1.getY2();
			return;
		}
		if((s1.getX1()<0)||(s1.getY1()<0)){
			this.x1=s2.getX1();
			this.x2=s2.getX2();
			this.y1=s2.getY1();
			this.y2=s2.getY2();
			return;
		}
		*/		

		if(s1.getX1()<=s2.getX1()) {
			this.x1=s1.getX1();
		} else {
			this.x1=s2.getX1();
		}
		if(s1.getY1()<=s2.getY1()) {
			this.x1=s1.getY1();
		} else {
			this.x1=s2.getY1();
		}
		if(s1.getX2()>=s2.getX2()) {
			this.x1=s1.getX2();
		} else {
			this.x1=s2.getX2();
		}
		if(s1.getY2()>=s2.getY2()) {
			this.x1=s1.getY2();
		} else {
			this.x1=s2.getY2();
		}		
	}

	@Override
	public int belong(int x, int y) {
		int result = 1; 
		if ((Lleaf.belong(x, y)==0)) {
			result = 0;
			return result;
		}	
		if ((Rleaf.belong(x, y)==0)) {
			result = 0;
			return result;
		}
		return result;
	}

	@Override
	public String toString() {
		String result = "Union :\n";
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
