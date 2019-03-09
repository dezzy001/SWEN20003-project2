/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Code usage from Sample Solution
 * Author: Matt Giuca <mgiuca>
 * 
 * Name: Derek Chen 
 * Student_ID: 766509
 */

import java.io.FileNotFoundException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/** Main class for the Role-Playing Game engine.
 * Handles initialisation, input and rendering.
 */
public class RPG extends BasicGame
{
    /** Location of the "assets" directory. */
    public static final String ASSETS_PATH = "assets";
    public static final String DATA_PATH = "data";
    /** Screen width, in pixels. */
    public static final int SCREEN_WIDTH = 800;
    /** Screen height, in pixels. */
    public static final int SCREEN_HEIGHT = 600;
    /** The world of our game */
    private World world;
    /** Height of the player status panel*/
    public static final int PANEL_HEIGHT = 70;
    
    //check if attack button 'a' is held down
    private static boolean attacking = false;
    //check if talk button 't' is held down
    private static boolean interacting = false;
    
    //for testing purposes only
    private static boolean teleport = false;
    
    /** Create a new RPG object. */
    public RPG()
    {
        super("RPG Game Engine");
    }

    /** Initialise the game state.
     * @param gc The Slick game container object.
     */
    @Override
    public void init(GameContainer gc)
    throws SlickException
    {
        try {
			world = new World();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /** Update the game state for a frame.
     * @param gc The Slick game container object.
     * @param delta Time passed since last frame (milliseconds).
     */
    @Override
    public void update(GameContainer gc, int delta)
    throws SlickException
    {
        // Get data about the current input (keyboard state).
        Input input = gc.getInput();

        // Update the player's movement direction based on keyboard presses.
        int dir_x = 0;
        int dir_y = 0;
        if (input.isKeyDown(Input.KEY_DOWN))
            dir_y += 1;
        if (input.isKeyDown(Input.KEY_UP))
            dir_y -= 1;
        if (input.isKeyDown(Input.KEY_LEFT))
            dir_x -= 1;
        if (input.isKeyDown(Input.KEY_RIGHT))
            dir_x += 1;
        
        if(input.isKeyPressed(Input.KEY_ESCAPE)){
        	System.exit(0);
        }
        
        //testing purposes only (uncomment for teleport feature)
        /*
        if(input.isKeyPressed(Input.KEY_3)) {
        	teleport = true;
        }else {
        	teleport = false;
        }
        */
        
        // Press 'A' to attack
        if (input.isKeyDown(Input.KEY_A)) {
        	attacking = true;
        } else {
        	attacking = false;
        }
        
        // Press 'T' to interact
        if (input.isKeyDown(Input.KEY_T)) {
        	interacting = true;
        } else {
        	interacting = false;
        }
        
        // Let World.update decide what to do with this data.
        world.update(dir_x, dir_y, delta);
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param gc The Slick game container object.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(GameContainer gc, Graphics g)
    throws SlickException
    {
        // Let World.render handle the rendering.
        world.render(g);
    }

    /** Start-up method. Creates the game and runs it.
     * @param args Command-line arguments (ignored).
     */
    public static void main(String[] args)
    throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new RPG());
        // setShowFPS(true), to show frames-per-second.
        app.setShowFPS(true);
        app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
        app.start();
    }


    
    
    //ONLY GETTERS AND SETTERS BELOW
	public static boolean isAttacking() {
		return attacking;
	}

	public static void setAttacking(boolean attacking) {
		RPG.attacking = attacking;
	}

	public static boolean isInteract() {
		return interacting;
	}

	public static void setInteract(boolean interact) {
		RPG.interacting = interact;
	}

	public static boolean isTeleport() {
		return teleport;
	}

	public static void setTeleport(boolean teleport) {
		RPG.teleport = teleport;
	}
}
