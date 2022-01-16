/**
 * 
 * Explosion class creates the explosion graphic which will be displayed in the map when a bomb is detonated
 * 
 * The explosion object handles the graphics of displaying the explsion, with the Runner class handling the frame updates of the explosion
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PImage;
import processing.core.PApplet;
import demolition.Icons;

public class Explosion extends Icons {

    private PImage sprite;

    /**
     * Creates a new explosion object which extends from all of the attributes and methods from the Icons super class, including setSprite(), draw(), getX() and getY().
     * 
     * @param x     the x-coordinate of the explosion
     * @param y     the y-coordinate of the explosion
     * 
     * @see         Icons
     * @since       1.0
     */

    public Explosion(int x, int y) {

        super(x, y);
    }


    /**
     * Sets the sprite of the explosion from the file loaded in the directory
     * 
     * @param sprite    the PImage representation of the graphic
     */

    public void setSprite(PImage sprite) {

        this.sprite = sprite;
    }

    /**
     * Draw method overrides the existing draw() method defined in the Icons super class, 
     * so the explosion can set its display coordinates in the horizontal and vertical directions in adjacent tiles
     * 
     * @param app   the App from which the program will run
     * @param x     the x-coordinate where the explosion will be displayed
     * @param y     the y-coordinate where the explosion will be displayed
     */

    public void draw(PApplet app, int x, int y) {

        app.image(this.sprite, x, y);
    }
}
