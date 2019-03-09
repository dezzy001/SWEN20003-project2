import org.newdawn.slick.SlickException;

public class ElixirOfLife extends Item{

	private final static int ITEM_ID = 3;
	
    public ElixirOfLife(String image_path, double x, double y)
            throws SlickException{
    		super(image_path,  x,  y);
    		this.setItemID(ITEM_ID);
        }

	@Override
	public void onPickUp(BuffState buffs) {
		//doesn't buff
	}
}
