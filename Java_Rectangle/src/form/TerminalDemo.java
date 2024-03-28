package form;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TerminalDemo {
	
	protected static int maxheight = 20;
	
	protected static int maxwidth = 150;
	
	private static String file  = "Shape.xml";
	
	public TerminalDemo() {}
	
	public static void paint(Scene sc) {
		String result="";
		for(int y = 0; y<maxheight; y++) {
			
			for(int x = 0; x<maxwidth; x++) {
				if (sc.Isin(x, y) == 1) {
					result+="*";
				}
					
				else if (sc.Isin(x, y)==0){
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
	
	public static void save(Scene sc) {
		try {
			XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
			e.writeObject(sc);
			e.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	public static Scene load() {
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
	
	public static void main(String[] args) {
		
		/*Scene scene1 = new Scene();
		
		Rectangle r1 = new Rectangle(5,5,10,10);
		
		Rectangle r2 = new Rectangle(2,2,2,2);
		
		Rectangle r3 = new Rectangle(15,3,4,4);
		
		Union u1 = new Union(r1,r2);
		
		Union u2 = new Union(u1,r3);
		
		scene1.add(u2);
		
		paint(scene1);
		
		System.out.println(scene1);
		
		save(scene1);*/
		
		Scene scene1 = load();
		
		paint(scene1);
		
		System.out.println(scene1);
		
	}
		
}