/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject_155.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Clement
 */
abstract class MenuTemp {

    private Text title;
    Button rtr = new Button("Return");
    Scene scene;
    
    
    public <P extends Pane> void addScene (P paneGroup, String title){
        this.title = new Text(title);
        if(paneGroup instanceof BorderPane){
            BorderPane bp = (BorderPane) paneGroup;
            bp.setBottom(rtr);
            bp.setTop(this.title);
            scene = new Scene(bp);
        }
        else{
            paneGroup.getChildren().addAll(rtr, this.title);
            scene = new Scene(paneGroup);
        }
        
    }
    
    public <P extends Pane> void addScene (P paneGroup, double w, double h, String title){
        this.title = new Text(title);
        if(paneGroup instanceof BorderPane){
            BorderPane bp = (BorderPane) paneGroup;
            bp.setBottom(rtr);
            bp.setTop(this.title);
            scene = new Scene(bp, w, h);
        }
        else{
            paneGroup.getChildren().addAll(rtr, this.title);
            scene = new Scene(paneGroup, w, h);
        }
    }
    
        /**
     * @return the title
     */
    public Text getTitle() {
        return title;
    }
    
    public Scene create(Stage stage, Scene back){

        

        rtr.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                stage.setScene(back);
                stage.centerOnScreen();
            }
            
        });
        return scene;
    }
    
}
