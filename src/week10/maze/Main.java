package week10.maze;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;

public class Main extends Application {

    private Timeline timeline;

    private Game game;
    private Tile[][] board;

    Rectangle marker;
    Group root;
    Group stackContents;
    int stackX = 470;
    int stackY = 330;

    private int gridSize;
    private int gridHeight;
    private int gridWidth;
    private int squareSize;

    public static void main(String[] args) {
        launch(args);
    }

    /** start() is the main entry point and must be overridden */
    @Override
    public void start(Stage primaryStage) throws Exception{

        gridSize = 7;
        gridHeight = 400;
        gridWidth  = 600;
        squareSize = (gridHeight-50)/gridSize;

        game = new Game(new Random(100), gridSize, gridSize*gridSize/4);
        board = game.getBoardState();

        marker = new Rectangle(squareSize+10,squareSize+10);
        marker.setX(5);
        marker.setY(5);
        marker.setFill(Color.web("000000", 0.7));

        root = new Group();
        Scene scene = new Scene(root, 600, 400, Color.web("FEFBFF"));


        Group squares = new Group();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Text text = new Text("");
                Rectangle r = new Rectangle(squareSize,squareSize);
                r.setStroke(Color.web("2A195C"));
                if (board[i][j].getType() == "obstacle")
                    r.setFill(Color.web("2A195C"));
                else {
                    text = new Text(board[i][j].name);
                    r.setFill(Color.WHITE);
                }
                r.setX(10+(squareSize+5)*j);
                text.setX(5+(squareSize/2)+(squareSize+5)*j);
                r.setY(10+(squareSize+5)*i);
                text.setY(14+(squareSize/2)+ (squareSize+5)*i);
                r.setArcWidth(10);
                r.setArcHeight(10);
                squares.getChildren().addAll(r,text);
            }
        }
        root.getChildren().add(squares);

        root.getChildren().add(marker);

        stackContents = new Group();
        Text originT = new Text("O");
        originT.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        originT.setX(stackX);
        originT.setY(stackY);
        stackContents.getChildren().add(originT);
        root.getChildren().add(stackContents);

        /** stage is the top level container, and here, ours is called primaryStage */
        primaryStage.setTitle("Hello World");


        Button btn1 = new Button("DFS");
        Button btn2 = new Button("BFS");
        btn1.setLayoutX(450);
        btn1.setLayoutY(350);
        btn2.setLayoutX(500);
        btn2.setLayoutY(350);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                runDFS(root);
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                runBFS(root);
            }
        });
        root.getChildren().addAll(btn1, btn2);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void runDFS(Group root){
        //System.out.println("In DFS");

        String status = game.DFS();
        Tile current = game.getMarker();

        if(game.getMarker() != null && status.equals("In progress") || status.equals("Found exit")) {
            //marker.setX(10 + (squareSize + 5) * current.getY());
            //marker.setY(10 + (squareSize + 5) * current.getX());
            Rectangle mark = new Rectangle(squareSize,squareSize);
            mark.setFill(Color.web("FF45C9",0.2));
            mark.setX(10 + (squareSize + 5) * current.getY());
            mark.setY(10 + (squareSize + 5) * current.getX());
            root.getChildren().add(mark);

            // Moving animation for the marker
            TranslateTransition transT = new TranslateTransition(Duration.millis(500),marker);
            transT.setToX( (0+(squareSize+5)*current.getY()) );
            transT.setToY((0 + (squareSize + 5) * current.getX()));
            transT.play();


            Node toRemove;
            if (!stackContents.getChildren().isEmpty()) {
                toRemove = stackContents.getChildren().get(stackContents.getChildren().size() - 1);

                TranslateTransition removeT = new TranslateTransition(Duration.millis(500),toRemove);
                removeT.setToX( toRemove.getLayoutX() + 300 );
                removeT.play();
                removeT.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle (ActionEvent event){
                        stackContents.getChildren().remove(toRemove);

                        Stack s = game.getStack();
                        ListIterator t = s.listIterator();
                        int offset = 0;
                        for(int i = 0; i < stackContents.getChildren().size(); i++){
                            t.next();
                            offset = offset+30;
                        };
                        while(t.hasNext()){
                            Text tt = new Text(t.next().toString());
                            tt.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
                            tt.setX(stackX);
                            tt.setY(stackY - offset);
                            offset = offset+30;
                            stackContents.getChildren().add(tt);
                        }
                    }
                });
            }

        }

       // root.getChildren().add(rect1);
    }

    public void runBFS(Group root){
        String status = game.BFS();
        Tile current = game.getMarker();

        if(game.getMarker() != null && status.equals("In progress") || status.equals("Found exit")) {
            //marker.setX(10 + (squareSize + 5) * current.getY());
            //marker.setY(10 + (squareSize + 5) * current.getX());
            Rectangle mark = new Rectangle(squareSize,squareSize);
            mark.setFill(Color.web("FF45C9",0.2));
            mark.setX(10 + (squareSize + 5) * current.getY());
            mark.setY(10 + (squareSize + 5) * current.getX());
            root.getChildren().add(mark);

            TranslateTransition transT = new TranslateTransition(Duration.millis(500),marker);
            transT.setToX( (0+(squareSize+5)*current.getY()) );
            transT.setToY( (0+(squareSize+5)*current.getX()) );
            transT.play();

            Node toRemove;
            if (!stackContents.getChildren().isEmpty()) {
                toRemove = stackContents.getChildren().get(0);

                TranslateTransition removeT = new TranslateTransition(Duration.millis(500),toRemove);
                removeT.setToX( toRemove.getLayoutX() + 300 );
                removeT.play();
                removeT.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle (ActionEvent event){
                        stackContents.getChildren().remove(toRemove);

                        Queue q = game.getQueue();
                        Iterator t = q.iterator();
                        int offset = 0;
                        /*
                        for(int i = 0; i < stackContents.getChildren().size(); i++){
                            t.next();
                            offset = offset+30;
                        };
                        */
                        stackContents.getChildren().clear();
                        while(t.hasNext()){
                            Text tt = new Text(t.next().toString());
                            tt.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
                            tt.setX(stackX);
                            tt.setY(stackY - offset);
                            offset = offset+30;
                            stackContents.getChildren().add(tt);
                        }
                    }
                });
            }
        }

    }

}
