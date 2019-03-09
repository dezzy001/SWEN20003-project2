/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

import org.newdawn.slick.SlickException;

public abstract class AggressiveMonster extends Unit{
	
	private final static int CHASING_PLAYER_RANGE = 150;
	private final static int ATTACK_PLAYER_RANGE = 50;
	private final static double SPEED = 0.25;

	
	public AggressiveMonster(String image_path, double x, double y, String name) throws SlickException {
		super(image_path, x, y, name);
		
		//ensures proper blocking
		setWidth(getImage().getWidth()/2);
		setHeight(getImage().getHeight()/2);
	}
	
	
	public void update( World world, int delta){
		
		//distance variables for the algorithm-------------------------------------
		double  distTotal, dX, dY;

		//total distance away from player
		distTotal = Math.sqrt(Math.pow(this.getX() - world.getPlayer().getX(), 2)
							+ Math.pow(this.getY() - world.getPlayer().getY(), 2));
		
		//the x and y distances the monster has to move this frame in pixels
		dX = (this.getX() - world.getPlayer().getX()) / distTotal * SPEED * delta;
		dY = (this.getY() - world.getPlayer().getY()) / distTotal * SPEED * delta;
		
		/* set the new x and y */
		double new_x = this.getX() - dX;
		double new_y = this.getY() - dY;
		
		
		//attacking sequences------------------------------------------------------
		
		//monster within player attack range, damages Player, with cooldown
		if(UnitManager.unitNearPlayer(world.getPlayer(), this, ATTACK_PLAYER_RANGE)){
			this.monsterAttacking(world, delta);
		
			//monster within player chase range
		}else if(UnitManager.unitNearPlayer(world.getPlayer(), this, CHASING_PLAYER_RANGE)){
			
			//use units move function
	        super.move(world, new_x, new_y);	
		}
			
	
	}
}
