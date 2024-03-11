package form;

import java.util.List;
import java.util.ArrayList;


public class Group extends Shape{
		
	private  List<Shape> member = new ArrayList<Shape>();
	
	public Group(Shape subgroup) {
		this.member.add(subgroup);
	}

	public List<Shape> getMember() {
		return member;
	}

	public void setMember(List<Shape> member) {
		this.member = member;
	}
	
	public void addMember(Shape subgroup) {
		this.member.add(subgroup);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(int dx, int dy) {
		for(Shape m:member) {
			m.move(dx, dy);
		}
	}

}
