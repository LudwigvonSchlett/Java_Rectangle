package legacyform;

import java.util.List;
import java.awt.Graphics;
import java.util.ArrayList;


public class Group extends Shape{
	
	protected  List<Shape> Gcontent = new ArrayList<Shape>();
	
	public Group() {}
	
	public static Group createGroup(Shape s1) {
		Group result = new Group();
		result.add(s1);
		return result;
	}
	
	public List<Shape> getGcontent() {
		return Gcontent;
	}
	
	public void setGcontent(List<Shape> Lshape) {
		this.Gcontent = Lshape;
	}
	
	public void add(Shape subgroup) {
		
		Gcontent.add(subgroup);
				
		if(this.x == -1) {
			this.x = subgroup.getX();
			this.y = subgroup.getY();
			this.dx = subgroup.getDX();
			this.dy = subgroup.getDY();
		} else {
			updateCoord();
		}		
	}

 @Override
	public String toString() {
	 	updateCoord();
	    String result = "Group : x = " + this.x +" y = " + this.y + " dx = " + this.dx + " dy = "+ this.dy + "\n";
	    for (Shape c : Gcontent) {
	        if (!(c instanceof Group)) {
	            
	            result += "|-----";
	            result += " " + c.toString() + "\n";
	        } else {
	        	result += "|----- ";
	            String[] lines = c.toString().split("\\r?\\n");
	            
	            for (int i = 1; i < lines.length; i++) {
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
			for(Shape c:Gcontent)
				c.move(dx, dy);
		}
	}
	
	public void updateCoord() {
		
		int minx = this.x;
		int miny = this.y;
		int maxx = this.x;
		int maxy = this.y;
		
		for(Shape c:Gcontent) {
			
			if (c instanceof Group){
				((Group) c).updateCoord();
			}
			
			if(c.getX()<minx) {
				minx = c.getX();
			}
			if(c.getX()>maxx) {
				maxx = c.getX();
			} 
			
			if(c.getY()<miny) {
				miny = c.getY();
			}
			if(c.getY()>maxy) {
				maxy = c.getY();
			}
		}
		
		if (minx!=this.x) {
			this.x = minx;
		} 
		else if (maxx!=this.x) {
			this.x = maxx;
		}
		
		if (miny!=this.y) {
			this.y = miny;
		} 
		else if (maxy!=this.y) {
			this.y = maxy;
		}
		
		int mindx = this.dx;
		int mindy = this.dy;
		int maxdx = this.dx;
		int maxdy = this.dy;
			
		
		for(Shape c:Gcontent) {
			
			if (c instanceof Group){
				((Group) c).updateCoord();
			}
			
			if((c.getX()+c.getDX()-this.x)>(maxdx)) {
				maxdx = (c.getX()+c.getDX()-this.x);
			}
			if((c.getX()+c.getDX()-this.x)<(mindx)) {
				mindx = (c.getX()+c.getDX()-this.x);
			}
			
			if((c.getY()+c.getDY()-this.y)>(mindy)) {
				maxdy = (c.getY()+c.getDY()-this.y);
			}
			if((c.getY()+c.getDY()-this.y)>(mindy)) {
				mindy = (c.getY()+c.getDY()-this.y);
			}
		}
		
		if (maxdx!=this.dx) {
			this.dx = maxdx;
		} 
		else if (mindx!=this.dx) {
			this.dx = mindx;
		}
		
		if (maxdy!=this.dy) {
			this.dy = maxdy;
		} 
		else if (mindy!=this.dy) {
			this.dy = mindy;
		}	
	}

	@Override
	public void draw(Graphics g) {
		for(Shape c:Gcontent)
			c.draw(g);	
	}

	@Override
	public int Isin(int x, int y) {
		int result = 1; 
		for(Shape c:Gcontent) {
			if (c.Isin(x, y)==0) {
				result = 0;
			}	
		}
		return result;
	}
	
	public void Unite2G(Group g2) {
		List<Shape> subgroup = g2.getGcontent();
		for(Shape c:subgroup) {
			add(c);
		}
		updateCoord();
	}

	@Override
	public Group Intersect(Shape s1) {
		Group result = new Group();
		for(Shape c:Gcontent) {
			result.Unite2G(c.Intersect(s1));
		}
		result.updateCoord();
		return result;
	}

}