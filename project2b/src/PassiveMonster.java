/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

import org.newdawn.slick.SlickException;

public abstract class PassiveMonster extends Unit{
	 
	private final static double SPEED = 0.2;
	
	
	private final static double WANDER_RESET_TIME = 3000;
	private final static double RUN_TIME = 5000;
	
	private final static int PLAYER_ATTACK_RANGE = 50;
	private double attackedTime = RUN_TIME;
	private double moveTime = 0;
	

	
	//directions represented as integers
	private final static int UP = 1;
	private final static int DOWN = 2;
	private final static int LEFT = 3;
	private final static int RIGHT = 4;
	private final static int UP_RIGHT = 5;
	
	private final static int DOWN_RIGHT = 6;
	private final static int DOWN_LEFT = 7;
	private final static int UP_LEFT = 8;
	private final static int NO_DIRECTION = 9;
	
	//how many directions it can move in
	private final static int NUM_OF_DIRECTIONS = 9;

	//int direction;
	private int getDirection(){
		
		return (int)(Math.random() * NUM_OF_DIRECTIONS);
	}
	
	private int currentDirection = getDirection();
	
	public PassiveMonster(String image_path, double x, double y, String name) throws SlickException {
		super(image_path, x, y, name);
		
		//ensures proper blocking
		setWidth(getImage().getWidth()/2);
		setHeight(getImage().getHeight()/2);
	}
	
	
	public void update(World world, int delta){
		
		//distance variables for the algorithm-------------------------------------
		double  distTotal, dX, dY;
		
		//total distance away from player
		distTotal = Math.sqrt(Math.pow(this.getX() - world.getPlayer().getX(), 2)
							+ Math.pow(this.getY() - world.getPlayer().getY(), 2));
		
		//the x and y distances the monster has to move this frame in pixels
		dX = (this.getX() - world.getPlayer().getX()) / distTotal * SPEED * delta;
		dY = (this.getY() - world.getPlayer().getY()) / distTotal * SPEED * delta;
		
		/* set the new x and y */
		double new_x = this.getX() + dX;
		double new_y = this.getY() + dY;
		
		//running away sequence -------------------------------------------------------
		//if player is close enough to attack, and player presses "A"
		if (UnitManager.unitNearPlayer(world.getPlayer(), this, PLAYER_ATTACK_RANGE) 
				&& RPG.isAttacking()) {
			attackedTime = 0;
		}
		
		// if attacked (i.e attack time is 0)
		if(attackedTime < RUN_TIME){
			
			attackedTime += delta;
			super.move(world,new_x, new_y);
			
		// wander sequence----------------------------------------------------
		}else {
			
			// if wander time hasn't hit the cap ,increase it
			if (moveTime < WANDER_RESET_TIME){
				moveTime = moveTime + delta; 
			
			// if wander time hits cap time
			} else if (moveTime >= WANDER_RESET_TIME) {
				//reset wander direction and wander time
				moveTime = 0;
				moveTime +=  delta;
				currentDirection = getDirection();
			}
			wanderPassiveMonster(delta, world);
		}
		
	}
	
	
	public void wanderPassiveMonster(int delta,World world){
		
		double new_x = this.getX();
		double new_y = this.getY();
		
		if (currentDirection == UP) {
			new_x = this.getX();
			new_y = this.getY() - (SPEED * delta);
		} else if (currentDirection == DOWN) {
			new_x = this.getX();
			new_y = this.getY() + (SPEED * delta);
		} else if (currentDirection == LEFT) {
			new_x = this.getX() - (SPEED * delta);
			new_y = this.getY();
		} else if (currentDirection == RIGHT) {
			new_x = this.getX() + (SPEED * delta);
			new_y = this.getY();
		} else if (currentDirection == UP_RIGHT) {
			new_x = this.getX() + Math.cos(Math.PI/4) * (SPEED * delta);
			new_y = this.getY() -  Math.cos(Math.PI/4) * (SPEED * delta);
		} else if (currentDirection == DOWN_RIGHT) {
			new_x = this.getX() +  Math.cos(Math.PI/4)  * (SPEED * delta);
			new_y = this.getY() +  Math.cos(Math.PI/4)  * (SPEED * delta);
		} else if (currentDirection == DOWN_LEFT) {
			new_x = this.getX() -  Math.cos(Math.PI/4)  * (SPEED * delta);
			new_y = this.getY() +  Math.cos(Math.PI/4)  * (SPEED * delta);
		} else if (currentDirection == UP_LEFT) {
			new_x = this.getX() -  Math.cos(Math.PI/4)  * (SPEED * delta);
			new_y = this.getY() -  Math.cos(Math.PI/4)  * (SPEED * delta);
		} else if (currentDirection == NO_DIRECTION) {
			//stand in the same coordinates
		}
		
		//use the unit move method
		super.move(world,new_x, new_y);
	}

	//ONLY GETTERS AND SETTERS BELOW
	public double getAttackedTime() {
		return attackedTime;
	}


	public void setAttackedTime(double attackedTime) {
		this.attackedTime = attackedTime;
	}


	public double getMoveTime() {
		return moveTime;
	}


	public void setMoveTime(double moveTime) {
		this.moveTime = moveTime;
	}


	public int getCurrentDirection() {
		return currentDirection;
	}


	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}
	
	

	
}
