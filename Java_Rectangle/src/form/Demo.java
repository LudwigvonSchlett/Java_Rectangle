package form;

import java.awt.Graphics;

public class Demo implements Runnable{
	
	public Graphics g;
	
	public Demo(Graphics g) {
		this.g = g;
	}

	@Override
	public void run() {
		Group maingroup = new Group();
		Group group1 = new Group();
		Rectangle rectangle1 = new Rectangle(100,100,200,200);
		Rectangle rectangle2 = new Rectangle(400,200,200,200);
		maingroup.addMember(group1);
		group1.addMember(rectangle1);
		group1.addMember(rectangle2);
		maingroup.draw(g);
		
	}
}
