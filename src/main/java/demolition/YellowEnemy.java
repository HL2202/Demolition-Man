/**
 * 
 * YellowEnemy is the class which creates a new yellow enemy object into the game
 * Yellow enemy is one of two enemies in the game which are able to interact with the player
 * 
 * Yellow enemy extends from the Enemy superclass as well as the Figure superclass, and inherits all of their methods
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
import demolition.Enemy;


public class YellowEnemy extends Enemy {

    private int timer, yellowEnemyRow, yellowEnemyColumn;

    private DynamicMatrix levels;
    private ArrayList<String> level1;

    private ArrayList<String> individualRow;
    private String currentRow;

    private PImage sprite;

    /**
     * Creates a new yellow enemy to bbe displayed on the map in the game
     * 
     * @param x     the x-coordinate of the yellow enemy
     * @param y     the y-coordinate of the yellow enemy
     * 
     * @see         Enemy
     * @see         Figure
     */

    public YellowEnemy(int x, int y) {
        
        super(x, y);

        this.levels = new DynamicMatrix();
        this.level1 = levels.getLevel1();

        this.yellowEnemyRow = 9;
        this.yellowEnemyColumn = 5;
        this.currentRow = level1.get(yellowEnemyRow);

        this.individualRow = new ArrayList<String>();
        
        this.timer = 0;
    }

    /**
     * Updates the map by incrementing a timer for the yellow enemy's movement and interacting with the map environment
     * 
     * Based on the AI, the yellow enemy will make a movement every second, which will update its position and direction
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
            this.x = 160;
            this.y = 336;

            this.yellowEnemyRow = 9;
            this.yellowEnemyColumn = 5;

            this.moveDown = true;
            this.moveLeft = false;
            this.moveUp = false;
            this.moveRight = false;

            reset = false;
            this.timer = 0;
        }

        boolean moved = false;
        
        this.timer ++;

        if (this.timer > SECONDS_BETWEEN_MOVES * App.FPS && !enemyRemoved) {

            while (!moved) {
            

                if (moveUp) {

                    moveDown = false;
                    moveUp = true;
                    moveLeft = false;
                    moveRight = false;

                    String rowAbove = level1.get(yellowEnemyRow - 1);

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

                    if (individualRow.get(yellowEnemyColumn).equals("W") || individualRow.get(yellowEnemyColumn).equals("B")) {

                        moveUp = false;
                        moveRight = true;
                        individualRow = new ArrayList<String>();
                    }

                    else {

                        this.y -= 32;
                        yellowEnemyRow --;
                        individualRow = new ArrayList<String>();
                        moved = true;
                    }
                }


                else if (moveDown) {

                    moveDown = true;
                    moveUp = false;
                    moveLeft = false;
                    moveRight = false;

                    String rowBelow = level1.get(yellowEnemyRow + 1);

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

                    if (individualRow.get(yellowEnemyColumn).equals("W") || individualRow.get(yellowEnemyColumn).equals("B")) {

                        moveDown = false;
                        moveLeft = true;
                        individualRow = new ArrayList<String>();
                    }

                    else {

                        this.y += 32;
                        yellowEnemyRow ++;
                        individualRow = new ArrayList<String>();
                        moved = true;
                    }
                }


                else if (moveLeft) {

                    moveDown = false;
                    moveUp = false;
                    moveLeft = true;
                    moveRight = false;

                    String row = level1.get(yellowEnemyRow);

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
        
                    if (individualRow.get(yellowEnemyColumn - 1).equals("W") || individualRow.get(yellowEnemyColumn - 1).equals("B")) {

                        moveLeft = false;
                        moveUp = true;
                        individualRow = new ArrayList<String>();
                    }
        
                    else {

                        this.x -= 32;
                        yellowEnemyColumn --;
                        individualRow = new ArrayList<String>();
                        moved = true;
                    }
                }
                

                else if (moveRight) {

                    moveDown = false;
                    moveUp = false;
                    moveLeft = false;
                    moveRight = true;
                
                    String row = level1.get(yellowEnemyRow);

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
        
                    if (individualRow.get(yellowEnemyColumn + 1).equals("W") || individualRow.get(yellowEnemyColumn + 1).equals("B")) {

                        moveRight = false;
                        moveDown = true;
                        individualRow = new ArrayList<String>();
                    }
        
                    else {

                        this.x += 32;
                        yellowEnemyColumn ++;
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
}