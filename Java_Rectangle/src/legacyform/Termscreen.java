package legacyform;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Termscreen {
	
	protected static int maxheight = 20;
	
	protected static int maxwidth = 150;
	
	private static String file  = "Shape.xml";
	
	public Termscreen() {}
	
	public static void paint(Group g) {
		String result="";
		for(int y = 0; y<maxheight; y++) {
			
			for(int x = 0; x<maxwidth; x++) {
				if (g.Isin(x, y) == 1) {
					result+="*";
				}
					
				else if (g.Isin(x, y)==0){
					result+="#";
				}
				else {
					result+="-";
				}
			}
			
			result+="\n";
		}
		
		System.out.println(result);
	}
	
	public static void jump( ) {
		String result="";
		
		for(int x = 0; x<maxwidth; x++) {
			result += "=";
		}
		result+="\n";
		System.out.println(result);
	}
	
	public static void save(Group g1) {
		try {
			XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
			e.writeObject(g1);
			e.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	public static Group load() {
		Group result = new Group();
		try {
			XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
			result = (Group) d.readObject();
			d.close();		 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
				
		Group maingroup = new Group();
		
		Group group1 = new Group();
		
		Group group2 = new Group();
		
		Rectangle rectangle1 = Rectangle.createRectangle(4,4,6,6);
		
		Rectangle rectangle2 = Rectangle.createRectangle(2,2,12,12);
				
		group1.add(rectangle1);
		
		group2.add(rectangle2);
		
		//Group group3 = group1.Union(group2);
		
		maingroup.add(group1);
		
		maingroup.add(group2);
		
		//maingroup.add(group3);
		
		paint(maingroup);
		
		System.out.println(maingroup);
		
		jump();
		
		maingroup = Group.createGroup(group2.Intersect(group1));
		
		paint(maingroup);
		
		System.out.println(maingroup);
		
		jump();
		
		save(maingroup);
		
		/*
		
		maingroup = load();
		
		jump();
		
		paint(maingroup);
		
		System.out.println(maingroup);
		
		*/
		
	}
		
}