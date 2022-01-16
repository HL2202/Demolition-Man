/**
 * EmptyTile is the object used to store all of the empty tiles which will be loaded into the map.
 * 
 * The x and y coordinates of the empty tile are passed as arguments when constructing the object.
 * 
 * This corresponds to a specific position denoted by App.java, which draws the empty tile graphic into the coordinates.
 * 
 * 
 * A single pixel position which is 32 x 32 represents the tile denoted by the empty tile.
 * 
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */

package demolition;

import processing.core.PImage;

public class EmptyTile extends Icons {

    /**
     * Creates a new empty tile object which extends from all of the attributes and methods from the Icons super class, including setSprite(), draw(), getX() and getY().
     * 
     * @param x     the x-coordinate of the empty tile
     * @param y     the y-coordinate of the empty tile
     * @see         Icons
     * @since       1.0
     */

    public EmptyTile(int x, int y) {

        super(x, y);
    }
}