package main;

public interface Select {
	public boolean isSelected();
	public boolean isGrouped();
	
	public void setDepth(int depth);
	public void select();
	public void unselect();
	public void movebyOffset(int dx, int dy);
	public void setGrouped(boolean grouped);
	// Set MenuItem when only one object is selected.
	public void setMI();
	
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
}
