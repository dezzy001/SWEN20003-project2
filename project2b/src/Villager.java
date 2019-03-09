/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

import org.newdawn.slick.SlickException;

public abstract class Villager extends Unit {

	private static final int TALK_RANGE = 50;
	private static final double MAX_TALK_TIME = 3000;

	
	public Villager(String image_path, double x, double y, 
			String name ,String text, boolean talking, int talkTime) throws SlickException {
		
		super(image_path, x, y, name);
		

	}
	
	
	//GETTERS AND SETTERS ALL BELOW --------------


	public int getTalkRange() {
		return TALK_RANGE;
	}

	
	public double getMaxTalkingTime() {
		return MAX_TALK_TIME;
	}


	
	
}
