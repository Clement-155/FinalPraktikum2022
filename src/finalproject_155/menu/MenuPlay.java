/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject_155.menu;

import com.zetcode.*;


        
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;

/**
 *
 * @author Christopher Clement
 */
public class MenuPlay extends MenuTemp implements SwingApp<SpaceInvaders> {
    
    int score = -1;
    ArrayList<Entry> scores = new ArrayList<Entry>();
   
    private void initScore(){
        String line = "";
        String input[];
        Path path = Paths.get("HighScore.txt");

        try{
            BufferedReader fileInput = Files.newBufferedReader(path);
            line = fileInput.readLine();
            while (line != null) {
                input = line.split("-");
                scores.add(new Entry(input[0], Integer.valueOf(input[1])));
                line = fileInput.readLine();
            }
        }catch(IOException io){
            System.out.println("HighScore.txt File location error!!");
            System.exit(1);
        }
        Collections.sort(scores, Entry.COMPARE_BY_SCORE);
        System.out.println("After Sorting: ");
        for (Entry en : scores){
            System.out.println(en.getName() + " : " + en.getScore());
        }
    }
        
    @Override
    public Scene create(Stage stage, Scene back){
        
        final var ex = new SpaceInvaders(this.score);
        
        gameRun(ex);
       
        BorderPane bp = new BorderPane();
        this.addScene(bp, GlobalVars.WIN_WIDTH, GlobalVars.WIN_HEIGHT, "SpaceInvaders");
        
        this.initScore();
        
        rtr.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                gameClose(ex);
                if(score > 0){
                    System.out.println(score);
                }
                stage.setScene(back);
                stage.centerOnScreen();
            }
            
        });
            

        
        return scene;
        
    }
    
    @Override
    public void gameRun(final SpaceInvaders ex) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                
                ex.setVisible(true);
            }
        });
    }
        
    @Override
    public void gameClose(final SpaceInvaders ex) {

        ex.dispose();
        
    }
    
}
