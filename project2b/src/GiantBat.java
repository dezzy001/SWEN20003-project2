/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

import org.newdawn.slick.SlickException;

public class GiantBat extends PassiveMonster {

    //initial GiantBat stats
    private static final int START_HP = 40;
    private static final int START_DAMAGE = 0;		
    private static final int START_COOLDOWN = 0;
	
	public GiantBat(String image_path, double x, double y, String name) throws SlickException {
		super(image_path, x, y, name);
		setUnitStats(new Stats(START_COOLDOWN,START_DAMAGE,START_HP,START_HP));
	}


}
