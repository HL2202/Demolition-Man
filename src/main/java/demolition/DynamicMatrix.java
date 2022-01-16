/**
 * 
 * DynamicMatrix is the base class used to construct the map which will be loaded onto the screen at the start of the game
 * 
 * As there are two levels to the game, two separate maps will be created, and each map can be updated according to the respective method
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import java.util.ArrayList;


public class DynamicMatrix {
    
    private ArrayList<String> level1;

    private ArrayList<String> level2;


    /**
     * 
     * Constructs the two maps which will be drawn onto the screen, with "W" corresponding to solid walls, "B" corresponding to broken walls and " " corresponding to empty tiles
     */


    public DynamicMatrix() {
        
        level1 = new ArrayList<String>();

        level1.add("WWWWWWWWWWWWWWW");
        level1.add("WP    BBB BBBBW");
        level1.add("W W W W W W W W");
        level1.add("W         B B W");
        level1.add("WBW W W W WBW W");
        level1.add("W       R  B  W");
        level1.add("W W W W W W W W");
        level1.add("WB   B   B    W");
        level1.add("WBW W W WBW W W");
        level1.add("W    YBB   B BW");
        level1.add("W WBW W W W W W");
        level1.add("W        B   GW");
        level1.add("WWWWWWWWWWWWWWW");

        level2 = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {

            level2.add("               ");
        }
        level2.add("WWWWWWWWWWWWWWW");
        level2.add("WP    B      GW");
        level2.add("WWWWWWWWWWWWWWW");
        for (int i = 0; i < 5; i++) {

            level2.add("               ");
        }
    }

    /**
     * Returns the map displaying the first level of the game
     * 
     * @return  ArrayList containing the first level of the game
     */

    public ArrayList<String> getLevel1() {

        return level1;
    }

    /**
     * Updates the map by replacing a broken wall with an empty tile and returning the new map to be displayed
     * 
     * @param level     the specific level of which the map is to be updated
     * @param x         the x coordinate of the broken wall
     * @param y         the y coordinate of the broken wall
     * @return          ArrayList containing an updated map with the broken wall replaced by an empty tile
     */


    public ArrayList<String> replaceBrokenWall(ArrayList<String> level, int x, int y) {

        int column = x / 32;
        int row = y / 32;

        String replaceRow = level.get(row);
        ArrayList<String> newRow = new ArrayList<String>();

        for (int i = 0; i < replaceRow.length(); i++) {
          
            Character c = replaceRow.charAt(i);
            String letter = c.toString();

            if (letter.equals("W") || letter.equals("B") || letter.equals("G")) {

                newRow.add(letter);
            }

            else {

                newRow.add(" ");
            }
        }

        newRow.set(column, " ");
        String newLine = "";

        for (int j = 0; j < newRow.size(); j++) {

            newLine += newRow.get(j);
        }

        level.set(row, newLine);
        return level;
    }

    /**
     * Resets the map of the first level to its default appearance
     * 
     * @param level1    ArrayList containing the map of the first level
     */


    public void resetLevel1(ArrayList<String> level1) {

        level1.set(0, "WWWWWWWWWWWWWWW");
        level1.set(1, "WP    BBB BBBBW");
        level1.set(2, "W W W W W W W W");
        level1.set(3, "W         B B W");
        level1.set(4, "WBW W W W WBW W");
        level1.set(5, "W       R  B  W");
        level1.set(6, "W W W W W W W W");
        level1.set(7, "WB   B   B    W");
        level1.set(8, "WBW W W WBW W W");
        level1.set(9, "W    YBB   B BW");
        level1.set(10, "W WBW W W W W W");
        level1.set(11, "W        B   GW");
        level1.set(12, "WWWWWWWWWWWWWWW");

    }


    /**
     * Returns the map displaying the second level of the game
     * 
     * @return  ArrayList containing the second level of the game
     */


    public ArrayList<String> getLevel2() {

        return level2;
    }

    /**
     * Resets the map of the second level to its default appearance
     * 
     * @param level2    ArrayList containing the map of the second level
     */
    
    public void resetLevel2(ArrayList<String> level2) {

        for (int i = 0; i < 5; i++) {
            level2.set(i, "               ");
        }

        level2.set(5, "WWWWWWWWWWWWWWW");
        level2.set(6, "WP    B      GW");
        level2.set(7, "WWWWWWWWWWWWWWW");

        for (int j = 8; j < 13; j++) {
            level2.set(j, "               ");
        }
    }
}