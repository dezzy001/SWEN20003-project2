/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

import org.newdawn.slick.SlickException;

public class Draelic extends AggressiveMonster{

	
    //initial Draelic stats
    private static final int START_HP = 140;
    private static final int START_DAMAGE = 30;		
    private static final int START_COOLDOWN = 400;
	
	public Draelic(String image_path, double x, double y, String name) throws SlickException {
		super(image_path, x, y, name);
		setUnitStats(new Stats(START_COOLDOWN,START_DAMAGE,START_HP,START_HP));
	}



}
