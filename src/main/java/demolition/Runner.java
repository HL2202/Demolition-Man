/**
 * Runner is the helper class of the program
 * It directly performs the actions related to each of the classes and each of the methods called by the objects according to App.java
 * 
 * Every time App is made, a runner object is immediately constructed alongside the app
 * Every time the draw() method is called in the App class, the run() method in the Runner class will be called
 * This corresponds to actions pertaining to ticks in the game by updating the frames each second
 * 
 * As such, the runner class governs the behaviour of all of the other classes
 * It determines when the BombGuy object is moved by the player, when the RedEnemy and YellowEnemy object move, updates the time and number of lives, and progresses the level
 * 
 * @author  Harry Li
 * @version %I%, %G%
 * @since   1.0
 */


package demolition;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import java.util.ArrayList;

import demolition.App;


public class Runner {

    
    private DynamicMatrix levels;
    private static ArrayList<String> level1;
    private static ArrayList<String> level2;

    private Clock clock;
    private Player player;

    private BombGuy bombGuy;
    private YellowEnemy yellowEnemy;
    private RedEnemy redEnemy;

    private boolean bombMade, resetLevel, setLevel1, setLevel2, gameOver, winGame, explosionStart;

    private Lives lives;

    private Time time;

    private EndScreen endScreen;

    private Bomb bomb;

    private int lastXCoord, lastYCoord, explosionTimer;

    private Explosion explosion;

    public static final double EXPLOSION_COUNTDOWN = 0.5;


    /**
     * Creates a new runner object which is instantiated every time the program is run
     * It also serves to create instance objects of all of the other classes which will be updated each frame
     */


    public Runner() {

        this.levels = new DynamicMatrix();
        this.level1 = levels.getLevel1();
        this.level2 = levels.getLevel2();

        this.bombMade = false;

        this.bombGuy = new BombGuy(32, 80);
     
        this.yellowEnemy = new YellowEnemy(160, 336);

        this.redEnemy = new RedEnemy(256, 208);

        this.clock = new Clock(256, 20);

        this.player = new Player(128, 20);

        this.time = new Time(298, 50);
        
        this.lives = new Lives(170, 50);

        this.setLevel1 = true;

        this.setLevel2 = false;

        this.gameOver = false;

        this.winGame = false;

        this.lastXCoord = 0;

        this.lastYCoord = 0;

        this.bomb = new Bomb(lastXCoord, lastYCoord);

        this.explosionTimer = 0;

        this.explosionStart = false;

        this.explosion = new Explosion(lastXCoord, lastYCoord);
    }


    /**
     * Called to update the frames each second by calling the tick() methods of many of the classes
     * Every time the draw() method is called, the run() method automatically is run and governs the behaviour of all objects shown on the screen
     */

    public void run() {

        if (!gameOver && setLevel1) {

            this.bombGuy.tick();
            this.yellowEnemy.tick();
            this.redEnemy.tick();

            if (resetLevel) {

                this.bombGuy = new BombGuy(32, 80);
     
                this.yellowEnemy = new YellowEnemy(160, 336);
        
                this.redEnemy = new RedEnemy(256, 208);

                this.resetLevel = false;
            }

            this.bombGuy.spriteTick();
            this.yellowEnemy.spriteTick();
            this.redEnemy.spriteTick();


            if (this.bombMade && !this.bomb.isExploded()) {

                this.bomb.tick();
                this.bomb.spriteTick();
            }

            else if (this.bombMade && this.bomb.isExploded()) {

                this.explosionStart = true;
                this.bombMade = false;
            }


            if (explosionStart) {

                this.explosionTimer ++;
                
                if (this.explosionTimer > EXPLOSION_COUNTDOWN * App.FPS) {

                    this.explosionStart = false;
                    this.explosionTimer = 0;
                }
            }


            if ((bomb.isExploded() && bombMade) || explosionStart) {

                if (bomb.getY() - 16 == bombGuy.getY() && bomb.getX() == bombGuy.getX()) {

                    this.lives.loseLife();
                    levels.resetLevel1(level1);
                    this.time.timerReset();
                
                    bombGuy.gameReset();
                    yellowEnemy.gameReset();
                    redEnemy.gameReset();
                    this.bomb.detonate();
                    this.bomb.resetMap();
                
                    resetLevel = true;
                    this.bombMade = false;
                    this.explosionStart = false;
                    this.explosionTimer = 0;
                }

                else {

                    if (bomb.getY() - 16 == yellowEnemy.getY() && bomb.getX() == yellowEnemy.getX()) {

                        yellowEnemy.remove();
                    }

                    if (bomb.getY() - 16 == redEnemy.getY() && bomb.getX() == redEnemy.getX()) {

                        redEnemy.remove();
                    }
                }


                if (!bomb.getBlockedLeft() && !resetLevel) {

                    if (bomb.getY() - 16 == bombGuy.getY() && (bomb.getX() - 32 == bombGuy.getX() || bomb.getX() - 64 == bombGuy.getX())) {

                        this.lives.loseLife();
                        levels.resetLevel1(level1);
                        this.time.timerReset();
                    
                        bombGuy.gameReset();
                        yellowEnemy.gameReset();
                        redEnemy.gameReset();
                        this.bomb.detonate();
                        this.bomb.resetMap();
                    
                        resetLevel = true;
                        this.bombMade = false;
                        this.explosionStart = false;
                        this.explosionTimer = 0;
                    }

                    else {

                        if (bomb.getY() - 16 == yellowEnemy.getY() && (bomb.getX() - 32 == yellowEnemy.getX() || bomb.getX() - 64 == yellowEnemy.getX())) {

                            yellowEnemy.remove();
                        }

                        if (bomb.getY() - 16 == redEnemy.getY() && (bomb.getX() - 32 == redEnemy.getX() || bomb.getX() - 64 == redEnemy.getX())) {

                            redEnemy.remove();
                        }
                    }
                }

                if (!bomb.getBlockedRight() && !resetLevel) {
                    
                    if (bomb.getY() - 16 == bombGuy.getY() && (bomb.getX() + 32 == bombGuy.getX() || bomb.getX() + 64 == bombGuy.getX())) {

                        this.lives.loseLife();
                        levels.resetLevel1(level1);
                        this.time.timerReset();
                    
                        bombGuy.gameReset();
                        yellowEnemy.gameReset();
                        redEnemy.gameReset();
                        this.bomb.detonate();
                        this.bomb.resetMap();
                    
                        resetLevel = true;
                        this.bombMade = false;
                        this.explosionStart = false;
                        this.explosionTimer = 0;
                    }

                    else {

                        if (bomb.getY() - 16 == yellowEnemy.getY() && (bomb.getX() + 32 == yellowEnemy.getX() || bomb.getX() + 64 == yellowEnemy.getX())) {

                            yellowEnemy.remove();
                        }

                        if (bomb.getY() - 16 == redEnemy.getY() && (bomb.getX() + 32 == redEnemy.getX() || bomb.getX() + 64 == redEnemy.getX())) {

                            redEnemy.remove();
                        }
                    }
                }


                if (!bomb.getBlockedUp() && !resetLevel) {

                    if (bomb.getX() == bombGuy.getX() && (bomb.getY() - 48 == bombGuy.getY() || bomb.getY() - 80 == bombGuy.getY())) {

                        this.lives.loseLife();
                        levels.resetLevel1(level1);
                        this.time.timerReset();
                    
                        bombGuy.gameReset();
                        yellowEnemy.gameReset();
                        redEnemy.gameReset();
                        this.bomb.detonate();
                        this.bomb.resetMap();
                    
                        resetLevel = true;
                        this.bombMade = false;
                        this.explosionStart = false;
                        this.explosionTimer = 0;
                    }

                    else {

                        if (bomb.getX() == yellowEnemy.getX() && (bomb.getY() - 48 == yellowEnemy.getY() || bomb.getY() - 80 == yellowEnemy.getY())) {

                            yellowEnemy.remove();
                        }

                        if (bomb.getX() == redEnemy.getX() && (bomb.getY() - 48 == redEnemy.getY() || bomb.getY() - 80 == redEnemy.getY())) {

                            redEnemy.remove();
                        }
                    }
                }


                if (!bomb.getBlockedDown() && !resetLevel) {

                    if (bomb.getX() == bombGuy.getX() && (bomb.getY() + 16 == bombGuy.getY() || bomb.getY() + 48 == bombGuy.getY())) {

                        this.lives.loseLife();
                        levels.resetLevel1(level1);
                        this.time.timerReset();
                    
                        bombGuy.gameReset();
                        yellowEnemy.gameReset();
                        redEnemy.gameReset();
                        this.bomb.detonate();
                        this.bomb.resetMap();
                    
                        resetLevel = true;
                        this.bombMade = false;
                        this.explosionStart = false;
                        this.explosionTimer = 0;
                    }

                    else {

                        if (bomb.getX() == yellowEnemy.getX() && (bomb.getY() + 16 == yellowEnemy.getY() || bomb.getY() + 48 == yellowEnemy.getY())) {

                            yellowEnemy.remove();
                        }

                        if (bomb.getX() == redEnemy.getX() && (bomb.getY() + 16 == redEnemy.getY() || bomb.getY() + 48 == redEnemy.getY())) {

                            redEnemy.remove();
                        }
                    }
                }


                if (this.bomb.getBrokenWallUp1() && !resetLevel) {

                    int replaceX = bomb.getX();
                    int replaceY = bomb.getY() - 96;
                    level1 = levels.replaceBrokenWall(level1, replaceX, replaceY);

                    bombGuy.wallReplace(replaceX, replaceY);
                    bombGuy.tick();
                    bombGuy.resetReplace(); 

                    yellowEnemy.wallReplace(replaceX, replaceY);
                    yellowEnemy.tick();
                    yellowEnemy.timerUndo();
                    yellowEnemy.resetReplace(); 

                    redEnemy.wallReplace(replaceX, replaceY);
                    redEnemy.tick();
                    redEnemy.timerUndo();
                    redEnemy.resetReplace();

                    bomb.updateMap(replaceX, replaceY);
                }

                if (this.bomb.getBrokenWallDown1() && !resetLevel) {

                    int replaceX = bomb.getX();
                    int replaceY = bomb.getY() - 32;
                    level1 = levels.replaceBrokenWall(level1, replaceX, replaceY);

                    bombGuy.wallReplace(replaceX, replaceY); 
                    bombGuy.tick();
                    bombGuy.resetReplace(); 

                    yellowEnemy.wallReplace(replaceX, replaceY);
                    yellowEnemy.tick();
                    yellowEnemy.timerUndo();
                    yellowEnemy.resetReplace(); 

                    redEnemy.wallReplace(replaceX, replaceY);
                    redEnemy.tick();
                    redEnemy.timerUndo();
                    redEnemy.resetReplace(); 

                    bomb.updateMap(replaceX, replaceY);
                }


                if (this.bomb.getBrokenWallLeft1() && !resetLevel) {

                    int replaceX = bomb.getX() - 32;
                    int replaceY = bomb.getY() - 64;
                    level1 = levels.replaceBrokenWall(level1, replaceX, replaceY); 

                    bombGuy.wallReplace(replaceX, replaceY); 
                    bombGuy.tick();
                    bombGuy.resetReplace(); 

                    yellowEnemy.wallReplace(replaceX, replaceY);
                    yellowEnemy.tick();
                    yellowEnemy.timerUndo();
                    yellowEnemy.resetReplace(); 

                    redEnemy.wallReplace(replaceX, replaceY);
                    redEnemy.tick();
                    redEnemy.timerUndo();
                    redEnemy.resetReplace(); 

                    bomb.updateMap(replaceX, replaceY);
                }
            
                if (this.bomb.getBrokenWallRight1() && !resetLevel) {

                    int replaceX = bomb.getX() + 32;
                    int replaceY = bomb.getY() - 64;
                    level1 = levels.replaceBrokenWall(level1, replaceX, replaceY); 

                    bombGuy.wallReplace(replaceX, replaceY); 
                    bombGuy.tick();
                    bombGuy.resetReplace(); 

                    yellowEnemy.wallReplace(replaceX, replaceY);
                    yellowEnemy.tick();
                    yellowEnemy.timerUndo();
                    yellowEnemy.resetReplace(); 

                    redEnemy.wallReplace(replaceX, replaceY);
                    redEnemy.tick();
                    redEnemy.timerUndo();
                    redEnemy.resetReplace(); 

                    bomb.updateMap(replaceX, replaceY);
                }


                if (this.bomb.getBrokenWallUp2() && !this.bomb.getBrokenWallUp1() && !resetLevel && !this.bomb.getBlockedUp()) {

                    int replaceX = bomb.getX();
                    int replaceY = bomb.getY() - 128;
                    level1 = levels.replaceBrokenWall(level1, replaceX, replaceY);

                    bombGuy.wallReplace(replaceX, replaceY);
                    bombGuy.tick();
                    bombGuy.resetReplace(); 

                    yellowEnemy.wallReplace(replaceX, replaceY);
                    yellowEnemy.tick();
                    yellowEnemy.timerUndo();
                    yellowEnemy.resetReplace(); 

                    redEnemy.wallReplace(replaceX, replaceY);
                    redEnemy.tick();
                    redEnemy.timerUndo();
                    redEnemy.resetReplace(); 

                    bomb.updateMap(replaceX, replaceY);
                }

                if (this.bomb.getBrokenWallDown2() && !this.bomb.getBrokenWallDown1() && !resetLevel && !this.bomb.getBlockedDown()) {

                    int replaceX = bomb.getX();
                    int replaceY = bomb.getY();
                    level1 = levels.replaceBrokenWall(level1, replaceX, replaceY); 

                    bombGuy.wallReplace(replaceX, replaceY); 
                    bombGuy.tick();
                    bombGuy.resetReplace(); 

                    yellowEnemy.wallReplace(replaceX, replaceY);
                    yellowEnemy.tick();
                    yellowEnemy.timerUndo();
                    yellowEnemy.resetReplace(); 

                    redEnemy.wallReplace(replaceX, replaceY);
                    redEnemy.tick();
                    redEnemy.timerUndo();
                    redEnemy.resetReplace(); 

                    bomb.updateMap(replaceX, replaceY);
                }


                if (this.bomb.getBrokenWallLeft2() && !this.bomb.getBrokenWallLeft1() && !resetLevel && !this.bomb.getBlockedLeft()) {

                    int replaceX = bomb.getX() - 64;
                    int replaceY = bomb.getY() - 64;
                    level1 = levels.replaceBrokenWall(level1, replaceX, replaceY); 

                    bombGuy.wallReplace(replaceX, replaceY); 
                    bombGuy.tick();
                    bombGuy.resetReplace(); 

                    yellowEnemy.wallReplace(replaceX, replaceY);
                    yellowEnemy.tick();
                    yellowEnemy.timerUndo();
                    yellowEnemy.resetReplace(); 

                    redEnemy.wallReplace(replaceX, replaceY);
                    redEnemy.tick();
                    redEnemy.timerUndo();
                    redEnemy.resetReplace(); 

                    bomb.updateMap(replaceX, replaceY);
                }
            
                if (this.bomb.getBrokenWallRight2() && !this.bomb.getBrokenWallRight1() && !resetLevel && !this.bomb.getBlockedRight()) {

                    int replaceX = bomb.getX() + 64;
                    int replaceY = bomb.getY() - 64;
                    level1 = levels.replaceBrokenWall(level1, replaceX, replaceY); 

                    bombGuy.wallReplace(replaceX, replaceY); 
                    bombGuy.tick();
                    bombGuy.resetReplace(); 

                    yellowEnemy.wallReplace(replaceX, replaceY);
                    yellowEnemy.tick();
                    yellowEnemy.timerUndo();
                    yellowEnemy.resetReplace(); 

                    redEnemy.wallReplace(replaceX, replaceY);
                    redEnemy.tick();
                    redEnemy.timerUndo();
                    redEnemy.resetReplace(); 

                    bomb.updateMap(replaceX, replaceY);
                }
            }


            if (!yellowEnemy.isRemoved()) {

                if (bombGuy.getX() == yellowEnemy.getX() && bombGuy.getY() == yellowEnemy.getY()) {

                    this.lives.loseLife();
                    levels.resetLevel1(level1);
                    this.time.timerReset();
                
                    bombGuy.gameReset();
                    yellowEnemy.gameReset();
                    redEnemy.gameReset();
                    this.bomb.detonate();
                    this.bomb.resetMap();
                
                    resetLevel = true;
                    this.bombMade = false;
                    this.explosionStart = false;
                    this.explosionTimer = 0;
                }
            }
 
            if (!redEnemy.isRemoved()) {

                if (bombGuy.getX() == redEnemy.getX() && bombGuy.getY() == redEnemy.getY()) {

                    this.lives.loseLife();
                    levels.resetLevel1(level1);
                
                    bombGuy.gameReset();
                    redEnemy.gameReset();
                    yellowEnemy.gameReset();
                    this.time.timerReset();
                    this.bomb.detonate();
                    this.bomb.resetMap();
                
                    resetLevel = true;
                    this.bombMade = false;
                    this.explosionStart = false;
                    this.explosionTimer = 0;
                }
            }


            if (this.lives.getNumberLives() == 0 || this.time.getTimeCount() == 0) {

                setLevel1 = false;
                gameOver = true;
            }
 
            else if (bombGuy.getX() == 416 && bombGuy.getY() == 400) {

                this.setLevel1 = false;
                this.setLevel2 = true;
                this.time.timerReset();
                this.lives.resetLives();
                this.bomb.detonate();

                this.bombGuy = new BombGuy(32, 240);
                this.bombGuy.resetSpriteTimer();
                this.bombGuy.nextLevel();
                this.explosionStart = false;
                this.explosionTimer = 0;
            }       
        }


        else if (!gameOver && setLevel2) {

            if (resetLevel) {

                this.bombGuy = new BombGuy(32, 240);

                this.bombGuy.nextLevel();

                this.resetLevel = false;
            }

            this.bombGuy.tick();
            this.bombGuy.spriteTick();

            if (this.bombMade && !this.bomb.isExploded()) {
                this.bomb.nextLevel();
                this.bomb.tick();

                this.bomb.spriteTick();
            }

            else if (this.bombMade && this.bomb.isExploded()) {

                this.explosionStart = true;
                this.bombMade = false;
            }
            

            if (explosionStart) {

                this.explosionTimer ++;
                
                if (this.explosionTimer > EXPLOSION_COUNTDOWN * App.FPS) {

                    this.explosionStart = false;
                    this.explosionTimer = 0;
                }
            }


            if ((bomb.isExploded() && bombMade) || explosionStart) {

                if (bomb.getY() - 16 == bombGuy.getY() && bomb.getX() == bombGuy.getX()) {

                    this.lives.loseLife();
                    levels.resetLevel2(level2);
                    this.time.timerReset();
                
                    bombGuy.gameReset();
                    this.bomb.detonate();
                    this.bomb.resetMap();
                
                    resetLevel = true;
                    this.bombMade = false;
                    this.explosionStart = false;
                    this.explosionTimer = 0;
                }


                if (!bomb.getBlockedLeft() && !resetLevel) {

                    if (bomb.getY() - 16 == bombGuy.getY() && (bomb.getX() - 32 == bombGuy.getX() || bomb.getX() - 64 == bombGuy.getX())) {

                        this.lives.loseLife();
                        levels.resetLevel2(level2);
                        this.time.timerReset();
                        this.bomb.resetMap();
                    
                        bombGuy.gameReset();
                        this.bomb.detonate();
                    
                        resetLevel = true;
                        this.bombMade = false;
                        this.explosionStart = false;
                        this.explosionTimer = 0;
                    }
                }

                if (!bomb.getBlockedRight() && !resetLevel) {
                    
                    if (bomb.getY() - 16 == bombGuy.getY() && (bomb.getX() + 32 == bombGuy.getX() || bomb.getX() + 64 == bombGuy.getX())) {

                        this.lives.loseLife();
                        levels.resetLevel2(level2);
                        this.time.timerReset();
                
                        bombGuy.gameReset();
                        this.bomb.detonate();
                        this.bomb.resetMap();
                
                        resetLevel = true;
                        this.bombMade = false;
                        this.explosionStart = false;
                        this.explosionTimer = 0;
                    }
                }

                if (this.bomb.getBrokenWallRight1() && !resetLevel) {

                    int replaceX = bomb.getX() + 32;
                    int replaceY = bomb.getY() - 64;
                    level2 = levels.replaceBrokenWall(level2, replaceX, replaceY); 

                    bombGuy.wallReplace(replaceX, replaceY); 
                    bombGuy.tick();
                    bombGuy.resetReplace(); 

                    bomb.updateMap(replaceX, replaceY);
                }

                if (this.bomb.getBrokenWallRight2() && !this.bomb.getBrokenWallRight1() && !resetLevel && !this.bomb.getBlockedRight()) {

                    int replaceX = bomb.getX() + 64;
                    int replaceY = bomb.getY() - 64;
                    level2 = levels.replaceBrokenWall(level2, replaceX, replaceY); 

                    bombGuy.wallReplace(replaceX, replaceY); 
                    bombGuy.tick();
                    bombGuy.resetReplace(); 

                    bomb.updateMap(replaceX, replaceY);
                }
            }

                    
            if (this.lives.getNumberLives() == 0 || this.time.getTimeCount() == 0) {
            
                setLevel2 = false;
                gameOver = true;
            }

            else if (bombGuy.getX() == 416 && bombGuy.getY() == 240) {

                this.setLevel2 = false;
                this.winGame = true;
            }
        }
    }

    /**
     * Returns true if a bomb is made and false if a bomb is not made
     * 
     * @return      the state of whether a bomb is made
     */

    public boolean getBombMade() {

        return this.bombMade;
    }


    /**
     * Returns true if the level has been reset, false otherwise
     * 
     * @return      the state of whether the level has been reset
     */


    public boolean getResetLevel() {

        return this.resetLevel;
    }

    /**
     * Returns true if the game is currently displaying level 1, false otherwise
     * 
     * @return      whether the game is currently in level 1
     */

    public boolean getSetLevel1() {

        return this.setLevel1;
    }

    /**
     * Returns true if the game is currently displaying level 2, false otherwise
     * 
     * @return      whether the game is currently in level 2
     */

    public boolean getSetLevel2() {

        return this.setLevel2;
    }
    
    /**
     * Returns true if the game over screen is shown, false otherwise
     * 
     * @return      whether the game over screen is shown
     */

    public boolean getGameOver() {

        return this.gameOver;
    }

    /**
     * Returns true if the win game screen is shown, false otherwise
     * 
     * @return      whether the win game screen is shown
     */

    public boolean getWinGame() {

        return this.winGame;
    }
   
    /**
     * Returns the DynamicMatrix object representing the levels
     * @return      the DynamicMatrix object storing all of the levels
     */
    
    public DynamicMatrix getLevels() {

        return this.levels;
    }
   
    /**
     * Returns the arraylist containing the first level
     * @return      the arraylist in which the first level is stored
     */

    public ArrayList<String> getFirstLevel() {

        return this.level1;
    }

    /**
     * Returns the arraylist containing the second level
     * @return      the arraylist in which the second level is stored
     */

    public ArrayList<String> getSecondLevel() {

        return this.level2;
    }

    /**
     * Returns the Clock object displayed on the map
     * 
     * @return      the clock object displayed on the map
     */

    public Clock getClock() {

        return this.clock;
    }

    /**
     * Returns the Player object displayed on the map
     * 
     * @return      the player object displayed on the map
     */

    public Player getPlayer() {

        return this.player;
    }

    /**
     * Returns the BombGuy object displayed on the map
     * 
     * @return      the bomb guy object displayed on the map
     */


    public BombGuy getBombGuy() {

        return this.bombGuy;
    }

    /**
     * Returns the YellowEnemy object displayed on the map
     * 
     * @return      the yellow enemy object displayed on the map
     */

    public YellowEnemy getYellowEnemy() {

        return this.yellowEnemy;
    }

    /**
     * Returns the RedEnemy object displayed on the map
     * 
     * @return      the red enemy object displayed on the map
     */

    public RedEnemy getRedEnemy() {

        return this.redEnemy;
    }

    /**
     * Returns the Lives object displayed on the map
     * 
     * @return      the lives object displayed on the map
     */

    public Lives getLives() {

        return this.lives;
    }

    /**
     * Returns the Time object displayed on the map
     * 
     * @return      the time object displayed on the map
     */

    public Time getTime() {

        return this.time;
    }

    /**
     * Returns the Bomb object displayed on the map
     * 
     * @return      the bomb object displayed on the map
     */

    public Bomb getBomb() {

        return this.bomb;
    }

    /**
     * Returns the Explosion object displayed on the map
     * 
     * @return      the explosion object displayed on the map
     */

    public Explosion getExplosion() {

        return this.explosion;
    }

    /**
     * Returns true if explosion has started, false otherwise
     * @return      whether explosion has started
     */

    public boolean getExplosionStart() {

        return this.explosionStart;
    }

    /**
     * Controls bomb guy's movements by attempting to move left
     */

    public void keyLeft() {

        this.bombGuy.pressLeft();
    }

    /**
     * Controls bomb guy's movements by attempting to move right
     */

    public void keyRight() {

        this.bombGuy.pressRight();
    }

    /**
     * Controls bomb guy's movements by attempting to move up
     */

    public void keyUp() {

        this.bombGuy.pressUp();
    }

    /**
     * Controls bomb guy's movements by attempting to move down
     */

    public void keyDown() {

        this.bombGuy.pressDown();
    }

    /**
     * Makes a bomb which is to be deployed
     */

    public void keySpace() {

        this.bombMade = true;
        this.lastXCoord = bombGuy.getX();
        this.lastYCoord = bombGuy.getY() + 16;
        this.bomb = new Bomb(lastXCoord, lastYCoord);
        this.explosion = new Explosion(lastXCoord, lastYCoord);
    }

    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void setSecondLevel() {

        this.setLevel1 = false;
        this.setLevel2 = true;
    }

    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void bombSetBrokenWallDown2() {

        this.bomb.setBrokenWallDown2();
    }

    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void bombSetBrokenWallUp2() {

        this.bomb.setBrokenWallUp2();
    }
    

    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void bombSetBrokenWallLeft2() {

        this.bomb.setBrokenWallLeft2();
    }


    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void bombSetBrokenWallRight2() {

        this.bomb.setBrokenWallRight2();
    }


    /**
     * ONLY USED FOR TESTING
     */

    //  ONLY USED FOR TESTING

    public void setBombGuy(BombGuy bombGuy) {

        this.bombGuy = bombGuy;
    }
}