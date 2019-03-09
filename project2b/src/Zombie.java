/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

import org.newdawn.slick.SlickException;

public class Zombie extends AggressiveMonster{

    //initial Zombie stats
    private static final int START_HP = 60;
    private static final int START_DAMAGE = 10;		
    private static final int START_COOLDOWN = 800;
	
	public Zombie(String image_path, double x, double y, String name) throws SlickException {
		super(image_path, x, y, name);
		setUnitStats(new Stats(START_COOLDOWN,START_DAMAGE,START_HP,START_HP));
	}





}
