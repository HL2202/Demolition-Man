package demolition;

import org.junit.jupiter.api.Test;

import demolition.BombGuy;
import demolition.DynamicMatrix;
import demolition.Lives;
import demolition.Bomb;
import demolition.YellowEnemy;
import demolition.RedEnemy;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class BombTest {
    

    @Test 
    public void deployBombClear() {

        //  Check if bomb guy deploys a bomb which detonates correctly using the space bar

        BombGuy bombGuy = new BombGuy(32, 80);
        assertTrue(bombGuy.bombReady() == false);
        bombGuy.pressSpace();
        assertTrue(bombGuy.bombReady() == true);

        Bomb bomb = new Bomb(32, 80);
        assertEquals(32, bomb.getX());
        assertEquals(80, bomb.getY());

        assertTrue(bomb.isExploded() == false);
        bomb.tick();
        assertTrue(bomb.isExploded() == false);

        for (int i = 0; i < 120; i++) {

            bomb.tick();
        }

        assertTrue(bomb.isExploded() == true);
    }


    @Test 
    public void deployBombBlockedBySolidWallVertical() {

        //  Check if bomb explosion is correctly stopped in the vertical directions by solid walls

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressSpace();
        Bomb bomb = new Bomb(32, 80);

        assertTrue(bomb.getBlockedUp() == false);
        assertTrue(bomb.getBlockedDown() == false);
        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }
        assertTrue(bomb.getBlockedUp() == true);
        assertTrue(bomb.getBlockedDown() == false);
    }


    @Test 
    public void deployBombBlockedBySolidWallHorizontal() {

        //  Check if bomb explosion is correctly stopped in the horizontal directions by solid walls

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressSpace();
        Bomb bomb = new Bomb(32, 80);

        assertTrue(bomb.getBlockedLeft() == false);
        assertTrue(bomb.getBlockedRight() == false);
        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }
        assertTrue(bomb.getBlockedLeft() == true);
        assertTrue(bomb.getBlockedRight() == false);
    }


    @Test 
    public void deployBombBlockedByCorner() {

        //  Check if bomb explosion is correctly stopped in 2 directions when bomb is deployed at the corner of the map

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressSpace();
        Bomb bomb = new Bomb(32, 80);

        assertTrue(bomb.getBlockedUp() == false);
        assertTrue(bomb.getBlockedDown() == false);
        assertTrue(bomb.getBlockedLeft() == false);
        assertTrue(bomb.getBlockedRight() == false);
        
        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBlockedLeft() == true);
        assertTrue(bomb.getBlockedRight() == false);
        assertTrue(bomb.getBlockedUp() == true);
        assertTrue(bomb.getBlockedDown() == false);
    }


    @Test 
    public void deployBombBlockedByBrokenWallHorizontalOneSquare() {

        //  Check if bomb explosion is correctly stopped in the horizontal direction by broken wall 1 square away

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 160);
        assertEquals(y, 96);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBlockedRight() == false);
        assertTrue(bomb.getBrokenWallRight1() == false);

        assertTrue(bomb.getBlockedLeft() == false);
        assertTrue(bomb.getBrokenWallLeft1() == false);

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBlockedRight() == true);
        assertTrue(bomb.getBrokenWallRight1() == true);

        assertTrue(bomb.getBlockedLeft() == false);
        assertTrue(bomb.getBrokenWallLeft1() == false);
    }


    @Test
    public void deployBombBlockedByBrokenWallVerticalOneSquare1() {

        //  Check if bomb explosion is correctly stopped in the vertical direction by broken wall 1 square away

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressDown();
        bombGuy.pressDown();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 32);
        assertEquals(y, 160);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBlockedUp() == false);
        assertTrue(bomb.getBrokenWallUp1() == false);

        assertTrue(bomb.getBlockedDown() == false);
        assertTrue(bomb.getBrokenWallDown1() == false);

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBlockedDown() == true);
        assertTrue(bomb.getBrokenWallDown1() == true);

        assertTrue(bomb.getBlockedUp() == false);
        assertTrue(bomb.getBrokenWallUp1() == false);
    }


    @Test
    public void deployBombBlockedByBrokenWallVerticalOneSquare2() {

        //  Check if bomb explosion is correctly stopped in the vertical direction by broken wall 1 square away

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressRight();
        bombGuy.pressRight();

        bombGuy.pressDown();
        bombGuy.pressDown();
        bombGuy.pressDown();
        bombGuy.pressDown();

        bombGuy.pressLeft();
        bombGuy.pressLeft();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 32);
        assertEquals(y, 224);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBlockedUp() == false);
        assertTrue(bomb.getBrokenWallUp1() == false);

        assertTrue(bomb.getBlockedDown() == false);
        assertTrue(bomb.getBrokenWallDown1() == false);

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBlockedDown() == false);
        assertTrue(bomb.getBrokenWallDown1() == false);

        assertTrue(bomb.getBlockedUp() == true);
        assertTrue(bomb.getBrokenWallUp1() == true);
    }


    @Test 
    public void deployBombBlockedByBrokenWallHorizontalTwoSquares() {

        //  Check if bomb explosion is correctly stopped in the horizontal direction by broken wall 2 squares away

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 128);
        assertEquals(y, 96);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBrokenWallRight2() == false);

        assertTrue(bomb.getBrokenWallLeft2() == false);

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBrokenWallRight2() == true);

        assertTrue(bomb.getBrokenWallLeft2() == false);
    }


    @Test 
    public void deployBombBlockedByBrokenWallVerticalTwoSquares1() {

        //  Check if bomb explosion is correctly stopped in the vertical direction by broken wall 2 squares away

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressDown();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 32);
        assertEquals(y, 128);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBrokenWallUp2() == false);
        assertTrue(bomb.getBrokenWallDown2() == false);

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBrokenWallDown2() == true);
        assertTrue(bomb.getBrokenWallUp2() == false);       
    }


    @Test
    public void deployBombBlockedByBrokenWallVerticalTwoSquares2() {

        //  Check if bomb explosion is correctly stopped in the vertical direction by broken wall 1 square away

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressRight();
        bombGuy.pressRight();

        bombGuy.pressDown();
        bombGuy.pressDown();
        bombGuy.pressDown();
        bombGuy.pressDown();

        bombGuy.pressLeft();
        bombGuy.pressLeft();
        bombGuy.pressDown();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 32);
        assertEquals(y, 256);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBrokenWallUp2() == false);

        assertTrue(bomb.getBrokenWallDown2() == false);

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBrokenWallDown2() == false);

        assertTrue(bomb.getBrokenWallUp2() == true);
    }


    @Test 
    public void deployBombDestroyMultipleBrokenWalls1() {

        //  Check if bomb deployed in range of multiple broken walls is correctly stopped by the blast in the direction, and the wall is replaced with empty tile after blast

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressRight();
        bombGuy.pressRight();

        bombGuy.pressDown();
        bombGuy.pressDown();
        bombGuy.pressDown();
        bombGuy.pressDown();
        bombGuy.pressDown();
        bombGuy.pressDown();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 96);
        assertEquals(y, 288);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBrokenWallRight2() == false);
        assertTrue(bomb.getBrokenWallLeft2() == false);
        
        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBrokenWallRight2() == true);
        assertTrue(bomb.getBrokenWallLeft2() == true);
    }


    @Test
    public void deployBombDestroyMultipleBrokenWalls2() {

        //  Check if bomb deployed in range of multiple broken walls is correctly stopped by the blast in the direction, and the wall is replaced with empty tile after blast

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();

        bombGuy.pressDown();
        bombGuy.pressDown();

        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();

        bombGuy.pressUp();
        bombGuy.pressUp();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 288);
        assertEquals(y, 96);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBrokenWallRight1() == false);
        assertTrue(bomb.getBrokenWallLeft1() == false);
        assertTrue(bomb.getBlockedLeft() == false);
        assertTrue(bomb.getBlockedRight() == false);
        
        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBrokenWallRight1() == true);
        assertTrue(bomb.getBrokenWallLeft1() == true);
        assertTrue(bomb.getBlockedLeft() == true);
        assertTrue(bomb.getBlockedRight() == true);
    }


    @Test 
    public void deployBombBrokenWallBlockedBySolidWall1() {

        //  Check a broken wall is not destroyed when there is a solid wall blocking it

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressRight();
        bombGuy.pressRight();

        bombGuy.pressDown();
        bombGuy.pressDown();
        bombGuy.pressDown();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 96);
        assertEquals(y, 192);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBlockedLeft() == false);
        assertTrue(bomb.getBrokenWallLeft2() == false);
        
        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBlockedLeft() == true);
        assertTrue(bomb.getBrokenWallLeft2() == false);
    }


    @Test 
    public void deployBombBrokenWallBlockedBySolidWall2() {

        //  Check a broken wall is not destroyed when there is a solid wall blocking it

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();

        bombGuy.pressDown();
        bombGuy.pressDown();

        bombGuy.pressRight();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 192);
        assertEquals(y, 160);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBlockedUp() == false);
        assertTrue(bomb.getBrokenWallUp2() == false);
        
        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBlockedUp() == true);
        assertTrue(bomb.getBrokenWallUp2() == false);
    }


        
    @Test
    public void loseLifeBombSameTile() {

        //  Check if bomb guys loses a life if they are caught in explosion in same tile

        BombGuy bombGuy = new BombGuy(32, 80);
        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bombGuy.getX() == bomb.getX());
        assertTrue(bombGuy.getY() == bomb.getY() - 16);
        assertTrue(bomb.isExploded() == true);

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());
    }


    @Test
    public void loseLifeBombOneTileRight() {

        //  Check if bomb guys loses a life if they are caught in explosion in one tile to the right

        BombGuy bombGuy = new BombGuy(32, 80);
        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        bombGuy.pressRight();

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bombGuy.getX() == bomb.getX() + 32);
        assertTrue(bombGuy.getY() == bomb.getY() - 16);
        assertTrue(bomb.isExploded() == true);

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());
    }


    @Test
    public void loseLifeBombTwoTileRight() {

        //  Check if bomb guys loses a life if they are caught in explosion in two tiles to the right

        BombGuy bombGuy = new BombGuy(32, 80);
        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        bombGuy.pressRight();
        bombGuy.pressRight();

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bombGuy.getX() == bomb.getX() + 64);
        assertTrue(bombGuy.getY() == bomb.getY() - 16);
        assertTrue(bomb.isExploded() == true);

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());
    }


    @Test
    public void loseLifeBombOneTileLeft() {

        //  Check if bomb guys loses a life if they are caught in explosion in one tile to the left

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressRight();
        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        bombGuy.pressLeft();

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bombGuy.getX() == bomb.getX() - 32);
        assertTrue(bombGuy.getY() == bomb.getY() - 16);
        assertTrue(bomb.isExploded() == true);

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());
    }


    @Test
    public void loseLifeBombTwoTileLeft() {

        //  Check if bomb guys loses a life if they are caught in explosion in two tiles to the left

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressRight();
        bombGuy.pressRight();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        bombGuy.pressLeft();
        bombGuy.pressLeft();

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bombGuy.getX() == bomb.getX() - 64);
        assertTrue(bombGuy.getY() == bomb.getY() - 16);
        assertTrue(bomb.isExploded() == true);

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());
    }


    @Test
    public void loseLifeBombOneTileDown() {

        //  Check if bomb guys loses a life if they are caught in explosion in one tile down

        BombGuy bombGuy = new BombGuy(32, 80);
        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        bombGuy.pressDown();

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bombGuy.getX() == bomb.getX());
        assertTrue(bombGuy.getY() == bomb.getY() + 16);
        assertTrue(bomb.isExploded() == true);

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());
    }


    @Test
    public void loseLifeBombTwoTilesDown() {

        //  Check if bomb guys loses a life if they are caught in explosion in two tiles down

        BombGuy bombGuy = new BombGuy(32, 80);
        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        bombGuy.pressDown();
        bombGuy.pressDown();

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bombGuy.getX() == bomb.getX());
        assertTrue(bombGuy.getY() == bomb.getY() + 48);
        assertTrue(bomb.isExploded() == true);

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());
    }


    @Test
    public void loseLifeBombOneTileUp() {

        //  Check if bomb guys loses a life if they are caught in explosion in one tile up

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressDown();
        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        bombGuy.pressUp();

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bombGuy.getX() == bomb.getX());
        assertTrue(bombGuy.getY() == bomb.getY() - 48);
        assertTrue(bomb.isExploded() == true);

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());
    }


    @Test
    public void loseLifeBombTwoTilesUp() {

        //  Check if bomb guys loses a life if they are caught in explosion in two tiles up

        BombGuy bombGuy = new BombGuy(32, 80);
        bombGuy.pressDown();
        bombGuy.pressDown();
        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        bombGuy.pressUp();
        bombGuy.pressUp();

        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bombGuy.getX() == bomb.getX());
        assertTrue(bombGuy.getY() == bomb.getY() - 80);
        assertTrue(bomb.isExploded() == true);

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());
    }


    @Test
    public void bombRemoveYellowEnemy() {

        //  Check if yellow enemy in the vicinity of the bomb is correctly removed when bomb detonates

        BombGuy bombGuy = new BombGuy(32, 80);
        YellowEnemy yellowEnemy = new YellowEnemy(160, 336);
        bombGuy.pressRight();
        bombGuy.pressRight();
        for (int i = 0; i < 8; i++) {
            bombGuy.pressDown();
        }
        bombGuy.pressRight();
        bombGuy.pressRight();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        assertTrue(yellowEnemy.isRemoved() == false);

        for (int i = 0; i < 61; i++) {

            bomb.tick();
        }

        for (int j = 0; j < 61; j++) {

            yellowEnemy.tick();
        }

        for (int k = 0; k < 60; k++) {

            bomb.tick();
        }

        assertTrue(bomb.getX() == yellowEnemy.getX());
        assertTrue(bomb.getY() + 16 == yellowEnemy.getY());
        yellowEnemy.remove();
        assertTrue(yellowEnemy.isRemoved() == true);
    }


    @Test
    public void bombRemoveYellowEnemy2() {

        //  Check if yellow enemy in the vicinity of the bomb is correctly removed when bomb detonates

        BombGuy bombGuy = new BombGuy(32, 80);
        YellowEnemy yellowEnemy = new YellowEnemy(160, 336);
        bombGuy.pressRight();
        bombGuy.pressRight();
        for (int i = 0; i < 8; i++) {
            bombGuy.pressDown();
        }
        bombGuy.pressRight();
        bombGuy.pressRight();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        assertTrue(yellowEnemy.isRemoved() == false);

        for (int i = 0; i < 61; i++) {

            bomb.tick();
        }

        for (int j = 0; j < 61; j++) {

            yellowEnemy.tick();
        }

        for (int k = 0; k < 60; k++) {

            bomb.tick();
        }

        for (int j = 0; j < 61; j++) {

            yellowEnemy.tick();
        }

        assertTrue(bomb.getX() == yellowEnemy.getX());
        assertTrue(bomb.getY() + 48 == yellowEnemy.getY());
        yellowEnemy.remove();
        assertTrue(yellowEnemy.isRemoved() == true);
    }

    
    @Test
    public void enemyTimerUndo() {

        //  Check enemies correctly undo tick after bomb destroys wall

        BombGuy bombGuy = new BombGuy(32, 80);
        YellowEnemy yellowEnemy = new YellowEnemy(160, 336);
        RedEnemy redEnemy = new RedEnemy(256, 208);

        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();

        bombGuy.pressDown();
        bombGuy.pressDown();

        bombGuy.pressRight();

        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;

        assertEquals(x, 192);
        assertEquals(y, 160);

        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBlockedUp() == false);
        assertTrue(bomb.getBrokenWallUp2() == false);
        
        for (int i = 0; i < 121; i++) {

            bomb.tick();
        }

        assertTrue(bomb.getBlockedUp() == true);
        assertTrue(bomb.getBrokenWallUp2() == false);

        yellowEnemy.tick();
        yellowEnemy.timerUndo();

        redEnemy.tick();
        redEnemy.timerUndo();
    }


    @Test 
    public void bombSpriteTick() {

        //  Check the spriteTick() method correctly loads the sprites needed

        BombGuy bombGuy = new BombGuy(32, 80);
        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.getBombSprite1() == true);

        for (int i = 0; i < 15; i++) {

            bomb.spriteTick();
        }

        assertTrue(bomb.getBombSprite1() == false);
        assertTrue(bomb.getBombSprite2() == true);

        for (int i = 0; i < 15; i++) {

            bomb.spriteTick();
        }

        assertTrue(bomb.getBombSprite2() == false);
        assertTrue(bomb.getBombSprite3() == true);

        for (int i = 0; i < 15; i++) {

            bomb.spriteTick();
        }

        assertTrue(bomb.getBombSprite3() == false);
        assertTrue(bomb.getBombSprite4() == true);

        for (int i = 0; i < 15; i++) {

            bomb.spriteTick();
        }

        assertTrue(bomb.getBombSprite4() == false);
        assertTrue(bomb.getBombSprite5() == true);

        for (int i = 0; i < 15; i++) {

            bomb.spriteTick();
        }

        assertTrue(bomb.getBombSprite5() == false);
        assertTrue(bomb.getBombSprite6() == true);

        for (int i = 0; i < 15; i++) {

            bomb.spriteTick();
        }

        assertTrue(bomb.getBombSprite6() == false);
        assertTrue(bomb.getBombSprite7() == true);

        for (int i = 0; i < 15; i++) {

            bomb.spriteTick();
        }

        assertTrue(bomb.getBombSprite7() == false);
        assertTrue(bomb.getBombSprite8() == true);
    }


    @Test 
    public void bombDetonate() {

        //  Check bomb correctly detonates

        BombGuy bombGuy = new BombGuy(32, 80);
        int x = bombGuy.getX();
        int y = bombGuy.getY() + 16;
        Bomb bomb = new Bomb(x, y);

        assertTrue(bomb.isExploded() == false);
        bomb.detonate();
        assertTrue(bomb.isExploded() == true);

        bomb.tick();
        bomb.updateMap(x, y);

        bomb.tick();
        bomb.resetMap();

        bomb.tick();
        bomb.nextLevel();

        bomb.tick();
        bomb.updateMap(x, y);

        bomb.tick();
        bomb.resetMap();
        bomb.tick();
    }
}
