package form;

import java.util.ArrayList;

public class Group extends Element{
		
	private  ArrayList<Element> member;
	
	public Group(Element subgroup) {
		this.member = new ArrayList<Element>();
		this.member.add(subgroup);
	}

	public ArrayList<Element> getMember() {
		return member;
	}

	public void setMember(ArrayList<Element> member) {
		this.member = member;
	}
	
	public void addMember(Element subgroup) {
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
		for(Element m:member) {
			m.move(dx, dy);
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		for(Element m:member) {
			m.delete();
		}
		this.member = new ArrayList<Element>();
	}

	@Override
	public void union() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void intersect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void difference() {
		// TODO Auto-generated method stub
		
	}

}
