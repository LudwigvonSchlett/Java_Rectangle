package forms;

import java.awt.Color;
import java.awt.Graphics;

public class Inter extends Duplet {

	private static final long serialVersionUID = -1428080441753075301L;

	public Inter () {}
	
	public Inter (Shape s1,Shape s2) {
		this.Lleaf=s1;
		this.Rleaf=s2;

		this.x1 = Math.max(s1.getX1(),s2.getX1());
		this.y1 = Math.max(s1.getY1(),s2.getY1());
		this.x2 = Math.min(s1.getX2(),s2.getX2());
		this.y2 = Math.min(s1.getY2(),s2.getY2());

		selected = -2;

		for(int y = this.y1; y<this.y2+1; y++) {
			for(int x = this.x1; x<this.x2+1; x++) {
				if (belong(x, y)==0) {
					selected = 0;
				}
			}
		}
		
		if (selected == -2) {
			this.x1 = -1;
			this.x2 = -1;
			this.y1 = -1;
			this.y2 = -1;
		}
		
	}

	@Override
	public int belong(int x, int y) {
		int result = 1; 
		if ((Lleaf.belong(x, y)==0)&&(Rleaf.belong(x, y)==0)) {
			result = 0;
		}	
		return result;
	}

	@Override
	public String toString() {
		//String result = "Inter : x1 = " + this.x1 +"  y1 = " + this.y1 + "  x2 = " + this.x2 + "  y2 = "+ this.y2+"\n";
		String result = "Inter :\n";
	    if (!(this.Lleaf instanceof Duplet)) {
	            result += " + " + this.Lleaf.toString() + "\n";
	    } else {
	        	result += " +  ";
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

	public void draw(Graphics g) {

		if (this.selected == 1) {
			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.BLACK);
		}

		int minx;
		int maxx;
		int drawLine;

		for(int y = this.y1; y<this.y2+2; y++) {
			minx = 0;
			maxx = 0;
			drawLine = 0;
			for(int x = this.x1; x<this.x2+2; x++) {
				if (drawLine == 0) {
					if (belong(x, y)==0){
						minx = x;
						maxx = x;
						drawLine = 1;
					}
				} else {
					if (belong(x, y)==1){
						g.drawLine(minx, y, maxx, y);
						drawLine = 0;
						if (belong(x, y)==1) {
							minx = x;
						}	
					} else {
						maxx = x;
					}
				}
			}
		}
	}

	public Shape copy(){
		Inter result = new Inter(Lleaf.copy(),Rleaf.copy());
		return result;
	}

}
