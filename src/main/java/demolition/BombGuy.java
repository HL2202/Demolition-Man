/**
 * BombGuy is the object controlled directly by the player
 * 
 * It is the main character in the game, who is able to move left, move right, move up, move down and deploy bombs based on player contro;
 * 
 * BombGuy extends from the parent class Figure and inherits all of its methods, and it implements the interface IUserControllable
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
import demolition.IUserControllable;


public class BombGuy extends Figure implements IUserControllable{


    private DynamicMatrix levels = new DynamicMatrix();
    private ArrayList<String> level1 = levels.getLevel1();
    private ArrayList<String> level2 = levels.getLevel2();

    private ArrayList<String> individualRow;

    private boolean deployBomb, setLevel1, setLevel2;

    private int bombGuyRow, bombGuyColumn;
    private String currentRow;

    private PImage sprite;

    /**
     * Creates a new bomb guy object which will be instantiated based on the runner class, where the object's control and methods are run
     * 
     * @param x     the x-coordinate where bomb guy is created
     * @param y     the y-coordinate where bomb guy is created
     * 
     * @see             Figure
     * @see             IUserControllable
     * @since           1.0
     */


    public BombGuy(int x, int y) {
        
        super(x, y);

        this.deployBomb = false;

        this.bombGuyRow = 1;
        this.bombGuyColumn = 1;

        this.currentRow = level1.get(bombGuyRow);
        this.individualRow = new ArrayList<String>();

        this.setLevel1 = true;
        this.setLevel2 = false;
    }

    /**
     * 
     * Updates the map according to any changes made by the player's actions, including loading level 2, reset of level 1 and level 2 and replacing broken walls
     * 
     * @see             Figure
     * @see             IUserControllable
     */

    public void tick() {

        if (replace && setLevel1) {

            level1 = levels.replaceBrokenWall(level1, replaceX, replaceY);
            replace = false;
        }

        else if (replace && setLevel2) {

            level2 = levels.replaceBrokenWall(level2, replaceX, replaceY);
            replace = false;
        }

        if (setLevel1) {

            level1 = levels.getLevel1();
            currentRow = level1.get(bombGuyRow);

            if (reset) {

                levels.resetLevel1(level1);
                this.x = 32;
                this.y = 80;

                this.bombGuyRow = 1;
                this.bombGuyColumn = 1;

                this.moveDown = true;
                this.moveLeft = false;
                this.moveRight = false;
                this.moveUp = false;
                this.spriteTimer = 0;

                reset = false;
            }
        }

        else if (setLevel2) {

            level2 = levels.getLevel2();
            currentRow = level2.get(bombGuyRow);

            if (reset) {

                levels.resetLevel2(level2);
                this.x = 32;
                this.y = 240;

                this.bombGuyRow = 6;
                this.bombGuyColumn = 1;

                this.moveDown = true;
                this.moveLeft = false;
                this.moveRight = false;
                this.moveUp = false;
                this.spriteTimer = 0;

                reset = false;
            }
        }
    }

    /**
     * 
     * Moves bomb guy one tile left if there is an empty tile available in the position, otherwise it keeps bomb guy in its current position
     * 
     * Also makes changes to the bomb guy's movement direction
     * 
     * @see             IUserControllable
     */

    public void pressLeft() {

        moveDown = false;
        moveLeft = true;
        moveUp = false;
        moveRight = false;

        if (setLevel1) {

            level1 = levels.getLevel1();

            String row = level1.get(bombGuyRow);

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

            if (individualRow.get(bombGuyColumn - 1).equals("W") || individualRow.get(bombGuyColumn - 1).equals("B")) {

                individualRow = new ArrayList<String>();
            }

            else {

                this.x -= 32;
                bombGuyColumn --;
                individualRow = new ArrayList<String>();
            }
        }

        else if (setLevel2) {

            level2 = levels.getLevel2();

            String row = level2.get(bombGuyRow);

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

            if (individualRow.get(bombGuyColumn - 1).equals("W") || individualRow.get(bombGuyColumn - 1).equals("B")) {

                individualRow = new ArrayList<String>();
            }

            else {

                this.x -= 32;
                bombGuyColumn --;
                individualRow = new ArrayList<String>();
            }
        }
    }

    /**
     * 
     * Moves bomb guy one tile right if there is an empty tile available in the position, otherwise it keeps bomb guy in its current position
     * 
     * Also makes changes to the bomb guy's movement direction
     * 
     * @see             IUserControllable
     */

    public void pressRight() {

        moveDown = false;
        moveLeft = false;
        moveUp = false;
        moveRight = true;

        if (setLevel1) {

            level1 = levels.getLevel1();

            String row = level1.get(bombGuyRow);

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

            if (individualRow.get(bombGuyColumn + 1).equals("W") || individualRow.get(bombGuyColumn + 1).equals("B")) {

                individualRow = new ArrayList<String>();
            }

            else {

                this.x += 32;
                bombGuyColumn ++;
                individualRow = new ArrayList<String>();
            }
        }

        else if (setLevel2) {

            level2 = levels.getLevel2();

            String row = level2.get(bombGuyRow);

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

            if (individualRow.get(bombGuyColumn + 1).equals("W") || individualRow.get(bombGuyColumn + 1).equals("B")) {

                individualRow = new ArrayList<String>();
            }

            else { 

                this.x += 32;
                bombGuyColumn ++;
                individualRow = new ArrayList<String>();
            }
        }
    }

    /**
     * 
     * Moves bomb guy one tile up if there is an empty tile available in the position, otherwise it keeps bomb guy in its current position
     * 
     * Also makes changes to the bomb guy's movement direction
     * 
     * @see             IUserControllable
     */

    public void pressUp() {

        moveDown = false;
        moveLeft = false;
        moveUp = true;
        moveRight = false;

        if (setLevel1) {

            level1 = levels.getLevel1();
        
            String rowAbove = level1.get(bombGuyRow - 1);

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

            if (individualRow.get(bombGuyColumn).equals("W") || individualRow.get(bombGuyColumn).equals("B")) {

                individualRow = new ArrayList<String>();
            }

            else {

                this.y -= 32;
                bombGuyRow --;
                individualRow = new ArrayList<String>();
            }

        }
    }

    /**
     * 
     * Moves bomb guy one tile down if there is an empty tile available in the position, otherwise it keeps bomb guy in its current position
     * 
     * Also makes changes to the bomb guy's movement direction
     * 
     * @see             IUserControllable
     */

    public void pressDown() {

        moveDown = true;
        moveLeft = false;
        moveUp = false;
        moveRight = false;

        if (setLevel1) {
      
            level1 = levels.getLevel1();

            String rowBelow = level1.get(bombGuyRow + 1);

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

            if (individualRow.get(bombGuyColumn).equals("W") || individualRow.get(bombGuyColumn).equals("B")) {

                individualRow = new ArrayList<String>();
            }

            else {

                this.y += 32;
                bombGuyRow ++;
                individualRow = new ArrayList<String>();
            }
        }
    }

    /**
     * Deploys a bomb at the position of bomb guy's current coordinates
     * 
     * @see             IUserControllable
     */

    public void pressSpace() {

        if (!deployBomb) {

            this.deployBomb = true;
        }
    }

    /**
     * Returns true if a bomb is ready to be deployed, false otherwise
     * 
     * @return  whether a bbomb is ready to be deployed
     * 
     * @see             IUserControllable
     */

    public boolean bombReady() {

        return deployBomb;
    }


    /**
     * Sets the bomb deploy boolean to be false to indicate the bomb has been deployed
     * 
     * @see             IUserControllable
     */

    public void bombDeployed() {

        this.deployBomb = false;
    }

    /**
     * 
     * Sets bomb guy's map to be the second level
     * 
     * @see             IUserControllable
     */

    public void nextLevel() {
        
        this.setLevel1 = false;
        this.setLevel2 = true;
        
        this.bombGuyRow = 6;
        this.bombGuyColumn = 1;
    }


    /**
     * 
     * Returns true if bomb guy is in level 1, false otherwise
     * 
     * @return  true if bomb guy is in level 1
     * 
     * @see             IUserControllable
     */

    public boolean getSetLevel1() {
        
        return this.setLevel1;
    }


        /**
     * 
     * Sets bomb guy's map to be the second level
     * 
     * Returns true if bomb guy is in level 2, false otherwise
     * 
     * @return  true if bomb guy is in level 2
     * 
     * @see             IUserControllable
     */

    public boolean getSetLevel2() {
        
        return this.setLevel2;
    }
}