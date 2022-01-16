/**
 * IUserControllable is the interface which provides a template to describe how player-controlled objects are the be governed
 * 
 * Specifically, this concerns the BombGuy object, whose movements and actions are controlled by the player
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */

package demolition;


public interface IUserControllable {

    /**
     * Updates the position and status of the game
     */
    
    public void tick();

    /**
     * Attempts to move the bomb guy figure one tile left
     */

    public void pressLeft();

    /**
     * Attempts to move the bomb guy figure one tile right
     */

    public void pressRight();

    /**
     * Attempts to move the bomb guy figure one tile up
     */

    public void pressUp();

    /**
     * Attempts to move the bomb guy figure one tile down
     */

    public void pressDown();

    /**
     * Deploys a bomb
     */

    public void pressSpace();

    /**
     * Returns true if the bomb is ready for deploy, false otherwise
     * 
     * @return  whether the bomb is ready for deploy
     */

    public boolean bombReady();

    /**
     * Sets the bomb to deployed stage by making bombReady false
     */

    public void bombDeployed();

    /**
     * Sets the game to the next level
     */

    public void nextLevel();
}
