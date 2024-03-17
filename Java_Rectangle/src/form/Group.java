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
	public void saveBinary(String filename) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadBinary(String filename) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		String result = "Group :\n";
		for(Shape m:member) {
			result += "Subgroup : ";
			result += m.toString();
		}
		return result;
	}

	@Override
	public void move(int dx, int dy) {
		for(Shape m:member)
			m.move(dx, dy);
	}

	@Override
	public void draw(Graphics g) {
		for(Shape m:member)
			m.draw(g);
		
	}

}
