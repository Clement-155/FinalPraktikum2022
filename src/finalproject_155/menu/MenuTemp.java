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
import javafx.stage.Stage;

/**
 *
 * @author Christopher Clement
 */
abstract class MenuTemp {
    Group root = new Group();
    Button rtr = new Button("Return");
    Scene scene;
    
    public void addScene (){
        BorderPane bp = new BorderPane();
        bp.setBottom(rtr);
        root.getChildren().add(bp);
        scene = new Scene(root);
    }
    
    public void addScene (double w, double h){
        BorderPane bp = new BorderPane();
        bp.setBottom(rtr);
        root.getChildren().add(bp);
        root.getChildren().get(0).setLayoutY(h-25);
        scene = new Scene(root, w, h);
    }
    
    public <P extends Pane> void addScene (P paneGroup){
        paneGroup.getChildren().add(rtr);
        root.getChildren().add(paneGroup);
        scene = new Scene(root);
    }
    
    public <P extends Pane> void addScene (P paneGroup, double w, double h){
        paneGroup.getChildren().add(rtr);
        root.getChildren().add(paneGroup);
        scene = new Scene(root, w, h);
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
