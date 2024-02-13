package form;

public class Group extends Element{
		
	private  Element[] member;
	
	public Group(Element subgroup) {
		this.member[0]=subgroup;
	}

	public Element[] getMember() {
		return member;
	}

	public void setMember(Element[] member) {
		this.member = member;
	}
	
	public void addMember(Element subgroup) {
		this.member[this.member.length]=subgroup;
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
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		for(Element m:member) {
			m.delete();
			m=null;
		}
		
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
