/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

public class ItemManager {
	
	//checks if the item is within players range to pick up
	public static boolean itemNearPlayer(Player player , Item item ,int range) {
		if (range >= Math.sqrt(Math.pow((item.getX() - player.getX()), 2) 
				+ Math.pow((item.getY() - player.getY()), 2))) {
			return true;
		} else {
			return false;
		}
	}


}
