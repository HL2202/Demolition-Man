package demolition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class YellowEnemyTest {
    

    @Test
    public void yellowEnemyLoadCorrectly() {

        //  Check yellow enemy is correctly loaded at the start of the game

        YellowEnemy yellowEnemy = new YellowEnemy(160, 336);
        assertEquals(160, yellowEnemy.getX());
        assertEquals(336, yellowEnemy.getY());
    }


    @Test
    public void yellowEnemyMoveDownCorrect() {

        //  Check yellow enemy correctly moves down at the start of the game

        YellowEnemy yellowEnemy = new YellowEnemy(160, 336);
        assertEquals(336, yellowEnemy.getY());
        yellowEnemy.tick();
        assertEquals(336, yellowEnemy.getY());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        //  Check yellow enemy moves down correctly 

        assertEquals(368, yellowEnemy.getY());
        assertEquals(160, yellowEnemy.getX());
    }


    @Test
    public void yellowEnemyEncounterWallBehaviour() {

        //  Check yellow enemy correctly moves clockwise when encountering wall

        YellowEnemy yellowEnemy = new YellowEnemy(160, 336);
        assertEquals(336, yellowEnemy.getY());
        yellowEnemy.tick();
        assertEquals(336, yellowEnemy.getY());
        
        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(368, yellowEnemy.getY());
        assertEquals(160, yellowEnemy.getX());
        
        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(400, yellowEnemy.getY());
        assertEquals(160, yellowEnemy.getX());
        
        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        //  Check yellow enemy no longer moves down after encountering wall

        assertEquals(400, yellowEnemy.getY());

        //  Check yellow enemy correctly moves left

        assertEquals(128, yellowEnemy.getX());
    }


    @Test 
    public void yellowEnemySecondWallInteraction() {

        // Check yellow enemy correctly moves clockwise when reaching second wall

        YellowEnemy yellowEnemy = new YellowEnemy(160, 336);
        assertEquals(336, yellowEnemy.getY());
        yellowEnemy.tick();
        assertEquals(336, yellowEnemy.getY());
        
        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(368, yellowEnemy.getY());
        assertEquals(160, yellowEnemy.getX());
        
        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(400, yellowEnemy.getY());
        assertEquals(160, yellowEnemy.getX());
        
        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(400, yellowEnemy.getY());

        //  Check yellow enemy correctly moves left

        assertEquals(128, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(96, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(64, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(32, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        //  Check yellow enemy no longer moves left after encountering wall

        assertEquals(32, yellowEnemy.getX());

        //  Check yellow enemy moves up correctly 

        assertEquals(368, yellowEnemy.getY());
    }

    
    @Test 
    public void yellowEnemyMovementMultiple() {

        //  Check yellow enemy moves correctly through one cycle

        YellowEnemy yellowEnemy = new YellowEnemy(160, 336);
        assertEquals(336, yellowEnemy.getY());
        yellowEnemy.tick();
        assertEquals(336, yellowEnemy.getY());
        
        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(368, yellowEnemy.getY());
        assertEquals(160, yellowEnemy.getX());
        
        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(400, yellowEnemy.getY());
        assertEquals(160, yellowEnemy.getX());
        
        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(400, yellowEnemy.getY());

        //  Check yellow enemy correctly moves left

        assertEquals(128, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(96, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(64, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(32, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        //  Check yellow enemy no longer moves left after encountering wall

        assertEquals(32, yellowEnemy.getX());

        //  Check yellow enemy moves up correctly 

        assertEquals(368, yellowEnemy.getY());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(336, yellowEnemy.getY());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        //  Check yellow enemy no longer moves up after encountering wall

        assertEquals(336, yellowEnemy.getY());

        //  Check yellow enemy moves right correctly 

        assertEquals(64, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(96, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(128, yellowEnemy.getX());

        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        //  One full cycle moved by yellow enemy covering all four directions

        assertEquals(160, yellowEnemy.getX());


        for (int i = 0; i < 61; i++) {

            yellowEnemy.tick();
        }

        assertEquals(368, yellowEnemy.getY());

        yellowEnemy.tick();

        yellowEnemy.wallReplace(32, 320);

        yellowEnemy.tick();

        yellowEnemy.gameReset();

        yellowEnemy.tick();
    }   
}
