/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject_155.game;
import finalproject_155.menu.GlobalVars;
import java.awt.event.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 *
 * @author Christopher Clement
 */
public class Player extends Sprite{
    private double width;
    private int hitPoint = GlobalVars.PLAYER_HP;
    
    public Player() {

        initPlayer();
    }
    
    private void initPlayer() {

        Image image = new Image(getClass().getResource(GlobalVars.PLAYER_SPRITE).toString());
        
        setImage(image);
        ImageView imageView = new ImageView(image);
        width = image.getWidth();
        
        double START_Y = ((double)GlobalVars.WIN_HEIGHT)/2;
        setY(START_Y);

        double START_X = ((double)GlobalVars.WIN_WIDTH)/2;
        setX(START_X);
    }
    
    public void damaged(){
        this.hitPoint -= 1;
    }
    
    public void act() {

        x += dx;

        if (x <= 2) {

            x = 2;
        }

        if (x >= (double) GlobalVars.WIN_WIDTH - 2.0 * width) {

            x = ((double) GlobalVars.WIN_WIDTH) - 2.0 * width;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
    }
}
