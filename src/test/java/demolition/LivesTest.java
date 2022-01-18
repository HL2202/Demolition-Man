package demolition;

import org.junit.jupiter.api.Test;

import demolition.Lives;

import static org.junit.jupiter.api.Assertions.*;


public class LivesTest {
    

    @Test
    public void loadLives() {

        //  Check number of lives is loaded correctly in the start screen

        Lives lives = new Lives(170, 45);
        assertEquals(170, lives.getX());
        assertEquals(45, lives.getY());

        //  Check player has the correct number of lives displayed at the start of the game
        assertEquals(3, lives.getNumberLives());
    }

    
    @Test
    public void loadPlayerIcon() {

        //  Check player icon is loaded correctly in the start screen

        Player player = new Player(128, 20);
        assertEquals(128, player.getX());
        assertEquals(20, player.getY());
    }


    @Test 
    public void livesDisplayLoseLife() {

        //  Check player has the correct number of lives displayed after losing a life

        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());
    }


    @Test 
    public void livesDisplayReset() {

        //  Check the number of lives get correctly reset


        Lives lives = new Lives(170, 45);
        assertEquals(3, lives.getNumberLives());

        lives.loseLife();
        assertEquals(2, lives.getNumberLives());

        lives.loseLife();
        assertEquals(1, lives.getNumberLives());

        lives.resetLives();
        assertEquals(3, lives.getNumberLives());
    }
}
