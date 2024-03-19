package form;

import java.util.List;
import java.awt.Graphics;
import java.util.ArrayList;


public class Group extends Shape{
		
	private  List<Shape> member = new ArrayList<Shape>();
	
	public Group() {
		this.x = -1;
		this.y = -1;
		this.dx = -1;
		this.dx = -1;
	}

	public List<Shape> getMember() {
		return member;
	}

	public void setMember(List<Shape> member) {
		this.member = member;
	}
	
	public void addMember(Shape subgroup) {
		this.member.add(subgroup);
		
		if(this.x > subgroup.getX()) {
			this.x = subgroup.getX();
		}
		if(this.y > subgroup.getY()) {
			this.y = subgroup.getY();
		}
		if(this.dx > subgroup.getDX()) {
			this.dx = subgroup.getDX();
		}
		if(this.dy > subgroup.getDY()) {
			this.dy = subgroup.getDY();
		}
				
		if(this.x == -1) {
			this.x = subgroup.getX();
			this.y = subgroup.getY();
			this.dx = subgroup.getDX();
			this.dy = subgroup.getDY();
		}
		
	}

	@Override
	public String toString() {
	    String result = "";
	    for (Shape m : member) {
	        if (!(m instanceof Group)) {
	            
	            result += "|-----";
	            result += " " + m.toString() + "\n";
	        } else {
	            
	        	result += "|----- Group :\n";

	            String[] lines = m.toString().split("\\r?\\n");
	            
	            for (int i = 0; i < lines.length; i++) {
	            	lines[i] = "|      " + lines[i];
	            }
				
	            
	            result += String.join(System.lineSeparator(), lines);
	            result += "\n|\n";
	            
	            
	        }
	    }
	    return result;
	}

	@Override
	public void move(int dx, int dy) {
		if ((this.x+dx>=0) && (this.y+dy>=0)) {
			this.x=this.x+dx;
			this.y=this.y+dy;
			for(Shape m:member)
				m.move(dx, dy);
		}
		
	}

	@Override
	public void draw(Graphics g) {
		for(Shape m:member)
			m.draw(g);	
	}

	@Override
	public int Isin(int x, int y) {
		int result = 1; 
		for(Shape m:member) {
			if (m.Isin(x, y)==0) {
				result = 0;
			}
			
		}
			
		return result;
		
		
	}

}
