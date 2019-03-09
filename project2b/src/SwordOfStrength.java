import org.newdawn.slick.SlickException;

public class SwordOfStrength extends Item{
	
	private final static int MAX_DAMAGE = 30;
	
	private final static int ITEM_ID = 1;
    public SwordOfStrength(String image_path, double x, double y)
            throws SlickException{
    		super(image_path,  x,  y);
    		this.setItemID(ITEM_ID);
        }

	public void onPickUp(BuffState buffs){
		if(this.isPickedUp() == true && this.isAlreadyBuffed() == false){
			buffs.setBuffDamage(buffs.getBuffDamage() + MAX_DAMAGE);
			this.setAlreadyBuffed(true);
		}
	}
	
}
