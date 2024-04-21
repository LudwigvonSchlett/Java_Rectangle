package forms;


public class TerminalDemo {
	
	protected static int maxheight = 50;
	
	protected static int maxwidth = 180;
	
	private static String file  = "SimpleShape.xml";
	
	public TerminalDemo() {}
	
	public static void paint(Scene sc) {
		String result="";
		for(int y = 0; y<maxheight; y++) {
			
			for(int x = 0; x<maxwidth; x++) {
				if (sc.belong(x, y) == 1) {
					result+="-";
				}
					
				else if (sc.belong(x, y)==0){
					result+="#";
				}
				else {
					result+="=";
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
	
	public static void main(String[] args) {
		
		Scene scene1 = new Scene(1920,1080);
		
		//Scene scene1 = Scene.loadXML(file);
		
		Rect r1 = new Rect(5,5,10,10);
		
		Rect r2 = new Rect(7,7,12,12);
		
		Rect r3 = new Rect(2,5,7,15);
		
		Rect r4 = new Rect(5,7,10,9);
		
		Union u1 = new Union(r1,r2);
		
		Inter i1 = new Inter(u1,r3);
		
		Diffe d1 = new Diffe(i1,r4);
		
		scene1.add(d1);
		
		paint(scene1);
		
		System.out.println(scene1);
		
		jump();
		
		//scene1.Gcontent.get(0).move(10,10);
		
		//paint(scene1);
		
		//System.out.println(scene1);
		
		//scene1.saveXML(file);
		
	}
		
}