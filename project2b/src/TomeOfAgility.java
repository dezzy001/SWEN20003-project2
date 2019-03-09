import org.newdawn.slick.SlickException;

public class TomeOfAgility extends Item{

	private final static int MAX_COOLDOWN = -300;
	
	private final static int ITEM_ID = 2;
	
    public TomeOfAgility(String image_path, double x, double y)
            throws SlickException{
    		super(image_path,  x,  y);
    		this.setItemID(ITEM_ID);
        }
    
	public void onPickUp(BuffState buffs){
		if(this.isPickedUp() == true && this.isAlreadyBuffed() == false){
			buffs.setBuffCooldown(buffs.getBuffCooldown() + MAX_COOLDOWN);
			this.setAlreadyBuffed(true);
		}
		
	}
    
}
