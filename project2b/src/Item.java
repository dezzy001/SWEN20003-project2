/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Item {
	
	private final static int PICK_UP_RANGE = 50;
	
	private Image image = null;
	private double x, y;
	private int itemID;
	private boolean alreadyBuffed = false;
	
	//if player has picked up the item
	private boolean pickedUp = false;
	
	
    public Item(String image_path, double x, double y)
            throws SlickException{
    	
            setImage(new Image(image_path));
            
            this.x = x;
            this.y = y;
        }
	
	public void renderImage(Graphics g){
		image.drawCentered((int)this.getX(), (int)this.getY());
	}
	
	//if the item is within players range, player picks up item
	public void update(World world) {
		if (ItemManager.itemNearPlayer(world.getPlayer(), this, PICK_UP_RANGE)) {
			pickedUp = true;
			this.setImage(null);
		}
	}
	
	public abstract void onPickUp(BuffState buffs);

	
	
	//ONLY GETTERS AND SETTERS BELOW
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public boolean isAlreadyBuffed() {
		return alreadyBuffed;
	}

	public void setAlreadyBuffed(boolean alreadyBuffed) {
		this.alreadyBuffed = alreadyBuffed;
	}
	
	
	
	
	
}
