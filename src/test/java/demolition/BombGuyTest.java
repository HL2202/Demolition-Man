package demolition;

import org.junit.jupiter.api.Test;

import demolition.BombGuy;
import demolition.DynamicMatrix;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class BombGuyTest {

    
    @Test
    public void loadBombGuy() {

        //  Test if bomb guy is correctly loaded in the start screen

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(32, bombGuy.getX());
        assertEquals(80, bombGuy.getY());
    }


    @Test
    public void playerMoveRight() {

        //  Check if bomb guy correctly moves left when player uses left arrow

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(32, bombGuy.getX());
        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());
    }


    @Test 
    public void playerMoveDown() {

        //  Check if bomb guy correctly moves right when player uses right arrow

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(80, bombGuy.getY());
        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(112, bombGuy.getY());
    }


    @Test 
    public void playerMoveLeft() {

        //  Check if bomb guy correctly moves left when player uses left arrow

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(32, bombGuy.getX());
        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());

        bombGuy.pressLeft();
        bombGuy.tick();
        assertEquals(32, bombGuy.getX());
    }


    @Test 
    public void playerMoveUp() {

        //  Check if bomb guy correctly moves up when player uses up arrow
        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(80, bombGuy.getY());
        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(112, bombGuy.getY());

        bombGuy.pressUp();
        bombGuy.tick();
        assertEquals(80, bombGuy.getY());
    }


    @Test 
    public void playerBlockedBySolidLeft() {

        //  Check that player cannot move left after reaching a solid wall

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(32, bombGuy.getX());
        bombGuy.pressLeft();
        bombGuy.tick();
        assertEquals(32, bombGuy.getX());
    }


    @Test 
    public void playerBlockedBySolidWallUp() {

        //  Check that player cannot move up after reaching a solid wall

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(80, bombGuy.getY());
        bombGuy.pressUp();
        bombGuy.tick();
        assertEquals(80, bombGuy.getY());
    }


    @Test 
    public void playerBlockedBySolidWallDown() {

        //  Check that player cannot move down after reaching a solid wall

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(80, bombGuy.getY());
        bombGuy.pressRight();
        bombGuy.tick();

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(80, bombGuy.getY());
    }


    @Test 
    public void playerBlockedBySolidWallRight() {

        //  Check that player cannot move right after reaching a solid wall

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(32, bombGuy.getX());
        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(96, bombGuy.getX());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(112, bombGuy.getY());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(96, bombGuy.getX());
    }


    @Test 
    public void playerCornerBlock() {

        //  Check player is correctly blocked by multiple directions of solid walls at the corner(s) of the map

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(32, bombGuy.getX());
        assertEquals(80, bombGuy.getY());

        bombGuy.pressLeft();
        bombGuy.tick();
        assertEquals(32, bombGuy.getX());

        bombGuy.pressUp();
        bombGuy.tick();
        assertEquals(80, bombGuy.getY());
    }


    @Test 
    public void playerBlockedByBrokenWallRight() {

        //  Check that player cannot move in right after reaching a broken wall

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(32, bombGuy.getX());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(96, bombGuy.getX());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(128, bombGuy.getX());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(160, bombGuy.getX());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(160, bombGuy.getX());
    }


    @Test 
    public void playerBlockedByBrokenWallDown() {

        //  Check that player cannot move down after reaching a broken wall

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(80, bombGuy.getY());
        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(112, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(144, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(144, bombGuy.getY());
    }


    @Test 
    public void playerBlockedByBrokenWallUp() {

        //  Check that player cannot move up after reaching a broken wall
        
        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(32, bombGuy.getX());
        assertEquals(80, bombGuy.getY());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(96, bombGuy.getX());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(112, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(144, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(176, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(208, bombGuy.getY());

        bombGuy.pressLeft();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());

        bombGuy.pressLeft();
        bombGuy.tick();
        assertEquals(32, bombGuy.getX());

        bombGuy.pressUp();
        bombGuy.tick();
        assertEquals(208, bombGuy.getY());
    }


    @Test 
    public void playerBlockedByBrokenWallLeft() {

        //  Check that player cannot move left after reaching a broken wall
        
        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(32, bombGuy.getX());
        assertEquals(80, bombGuy.getY());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(96, bombGuy.getX());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(112, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(144, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(176, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(208, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(240, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(272, bombGuy.getY());

        bombGuy.pressLeft();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());

        bombGuy.pressLeft();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());
    }


    @Test
    public void playerMultipleMoves() {

        //  Check bomb guy moves correctly across multiple arrow key presses

        BombGuy bombGuy = new BombGuy(32, 80);
        assertEquals(32, bombGuy.getX());
        assertEquals(80, bombGuy.getY());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());
        assertEquals(80, bombGuy.getY());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(96, bombGuy.getX());
        assertEquals(80, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(112, bombGuy.getY());
        assertEquals(96, bombGuy.getX());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(144, bombGuy.getY());
        assertEquals(96, bombGuy.getX());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(176, bombGuy.getY());
        assertEquals(96, bombGuy.getX());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(208, bombGuy.getY());
        assertEquals(96, bombGuy.getX());

        bombGuy.pressLeft();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());
        assertEquals(208, bombGuy.getY());

        bombGuy.pressLeft();
        bombGuy.tick();
        assertEquals(32, bombGuy.getX());
        assertEquals(208, bombGuy.getY());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());
        assertEquals(208, bombGuy.getY());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(96, bombGuy.getX());
        assertEquals(208, bombGuy.getY());

        bombGuy.pressUp();
        bombGuy.tick();
        assertEquals(176, bombGuy.getY());
        assertEquals(96, bombGuy.getX());

        bombGuy.pressUp();
        bombGuy.tick();
        assertEquals(144, bombGuy.getY());
        assertEquals(96, bombGuy.getX());

        bombGuy.pressLeft();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());
        assertEquals(144, bombGuy.getY());
    }


    public void bombGuyLevel2() {

        //  Sets to the second level and tests bomb guy's interactions in level 2

        BombGuy bombGuy = new BombGuy(32, 240);
        bombGuy.nextLevel();
        bombGuy.tick();
        bombGuy.nextLevel();
        bombGuy.pressLeft();
        bombGuy.tick();
        bombGuy.pressRight();
        bombGuy.tick();
        bombGuy.pressUp();
        bombGuy.tick();
        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(32, bombGuy.getX());
        assertEquals(240, bombGuy.getY());

        bombGuy.pressUp();
        bombGuy.tick();
        assertEquals(32, bombGuy.getX());
        assertEquals(240, bombGuy.getY());

        bombGuy.pressDown();
        bombGuy.tick();
        assertEquals(32, bombGuy.getX());
        assertEquals(240, bombGuy.getY());

        bombGuy.pressRight();
        bombGuy.tick();
        assertEquals(64, bombGuy.getX());
        assertEquals(240, bombGuy.getY());
    }

    
    @Test 
    public void bombGuySprite() {

        //  Check all bomb guy sprite animations are correctly loaded

        BombGuy bombGuy = new BombGuy(32, 240);
        bombGuy.spriteTick();
        assertTrue(bombGuy.getDownSprite1() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }
        
        assertTrue(bombGuy.getDownSprite1() == false);
        assertTrue(bombGuy.getDownSprite2() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getDownSprite2() == false);
        assertTrue(bombGuy.getDownSprite3() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getDownSprite3() == false);
        assertTrue(bombGuy.getDownSprite4() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        bombGuy.resetSpriteTimer();
        bombGuy.pressRight();
        bombGuy.spriteTick();
        assertTrue(bombGuy.getDownSprite4() == false);
        assertTrue(bombGuy.getRightSprite1() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getRightSprite1() == false);
        assertTrue(bombGuy.getRightSprite2() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getRightSprite2() == false);
        assertTrue(bombGuy.getRightSprite3() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getRightSprite3() == false);
        assertTrue(bombGuy.getRightSprite4() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        bombGuy.resetSpriteTimer();
        bombGuy.pressUp();
        bombGuy.spriteTick();
        assertTrue(bombGuy.getRightSprite4() == false);
        assertTrue(bombGuy.getUpSprite1() == true);
        
        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getUpSprite1() == false);
        assertTrue(bombGuy.getUpSprite2() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getUpSprite2() == false);
        assertTrue(bombGuy.getUpSprite3() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getUpSprite3() == false);
        assertTrue(bombGuy.getUpSprite4() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        bombGuy.resetSpriteTimer();
        bombGuy.pressLeft();
        bombGuy.spriteTick();
        assertTrue(bombGuy.getUpSprite4() == false);
        assertTrue(bombGuy.getLeftSprite1() == true);
        
        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getLeftSprite1() == false);
        assertTrue(bombGuy.getLeftSprite2() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getLeftSprite2() == false);
        assertTrue(bombGuy.getLeftSprite3() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        assertTrue(bombGuy.getLeftSprite3() == false);
        assertTrue(bombGuy.getLeftSprite4() == true);

        for (int i = 0; i < 12; i++) {

            bombGuy.spriteTick();
        }

        bombGuy.resetReplace();
        bombGuy.bombDeployed();
    }



    @Test 
    public void testLevel2() {

        //  Check level2 is correctly loaded

        BombGuy bombGuy = new BombGuy(32, 240);
        bombGuy.nextLevel();
        assertTrue(bombGuy.getSetLevel1() == false);
        assertTrue(bombGuy.getSetLevel2() == true);

        bombGuy.tick();
        bombGuy.pressLeft();

        bombGuy.tick();
        bombGuy.pressUp();

        bombGuy.tick();
        bombGuy.pressDown();

        bombGuy.tick();
        bombGuy.pressRight();

        bombGuy.tick();
        bombGuy.pressLeft();

        bombGuy.tick();
        bombGuy.gameReset();

        bombGuy.tick();
        bombGuy.wallReplace(192, 240);

        bombGuy.tick();
        bombGuy.gameReset();

        bombGuy.tick();
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();
        bombGuy.pressRight();

        bombGuy.tick();
    }
}
