/**
 * Time is the object used to keep track of and display the time remaining in the game.
 * 
 * The x and y coordinates of the time object are passed as arguments when constructing the object.
 * 
 * The coordinates corresponds to a specific position denoted by App.java, which displays the text to the coordinates.
 * 
 * Every second in the game, the time will automatically update and display a new time, which will be a descending range from 180 down to 1 (inclusive)
 * 
 * When the time reaches zero, the game automatically ends
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PApplet;
import processing.core.PFont;

import demolition.TextDisplay;



public class Time extends TextDisplay {

    private int timeCount;

    private int timer;

    public static final double SECONDS_BETWEEN_TIME = 1;

    /**
     * Creates a new time object at the start of the game which extends from all of the attributes and methods from the TextDisplay super class, including text(), createFont(), textFont(), textSize(), getX() and getY().
     * 
     * @param x             the x-coordinate of the time object
     * @param y             the y-coordinate of the time object
     * 
     * @see         TextDisplay
     * @since       1.0
     */
    

    public Time(int x, int y) {
        
        super(x, y);
        this.timeCount = 180;
        this.timer = 0;
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

        app.text(this.timeCount, this.x, this.y);
    }

    /**
     * The method used to update the frame each tick and increment the timer
     * 
     * If the tick is called 60 times (one second), the timeCount will be updated by decreasing the value of the time remaining by 1
     */
    
    public void tick() {

        this.timer ++;

        if (this.timer > SECONDS_BETWEEN_TIME * App.FPS) {

            this.timeCount --;
            this.timer = 0;
        }
    }


    /**
     * Returns the value of the time remaining until game over
     * 
     * @return  the amount of time remaining
     */

    
    public int getTimeCount() {

        return this.timeCount;
    }


    /**
     * 
     * Resets the timer by setting timeCount back to 180 seconds and the incrementing time back to the default of 0
     */

    
    public void timerReset() {

        this.timeCount = 180;
        this.timer = 0;
    }
}