/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Garth extends Villager{

	private static final String NEED_AMULET = "Find the Amulet of Vitality, across the river to the west.";
	private static final String NEED_SWORD = "Find the Sword of Strength - cross the bridge to the east, then head south.";
	private static final String NEED_TOME = "Find the Tome of Agility, in the Land of Shadows.";
	private static final String HAVE_ALL_ITEMS = "You have found all the treasure I know of.";

	//initial Garth stats
    private static final int START_HP = 1;
    private static final int START_DAMAGE = 0;		
    private static final int START_COOLDOWN = 0;
	
//	private boolean noAmulet = false;
//	private boolean noSword = false;
//	private boolean noTome = false;
	private double noAmuletTimer = 0;
	private double noSwordTimer = 0;
	private double noTomeTimer = 0;
	private double hasAllItemTimer = 0;
    
	public Garth(String image_path, double x, double y, String name,
			String text, boolean talking, int talkTime)
			throws SlickException {
		super(image_path, x, y, name, text, talking, talkTime);
		setUnitStats(new Stats(START_COOLDOWN,START_DAMAGE,START_HP,START_HP));
	}

	public void interact(int delta, World world) {
	
		if (UnitManager.unitNearPlayer(world.getPlayer(), this, this.getTalkRange())
				&& RPG.isInteract() 
				&& world.getPlayer().getInventory()[world.getAmuletID()] == false) 
		{
			
			
			noAmuletTimer = getMaxTalkingTime();
		}
		
		else if (UnitManager.unitNearPlayer(world.getPlayer(), this, this.getTalkRange())
				&& RPG.isInteract() 
				&& world.getPlayer().getInventory()[world.getSwordID()] == false) 
		{
			
			
			noSwordTimer = getMaxTalkingTime();
		}
		
		else if (UnitManager.unitNearPlayer(world.getPlayer(), this, this.getTalkRange())
				&& RPG.isInteract() 
				&& world.getPlayer().getInventory()[world.getTomeID()] == false) 
		{
			
			
			noTomeTimer = getMaxTalkingTime();
		}
		
		else if (UnitManager.unitNearPlayer(world.getPlayer(), this, this.getTalkRange())
				&& RPG.isInteract()) 
		{
			
			hasAllItemTimer = getMaxTalkingTime();
		}
		
		
		if (noAmuletTimer > 0) {
			noAmuletTimer -= delta;

		}
		if (noSwordTimer > 0) {
			noSwordTimer -= delta;
			
		}
		if (noTomeTimer > 0) {
			noTomeTimer -= delta;

		}
		if (hasAllItemTimer > 0) {
			hasAllItemTimer -= delta;

		}
		
	}
	
	public void renderTalk(World world, Graphics g) {

		if (noAmuletTimer > 0) {
			g.drawString(NEED_AMULET, 400 - g.getFont().getWidth(NEED_AMULET)/2, 350);
		}
		if (noSwordTimer > 0) {
			g.drawString(NEED_SWORD, 400 - g.getFont().getWidth(NEED_SWORD)/2, 350);
		}
		if (noTomeTimer > 0) {
			g.drawString(NEED_TOME, 400 - g.getFont().getWidth(NEED_TOME)/2, 350);
		}
		if (hasAllItemTimer > 0) {
			g.drawString(HAVE_ALL_ITEMS, 400 - g.getFont().getWidth(HAVE_ALL_ITEMS)/2, 350);
		}
		
	}



	
}

