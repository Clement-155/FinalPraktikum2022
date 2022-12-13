# FinalPraktikum2022

Nama  : Christopher Clement Wijaya

NRP   : 5025211155

Kelas : PBO B


Deskripsi
  Program ini adalah program yang dibuat untuk menambah fitur dari game SpaceInvaders dari zetcode.com.
  Fitur yang ditambah adalah UI menu utama, mencatat highscore, serta menjalankan game dari UI sehingga tidak perlu restart program.
  
  
Aplikasi Konsep PBO

  Casting/Conversion :
  
    MenuTemp.java, casting pada method "addScene".
    
       `...... 

        if(paneGroup instanceof BorderPane){
        
            BorderPane bp = (BorderPane) paneGroup;
            
            bp.setBottom(rtr);
            
        .......`
    
  Constructor :
  
    Entry.java
    
        `public Entry(String Name, Integer Score) {

            this.Name = Name;
            
            this.Score = Score;
            
        }`
  
  Overloading :
  
    MenuTemp.java, generics pada method "addScene".
    
     `public <P extends Pane> void addScene (P paneGroup, String title){
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
    }`
    

  Overriding :
  
    MenuPlay.java, overriding method "gameRun" dan "gameClose".
    
    `@Override
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
        
    }`
    
  Encapsulation :
  
    MenuTemp.java, encapsulation judul window.
    
    `private Text title;
    ...
    ...
    public Text getTitle() {
        return title;
    }`
    
    Dalam fungsi addScene
    
    `this.title = new Text(title);`
    
  Inheritance :
  
    Penggunaan MenuTemp.java pada MenuHighScr.java dan MenuPlay.java
    
    `public class MenuPlay extends MenuTemp implements SwingApp<SpaceInvaders>
    public class MenuHighScr extends MenuTemp`
    
  Polymorphism : Implementasi overloading dan overriding.
  
  ArrayList :
  
    MenuPlay.java, aplikasi menyimpan data highscore dalam ArrayList sebelum digunakan.
    
   `ArrayList<Entry> scores = new ArrayList<Entry>();`
    
  Exception Handling :
  
    MenuHighScr.java, mengatasi error IOException dalam membaca file.
    
        `try{
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
        }`
    
  GUI : Secara keseluruhan, aplikasi selain game SpaceInvaders menggunakan JavaFX
  
    Berikut contoh dari FinalProject_155.java
    
`public class FinalProject_155 extends Application {

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
    primaryStage.setTitle("Space Invaders");
    primaryStage.centerOnScreen();
    //primaryStage.initStyle(StageStyle.UNDECORATED);
    primaryStage.show();
    primaryStage.setResizable(false);


    //Fungsi button
    play.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            MenuPlay play = new MenuPlay();
            primaryStage.setScene(play.create(primaryStage, mainScene));
            primaryStage.setY(primaryStage.getY()+125);
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
}`
  
  Interface :
  
    SwingApp.java, interface untuk mengimplementasikan aplikasi yang menggunakan jawaswing.
    
`public interface SwingApp <S extends JFrame> {
    public void gameRun(final S ex);
    public void gameClose(final S ex);
}`
    
  Abstract Class :
  
    MenuTemp.java, abstract class untuk window-window.
    
    `abstract class MenuTemp {

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
    
}`
    
  Generics :
  
    MenuTemp.java, generics pada method "addScene".
        
    `public <P extends Pane> void addScene (P paneGroup, String title){
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
    }`
    
  Collection :
  
    MenuPlay.java, penggunaan ArrayList dan method static "sort".
    
    `ArrayList<Entry> scores = new ArrayList<Entry>();
    ...
    Collections.sort(scores, Entry.COMPARE_BY_SCORE);`
  
  Input Output : 
  
    Secara keseluruhan, aplikasi menerima input button
    MenuHighScr.java, aplikasi membaca input berupa data highscore dari file txt.
  
       `Path path = Paths.get("HighScore.txt");

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
        }`
  
  
Referensi

  https://zetcode.com/javagames/spaceinvaders/
  
  https://openjfx.io/javadoc/11/javafx.swing/javafx/embed/swing/SwingNode.html
  
  https://jenkov.com/tutorials/javafx/tableview.html
  
  https://stackoverflow.com/questions/43309483/can-i-create-various-scene-in-diffent-class-file-and-switch-between-them-in-java
