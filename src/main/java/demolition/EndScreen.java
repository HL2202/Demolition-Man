/**
 * EndScreen is the object used to store the two forms of end screen to be displayed: "GAME OVER and "YOU WIN".
 * 
 * The x and y coordinates and display line of the end screen are passed as arguments when constructing the object.
 * 
 * The coordinates corresponds to a specific position denoted by App.java, which draws the end screen graphic into the coordinates.
 * 
 * The line can either be one of "GAME OVER" or "YOU WIN" depending on the outomce of the game
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */

package demolition;

import processing.core.PApplet;
import processing.core.PFont;

import demolition.TextDisplay;

public class EndScreen extends TextDisplay {
    
    private String line;

    /**
     * Creates a new end screen object which extends from all of the attributes and methods from the TextDisplay super class, including text(), createFont(), textFont(), textSize(), getX() and getY().
     * 
     * @param x     the x-coordinate of the end screen
     * @param y     the y-coordinate of the end screen
     * @param line  the line to be displayed based on the outcome of the game
     * 
     * @see         TextDisplay
     * @since       1.0
     */

    public EndScreen(int x, int y, String line) {
        
        super(x, y);
        this.line = line;
    }

    /**
     * Creates the text in the App.java to be displayed on the screen
     * 
     * Abstract method inherited from the TextDisplay class
     * 
     * @param app   the App from which the program will run
     * 
     * @see         TextDisplay
     * @since       1.0
     */

    public void text(PApplet app) {

        app.text(this.line, this.x, this.y);
    }   
}
