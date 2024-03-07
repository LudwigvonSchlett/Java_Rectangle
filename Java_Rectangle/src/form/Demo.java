package form;

public class Demo {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(0,0,2,3);
		System.out.println(rect1);
		rect1.move(-2, 6);
		System.out.println(rect1);
		rect1.move(5, -3);
		System.out.println(rect1);
		Group group1 = new Group(rect1);
		System.out.println(group1);
	}
}
