package demolition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import demolition.BrokenWall;
import demolition.Wall;
import demolition.EmptyTile;


public class TileTest {
    
    
    @Test 
    public void wallLoad() {

        //  Check wall is loaded in correctly

        Wall wall = new Wall(0, 64);
        assertEquals(0, wall.getX());
        assertEquals(64, wall.getY());
    }


    @Test 
    public void brokenWallLoad() {

        //  Check broken wall is loaded in correctly

        BrokenWall brokenWall = new BrokenWall(32, 192);
        assertEquals(32, brokenWall.getX());
        assertEquals(192, brokenWall.getY());
    }


    @Test 
    public void emptyTileLoad() {

        //  Check empty tile is loaded in correctly

        EmptyTile tile = new EmptyTile(32, 96);
        assertEquals(32, tile.getX());
        assertEquals(96, tile.getY());
    }
}
