package simpleform;

import java.util.List;
import java.util.ArrayList;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



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

	public int belong(int x, int y) {
		int result = 1; 
		for(Shape c:Gcontent) {
			if (c.belong(x, y)==0) {
				result = 0;
			}	
		}
		return result;
	}
	
	public void saveXML(String file) {
		try {
			XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
			e.writeObject(this);
			e.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	public static Scene loadXML(String file) {
		Scene result = new Scene();
		try {
			XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
			result = (Scene) d.readObject();
			d.close();		 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}