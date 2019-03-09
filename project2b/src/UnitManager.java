
public class UnitManager {

	
	public static boolean unitNearPlayer(Player player , Unit unit ,int range) {
		if (range >= Math.sqrt(Math.pow((unit.getX() - player.getX()), 2) 
				+ Math.pow((unit.getY() - player.getY()), 2))) {
			return true;
		} else {
			return false;
		}
	}
}
