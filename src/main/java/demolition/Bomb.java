/**
 * 
 * Bomb is the class used to create a bomb object which is called every time the player presses the space bar
 * 
 * The bomb is deployed directly from bomb guy's coordinates, and is controlled via the Runner class
 * 
 * Although not inheriting any classes explicitly, the bomb class is heavily dependent on the operations of many other classes,  
 * including the BombGuy class, Runner class and Explosion class
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PImage;
import processing.core.PApplet;
import java.util.ArrayList;

import demolition.DynamicMatrix;


public class Bomb {


    private int x, y, timer, bombRow, bombColumn, spriteTimer;
    private PImage sprite;

    public static final int COUNTDOWN = 2;
    
    private boolean exploded, blockedUp, blockedDown, blockedLeft, blockedRight, setLevel1;

    private boolean blockedUp2, blockedDown2, blockedLeft2, blockedRight2;

    private static DynamicMatrix levels = new DynamicMatrix();
    private ArrayList<String> level;

    private ArrayList<String> individualRow;

    private boolean brokenWallUp1, brokenWallDown1, brokenWallLeft1, brokenWallRight1, brokenWallUp2, brokenWallDown2, brokenWallLeft2, brokenWallRight2;

    private boolean bombSprite1, bombSprite2, bombSprite3, bombSprite4, bombSprite5, bombSprite6, bombSprite7, bombSprite8;

    /**
     * Creates a new bomb object which is instantiated to be in the same position as the bomb guy's coordinates, 
     * hence the params will pass in the x and y values from BombGuy's getX() and getY() methods when called by the Runner class
     * 
     * @param x     the x-coordinate of the bomb
     * @param y     the y-coordinate of the bomb
     */

    public Bomb(int x, int y) {
        
        this.x = x;
        this.y = y;

        this.exploded = false;
        this.timer = 0;

        this.blockedUp = false;
        this.blockedDown = false;
        this.blockedLeft = false;
        this.blockedRight = false;

        this.blockedUp2 = false;
        this.blockedDown2 = false;
        this.blockedLeft2 = false;
        this.blockedRight2 = false;

        this.setLevel1 = true;

        this.bombRow = (y - 48) / 32;
        this.bombColumn = x / 32;

        this.individualRow = new ArrayList<String>();

        this.brokenWallUp1 = false;
        this.brokenWallDown1 = false;
        this.brokenWallLeft1 = false;
        this.brokenWallRight1 = false;

        this.brokenWallUp2 = false;
        this.brokenWallDown2 = false;
        this.brokenWallLeft2 = false;
        this.brokenWallRight2 = false;

        this.bombSprite1 = true;
        this.bombSprite2 = false;
        this.bombSprite3 = false;
        this.bombSprite4 = false;
        this.bombSprite5 = false;
        this.bombSprite6 = false;
        this.bombSprite7 = false;
        this.bombSprite8 = false;

        this.spriteTimer = 0;
    }

    /**
     * 
     * Main method used to update the frame of the bomb
     * 
     * Every time this method is called, the timer is incremented by 1 until the bomb detonates, at which point the bomb will check its surroundings for solid and broken walls
     * 
     */
    
    public void tick() {

        this.timer ++;

        if (this.timer > COUNTDOWN * App.FPS && !exploded) {

            this.timer = 0;
            exploded = true;

            if (setLevel1) {

                level = levels.getLevel1();
            }

            else {

                level = levels.getLevel2();
            }

            String row = level.get(bombRow);

            individualRow = new ArrayList<String>();
    
            for (int i = 0; i < row.length(); i++) {
              
                Character c = row.charAt(i);
                String letter = c.toString();
    
                if (letter.equals("W") || letter.equals("B") || letter.equals("G")) {
    
                    individualRow.add(letter);
                }
    
                else {
    
                    individualRow.add(" ");
                }
            }
    
            if (individualRow.get(bombColumn - 1).equals("W") || individualRow.get(bombColumn - 1).equals("B")) {
    
                this.blockedLeft = true;

                if (individualRow.get(bombColumn - 1).equals("B")) {

                    this.brokenWallLeft1 = true;
                }
            }

            if (bombColumn - 2 >= 0) {

                if (individualRow.get(bombColumn - 2).equals("B") && !this.blockedLeft) {

                    this.brokenWallLeft2 = true;
                }

                if (individualRow.get(bombColumn - 2).equals("B") || individualRow.get(bombColumn - 2).equals("W") && !this.blockedLeft) {

                    this.blockedLeft2 = true;
                }
            }
    
            if (individualRow.get(bombColumn + 1).equals("W") || individualRow.get(bombColumn + 1).equals("B")) {
    
                this.blockedRight = true;

                if (individualRow.get(bombColumn + 1).equals("B")) {

                    this.brokenWallRight1 = true;
                }
            }

            if (bombColumn + 2 < 14) {
                if (individualRow.get(bombColumn + 2).equals("B") && !this.blockedRight) {

                    this.brokenWallRight2 = true;
                }

                if (individualRow.get(bombColumn + 2).equals("B") || individualRow.get(bombColumn + 2).equals("W") && !this.blockedRight) {

                    this.blockedRight2 = true;
                }
            }


            individualRow = new ArrayList<String>();
        
            String rowAbove = level.get(bombRow - 1);
    
            for (int i = 0; i < rowAbove.length(); i++) {
              
                Character c = rowAbove.charAt(i);
                String letter = c.toString();
    
                if (letter.equals("W") || letter.equals("B") || letter.equals("G")) {
    
                    individualRow.add(letter);
                }
    
                else {
    
                    individualRow.add(" ");
                }
            }
    
            if (individualRow.get(bombColumn).equals("W") || individualRow.get(bombColumn).equals("B")) {
    
                this.blockedUp = true;

                if (individualRow.get(bombColumn).equals("B")) {

                    this.brokenWallUp1 = true;
                }
            }

            individualRow = new ArrayList<String>();

            String rowBelow = level.get(bombRow + 1);
    
            for (int i = 0; i < rowBelow.length(); i++) {
                
                Character c = rowBelow.charAt(i);
                String letter = c.toString();
                if (letter.equals("W") || letter.equals("B") || letter.equals("G")) {
    
                    individualRow.add(letter);
                }
    
                else {
    
                    individualRow.add(" ");
                }
            }
    
            if (individualRow.get(bombColumn).equals("W") || individualRow.get(bombColumn).equals("B")) {
    
                this.blockedDown = true;

                if (individualRow.get(bombColumn).equals("B")) {

                    this.brokenWallDown1 = true;
                }
            }

            if (bombRow - 2 >= 0) { 

                individualRow = new ArrayList<String>();
        
                String rowAboveTwo = level.get(bombRow - 2);
    
                for (int i = 0; i < rowAboveTwo.length(); i++) {
              
                    Character c = rowAboveTwo.charAt(i);
                    String letter = c.toString();
    
                    if (letter.equals("W") || letter.equals("B") || letter.equals("G")) {
    
                        individualRow.add(letter);
                    }
    
                    else {
    
                        individualRow.add(" ");
                    }
                }

                if (individualRow.get(bombColumn).equals("B") && !this.blockedUp) {

                    this.brokenWallUp2 = true;
                }

                if (individualRow.get(bombColumn).equals("B") || individualRow.get(bombColumn).equals("W") && !this.blockedUp) {

                    this.blockedUp2 = true;
                }
            }

            if (bombRow + 2 < 12) {

                individualRow = new ArrayList<String>();
        
                String rowBelowTwo = level.get(bombRow + 2);
    
                for (int i = 0; i < rowBelowTwo.length(); i++) {
              
                    Character c = rowBelowTwo.charAt(i);
                    String letter = c.toString();
    
                    if (letter.equals("W") || letter.equals("B") || letter.equals("G")) {
    
                        individualRow.add(letter);
                    }
    
                    else {
    
                        individualRow.add(" ");
                    }
                }

                if (individualRow.get(bombColumn).equals("B") && !this.blockedDown) {

                    this.brokenWallDown2 = true;
                }

                if (individualRow.get(bombColumn).equals("B") || individualRow.get(bombColumn).equals("W") && !this.blockedDown) {

                    this.blockedDown2 = true;
                }
            }
        }
    }

    /**
     * Sets the correct sprite appearance of the bomb to display as a graphic in the game, updated by incrementations of the sprite timer
     */

    public void spriteTick() {

        this.spriteTimer ++;

        if (this.spriteTimer < COUNTDOWN * App.FPS * 0.125) {

            this.bombSprite1 = true;
        }

        else if (this.spriteTimer < COUNTDOWN * App.FPS * 0.25) {

            this.bombSprite1 = false;
            this.bombSprite2 = true;
        }

        else if (this.spriteTimer < COUNTDOWN * App.FPS * 0.375) {

            this.bombSprite2 = false;
            this.bombSprite3 = true;
        }

        else if (this.spriteTimer < COUNTDOWN * App.FPS * 0.5) {

            this.bombSprite3 = false;
            this.bombSprite4 = true;
        }

        else if (this.spriteTimer < COUNTDOWN * App.FPS * 0.625) {

            this.bombSprite4 = false;
            this.bombSprite5 = true;
        }

        else if (this.spriteTimer < COUNTDOWN * App.FPS * 0.75) {

            this.bombSprite5 = false;
            this.bombSprite6 = true;
        }

        else if (this.spriteTimer < COUNTDOWN * App.FPS * 0.875) {

            this.bombSprite6 = false;
            this.bombSprite7 = true;
        }

        else if (this.spriteTimer < COUNTDOWN * App.FPS) {

            this.bombSprite7 = false;
            this.bombSprite8 = true;
        }     
    }

    /**
     * Sets the sprite of the explosion from the file loaded in the directory
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
     * Returns true if the bomb is exploded, false otherwise
     * 
     * @return      whether the bomb is exploded
     */

    public boolean isExploded() {

        return this.exploded;
    }

    /**
     *  Sets the bomb explosion to true
     */

    public void detonate() {

        this.exploded = true;
    }

    /**
     * Returns the x value of the bomb coordinate
     * 
     * @return          the x variable corresponding to the x-value position of the bomb
     * 
     * @see             IGraphic
     * @since           1.0
     */

    public int getX() {

        return this.x;
    }

    /**
     * Returns the y value of the bomb coordinate
     * 
     * @return          the y variable corresponding to the y-value position of the bomb
     * 
     * @see             IGraphic
     * @since           1.0
     */

    public int getY() {
        
        return this.y;
    }

    /**
     * Return true if the bomb is blocked by left wall directly adjacent, false otherwise
     * 
     * @return  whether bomb is blocked by directly adjacent left wall
     */

    public boolean getBlockedLeft() {

        return this.blockedLeft;
    }

    /**
     * Return true if the bomb is blocked by right wall directly adjacent, false otherwise
     * 
     * @return  whether bomb is blocked by directly adjacent right wall
     */
    
    public boolean getBlockedRight() {

        return this.blockedRight;
    }

    /**
     * Return true if the bomb is blocked by above wall directly adjacent, false otherwise
     * 
     * @return  whether bomb is blocked by directly adjacent above wall
     */

    public boolean getBlockedUp() {

        return this.blockedUp;
    }
    
    /**
     * Return true if the bomb is blocked by below wall directly adjacent, false otherwise
     * 
     * @return  whether bomb is blocked by directly adjacent below wall
     */

    public boolean getBlockedDown() {

        return this.blockedDown;
    }

    /**
     * Return true if the bomb is blocked by a wall 2 tiles to the left, false otherwise
     * 
     * @return  whether bomb is blocked by wall 2 tiles left
     */

    public boolean getBlockedLeft2() {

        return this.blockedLeft2;
    }

    /**
     * Return true if the bomb is blocked by a wall 2 tiles to the right, false otherwise
     * 
     * @return  whether bomb is blocked by wall 2 tiles right
     */

    public boolean getBlockedRight2() {

        return this.blockedRight2;
    }

    /**
     * Return true if the bomb is blocked by a wall 2 tiles above, false otherwise
     * 
     * @return  whether bomb is blocked by wall 2 tiles above
     */

    public boolean getBlockedUp2() {

        return this.blockedUp2;
    }

    /**
     * Return true if the bomb is blocked by a wall 2 tiles below, false otherwise
     * 
     * @return  whether bomb is blocked by wall 2 tiles below
     */

    public boolean getBlockedDown2() {

        return this.blockedDown2;
    }

    /**
     * Return true if there is broken wall directly above bomb, false otherwise
     * 
     * @return  whether there is broken wall directly above bomb
     */

    public boolean getBrokenWallUp1() {

        return this.brokenWallUp1;
    }

    /**
     * Return true if there is broken wall directly below bomb, false otherwise
     * 
     * @return  whether there is broken wall directly below bomb
     */

    public boolean getBrokenWallDown1() {

        return this.brokenWallDown1;
    }

    /**
     * Return true if there is broken wall directly to the left of bomb, false otherwise
     * 
     * @return  whether there is broken wall directly left of bomb
     */

    public boolean getBrokenWallLeft1() {

        return this.brokenWallLeft1;
    }

    /**
     * Return true if there is broken wall directly to the right of bomb, false otherwise
     * 
     * @return  whether there is broken wall directly right of bomb
     */

    public boolean getBrokenWallRight1() {

        return this.brokenWallRight1;
    }

    /** 
     * Return true if there is broken wall 2 tiles above bomb, false otherwise
     * 
     * @return  whether there is broken wall 2 tiles above bomb
    */

    public boolean getBrokenWallUp2() {

        return this.brokenWallUp2;
    }

    /** 
     * Return true if there is broken wall 2 tiles below bomb, false otherwise
     * 
     * @return  whether there is broken wall 2 tiles below bomb
    */

    public boolean getBrokenWallDown2() {

        return this.brokenWallDown2;
    }

    /** 
     * Return true if there is broken wall 2 tiles to the left of bomb, false otherwise
     * 
     * @return  whether there is broken wall 2 tiles left of bomb
    */

    public boolean getBrokenWallLeft2() {

        return this.brokenWallLeft2;
    }

    /** 
     * Return true if there is broken wall 2 tiles to the right of bomb, false otherwise
     * 
     * @return  whether there is broken wall 2 tiles right of bomb
    */   
    public boolean getBrokenWallRight2() {

        return this.brokenWallRight2;
    }

    /**
     * Return true if bomb is in sprite position 1, false otherwise
     * 
     * @return  whether bomb is in sprite position 1
     */

    public boolean getBombSprite1() {

        return this.bombSprite1;
    }

    /**
     * Return true if bomb is in sprite position 2, false otherwise
     * 
     * @return  whether bomb is in sprite position 2
     */

    public boolean getBombSprite2() {

        return this.bombSprite2;
    }

    /**
     * Return true if bomb is in sprite position 3, false otherwise
     * 
     * @return  whether bomb is in sprite position 3
     */

    public boolean getBombSprite3() {

        return this.bombSprite3;
    }

    /**
     * Return true if bomb is in sprite position 4, false otherwise
     * 
     * @return  whether bomb is in sprite position 4
     */

    public boolean getBombSprite4() {

        return this.bombSprite4;
    }

    /**
     * Return true if bomb is in sprite position 5, false otherwise
     * 
     * @return  whether bomb is in sprite position 5
     */

    public boolean getBombSprite5() {

        return this.bombSprite5;
    }

    /**
     * Return true if bomb is in sprite position 6, false otherwise
     * 
     * @return  whether bomb is in sprite position 6
     */

    public boolean getBombSprite6() {

        return this.bombSprite6;
    }

    /**
     * Return true if bomb is in sprite position 7, false otherwise
     * 
     * @return  whether bomb is in sprite position 7
     */

    public boolean getBombSprite7() {

        return this.bombSprite7;
    }
    
    /**
     * Return true if bomb is in sprite position 8, false otherwise
     * 
     * @return  whether bomb is in sprite position 8
     */

    public boolean getBombSprite8() {

        return this.bombSprite8;
    }

    /**
     * Set game to level 2 and update bomb interactions accordingly
     */

    public void nextLevel() {

        this.setLevel1 = false;
    }

    /**
     * Update the map after bomb destroys a broken wall
     * 
     * @param x     the x-coordinate of the broken wall
     * @param y     the y-coordinate of the broken wall
     */

    public void updateMap(int x, int y) {

        if (setLevel1) {

            ArrayList<String> level1 = levels.getLevel1();

            level = levels.replaceBrokenWall(level1, x, y);
        }

        else {

            ArrayList<String> level2 = levels.getLevel2();

            level = levels.replaceBrokenWall(level2, x, y);
        }
    }

    /**
     * Resets the map to its state at the start of the game
     */

    public void resetMap() {

        if (setLevel1) {

            ArrayList<String> level1 = levels.getLevel1();

            levels.resetLevel1(level1);
        }

        else {

            ArrayList<String> level2 = levels.getLevel2();

            levels.resetLevel2(level2);
        }
    }


    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void setBrokenWallDown2() {

        this.brokenWallDown2 = true;
    }


    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void setBrokenWallUp2() {

        this.brokenWallUp2 = true;
    }
    

    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void setBrokenWallLeft2() {

        this.brokenWallLeft2 = true;
    }


    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void setBrokenWallRight2() {

        this.brokenWallRight2 = true;
    }
}