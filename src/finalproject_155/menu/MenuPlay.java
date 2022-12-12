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
import java.util.List;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;

/**
 *
 * @author Christopher Clement
 */
public class MenuPlay extends MenuTemp {
    
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
        
        final SwingNode spaceInvaders = new SwingNode();
        var ex = new SpaceInvaders();
        game(spaceInvaders, ex);
        
        this.addScene(GlobalVars.WIN_WIDTH, GlobalVars.WIN_HEIGHT);
        
        BorderPane temp = (BorderPane) root.getChildren().get(0);
        temp.setCenter(spaceInvaders);
        
        this.initScore();
        
        rtr.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ex.dispose();
                stage.setScene(back);
                stage.centerOnScreen();
            }
            
        });
            

        
        return scene;
        
    }
    
        public static void game(final SwingNode swingnode, final SpaceInvaders ex) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                
                ex.setVisible(true);
            }
        });
    }
    
}
