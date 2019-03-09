/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Elvira extends Villager{

	//talk strings
    private static final String NEED_HEAL = "You're looking much healthier now.";
    private static final String HEALED = "Return to me if you ever need healing.";
	
    private double healingTimer = 0;
	private double notHealingTimer = 0;
    
	//initial Elvira stats
    private static final int START_HP = 1;
    private static final int START_DAMAGE = 0;		
    private static final int START_COOLDOWN = 0;
	
	public Elvira(String image_path, double x, double y, String name,
			String text, boolean talking, int talkTime) throws SlickException {
		super(image_path, x, y, name, text, talking, talkTime);
		setUnitStats(new Stats(START_COOLDOWN,START_DAMAGE,START_HP,START_HP));
	}

	
	public void interact(int delta, World world) {

		if (UnitManager.unitNearPlayer(world.getPlayer(), this, this.getTalkRange())
				&& RPG.isInteract()
				&& world.getPlayer().getUnitStats().getHp() 
					== world.getPlayer().getUnitStats().getMaxHP()
				&& healingTimer <= 0){
			notHealingTimer = getMaxTalkingTime();
		}
		
		
		if (UnitManager.unitNearPlayer(world.getPlayer(), this, this.getTalkRange())
				&& RPG.isInteract()
				&& world.getPlayer().getUnitStats().getHp() 
					!= world.getPlayer().getUnitStats().getMaxHP()) {
			
			world.getPlayer().getUnitStats().setHp((world.getPlayer().getUnitStats().getMaxHP()));
			healingTimer = getMaxTalkingTime();
		}
		
		
		if (healingTimer > 0) {
			healingTimer -= delta;
		}
		if (notHealingTimer > 0) {
			notHealingTimer -= delta;
		}
	}

	
	public void renderTalk(World world, Graphics g) {
		if (notHealingTimer > 0) {
			g.drawString(HEALED, 300 - g.getFont().getWidth(HEALED)/2, 150);
		}
		
		if (healingTimer > 0) {
			g.drawString(NEED_HEAL, 300 - g.getFont().getWidth(NEED_HEAL)/2, 150);
		}

	}








	
}
