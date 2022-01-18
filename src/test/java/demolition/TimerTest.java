package demolition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TimerTest {
    

    @Test
    public void loadTimer() {

        //  Check timer is loaded correctly in the start screen

        Time tickTime = new Time(298, 45);
        assertEquals(298, tickTime.getX());
        assertEquals(45, tickTime.getY());
        assertEquals(180, tickTime.getTimeCount());
    }

    
    @Test
    public void loadClock() {

        //  Check clock is loaded correctly in the start screen

        Clock clock = new Clock(256, 20);
        assertEquals(256, clock.getX());
        assertEquals(20, clock.getY());
    }


    @Test 
    public void timeTick() {

        //  Check the time is correctly displayed each second

        Time tickTime = new Time(298, 45);
        assertEquals(180, tickTime.getTimeCount());  
        tickTime.tick();
        assertEquals(180, tickTime.getTimeCount());  

        for (int i = 0; i < 60; i++) {

            tickTime.tick();  
        }

        assertEquals(179, tickTime.getTimeCount());  
    }


    @Test 
    public void resetTimer() {

        //  Check the time gets correctly reset

        Time tickTime = new Time(298, 45);
        assertEquals(180, tickTime.getTimeCount());   

        for (int i = 0; i < 61; i++) {

            tickTime.tick();  
        }

        assertEquals(179, tickTime.getTimeCount()); 

        for (int i = 0; i < 61; i++) {

            tickTime.tick();  
        }

        assertEquals(178, tickTime.getTimeCount()); 

        tickTime.timerReset();
        assertEquals(180, tickTime.getTimeCount());   
    }
}
