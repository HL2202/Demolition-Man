/**
 * Lives is the object used to keep track of and display the player's remaining lives in the game.
 * 
 * The x and y coordinates of the lives object are passed as arguments when constructing the object.
 * 
 * The coordinates corresponds to a specific position denoted by App.java, which displays the text to the coordinates.
 * 
 * The player starts with three lives. Whenever the player loses a life, the number of lives decreases by 1
 * 
 * When the number of lives reaches zero, the game automatically ends
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PImage;
import processing.core.PApplet;
import processing.core.PFont;
import java.awt.Font;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import demolition.TextDisplay;


public class Lives extends TextDisplay {

    private int numberLives;
    private PImage sprite; 

    private String fontName;


    /**
     * Creates a new lives object at the start of the game which extends from all of the attributes and methods from the TextDisplay super class, including text(), createFont(), textFont(), textSize(), getX() and getY().
     * 
     * @param x             the x-coordinate of the lives object
     * @param y             the y-coordinate of the lives object
     * 
     * @see         TextDisplay
     * @since       1.0
     */

    
    public Lives(int x, int y) {
        
        super(x, y);
        this.numberLives = 3;
        this.fontName = "src/main/resources/PressStart2P-Regular.ttf";
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

        app.text(this.numberLives, this.x, this.y);
    }


    /**
     * Returns the number of lives which the player has remaining
     * 
     * @return  the number of lives remaining
     */

    
    public int getNumberLives() {

        return this.numberLives;
    }


    /**
     * Decreases the number of lives the player has by 1
     */

    
    public void loseLife() {

        this.numberLives --;
    }

    /**
     * 
     * Resets the number of lives of the player back to 3
     */

    
    public void resetLives() {

        this.numberLives = 3;
    }
}
