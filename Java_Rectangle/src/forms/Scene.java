package forms;

import java.util.List;
import java.util.ArrayList;

import java.awt.Graphics;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;



public class Scene implements Serializable{
	
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

	public void remove(Shape subgroup) {
		Gcontent.remove(subgroup);			
	}

 	@Override
	public String toString() {
	 	String result = "Scene \n";
	    for (Shape c : Gcontent) {
	        if (!(c instanceof Duplet)) {
	            
	            result += " + " + c.toString() + "\n";

	        } else {
	        	result += " + ";
	            String[] lines = c.toString().split("\\r?\\n");
	            
	            for (int i = 1; i < lines.length; i++) {
	            	lines[i] = "   " + lines[i];
	            }
	            result += String.join(System.lineSeparator(), lines);
	            result += "\n";	            
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

	/**
	 * @return Une copie de la scene
	 */
	public Scene copy(){
		Scene result = new Scene(this.width, this.height);
		for(Shape c:Gcontent) {
			result.add(c.copy());
		}
		return result;
	}

	/**
	 * Désecltionne tous les éléments de la scène
	 */
	public void unselectall() {
		for(Shape c:Gcontent) {
			c.unselect();
		}
	}

	/**
	 * @return le premier élément correspondant au critère de sélection et le sélectionne
	 */
	public Shape select(int x, int y){
		Shape result = null;
		for(Shape c:Gcontent) {
			if((c.belong(x, y)==0)&&(result==null)&&(c.getSelected()==0)){
				c.select();
				result = c;
			} else {
				c.unselect();
			}
		}
		return result;
	}
	
	/**
	 * Dessine la scène
	 */
	public void draw(Graphics g) {
		for(Shape c:Gcontent) {
			c.draw(g);
		}
	}
	
	/**
	 * Exporte sous format XML
	 */
	public void saveXML(String file) {
		try {
			XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
			e.writeObject(this);
			e.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	/**
	 * Importe un fichier sous format XML
	 */
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
