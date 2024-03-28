package form;

import java.util.List;
import java.awt.Graphics;
import java.util.ArrayList;


public class Scene{
	
	protected  List<Shape> Gcontent = new ArrayList<Shape>();
	
	public Scene() {}
	
	public Scene(Shape s1) {
		Gcontent.add(s1);
	}
	
	public Scene(List<Shape> l1) {
		this.Gcontent = l1;
	}
	
	public List<Shape> getGcontent() {
		return Gcontent;
	}
	
	public void setGcontent(List<Shape> Lshape) {
		this.Gcontent = Lshape;
	}
	
	public void add(Shape subgroup) {
		
		Gcontent.add(subgroup);
			
	}

 @Override
	public String toString() {
	 	String result = "Scene \n";
	    for (Shape c : Gcontent) {
	        if (!(c instanceof Duplet)) {
	            
	            result += "|-----";
	            result += " " + c.toString() + "\n";
	        } else {
	        	result += "|----- ";
	            String[] lines = c.toString().split("\\r?\\n");
	            
	            for (int i = 1; i < lines.length; i++) {
	            	lines[i] = "|      " + lines[i];
	            }
	            result += String.join(System.lineSeparator(), lines);
	            result += "\n|\n";	            
	        }
	    }
	    return result;
	}

	public void draw(Graphics g) {
		for(Shape c:Gcontent)
			c.draw(g);	
	}

	public int Isin(int x, int y) {
		int result = 1; 
		for(Shape c:Gcontent) {
			if (c.Isin(x, y)==0) {
				result = 0;
			}	
		}
		return result;
	}

}