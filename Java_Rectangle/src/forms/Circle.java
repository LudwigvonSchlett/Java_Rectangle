package forms;



import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{

    private static final long serialVersionUID = 8548574475866868434L;

	public Circle() {}

    public Circle(double r, int cx, int cy) {
        this.r = r;
        this.cx = cx;
        this.cy = cy;

        if ((int) (cx - r + 0.5) < ((int) (cx - r)+1)) {
            this.x1 = (int) (cx - r);
        } else {
            this.x1 = (int) (cx - r + 1);
        }

        if ((int) (cy - r + 0.5) < ((int) (cy - r)+1)) {
            this.y1 = (int) (cy - r);
        } else {
            this.y1 = (int) (cy - r + 1);
        }

        if ((int) (cx + r + 0.5) < ((int) (cx + r)+1)) {
            this.x2 = (int) (cx + r);
        } else {
            this.x2 = (int) (cx + r + 1);
        }

        if ((int) (cy + r + 0.5) < ((int) (cy + r)+1)) {
            this.y2 = (int) (cy + r);
        } else {
            this.y2 = (int) (cy + r + 1);
        }

        
    }

    private double r;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    private int cx;

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    private int cy;

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    @Override
	public void select() {
		this.selected = 1;
	}

	@Override
	public void unselect() {
		this.selected = 0;
	}

	@Override
	public void draw(Graphics g) {

        if (this.selected == 1) {
			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.BLACK);
		}
		g.fillOval(this.x1, this.y1, this.x2-this.x1, this.y2-this.y1);  
	}

	@Override
	public Shape copy() {
		Circle result = new Circle(this.r, this.cx, this.cy);
		return result;
	}

    @Override
    public int belong(int x, int y) {
        int result = 1;
        
        double r = Math.sqrt(Math.pow(this.cx - x, 2) + Math.pow(this.cy - y, 2));

        /*
        if ((int) Math.sqrt(Math.pow(this.cx - x, 2) + Math.pow(this.cy - y, 2))<(int) (Math.sqrt(Math.pow(this.cx - x, 2) + Math.pow(this.cy - y, 2))+0.5)){
            r = (int) Math.sqrt(Math.pow(this.cx - x, 2) + Math.pow(this.cy - y, 2)) + 1;
        } else {
            r = (int) Math.sqrt(Math.pow(this.cx - x, 2) + Math.pow(this.cy - y, 2));
        }
        */

        if (r<=this.r){
            result = 0;
        }
        return result;
    }

    @Override
    public void move(int dx, int dy) {
        this.cx = this.cx + dx;
        this.cy = this.cy + dy;
        this.x1 = this.x1 + dx;
        this.y1 = this.y1 + dy;
        this.x2 = this.x2 + dx;
        this.y2 = this.y2 + dy;
        
    }

    @Override
    public String toString() {
        return ("Circle : x1 = " + this.x1 +"  y1 = " + this.y1 + "  x2 = " + this.x2 + "  y2 = "+ this.y2);
    }

    

}
