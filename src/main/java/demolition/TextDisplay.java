/**
 * TextDisplay is an abstract super class object which forms the class base for all text-related objects: EndScreen, Time and Lives
 * 
 * These text objects are objects that will display a certain text onto the screen, which may be changed throughout the game
 * 
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PApplet;
import processing.core.PFont;


public abstract class TextDisplay {
    
    protected int x;
    protected int y;

    protected float colourOne;
    protected float colourTwo;
    protected float colourThree;

    protected PFont font;
    protected float size;

    protected char[] charSet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R','S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    /**
     * Displays all of the differen texts all according to their position. 
     * 
     * If the text gets updated during the game, a new value will be displayed on the screen
     * 
     * Instance method to create the new text to be inherited by all subclasses
     * 
     * @param x         the x-coordinate of the text
     * @param y         the y-coordinate of the text
     * 
     * @since           1.0
     */

    public TextDisplay(int x, int y) {

        this.x = x;
        this.y = y;

        this.colourOne = 0;
        this.colourTwo = 0;
        this.colourThree = 0;

        this.size = 25;
    }

    /**
     * Abstract class to create the text which gets displayed by the subclass object
     * 
     * @param app   the App from which the program will run
     */

    public abstract void text(PApplet app);

    /**
     * Fill in the text to the colour black as set by the constructor
     * 
     * @param app   the App from which the program will run
     */

    public void fill(PApplet app) {

        app.fill(colourOne, colourThree, colourThree);
    }


    /**
     * Creates the font to be used to load the text
     * 
     * @param app       the App from which the program will run
     * @param fontName  the name of the font used represented as a string
     * @return          the font created as a PFont object
     */

    public PFont createFont(PApplet app, String fontName) {

        this.font = app.createFont(fontName, this.size, true, this.charSet);
        return this.font;
    }


    /**
     * Displays text with the font and size inputted
     * 
     * @param font  the font to be used for the text
     * @param size  the size of the text
     */


    public void textFont(PFont font, float size) {
        
        this.font = font;
        this.size = size;
    }


    /**
     * Sets the text size to be used to display the text
     * 
     * @param app   the size of the text
     */


    public void textSize(PApplet app) {
        
        app.textSize(this.size);
    }


    /**
     * Returns the x value of the text coordinate
     * 
     * @return          the x variable corresponding to the x-value position of the text
     * 
     */

    public int getX() {

        return this.x;
    }

    /**
     * Returns the y value of the text coordinate
     * 
     * @return          the y variable corresponding to the y-value position of the text
     * 
     */

    public int getY() {

        return this.y;
    }
}