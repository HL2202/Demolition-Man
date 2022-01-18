package demolition;

import org.junit.jupiter.api.Test;

import demolition.RedEnemy;

import static org.junit.jupiter.api.Assertions.*;


public class RedEnemyTest {


    @Test
    public void redEnemyLoadCorrectly() {

        //  Check red enemy is correctly loaded at the start of the game
        RedEnemy redEnemy = new RedEnemy(256, 208);
        assertEquals(256, redEnemy.getX());
        assertEquals(208, redEnemy.getY());
    }

    
    @Test
    public void redEnemyMoveCorrect() {

        //  Check red enemy correctly moves right or left at the start of the game

        RedEnemy redEnemy = new RedEnemy(256, 208);
        assertEquals(256, redEnemy.getX());
        redEnemy.tick();
        assertTrue(256 == redEnemy.getX());
        assertTrue(208 == redEnemy.getY());

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        //  Check red enemy correctly goes only left or right and not down or up

        assertFalse(256 == redEnemy.getX());
        assertTrue(208 == redEnemy.getY());
    }


    @Test 
    public void redEnemyMoveLeftCorrect() {

        //  Check red enemy correctly moves left

        RedEnemy redEnemy = new RedEnemy(256, 208);
        assertEquals(256, redEnemy.getX());
        redEnemy.setMoveLeft();

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        assertEquals(224, redEnemy.getX());
    }


    @Test 
    public void redEnemyMoveRightCorrect() {

        //  Check red enemy correctly moves right

        RedEnemy redEnemy = new RedEnemy(256, 208);
        assertEquals(256, redEnemy.getX());
        redEnemy.setMoveRight();

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        assertEquals(288, redEnemy.getX());
    }


    @Test 
    public void redEnemyEncounterWallBehaviour() {

        //  Check red enemy correctly moves according to AI when encountering wall

        RedEnemy redEnemy = new RedEnemy(256, 208);
        assertEquals(256, redEnemy.getX());
        redEnemy.setMoveUp();
        redEnemy.setMoveRight();

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        //  Check red enemy correctly moves right

        assertEquals(288, redEnemy.getX());

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        assertEquals(320, redEnemy.getX());

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        //  Check red enemy will always move left when it encounters the wall on its right

        assertEquals(288, redEnemy.getX());
    }

    
    @Test 
    public void redEnemySecondWallInteraction() {

        //  Check red enemy correctly moves according to AI when encountering walls

        RedEnemy redEnemy = new RedEnemy(256, 208);
        assertEquals(256, redEnemy.getX());
        redEnemy.setMoveLeft();

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        //  Check red enemy correctly moves left

        assertEquals(224, redEnemy.getX());

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        assertEquals(192, redEnemy.getX());

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        assertEquals(160, redEnemy.getX());

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        assertEquals(128, redEnemy.getX());

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        assertEquals(96, redEnemy.getX());

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        assertEquals(64, redEnemy.getX());

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        assertEquals(32, redEnemy.getX());

        //  When encountering the left end wall, set the movement to down to check what happens when it reaches bottom wall

        redEnemy.setMoveDown();

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        //  Check red enemy moves down correctly

        assertEquals(32, redEnemy.getX());
        assertEquals(240, redEnemy.getY());

        redEnemy.setMoveUp();

        for (int i = 0; i < 61; i ++) {

            redEnemy.tick();
        }

        //  Check red enemy moves up correctly after encountering second wall
        
        assertEquals(32, redEnemy.getX());
        assertEquals(208, redEnemy.getY());

        redEnemy.tick();

        redEnemy.wallReplace(32, 320);

        redEnemy.tick();

        redEnemy.gameReset();

        redEnemy.tick();
    }
}
