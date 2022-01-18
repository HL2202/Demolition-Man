package demolition;

import org.junit.jupiter.api.Test;

import demolition.Runner;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class RunnerTest {
    

    @Test
    public void runTest() {

        //  Test the runner and run method to check it is working correctly

        Runner runner = new Runner();

        for (int i = 0; i < 10; i ++) {
            runner.run();
        }

        runner.keyLeft();
        runner.keyRight();
        runner.keyUp();
        runner.keyDown();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keySpace();
        Bomb bomb = runner.getBomb();
        
        boolean bombMade = runner.getBombMade();
        assertTrue(bombMade == true);

        boolean resetLevel = runner.getResetLevel();
        assertTrue(resetLevel == false);

        boolean setLevel1 = runner.getSetLevel1();
        assertTrue(setLevel1 == true);
        
        boolean setLevel2 = runner.getSetLevel2();
        assertTrue(setLevel2 == false);

        boolean gameOver = runner.getGameOver();
        assertTrue(gameOver == false);

        boolean winGame = runner.getWinGame();
        assertTrue(winGame == false);

        ArrayList<String> level1 = runner.getFirstLevel();
        ArrayList<String> level2 = runner.getSecondLevel();


        for (int i = 0; i < 121; i ++) {

            runner.run();
        }

        runner.keyRight();
        runner.keyRight();
        for (int i = 0; i < 8; i++) {
            runner.keyDown();
        }
        runner.keyLeft();
        runner.keyLeft();
        runner.keyDown();
        runner.keyDown();
        runner.keySpace();
        Bomb newBomb = runner.getBomb();

        runner.keyUp();
        runner.keyUp();
        runner.keyRight();

        for (int i = 0; i < 121; i ++) {
            runner.run();
        }

        Explosion explosion = runner.getExplosion();
        assertTrue(runner.getExplosionStart() == false);

        for (int i = 0; i < 31; i++) {
            runner.run();
        }
    }


    @Test 
    public void bombGuyDestroyedByExplosions1() {

        //  Check bomb guy correctly gets blown up by bombs and levels reset

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyRight();

        assertTrue(runner.getSetLevel1() == true);
        assertTrue(runner.getGameOver() == false);

        assertEquals(3, lives.getNumberLives());

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertEquals(2, lives.getNumberLives());

        bombGuy.gameReset();

        runner.keySpace();
        Bomb newBomb = runner.getBomb();

        runner.keyDown();

        assertEquals(2, lives.getNumberLives());

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertEquals(1, lives.getNumberLives());

        bombGuy.gameReset();

        runner.keySpace();
        Bomb finalBomb = runner.getBomb();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertEquals(0, lives.getNumberLives());
        assertTrue(runner.getSetLevel1() == false);
        assertTrue(runner.getGameOver() == true);
    }


    @Test 
    public void bombGuyDestroyedByExplosions2() {

        //  Check bomb guy correctly gets blown up by bombs and levels reset

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyDown();

        assertTrue(runner.getSetLevel1() == true);
        assertTrue(runner.getGameOver() == false);

        assertEquals(3, lives.getNumberLives());

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertEquals(2, lives.getNumberLives());
    }


    @Test 
    public void bombGuyDestroyedByExplosions3() {

        //  Check bomb guy correctly gets blown up by bombs and levels reset

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keyRight();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyLeft();

        assertTrue(runner.getSetLevel1() == true);
        assertTrue(runner.getGameOver() == false);

        assertEquals(3, lives.getNumberLives());

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertEquals(2, lives.getNumberLives());
    }


    @Test 
    public void bombGuyDestroyedByExplosions4() {

        //  Check bomb guy correctly gets blown up by bombs and levels reset

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keyDown();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyUp();

        assertTrue(runner.getSetLevel1() == true);
        assertTrue(runner.getGameOver() == false);

        assertEquals(3, lives.getNumberLives());

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertEquals(2, lives.getNumberLives());
    }


    @Test 
    public void brokenWallDestroyedByExplosion1() {

        //  Check broken wall is correctly blown up by bombs

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();
        runner.keyDown();
        runner.keyDown();
        runner.keyRight();
        runner.keyRight();
        runner.keyUp();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyDown();
        runner.keyRight();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }
    }


    @Test 
    public void brokenWallDestroyedByExplosion2() {

        //  Check broken wall is correctly blown up by bombs

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keyDown();
        runner.keyDown();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyRight();
        runner.keyRight();
        runner.keyDown();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }
    }


    @Test 
    public void brokenWallDestroyedByExplosion3() {

        //  Check broken wall is correctly blown up by bombs

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyDown();
        runner.keyDown();
        runner.keyRight();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }
    }


    @Test 
    public void brokenWallDestroyedByExplosion4() {

        //  Check broken wall is correctly blown up by bombs

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keyRight();
        runner.keyRight();

        for (int i = 0; i < 6; i++) {
            runner.keyDown();
        }

        runner.keyLeft();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyRight();
        runner.keyUp();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }
    }


    @Test 
    public void brokenWallDestroyedByExplosion5() {

        //  Check broken wall is correctly blown up by bombs

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();
        runner.keyDown();
        runner.keyDown();
        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyLeft();
        runner.keyLeft();
        runner.keyUp();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        runner.bombSetBrokenWallUp2();
        runner.run();
    }


    @Test 
    public void brokenWallDestroyedByExplosion6() {

        //  Check broken wall is correctly blown up by bombs

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        ArrayList<String> level1 = levels.getLevel1();

        runner.keyDown();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyUp();
        runner.keyRight();

        for (int i = 0; i < 122; i++) {

            runner.run();
        }

        runner.bombSetBrokenWallDown2();
        runner.run();
    }


    @Test 
    public void brokenWallDestroyedByExplosion7() {

        //  Check broken wall is correctly blown up by bombs

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.keyRight();
        runner.keyRight();

        for (int i = 0; i < 6; i++) {
            runner.keyDown();
        }

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyUp();
        runner.keyUp();
        runner.keyUp();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        runner.bombSetBrokenWallLeft2();
        runner.run();

        runner.bombSetBrokenWallRight2();
        runner.run();
    }


    @Test 
    public void bombGuyCollideRedEnemy() {

        //  Check level correctly resets and one life is removed when bomb guy collides with red enemy

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        assertEquals(3, lives.getNumberLives());

        runner.keyRight();
        runner.keyRight();

        runner.keyDown();
        runner.keyDown();
        runner.keyDown();
        runner.keyDown();

        for (int i = 0; i < 5; i++) {
            runner.keyRight();
        }

        for (int i = 0; i < 60; i++) {

            runner.run();
        }

        assertEquals(2, lives.getNumberLives());   
    }


    @Test 
    public void bombGuyCollideYellowEnemy() {

        //  Check level correctly resets and one life is removed when bomb guy collides with yellow enemy

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        assertEquals(3, lives.getNumberLives());

        runner.keyRight();
        runner.keyRight();

        for (int i = 0; i < 8; i++) {
            runner.keyDown();
        }

        runner.keyRight();
        runner.keyRight();

        for (int i = 0; i < 60; i++) {

            runner.run();
        }

        assertEquals(2, lives.getNumberLives());   
    }


    @Test 
    public void reachNextLevel() {

        //  Check bomb guy correctly reaches level 2 when reaching goal tile

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        assertTrue(runner.getSetLevel1() == true);
        assertTrue(runner.getSetLevel2() == false);

        for (int i = 0; i < 181; i++) {

            runner.run();
        }

        runner.keyRight();
        runner.keyRight();

        for (int i = 0; i < 8; i++) {
            runner.keyDown();
        }

        runner.keyRight();
        runner.keyRight();

        runner.keyDown();
        runner.keyDown();

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyLeft();
        runner.keyLeft();
        runner.keyLeft();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        for (int i = 0; i < 9; i++) {
            runner.keyRight();
        }
    }


    @Test 
    public void secondLevel1() {

        //  Test map correctly loads and works in second level

        Runner runner = new Runner();

        assertTrue(runner.getSetLevel1() == true);
        assertTrue(runner.getSetLevel2() == false);

        runner.setSecondLevel();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.run();

        assertTrue(runner.getSetLevel1() == false);
        assertTrue(runner.getSetLevel2() == true);

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyLeft();
        runner.keyLeft();
        runner.keyLeft();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }
        runner.run();
    }


    @Test 
    public void secondLevel2() {

        //  Test map correctly loads and works in second level

        Runner runner = new Runner();

        assertTrue(runner.getSetLevel1() == true);
        assertTrue(runner.getSetLevel2() == false);

        runner.setSecondLevel();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        assertEquals(3, lives.getNumberLives());

        assertTrue(runner.getSetLevel2() == true);
        assertTrue(runner.getWinGame() == false);

        runner.run();

        assertTrue(runner.getSetLevel1() == false);
        assertTrue(runner.getSetLevel2() == true);

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }
        runner.run();
        assertEquals(2, lives.getNumberLives());

        runner.keySpace();
        Bomb newBomb = runner.getBomb();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }
        runner.run();
        assertEquals(1, lives.getNumberLives());

        runner.keySpace();
        Bomb finalBomb = runner.getBomb();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }
        runner.run();
        assertEquals(0, lives.getNumberLives());

        assertTrue(runner.getSetLevel2() == false);
        assertTrue(runner.getGameOver() == true);
    }


    @Test 
    public void secondLevel3() {

        //  Test map correctly loads and works in second level

        Runner runner = new Runner();

        assertTrue(runner.getSetLevel1() == true);
        assertTrue(runner.getSetLevel2() == false);

        runner.setSecondLevel();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.run();

        assertTrue(runner.getSetLevel1() == false);
        assertTrue(runner.getSetLevel2() == true);

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyLeft();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        runner.run();
    }


    @Test 
    public void secondLevel4() {

        //  Test map correctly loads and works in second level

        Runner runner = new Runner();

        assertTrue(runner.getSetLevel1() == true);
        assertTrue(runner.getSetLevel2() == false);

        runner.setSecondLevel();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();

        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();

        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
        
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.run();

        assertTrue(runner.getSetLevel1() == false);
        assertTrue(runner.getSetLevel2() == true);

        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyRight();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        runner.run();
    }


    @Test 
    public void yellowEnemyRemovedBomb1() {

        //  Check yellow enemy is correctly removed by bomb

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();
    
        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();
    
        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
            
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        assertTrue(yellowEnemy.isRemoved() == false);

        runner.keyRight();
        runner.keyRight();
    
        for (int i = 0; i < 8; i++) {
            runner.keyDown();
        }

        runner.keyLeft();
        runner.keyLeft();

        runner.keyDown();
        runner.keyDown();

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keyUp();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyDown();
        runner.keyDown();
        runner.keyLeft();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertTrue(yellowEnemy.isRemoved() == true);
    }


    @Test 
    public void yellowEnemyRemovedBomb2() {

        //  Check yellow enemy is correctly removed by bomb

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();
    
        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();
    
        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
            
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        assertTrue(yellowEnemy.isRemoved() == false);

        runner.keyRight();
        runner.keyRight();
    
        for (int i = 0; i < 8; i++) {
            runner.keyDown();
        }

        runner.keyLeft();
        runner.keyLeft();

        runner.keyDown();
        runner.keyDown();

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyLeft();
        runner.keyLeft();
        runner.keyLeft();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertTrue(yellowEnemy.isRemoved() == true);
    }


    @Test 
    public void yellowEnemyRemovedBomb3() {

        //  Check yellow enemy is correctly removed by bomb

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();
    
        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();
    
        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
            
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        assertTrue(yellowEnemy.isRemoved() == false);

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        runner.keyRight();
        runner.keyRight();
    
        for (int i = 0; i < 8; i++) {
            runner.keyDown();
        }

        runner.keyLeft();
        runner.keyLeft();

        runner.keyDown();
        runner.keyDown();

        runner.keyRight();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyLeft();
        runner.keyUp();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertTrue(yellowEnemy.isRemoved() == true);
    }


    @Test 
    public void yellowEnemyRemovedBomb4() {

        //  Check yellow enemy is correctly removed by bomb

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();
    
        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();
    
        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
            
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        assertTrue(yellowEnemy.isRemoved() == false);

        for (int i = 0; i < 301; i++) {

            runner.run();
        }

        runner.keyRight();
        runner.keyRight();
    
        for (int i = 0; i < 8; i++) {
            runner.keyDown();
        }

        runner.keyLeft();
        runner.keyLeft();

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyRight();
        runner.keyRight();
        runner.keyUp();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertTrue(yellowEnemy.isRemoved() == true);
    }


    @Test 
    public void yellowEnemyRemovedBomb5() {

        //  Check yellow enemy is correctly removed by bomb

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();
    
        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();
    
        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
            
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        assertTrue(yellowEnemy.isRemoved() == false);

        for (int i = 0; i < 421; i++) {

            runner.run();
        }

        runner.keyRight();
        runner.keyRight();
    
        for (int i = 0; i < 8; i++) {
            runner.keyDown();
        }

        runner.keySpace();
        Bomb bomb = runner.getBomb();

        runner.keyUp();
        runner.keyUp();
        runner.keyRight();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        assertTrue(yellowEnemy.isRemoved() == true);
    }


    @Test 
    public void testExplosion() {

        //  Check explosions are handle correctly

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();
    
        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();
    
        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
            
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.run();

        runner.keySpace();
        Bomb bomb = runner.getBomb();
        bomb.detonate();

        Explosion explosion = runner.getExplosion();

        for (int i = 0; i < 40; i++) {

            runner.run();
        }

        runner.keySpace();
        Bomb newBomb = runner.getBomb();
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        for (int i = 0; i < 152; i++) {

            runner.run();
        }

        runner.setSecondLevel();
        runner.keySpace();
        Bomb finalBomb = runner.getBomb();
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        for (int i = 0; i < 152; i++) {

            runner.run();
        }
    }


    @Test 
    public void removeRedEnemy1() {

        //  Check red enemy is correctly removed by bomb

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();
    
        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();
    
        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
            
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        runner.run();

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keyDown();
        runner.keyDown();
        runner.keyDown();
        runner.keyDown();

        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb newBomb = runner.getBomb();

        runner.keyLeft();
        runner.keyLeft();
        runner.keyUp();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }
    }


    @Test 
    public void removeRedEnemy2() {

        //  Check red enemy is correctly removed by bomb

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();
    
        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();
    
        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
            
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();

        redEnemy.setMoveLeft();

        runner.run();

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keyDown();
        runner.keyDown();
        runner.keyDown();
        runner.keyDown();

        runner.keyRight();

        runner.keySpace();
        Bomb newBomb = runner.getBomb();

        runner.keyLeft();
        runner.keyUp();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        newBomb.getBlockedLeft2();
        newBomb.getBlockedRight2();
        newBomb.getBlockedUp2();
        newBomb.getBlockedDown2();
    }



    @Test 
    public void level2Test1() {

        //  Test level 2 correctly loads

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();
    
        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();
    
        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
            
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();


        BombGuy newBombGuy = new BombGuy(416, 400);
        runner.setBombGuy(newBombGuy);
        runner.run();

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb newBomb = runner.getBomb();

        runner.keyLeft();
        runner.keyLeft();
        runner.keyLeft();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        BombGuy myBombGuy = new BombGuy(416, 240);
        runner.setBombGuy(myBombGuy);
        runner.run();
    }


    @Test 
    public void level2Test2() {

        //  Test level 2 correctly loads

        Runner runner = new Runner();

        Clock clock = runner.getClock();
        Player player = runner.getPlayer();
    
        YellowEnemy yellowEnemy = runner.getYellowEnemy();
        RedEnemy redEnemy = runner.getRedEnemy();
    
        BombGuy bombGuy = runner.getBombGuy();
        Lives lives = runner.getLives();
            
        DynamicMatrix levels = runner.getLevels();
        Time time = runner.getTime();


        BombGuy newBombGuy = new BombGuy(416, 400);
        runner.setBombGuy(newBombGuy);
        runner.run();

        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        runner.keySpace();
        Bomb newBomb = runner.getBomb();

        runner.keyLeft();
        runner.keyLeft();
        runner.keyLeft();

        for (int i = 0; i < 121; i++) {

            runner.run();
        }

        runner.bombSetBrokenWallRight2();
        runner.run();

        runner.keySpace();
        Bomb bomb = runner.getBomb();
        
        runner.keyRight();
        runner.keyRight();
        runner.keyRight();

        for (int i = 0; i < 152; i++) {

            runner.run();
        }
    }
}
