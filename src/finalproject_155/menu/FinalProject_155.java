/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject_155.menu;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Clement
 */
public class FinalProject_155 extends Application {


    @Override
    public void start(Stage primaryStage) {
        
        //Inisialisasi scene utama
        Button play = new Button("Play");
        Button highScr = new Button("High Scores");
        Button exit = new Button("Exit");
        
        

        
        VBox buttons = new VBox(play, highScr, exit);
        BorderPane root = new BorderPane();
        root.setCenter(buttons);
        buttons.setAlignment(Pos.CENTER);
        Scene mainScene = new Scene(root, GlobalVars.WIN_WIDTH, GlobalVars.WIN_HEIGHT);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Deflect");
        primaryStage.centerOnScreen();
        primaryStage.show();
        primaryStage.setResizable(false);

        
        //Fungsi button
        play.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                MenuPlay play = new MenuPlay();
                primaryStage.setScene(play.create(primaryStage, mainScene));
                primaryStage.centerOnScreen();
            }
            
        });
        highScr.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                MenuHighScr highScore = new MenuHighScr();
                primaryStage.setScene(highScore.create(primaryStage, mainScene));
                primaryStage.centerOnScreen();
            }
            
        });
        exit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                System.exit(0);
                
            }
            
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }//end method main
    
}
