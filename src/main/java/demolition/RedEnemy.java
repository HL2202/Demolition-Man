/**
 * 
 * RedEnemy is the class which creates a new red enemy object into the game
 * Red enemy is one of two enemies in the game which are able to interact with the player
 * 
 * Red enemy extends from the Enemy superclass as well as the Figure superclass, and inherits all of their methods
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PImage;
import processing.core.PApplet;
import java.util.ArrayList;
import java.lang.Math;

import demolition.DynamicMatrix;
import demolition.Enemy;


public class RedEnemy extends Enemy {


    private int timer, redEnemyRow, redEnemyColumn;

    private DynamicMatrix levels;
    private ArrayList<String> level1;

    private ArrayList<String> individualRow;
    private String currentRow;

    private PImage sprite;

    /**
     * Creates a new red enemy to bbe displayed on the map in the game
     * 
     * @param x     the x-coordinate of the red enemy
     * @param y     the y-coordinate of the red enemy
     * 
     * @see         Enemy
     * @see         Figure
     */

    public RedEnemy(int x, int y) {

        super(x, y);

        this.levels = new DynamicMatrix();
        this.level1 = levels.getLevel1();

        this.redEnemyRow = 5;
        this.redEnemyColumn = 8;
        this.currentRow = level1.get(redEnemyRow);

        this.individualRow = new ArrayList<String>();
        this.timer = 0;
    }

    /**
     * Updates the map by incrementing a timer for the red enemy's movement and interacting with the map environment
     * 
     * Based on the AI, the red enemy will make a movement every second, which will update its position and direction
     * 
     * @see     Figure
     */

    public void tick() {

        if (replace) {

            level1 = levels.replaceBrokenWall(level1, replaceX, replaceY);
            replace = false;
        }

        level1 = levels.getLevel1();

        if (reset) {

            levels.resetLevel1(level1);
            this.x = 256;
            this.y = 208;
            
            this.redEnemyRow = 5;
            this.redEnemyColumn = 8;

            this.moveDown = true;
            this.moveLeft = false;
            this.moveUp = false;
            this.moveRight = false;
            
            reset = false;
            this.timer = 0;
        }
        
        this.timer ++;

        boolean moved = false;

        if (this.timer > SECONDS_BETWEEN_MOVES * App.FPS && !enemyRemoved) {

            while (!moved) {

                int randNum = (int)(Math.random() * 3) + 1;
            
                if (moveUp) {

                    moveDown = false;
                    moveUp = true;
                    moveLeft = false;
                    moveRight = false;

                    String rowAbove = level1.get(redEnemyRow - 1);

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

                    if (individualRow.get(redEnemyColumn).equals("W") || individualRow.get(redEnemyColumn).equals("B")) {

                        moveUp = false;

                        if (randNum == 1) {

                            moveRight = true;
                        }

                        else if (randNum == 2) {

                            moveDown = true;
                        }

                        else {

                            moveLeft = true;
                        }

                        individualRow = new ArrayList<String>();
                    }

                    else {

                        this.y -= 32;
                        redEnemyRow --;
                        individualRow = new ArrayList<String>();
                        moved = true;
                    }
                }


                else if (moveDown) {

                    moveDown = true;
                    moveUp = false;
                    moveLeft = false;
                    moveRight = false;

                    String rowBelow = level1.get(redEnemyRow + 1);

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

                    if (individualRow.get(redEnemyColumn).equals("W") || individualRow.get(redEnemyColumn).equals("B")) {
                        
                        moveDown = false;

                        if (randNum == 1) {

                            moveLeft = true;
                        }

                        else if (randNum == 2) {

                            moveUp = true;
                        }

                        else {
                            moveRight = true;

                        }

                        individualRow = new ArrayList<String>();
                    }

                    else {

                        this.y += 32;
                        redEnemyRow ++;
                        individualRow = new ArrayList<String>();
                        moved = true;
                    }
                }


                else if (moveLeft) {

                    moveDown = false;
                    moveUp = false;
                    moveLeft = true;
                    moveRight = false;

                    String row = level1.get(redEnemyRow);

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
        
                    if (individualRow.get(redEnemyColumn - 1).equals("W") || individualRow.get(redEnemyColumn - 1).equals("B")) {

                        moveLeft = false;

                        if (randNum == 1) {

                            moveUp = true;
                        }

                        else if (randNum == 2) {

                            moveRight = true;
                        }

                        else {

                            moveDown = true;
                        }

                        individualRow = new ArrayList<String>();
                    }
        
                    else {

                        this.x -= 32;
                        redEnemyColumn --;
                        individualRow = new ArrayList<String>();
                        moved = true;
                    }
                }


                else if (moveRight) {

                    moveDown = false;
                    moveUp = false;
                    moveLeft = false;
                    moveRight = true;
                
                    String row = level1.get(redEnemyRow);

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
        
                    if (individualRow.get(redEnemyColumn + 1).equals("W") || individualRow.get(redEnemyColumn + 1).equals("B")) {

                        moveRight = false;

                        if (randNum == 1) {

                            moveDown = true;
                        }

                        else if (randNum == 2) {

                            moveLeft = true;
                        }

                        else {

                            moveUp = true;
                        }

                        individualRow = new ArrayList<String>();
                    }
        
                    else {

                        this.x += 32;
                        redEnemyColumn ++;
                        individualRow = new ArrayList<String>();
                        moved = true;
                    }
                }

                this.timer = 0;
            }
        }
    }

    /**
     * Reverts an incrementing of the timer by decreasing the count by 1
     */

    public void timerUndo() {

        this.timer --;
    }


    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void setMoveRight() {

        this.moveRight = true;
        this.moveDown = false;
        this.moveLeft = false;
        this.moveUp = false;
    }

    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void setMoveLeft() {

        this.moveRight = false;
        this.moveDown = false;
        this.moveLeft = true;
        this.moveUp = false;
    }

    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void setMoveUp() {

        this.moveRight = false;
        this.moveDown = false;
        this.moveLeft = false;
        this.moveUp = true;
    }

    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void setMoveDown() {

        this.moveRight = false;
        this.moveDown = true;
        this.moveLeft = false;
        this.moveUp = false;
    }
}