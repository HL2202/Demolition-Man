/**
 * Player is the object used to store the bomb guy/player icon displayed at the top of the map throughout the gameplay.
 * 
 * The x and y coordinates of the player icon are passed as arguments when constructing the object.
 * 
 * This corresponds to a specific position denoted by App.java, which draws the player graphic into the coordinates.
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PImage;

public class Player extends Icons {

    /**
     * Creates a new player icon object which extends from all of the attributes and methods from the Icons super class, including setSprite(), draw(), getX() and getY().
     * 
     * @param x     the x-coordinate of the player icon
     * @param y     the y-coordinate of the player icon
     * @see         Icons
     * @since       1.0
     */
    
    public Player(int x, int y) {

        super(x, y);
    }
}
