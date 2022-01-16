/**
 * 
 * Interface IGraphic is the mother class which will set the template for all graphic-related classes to use
 * 
 * It is directly implemented by two key abstract parent classes: Figure and Icons. These classes govern the behaviour of static and dynamic classes
 * 
 * IGraphic forms the layout for how the objects will be displayed on the screen
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PImage;
import processing.core.PApplet;

public interface IGraphic {

    /**
     * Sets the sprite of the object from a PImage object
     * 
     * @param sprite    the PImage representation of the graphic
     */
    
    public void setSprite(PImage sprite);

    /**
     * Draws the object into the program to be displayed
     * 
     * @param app   the App from which the program will run
     */

    public void draw(PApplet app);

    /**
     * Returns the x-value of the object
     * 
     * @return  the value of the x-coordinate of the object
     */

    public int getX();
    
    /**
     * Returns the y-value of the object
     * 
     * @return  the value of the y-coordinate of the object
     */

    public int getY();
}