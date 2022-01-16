/**
 * Clock is the object used to store the clock/timer icon displayed at the top of the map throughout the gameplay.
 * 
 * The x and y coordinates of the clock are passed as arguments when constructing the object.
 * 
 * This corresponds to a specific position denoted by App.java, which draws the clock graphic into the coordinates.
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PImage;

public class Clock extends Icons {

    /**
     * Creates a new clock object which extends from all of the attributes and methods from the Icons super class, including setSprite(), draw(), getX() and getY().
     * 
     * @param x     the x-coordinate of the clock
     * @param y     the y-coordinate of the clock
     * @see         Icons
     * @since       1.0
     */
    
    public Clock(int x, int y) {

        super(x, y);
    }
}