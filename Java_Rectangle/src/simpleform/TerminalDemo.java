package simpleform;


public class TerminalDemo {
	
	protected static int maxheight = 20;
	
	protected static int maxwidth = 150;
	
	private static String file  = "SimpleShape.xml";
	
	public TerminalDemo() {}
	
	public static void paint(Scene sc) {
		String result="";
		for(int y = 0; y<maxheight; y++) {
			
			for(int x = 0; x<maxwidth; x++) {
				if (sc.belong(x, y) == 1) {
					result+="*";
				}
					
				else if (sc.belong(x, y)==0){
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
	
	public static void main(String[] args) {
		
		Scene scene1 = new Scene();
		
		//Scene scene1 = Scene.load(file);
		
		paint(scene1);
		
		System.out.println(scene1);
		
	}
		
}