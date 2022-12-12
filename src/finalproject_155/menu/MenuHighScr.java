/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject_155.menu;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Clement
 */
public class MenuHighScr extends MenuTemp {
            
    @Override
    public Scene create(Stage stage, Scene back){
        
        this.addScene();

        Text title = new Text("High Scores");
        TableView<Entry> tableView = new TableView<Entry>();
        
        BorderPane bp = (BorderPane) root.getChildren().get(0);
        
        bp.setTop(title);
        bp.setCenter(tableView);

        /*---------------------------------*/
        /*---------------------------------*/
        //Membuat dan membaca data highscore
        TableColumn<Entry, String> firstColumn = 
            new TableColumn<>("Name");
        firstColumn.setCellValueFactory(
            new PropertyValueFactory<>("Name"));

        TableColumn<Entry, Integer> lastColumn = 
            new TableColumn<>("Score");
        lastColumn.setCellValueFactory(
            new PropertyValueFactory<>("Score"));
        
        tableView.getColumns().add(firstColumn);
        tableView.getColumns().add(lastColumn);
        
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        lastColumn.setSortType(TableColumn.SortType.DESCENDING);
        tableView.getSortOrder().add(lastColumn);
        
        /*---------------------------------*/
        String line = "";
        String input[];
        Path path = Paths.get("HighScore.txt");

        try{
            BufferedReader fileInput = Files.newBufferedReader(path);
            line = fileInput.readLine();
            while (line != null) {
                input = line.split("-");
                tableView.getItems().add(new Entry(input[0], Integer.valueOf(input[1])));
                line = fileInput.readLine();
            }
            tableView.sort();
        }catch(IOException io){
            System.out.println("HighScore.txt File location error!!");
            System.exit(1);
        }
        
        /*---------------------------------*/
        /*---------------------------------*/

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
