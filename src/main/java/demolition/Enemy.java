/**
 * 
 * Enemy class is the abstract parent class of the two enemy classes in the game: red enemy and yellow enemy
 * 
 * Enemy class extends from the parent class Figure and inherits all of its methods
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */

package demolition;

import processing.core.PImage;
import processing.core.PApplet;


public abstract class Enemy extends Figure {
    
    public static final double SECONDS_BETWEEN_MOVES = 1;

    protected boolean enemyRemoved;

    /**
     * Creates the different enemies available according to their position. 
     * 
     * Instance method to create the new enemy to be inherited by all subclasses
     * 
     * @param x         the x-coordinate of the enemy
     * @param y         the y-coordinate of the enemy
     * 
     * @see             Figure
     * @since           1.0
     */

    public Enemy(int x, int y) {

        super(x, y);

        this.enemyRemoved = false;
    }

    /**
     * Removes an enemy from the map
     */

    public void remove() {

        this.enemyRemoved = true;
    }

    /**
     * Returns true if an enemy is removed, false otherwise
     * 
     * @return  whether the enemy is removed
     */

    public boolean isRemoved() {

        return this.enemyRemoved;
    }
}
