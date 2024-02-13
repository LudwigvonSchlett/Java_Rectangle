package form;

import java.io.Serializable;

public abstract class Element implements Serializable{
	
	public abstract void saveBinary(String filename) throws Exception;
	
	public abstract void loadBinary(String filename) throws Exception;
	
	public abstract String toString();
	
	public abstract void move();
	
	public abstract void delete();
	
	public abstract void union();
	
	public abstract void intersect();
	
	public abstract void difference();

}
