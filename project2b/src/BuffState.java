/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

public class BuffState {
	
	int buffCooldown = 0;
	int buffDamage = 0;
	int buffMaxHP = 0;
	//no need for constructor
	
	
	//ONLY GETTERS AND SETTERS BELOW
	
	public int getBuffCooldown() {
		return buffCooldown;
	}
	public void setBuffCooldown(int buffCooldown) {
		this.buffCooldown = buffCooldown;
	}
	public int getBuffDamage() {
		return buffDamage;
	}
	public void setBuffDamage(int buffDamage) {
		this.buffDamage = buffDamage;
	}
	public int getBuffMaxHP() {
		return buffMaxHP;
	}
	public void setBuffMaxHP(int buffMaxHP) {
		this.buffMaxHP = buffMaxHP;
	}

	
	
	
}
