/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

public class Stats {
	
	private double cooldown ;
	private double maxDamage;
	private double maxHP ;
	private double hp ; 
	
	public Stats(int cooldown,int maxDamage,int maxHP,int hp){
	  this.cooldown = cooldown;
	  this.maxDamage = maxDamage;
	  this.maxHP = maxHP;
	  this.hp = hp; 
	}
	

	public void reduceHP(double amount){
		setHp(hp - amount);
		
	}
	public void resetHP(){
		
		
	}
	
	public double getPercentHP(){
		return this.getHp()/this.getMaxHP();
	}

	
	// ONLY GETTERS AND SETTERS Below
	public double getCooldown() {
		return cooldown;
	}


	public void setCooldown(double cooldown) {
		this.cooldown = cooldown;
	}


	public double getMaxDamage() {
		return maxDamage;
	}


	public void setMaxDamage(double maxDamage) {
		this.maxDamage = maxDamage;
	}


	public double getMaxHP() {
		return maxHP;
	}


	public void setMaxHP(double maxHP) {
		this.maxHP = maxHP;
	}


	public double getHp() {
		return hp;
	}


	public void setHp(double hp) {
		this.hp = hp;
	}
	
	
	
	
}
