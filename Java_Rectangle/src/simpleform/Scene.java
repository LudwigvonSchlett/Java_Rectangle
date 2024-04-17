package simpleform;

import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



public class Scene{
	
	protected  List<Shape> Gcontent = new ArrayList<Shape>();
	
	public List<Shape> getGcontent() {
		return Gcontent;
	}
	
	public void setGcontent(List<Shape> Lshape) {
		this.Gcontent = Lshape;
	}
	
	protected int height = 1080;
	
	public void setHeight(int h) {
		this.height=h;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	protected int width = 1920;
	
	public void setWidth(int w) {
		this.width=w;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public Scene() {}
	
	public Scene(Shape s1) {
		Gcontent.add(s1);
	}
	
	public Scene(List<Shape> l1) {
		this.Gcontent = l1;
	}
	
	public Scene(int w, int h) {
		this.width=w;
		this.height=h;
	}
	
	public Scene(Shape s1, int w, int h) {
		Gcontent.add(s1);
		this.width=w;
		this.height=h;
	}
	
	public Scene(List<Shape> l1, int w, int h) {
		this.Gcontent = l1;
		this.width=w;
		this.height=h;
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
	            	lines[i] = "|     " + lines[i];
	            }
	            result += String.join(System.lineSeparator(), lines);
	            result += "\n\n";	            
	        }
	    }
	    return result;
	}

	public int belong(int x, int y) {
		int result = 1; 
		for(Shape c:Gcontent) {
			if ((c.getSelected()==1)&&(c.belong(x, y)==0)) {
				result = -1;
				return result;
			} else if(c.belong(x, y)==0){
				result = 0;
				return result;
			}
		}
		return result;
	}

	public void unselectall() {
		for(Shape c:Gcontent) {
			c.unselect();
		}
	}

	public Shape select(int x, int y){
		for(Shape c:Gcontent) {
			if(c.belong(x, y)==0){
				c.select();
				return c;
			}
		}
		return null;
	}
	
	public void draw(Graphics g) {

		int pixel = 0;

		for(int y = 0; y<height; y++) {
			
			for(int x = 0; x<width; x++) {

				g.setColor(Color.BLACK);
				pixel = 0;

				if((pixel==0)&&(belong(x,y)==0)) {
					pixel = 1;
				}
				if(belong(x, y)==-1) {
					g.setColor(Color.RED);
					pixel = 1;
				}

				if (pixel!=0){
					g.fillRect(x, y, 1, 1);
				}
				
			}
		}
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
		} catch (IOException error) {
			error.printStackTrace();
		}
		return result;
	}

}