import org.newdawn.slick.SlickException;

public class AmuletOfVitality extends Item{

	private final static int MAX_HP = 80;
	
	private final static int ITEM_ID = 0;
	
    public AmuletOfVitality(String image_path, double x, double y)
            throws SlickException{
    		super(image_path,  x,  y);
			this.setItemID(ITEM_ID);
        }
	
	public void onPickUp(BuffState buffs){
		
		if(this.isPickedUp() == true && this.isAlreadyBuffed() == false){
			buffs.setBuffMaxHP(buffs.getBuffMaxHP() + MAX_HP);
			this.setAlreadyBuffed(true);
		}
	}


	
	
}
