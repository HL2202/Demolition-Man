/**
 * App is the functional main class used to run the program
 * 
 * It integrates all of the other classes and methods into the construction of the game, which is loaded in the program to be played
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
import java.io.InputStream;
import java.io.ByteArrayInputStream;


public class App extends PApplet {


    public static final int WIDTH = 480;
    public static final int HEIGHT = 480;

    public static final int FPS = 60;

    private Wall wall;

    private int xTracker;

    private PFont font;

    private Runner runner;

    private Clock clock;

    private Player player;

    private YellowEnemy yellowEnemy;

    private RedEnemy redEnemy;

    private BombGuy bombGuy;

    private Lives lives;

    private Bomb bomb;

    private Time time;

    private DynamicMatrix levels;

    private EndScreen endScreen;

    private Explosion explosion;
    
    /**
    * 
    * Loads in the app by creating a new Runner class object, which is the key helper class used to run the program
    */

    public App() {

        this.xTracker = 0;
        this.runner = new Runner();
    }

    /**
     * Sets the width and height of the game screen
     */

    public void settings() {

        size(WIDTH, HEIGHT);
    }

    /**
     * Set up all of the objects appropriately in the game and load their sprites according to the image stored in folder
     */

    public void setup() {

        frameRate(FPS);

        this.clock = runner.getClock();
        this.player = runner.getPlayer();
        this.yellowEnemy = runner.getYellowEnemy();
        this.redEnemy = runner.getRedEnemy();
        this.bombGuy = runner.getBombGuy();
        this.lives = runner.getLives();
        //this.levels = runner.getLevels();
        this.levels = new DynamicMatrix("level1.txt");
           
        this.clock.setSprite(this.loadImage("src/main/resources/icons/clock.png"));
        player.setSprite(this.loadImage("src/main/resources/icons/player.png"));

        yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_down1.png"));
        redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_down1.png"));
        bombGuy.setSprite(this.loadImage("src/main/resources/player/player1.png"));

        this.font = lives.createFont(this, "src/main/resources/PressStart2P-Regular.ttf");
    }

    /**
     * Runs the program by calling the run() method from the runner class and drawing all of the objects according to the frame updates by the runner class
     */

    public void draw() {

        background(220, 120, 25);

        this.runner.run();

        this.clock = runner.getClock();
        this.player = runner.getPlayer();
        this.yellowEnemy = runner.getYellowEnemy();
        this.redEnemy = runner.getRedEnemy();
        this.bombGuy = runner.getBombGuy();
        this.lives = runner.getLives();
        this.bomb = runner.getBomb();
        this.time = runner.getTime();
        this.explosion = runner.getExplosion();

        if (!runner.getGameOver() && runner.getSetLevel1()) {
       
            int yTracker = 64;

            this.clock.draw(this);
            player.draw(this);

            this.textFont(createFont("src/main/resources/PressStart2P-Regular.ttf", 25), 25);
            lives.fill(this);
            lives.text(this);
            lives.textSize(this);

            time.tick();
            time.text(this);
            time.fill(this);
            time.textSize(this);

            ArrayList<String> level1 = runner.getFirstLevel();
            
            for (String row: level1) {

                for (int i = 0; i < row.length(); i ++) {
                
                    Character c = row.charAt(i);
                    String letter = c.toString();

                    if (letter.equals("W")) {

                        this.wall = new Wall(xTracker, yTracker);
                        this.wall.setSprite(this.loadImage("src/main/resources/wall/solid.png"));
                        this.wall.draw(this);
                    }

                    else if (letter.equals("B")) {

                        this.wall = new Wall(xTracker, yTracker);
                        this.wall.setSprite(this.loadImage("src/main/resources/broken/broken.png"));
                        this.wall.draw(this);
                    }

                    else if (letter.equals("G")) {

                        this.wall = new Wall(xTracker, yTracker);
                        this.wall.setSprite(this.loadImage("src/main/resources/goal/goal.png"));
                        this.wall.draw(this);
                    }

                    else {

                        this.wall = new Wall(xTracker, yTracker);
                        this.wall.setSprite(this.loadImage("src/main/resources/empty/empty.png"));
                        this.wall.draw(this);
                    }
                    xTracker += 32;
                }
                xTracker = 0;
                yTracker += 32;
            }

            
            if (bombGuy.getDownSprite1()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player1.png"));
            } 
        
            else if (bombGuy.getDownSprite2()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player2.png"));
            }

            else if (bombGuy.getDownSprite3()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player3.png"));
            }

            else if (bombGuy.getDownSprite4()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player4.png"));
            }

            else if (bombGuy.getRightSprite1()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_right1.png"));
            }

            else if (bombGuy.getRightSprite2()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_right2.png"));
            }

            else if (bombGuy.getRightSprite3()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_right3.png"));
            }

            else if (bombGuy.getRightSprite4()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_right4.png"));
            }

            else if (bombGuy.getUpSprite1()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_up1.png"));
            }

            else if (bombGuy.getUpSprite2()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_up2.png"));
            }

            else if (bombGuy.getUpSprite3()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_up3.png"));
            }

            else if (bombGuy.getUpSprite4()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_up4.png"));
            }

            else if (bombGuy.getLeftSprite1()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_left1.png"));
            }

            else if (bombGuy.getLeftSprite2()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_left2.png"));
            }

            else if (bombGuy.getLeftSprite3()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_left3.png"));
            }

            else if (bombGuy.getLeftSprite4()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_left4.png"));
            }


            if (yellowEnemy.getDownSprite1()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_down1.png"));
            }

            else if (yellowEnemy.getDownSprite2()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_down2.png"));
            }

            else if (yellowEnemy.getDownSprite3()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_down3.png"));
            }

            else if (yellowEnemy.getDownSprite4()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_down4.png"));
            }

            else if (yellowEnemy.getRightSprite1()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_right1.png"));
            }

            else if (yellowEnemy.getRightSprite2()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_right2.png"));
            }

            else if (yellowEnemy.getRightSprite3()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_right3.png"));
            }

            else if (yellowEnemy.getRightSprite4()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_right4.png"));
            }

            else if (yellowEnemy.getUpSprite1()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_up1.png"));
            }

            else if (yellowEnemy.getUpSprite2()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_up2.png"));
            }

            else if (yellowEnemy.getUpSprite3()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_up3.png"));
            }

            else if (yellowEnemy.getUpSprite4()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_up4.png"));
            }

            else if (yellowEnemy.getLeftSprite1()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_left1.png"));
            }

            else if (yellowEnemy.getLeftSprite2()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_left2.png"));
            }

            else if (yellowEnemy.getLeftSprite3()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_left3.png"));
            }

            else if (yellowEnemy.getLeftSprite4()) {
                yellowEnemy.setSprite(this.loadImage("src/main/resources/yellow_enemy/yellow_left4.png"));
            }


            if (redEnemy.getDownSprite1()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_down1.png"));
            }

            else if (redEnemy.getDownSprite2()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_down2.png"));
            }

            else if (redEnemy.getDownSprite3()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_down3.png"));
            }

            else if (redEnemy.getDownSprite4()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_down4.png"));
            }

            else if (redEnemy.getRightSprite1()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_right1.png"));
            }

            else if (redEnemy.getRightSprite2()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_right2.png"));
            }

            else if (redEnemy.getRightSprite3()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_right3.png"));
            }

            else if (redEnemy.getRightSprite4()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_right4.png"));
            }

            else if (redEnemy.getUpSprite1()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_up1.png"));
            }

            else if (redEnemy.getUpSprite2()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_up2.png"));
            }

            else if (redEnemy.getUpSprite3()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_up3.png"));
            }

            else if (redEnemy.getUpSprite4()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_up4.png"));
            }

            else if (redEnemy.getLeftSprite1()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_left1.png"));
            }

            else if (redEnemy.getLeftSprite2()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_left2.png"));
            }

            else if (redEnemy.getLeftSprite3()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_left3.png"));
            }

            else if (redEnemy.getLeftSprite4()) {
                redEnemy.setSprite(this.loadImage("src/main/resources/red_enemy/red_left4.png"));
            }


            bombGuy.draw(this);

            if (!yellowEnemy.isRemoved()) {

                yellowEnemy.draw(this);
            }

            if (!redEnemy.isRemoved()) {

                redEnemy.draw(this);
            }

            if (runner.getBombMade() && !bomb.isExploded()) {

                if (bomb.getBombSprite1()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb1.png"));
                }

                else if (bomb.getBombSprite2()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb2.png"));
                }

                else if (bomb.getBombSprite3()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb3.png"));
                }

                else if (bomb.getBombSprite4()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb4.png"));
                }

                else if (bomb.getBombSprite5()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb5.png"));
                }

                else if (bomb.getBombSprite6()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb6.png"));
                }

                else if (bomb.getBombSprite7()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb7.png"));
                }

                else if (bomb.getBombSprite8()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb8.png"));
                }

                bomb.draw(this);
            }

            if (runner.getExplosionStart()) {

                Explosion explosion1 = this.explosion;
                Explosion explosion2 = this.explosion;
                Explosion explosion3 = this.explosion;
                Explosion explosion4 = this.explosion;
                Explosion explosion5 = this.explosion;

                Explosion explosion6 = this.explosion;
                Explosion explosion7 = this.explosion;
                Explosion explosion8 = this.explosion;
                Explosion explosion9 = this.explosion;

                explosion1.setSprite(this.loadImage("src/main/resources/explosion/centre.png"));
                explosion1.draw(this, explosion.getX(), explosion.getY());

                if (!this.bomb.getBlockedRight()) {

                    explosion2.setSprite(this.loadImage("src/main/resources/explosion/horizontal.png"));
                    explosion2.draw(this, explosion.getX() + 32, explosion.getY());
                }

                if (!this.bomb.getBlockedLeft()) {

                    explosion3.setSprite(this.loadImage("src/main/resources/explosion/horizontal.png"));
                    explosion3.draw(this, explosion.getX() - 32, explosion.getY());
                }

                if (!this.bomb.getBlockedUp()) {

                    explosion4.setSprite(this.loadImage("src/main/resources/explosion/vertical.png"));
                    explosion4.draw(this, explosion.getX(), explosion.getY() - 32);
                }

                if (!this.bomb.getBlockedDown()) {

                    explosion5.setSprite(this.loadImage("src/main/resources/explosion/vertical.png"));
                    explosion5.draw(this, explosion.getX(), explosion.getY() + 32);
                }

                if (!this.bomb.getBlockedRight2() && !this.bomb.getBlockedRight()) {

                    explosion6.setSprite(this.loadImage("src/main/resources/explosion/horizontal.png"));
                    explosion6.draw(this, explosion.getX() + 64, explosion.getY());
                }

                if (!this.bomb.getBlockedLeft2() && !this.bomb.getBlockedLeft()) {

                    explosion7.setSprite(this.loadImage("src/main/resources/explosion/horizontal.png"));
                    explosion7.draw(this, explosion.getX() - 64, explosion.getY());
                }

                if (!this.bomb.getBlockedUp2() && !this.bomb.getBlockedUp()) {

                    explosion8.setSprite(this.loadImage("src/main/resources/explosion/vertical.png"));
                    explosion8.draw(this, explosion.getX(), explosion.getY() - 64);
                }

                if (!this.bomb.getBlockedDown2() && !this.bomb.getBlockedDown()) {

                    explosion9.setSprite(this.loadImage("src/main/resources/explosion/vertical.png"));
                    explosion9.draw(this, explosion.getX(), explosion.getY() + 64);
                }
            }
        }

        else if (!runner.getGameOver() && runner.getSetLevel2()) {

            this.bombGuy = runner.getBombGuy();

            int yTracker = 64;
            this.xTracker = 0;

            clock.draw(this);
            player.draw(this);
            
            this.textFont(createFont("src/main/resources/PressStart2P-Regular.ttf", 25), 25);
            lives.fill(this);
            lives.textSize(this);
            lives.text(this);

            time.tick();
            time.text(this);
            time.fill(this);
            time.textSize(this);

            ArrayList<String> level2 = runner.getSecondLevel();

            for (String row: level2) {

                for (int i = 0; i < row.length(); i ++) {
                
                    Character c = row.charAt(i);
                    String letter = c.toString();
                    
                    if (letter.equals("W")) {

                        this.wall = new Wall(xTracker, yTracker);
                        this.wall.setSprite(this.loadImage("src/main/resources/wall/solid.png"));
                        this.wall.draw(this);
                    }

                    else if (letter.equals("B")) {

                        this.wall = new Wall(xTracker, yTracker);
                        this.wall.setSprite(this.loadImage("src/main/resources/broken/broken.png"));
                        this.wall.draw(this);
                    }

                    else if (letter.equals("G")) {

                        this.wall = new Wall(xTracker, yTracker);
                        this.wall.setSprite(this.loadImage("src/main/resources/goal/goal.png"));
                        this.wall.draw(this);
                    }

                    else {

                        this.wall = new Wall(xTracker, yTracker);
                        this.wall.setSprite(this.loadImage("src/main/resources/empty/empty.png"));
                        this.wall.draw(this);
                    }
                    xTracker += 32;
                }
                xTracker = 0;
                yTracker += 32;
            }

            if (bombGuy.getDownSprite1()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player1.png"));
            } 
        
            else if (bombGuy.getDownSprite2()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player2.png"));
            }

            else if (bombGuy.getDownSprite3()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player3.png"));
            }

            else if (bombGuy.getDownSprite4()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player4.png"));
            }

            else if (bombGuy.getRightSprite1()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_right1.png"));
            }

            else if (bombGuy.getRightSprite2()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_right2.png"));
            }

            else if (bombGuy.getRightSprite3()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_right3.png"));
            }

            else if (bombGuy.getRightSprite4()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_right4.png"));
            }

            else if (bombGuy.getUpSprite1()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_up1.png"));
            }

            else if (bombGuy.getUpSprite2()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_up2.png"));
            }

            else if (bombGuy.getUpSprite3()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_up3.png"));
            }

            else if (bombGuy.getUpSprite4()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_up4.png"));
            }

            else if (bombGuy.getLeftSprite1()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_left1.png"));
            }

            else if (bombGuy.getLeftSprite2()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_left2.png"));
            }

            else if (bombGuy.getLeftSprite3()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_left3.png"));
            }

            else if (bombGuy.getLeftSprite4()) {
                bombGuy.setSprite(this.loadImage("src/main/resources/player/player_left4.png"));
            }
            
            this.bombGuy.draw(this);

            if (runner.getBombMade() && !bomb.isExploded()) {

                if (bomb.getBombSprite1()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb1.png"));
                }

                else if (bomb.getBombSprite2()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb2.png"));
                }

                else if (bomb.getBombSprite3()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb3.png"));
                }

                else if (bomb.getBombSprite4()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb4.png"));
                }

                else if (bomb.getBombSprite5()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb5.png"));
                }

                else if (bomb.getBombSprite6()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb6.png"));
                }

                else if (bomb.getBombSprite7()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb7.png"));
                }

                else if (bomb.getBombSprite8()) {
                    bomb.setSprite(this.loadImage("src/main/resources/bomb/bomb8.png"));
                }
                
                bomb.draw(this);
            }

            if (runner.getExplosionStart()) {

                Explosion explosion1 = this.explosion;
                Explosion explosion2 = this.explosion;
                Explosion explosion3 = this.explosion;
                Explosion explosion4 = this.explosion;
                Explosion explosion5 = this.explosion;

                Explosion explosion6 = this.explosion;
                Explosion explosion7 = this.explosion;
                Explosion explosion8 = this.explosion;
                Explosion explosion9 = this.explosion;

                explosion1.setSprite(this.loadImage("src/main/resources/explosion/centre.png"));
                explosion1.draw(this, explosion.getX(), explosion.getY());

                if (!this.bomb.getBlockedRight()) {

                    explosion2.setSprite(this.loadImage("src/main/resources/explosion/horizontal.png"));
                    explosion2.draw(this, explosion.getX() + 32, explosion.getY());
                }

                if (!this.bomb.getBlockedLeft()) {

                    explosion3.setSprite(this.loadImage("src/main/resources/explosion/horizontal.png"));
                    explosion3.draw(this, explosion.getX() - 32, explosion.getY());
                }

                if (!this.bomb.getBlockedUp()) {

                    explosion4.setSprite(this.loadImage("src/main/resources/explosion/vertical.png"));
                    explosion4.draw(this, explosion.getX(), explosion.getY() - 32);
                }

                if (!this.bomb.getBlockedDown()) {

                    explosion5.setSprite(this.loadImage("src/main/resources/explosion/vertical.png"));
                    explosion5.draw(this, explosion.getX(), explosion.getY() + 32);
                }

                if (!this.bomb.getBlockedRight2() && !this.bomb.getBlockedRight()) {

                    explosion6.setSprite(this.loadImage("src/main/resources/explosion/horizontal.png"));
                    explosion6.draw(this, explosion.getX() + 64, explosion.getY());
                }

                if (!this.bomb.getBlockedLeft2() && !this.bomb.getBlockedLeft()) {

                    explosion7.setSprite(this.loadImage("src/main/resources/explosion/horizontal.png"));
                    explosion7.draw(this, explosion.getX() - 64, explosion.getY());
                }

                if (!this.bomb.getBlockedUp2() && !this.bomb.getBlockedUp()) {

                    explosion8.setSprite(this.loadImage("src/main/resources/explosion/vertical.png"));
                    explosion8.draw(this, explosion.getX(), explosion.getY() - 64);
                }

                if (!this.bomb.getBlockedDown2() && !this.bomb.getBlockedDown()) {

                    explosion9.setSprite(this.loadImage("src/main/resources/explosion/vertical.png"));
                    explosion9.draw(this, explosion.getX(), explosion.getY() + 64);
                }
            }
        }

        else if (runner.getWinGame()) {

            this.endScreen = new EndScreen(165, 210, "YOU WIN");
            this.endScreen.text(this);
            this.endScreen.textFont(this.createFont("PressStart2P-Regular.ttf", 20), 20);
            this.endScreen.fill(this);
            this.endScreen.textSize(this);
        }

        else {

            this.endScreen = new EndScreen(150, 210, "GAME OVER");
            this.endScreen.text(this);
            this.endScreen.textFont(this.createFont("PressStart2P-Regular.ttf", 20), 20);
            this.endScreen.fill(this);
            this.endScreen.textSize(this);
        }
      
    }

    /**
     * Feeds a specific key value pressed by the user into the runner program to control the movements in the game
     */
    
    public void keyReleased() {

        if (this.keyCode == 37) {

            this.runner.keyLeft();
        } 
        
        else if (this.keyCode == 39) {

            this.runner.keyRight();
        }
        
        else if (this.keyCode == 38) {

            this.runner.keyUp();
        }
        
        else if (this.keyCode == 40) {

            this.runner.keyDown();
        }

        else if (this.keyCode == 32) {

            this.runner.keySpace();
        }
    }


    public static void main(String[] args) {

        PApplet.main("demolition.App");
    }
}