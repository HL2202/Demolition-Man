/**
 * Icons is an abstract super class object which forms the class base for all static objects: Wall, BrokenWall, EmptyTile, Clock, Player and Explosion
 * 
 * These static objects are objects that will never change their appearance/position irrespective of gameplay and player actions
 * 
 * The icons class extends from the IGraphic interface, which is the mother class for all graphics related classes and will implement methods to be used by its sub-class
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PImage;
import processing.core.PApplet;

import demolition.IGraphic;


public abstract class Icons implements IGraphic {
    
    protected int x, y;

    protected PImage sprite;

    /**
     * Draws all of the different icons available according to their position and sprite. 
     * 
     * If an icon has been replaced (BrokenWall object being destroyed by bomb object), it will draw in the replacement object (ie EmptyTile object)
     * 
     * Instance method to create the new icon to be inherited by all subclasses
     * 
     * @param x         the x-coordinate of the icon
     * @param y         the y-coordinate of the icon
     * 
     * @see             IGraphic
     * @since           1.0
     */

    public Icons(int x, int y) {

        this.x = x;
        this.y = y;
    }

    /**
     * Sets the sprite of the icon from the file loaded in the directory
     * 
     * @param sprite    the PImage representation of the graphic
     * 
     * @see             IGraphic
     * @since           1.0
     */

    public void setSprite(PImage sprite) {

        this.sprite = sprite;
    }

    /**
     * Draws the sprite set from the image loaded into the App.java
     * 
     * @param app       the App from which the program will run
     * 
     * @see             IGraphic
     * @since           1.0
     */

    public void draw(PApplet app) {

        app.image(this.sprite, this.x, this.y);
    }

    /**
     * Returns the x value of the icon coordinate, useful for testing, locating walls and replacing broken walls
     * 
     * @return          the x variable corresponding to the x-value position of the icon
     * 
     * @see             IGraphic
     * @since           1.0
     */

    public int getX() {
        
        return this.x;
    }

    /**
     * Returns the y value of the icon coordinate, useful for testing, locating walls and replacing broken walls
     * 
     * @return          the y variable corresponding to the y-value position of the icon
     * 
     * @see             IGraphic
     * @since           1.0
     */

    public int getY() {

        return this.y;
    }
}