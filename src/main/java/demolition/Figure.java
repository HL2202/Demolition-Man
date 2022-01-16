/**
 * 
 * Figure is an abstract super class object which forms the class base for all dynamic objects: Enemy, RedEnemy, and YellowEnemy
 * 
 * These dynamic objects are objects that will  change their appearance/position based on gameplay and is updated with each frame
 * 
 * The figure class extends from the IGraphic interface, which is the mother class for all graphics related classes and will implement methods to be used by its sub-class
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PImage;
import processing.core.PApplet;

import demolition.IGraphic;


public abstract class Figure implements IGraphic {

    protected int x, y, spriteTimer, replaceX, replaceY;
    
    private PImage sprite;

    protected boolean downSprite1, downSprite2, downSprite3, downSprite4;

    protected boolean rightSprite1, rightSprite2, rightSprite3, rightSprite4;

    protected boolean upSprite1, upSprite2, upSprite3, upSprite4;

    protected boolean leftSprite1, leftSprite2, leftSprite3, leftSprite4;

    protected boolean moveDown, moveLeft, moveUp, moveRight;

    protected boolean replace, reset;

    public static final double RENDER_SPRITE = 0.2;


    /**
     * Draws all of the different figures available according to their position. 
     * 
     * Instance method to create the new figure to be inherited by all subclasses
     * 
     * @param x     the x-coordinate of the figure
     * @param y     the y-coordinate of the figure
     * 
     * @see             IGraphic
     * @since           1.0
     */

    public Figure(int x, int y) {

        this.x = x;
        this.y = y;

        this.downSprite1 = true;
        this.downSprite2 = false;
        this.downSprite3 = false;
        this.downSprite4 = false;

        this.rightSprite1 = false;
        this.rightSprite2 = false;
        this.rightSprite3 = false;
        this.rightSprite4 = false;

        this.upSprite1 = false;
        this.upSprite2 = false;
        this.upSprite3 = false;
        this.upSprite4 = false;

        this.leftSprite1 = false;
        this.leftSprite2 = false;
        this.leftSprite3 = false;
        this.leftSprite4 = false;

        this.moveDown = true;
        this.moveLeft = false;
        this.moveUp = false;
        this.moveRight = false;

        this.spriteTimer = 0;

        this.replace = false;

        this.reset = false;

        this.replaceX = 0;
        this.replaceY = 0;
    }


    /**
     * 
     * Abstract method tick used by the subclasses to update their position, movement and direction each frame
     */

    public abstract void tick();
    
    /**
     * Sets the sprite of the figure from the file loaded in the directory
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
     * Returns the x-value of the figure coordinate
     * 
     * @return   the x-coordinate value of the figure
     */

    public int getX() {

        return this.x;
    }

    /**
     * Returns the y-value of the figure coordinate
     * 
     * @return  the y-coordinate value of the figure
     */

    public int getY() {

        return this.y;
    }

    /**
     * Returns true if the first down sprite is set, false otherwise
     * @return      whether the first down sprite is set
     */

    public boolean getDownSprite1() {

        return this.downSprite1;
    }

    /**
     * Returns true if the second down sprite is set, false otherwise
     * @return      whether the second down sprite is set
     */

    public boolean getDownSprite2() {

        return this.downSprite2;
    }
    
    /**
     * Returns true if the third down sprite is set, false otherwise
     * @return      whether the third down sprite is set
     */

    public boolean getDownSprite3() {

        return this.downSprite3;
    }

    /**
     * Returns true if the fourth down sprite is set, false otherwise
     * @return      whether the fourth down sprite is set
     */

    public boolean getDownSprite4() {

        return this.downSprite4;
    }
    
    /**
     * Returns true if the first right sprite is set, false otherwise
     * @return      whether the first right sprite is set
     */

    public boolean getRightSprite1() {

        return this.rightSprite1;
    }

    /**
     * Returns true if the second right sprite is set, false otherwise
     * @return      whether the second right sprite is set
     */

    public boolean getRightSprite2() {

        return this.rightSprite2;
    }

    /**
     * Returns true if the third right sprite is set, false otherwise
     * @return      whether the third right sprite is set
     */

    public boolean getRightSprite3() {

        return this.rightSprite3;
    }

    /**
     * Returns true if the fourth right sprite is set, false otherwise
     * @return      whether the fourth right sprite is set
     */

    public boolean getRightSprite4() {

        return this.rightSprite4;
    }

    /**
     * Returns true if the first up sprite is set, false otherwise
     * @return      whether the first up sprite is set
     */

    public boolean getUpSprite1() {

        return this.upSprite1;
    }

    /**
     * Returns true if the second up sprite is set, false otherwise
     * @return      whether the second up sprite is set
     */

    public boolean getUpSprite2() {

        return this.upSprite2;
    }

    /**
     * Returns true if the third up sprite is set, false otherwise
     * @return      whether the third up sprite is set
     */

    public boolean getUpSprite3() {

        return this.upSprite3;
    }

    /**
     * Returns true if the fourth up sprite is set, false otherwise
     * @return      whether the fourth up sprite is set
     */

    public boolean getUpSprite4() {

        return this.upSprite4;
    }

    /**
     * Returns true if the first left sprite is set, false otherwise
     * @return      whether the first left sprite is set
     */
    
    public boolean getLeftSprite1() {

        return this.leftSprite1;
    }

    /**
     * Returns true if the second left sprite is set, false otherwise
     * @return      whether the second left sprite is set
     */

    public boolean getLeftSprite2() {

        return this.leftSprite2;
    }

    /**
     * Returns true if the third left sprite is set, false otherwise
     * @return      whether the third left sprite is set
     */
    
    public boolean getLeftSprite3() {

        return this.leftSprite3;
    }

    /**
     * Returns true if the fourth left sprite is set, false otherwise
     * @return      whether the fourth left sprite is set
     */

    public boolean getLeftSprite4() {

        return this.leftSprite4;
    }

    /**
     * Reverts the incrementing the sprite time to be 0
     */

    public void resetSpriteTimer() {

        this.spriteTimer = 0;
    }

    /**
     * Increments the sprite timer to ensure the correct sprite is displayed in each frame
     */

    public void spriteTick() {

        this.spriteTimer ++;

        if (this.moveDown) {

            this.rightSprite1 = false;
            this.rightSprite2 = false;
            this.rightSprite3 = false;
            this.rightSprite4 = false;

            this.upSprite1 = false;
            this.upSprite2 = false;
            this.upSprite3 = false;
            this.upSprite4 = false;

            this.leftSprite1 = false;
            this.leftSprite2 = false;
            this.leftSprite3 = false;
            this.leftSprite4 = false;

            this.downSprite1 = false;
            this.downSprite2 = false;
            this.downSprite3 = false;
            this.downSprite4 = false;

            if (this.spriteTimer < RENDER_SPRITE * App.FPS) {

                this.downSprite1 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 2) {

                this.downSprite1 = false;
                this.downSprite2 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 3) {

                this.downSprite2 = false;
                this.downSprite3 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 4) {

                this.downSprite3 = false;
                this.downSprite4 = true;
            }

            else {

                this.downSprite4 = false;
                this.spriteTimer = 0;
            }
        }


        else if (this.moveRight) {

            this.downSprite1 = false;
            this.downSprite2 = false;
            this.downSprite3 = false;
            this.downSprite4 = false;

            this.upSprite1 = false;
            this.upSprite2 = false;
            this.upSprite3 = false;
            this.upSprite4 = false;

            this.leftSprite1 = false;
            this.leftSprite2 = false;
            this.leftSprite3 = false;
            this.leftSprite4 = false;

            this.rightSprite1 = false;
            this.rightSprite2 = false;
            this.rightSprite3 = false;
            this.rightSprite4 = false;

            if (this.spriteTimer < RENDER_SPRITE * App.FPS) {

                this.rightSprite1 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 2) {

                this.rightSprite1 = false;
                this.rightSprite2 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 3) {

                this.rightSprite2 = false;
                this.rightSprite3 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 4) {

                this.rightSprite3 = false;
                this.rightSprite4 = true;
            }

            else {

                this.rightSprite4 = false;
                this.spriteTimer = 0;
            }
        }


        else if (this.moveUp) {

            this.downSprite1 = false;
            this.downSprite2 = false;
            this.downSprite3 = false;
            this.downSprite4 = false;

            this.rightSprite1 = false;
            this.rightSprite2 = false;
            this.rightSprite3 = false;
            this.rightSprite4 = false;

            this.leftSprite1 = false;
            this.leftSprite2 = false;
            this.leftSprite3 = false;
            this.leftSprite4 = false;

            this.upSprite1 = false;
            this.upSprite2 = false;
            this.upSprite3 = false;
            this.upSprite4 = false;

            if (this.spriteTimer < RENDER_SPRITE * App.FPS) {

                this.upSprite1 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 2) {

                this.upSprite1 = false;
                this.upSprite2 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 3) {

                this.upSprite2 = false;
                this.upSprite3 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 4) {

                this.upSprite3 = false;
                this.upSprite4 = true;
            }

            else {

                this.upSprite4 = false;
                this.spriteTimer = 0;
            }
        }


        else if (this.moveLeft) {

            this.downSprite1 = false;
            this.downSprite2 = false;
            this.downSprite3 = false;
            this.downSprite4 = false;

            this.rightSprite1 = false;
            this.rightSprite2 = false;
            this.rightSprite3 = false;
            this.rightSprite4 = false;

            this.upSprite1 = false;
            this.upSprite2 = false;
            this.upSprite3 = false;
            this.upSprite4 = false;

            this.leftSprite1 = false;
            this.leftSprite2 = false;
            this.leftSprite3 = false;
            this.leftSprite4 = false;

            if (this.spriteTimer < RENDER_SPRITE * App.FPS) {

                this.leftSprite1 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 2) {

                this.leftSprite1 = false;
                this.leftSprite2 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 3) {

                this.leftSprite2 = false;
                this.leftSprite3 = true;
            }

            else if (this.spriteTimer < RENDER_SPRITE * App.FPS * 4) {

                this.leftSprite3 = false;
                this.leftSprite4 = true;
            }

            else {
                
                this.leftSprite4 = false;
                this.spriteTimer = 0;
            }
        }
    }


    /**
     * Replaces a specific broken tile in the wall
     * 
     * @param x     the x-coordinate of the tile to be replaced
     * @param y     the y-coordinate of the tile to be replaced
     */
    
    public void wallReplace(int x, int y) {

        this.replace = true;
        this.replaceX += x;
        this.replaceY += y;
    }

    /**
     * Resets the game to its starting frame
     */

    public void gameReset() {
        
        this.reset = true;
        this.replace = false;
    }

    /**
     * Reset any walls which were replaced to the default map
     */

    public void resetReplace() {

        this.replaceX = 0;
        this.replaceY = 0;
    }
}