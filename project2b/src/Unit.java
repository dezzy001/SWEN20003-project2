/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Unit{
	
	private static final int PLAYER_RANGE = 50;
	
	private String name;
	private Image image = null;
	
	private Stats unitStats = null;
	
	private double attackTimer = 0;
	private boolean attack = true;
	
	//in pixels
	private double x, y;
	private double width, height;
	
    public Unit(String image_path, double x, double y, String name)
            throws SlickException{
    	
            setImage(new Image(image_path));
            this.name = name;
            
            this.x = x;
            this.y = y;
            
            this.width = image.getWidth();
            this.height = image.getHeight();
        }
	
	public int getImageWidth(){
		return image.getWidth();
	}
	
	public int getImageHeight(){
		return image.getHeight();
	}
	
	
	public void move(World world, double new_x, double new_y){
		
        // Move in x first
        double x_sign = Math.signum(new_x - getX());
        if(!world.terrainBlocks(new_x + x_sign * getWidth() / 2, getY() + getHeight() / 2) 
                && !world.terrainBlocks(new_x + x_sign * getWidth() / 2, getY() - getHeight() / 2)) {
            setX(new_x);
        }
        
        // Then move in y
        double y_sign = Math.signum(new_y - this.getY());
        if(!world.terrainBlocks(getX() + getWidth() / 2, new_y + y_sign * getHeight() / 2) 
                && !world.terrainBlocks(getX() - getWidth() / 2, new_y + y_sign * getHeight() / 2)){
            setY(new_y);
        }
		
	}
	
	public void renderImage(Graphics g){
		image.drawCentered((int)getX(), (int)getY());
	}
	
	
	
	public void renderHealthbar(Graphics g){
		
		Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp
        
        // Variables for layout
        String text;                // Text to display
        int text_x, text_y;         // Coordinates to draw text
        int bar_x, bar_y;           // Coordinates to draw rectangles
        int bar_width, bar_height;  // Size of rectangle to draw
        int hp_bar_width;           // Size of red (HP) rectangle
        
        text = this.getName();
        
        bar_width = g.getFont().getWidth(text) + 6 > 70 ?
        					g.getFont().getWidth(text) + 6: 70;
        bar_height = g.getFont().getHeight(text) + 5;
        
        bar_x = (int) this.getX() - bar_width/2 ;
        bar_y = (int) this.getY() - 50;
        
        float health_percent = (float) (this.getUnitStats().getPercentHP());
       
        //hp bar cannot go below 0 
        hp_bar_width = (int) (bar_width * health_percent) >= 0 ?
        				(int) (bar_width * health_percent): 0;
        				
		text_y = (int) this.getY() - 50;
		text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

	}
	

	//Player attacking a monster
	public void attackMonster(World world){
		if ((UnitManager.unitNearPlayer(world.getPlayer(),this,PLAYER_RANGE) == true 
					&& RPG.isAttacking()) && world.getPlayer().isAttack()) {
			this.getUnitStats().reduceHP(world.getPlayer().damageAmount());
			
		}else{
			
		}
	}
	
	
	//Player attacked by a monster (with cooldown)
	public void monsterAttacking(World world, int delta){
		
		this.setAttackTimer(this.getAttackTimer() - delta );
		if (this.getAttackTimer() <= 0) {
			world.getPlayer().getUnitStats().reduceHP(this.damageAmount());
			this.setAttackTimer( this.getUnitStats().getCooldown() );
		}
	}
	
	public int damageAmount(){
		return  (int) (Math.random() * this.getUnitStats().getMaxDamage());
	}
	

	
	

	//GETTERS AND SETTERS ALL BELOW --------------------
	
	public boolean isAttack() {
		return attack;
	}

	public void setAttack(boolean attack) {
		this.attack = attack;
	}
	
	public Stats getUnitStats() {
		return unitStats;
	}

	public void setUnitStats(Stats unitStats) {
		this.unitStats = unitStats;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public double getAttackTimer() {
		return attackTimer;
	}

	public void setAttackTimer(double attackTimer) {
		this.attackTimer = attackTimer;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	




	
	

	
	
}
