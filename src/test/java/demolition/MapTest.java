package demolition;

import org.junit.jupiter.api.Test;

import demolition.DynamicMatrix;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class MapTest {

    
    @Test 
    public void mapTest() {

        //  Test the different features of the map

        DynamicMatrix levels = new DynamicMatrix();
        ArrayList<String> level1 = levels.getLevel1();
        ArrayList<String> level2 = levels.getLevel2();

        ArrayList<String> level1Updated = levels.replaceBrokenWall(level1, 32, 192);
        levels.resetLevel1(level1Updated);
        assertEquals(level1, level1Updated);

        ArrayList<String> level2Updated = levels.replaceBrokenWall(level2, 192, 192);
        levels.resetLevel2(level2Updated);
        assertEquals(level2, level2Updated);
    }
}