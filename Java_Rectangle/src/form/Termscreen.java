package form;

public class Termscreen {
	
	protected int maxheight = 20;
	
	protected int maxwidth = 150;
	
	public void paint(Group g) {
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
	
	public void jump( ) {
		String result="";
		
		for(int x = 0; x<maxwidth; x++) {
			result += "=";
		}
		result+="\n";
		System.out.println(result);
	}
	
	
	public Termscreen() {
		
	}
	
	public static void main(String[] args) {
		
		Termscreen term = new Termscreen();
		
		Group maingroup = new Group();
		
		Group group1 = new Group();
		
		Rectangle rectangle1 = new Rectangle(2,2,5,5);
		
		Rectangle rectangle2 = new Rectangle(7,7,5,5);
		
		//Rectangle rectangle2 = new Rectangle(80,10,50,30);
		
		maingroup.addMember(group1);
		
		group1.addMember(rectangle1);
		
		group1.addMember(rectangle2);
			
		term.paint(maingroup);
		
		term.jump();
		
		group1.move(50, 0);
		
		term.paint(maingroup);
		
	}
	
	
	
}
