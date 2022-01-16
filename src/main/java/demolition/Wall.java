/**
 * Wall is the object used to store all of the solid walls which will be loaded into the map.
 * 
 * The x and y coordinates of the solid wall are passed as arguments when constructing the object.
 * 
 * This corresponds to a specific position denoted by App.java, which draws the solid wall graphic into the coordinates.
 * 
 *
 * A single pixel position which is 32 x 32 represents the tile denoted by the solid wall.
 *
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */

package demolition;

import processing.core.PImage;

public class Wall extends Icons {

    /**
     * Creates a new wall object which extends from all of the attributes and methods from the Icons super class, including setSprite(), draw(), getX() and getY().
     * 
     * @param x     the x-coordinate of the wall
     * @param y     the y-coordinate of the wall
     * @see         Icons
     * @since       1.0
     */

    public Wall(int x, int y) {

        super(x, y);
    }
}