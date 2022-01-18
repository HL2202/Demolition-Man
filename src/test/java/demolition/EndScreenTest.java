package demolition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EndScreenTest {
    
    @Test
    public void loadEndScreen() {

        //  Check endscreen is loaded in correctly

        EndScreen endScreenWin = new EndScreen(150, 210, "GAME OVER");
        assertEquals(150, endScreenWin.getX());
        assertEquals(210, endScreenWin.getY());

        EndScreen endScreenLose = new EndScreen(165, 210, "YOU WIN");
        assertEquals(165, endScreenLose.getX());
        assertEquals(210, endScreenLose.getY());
    }
}
