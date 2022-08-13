package com.quasar.chessgame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Window extends Application {
	static Board board = new Board();
    static Square[][] squares = board.getSquares();
    
    public String title = "Window";
    final static int BZ = 80;
    public static final int PZ = BZ;
    public static final int offset = 10;
    	
    public Window() {}
    
    @Override
    public void start(Stage primaryStage) throws Exception { // TODO: Fix `Exception`
        Group root = new Group();
        Rectangle mainRect = new Rectangle(0, 0, 8*BZ+Window.offset, 8*BZ+Window.offset);
        mainRect.setWidth(8*BZ);
        mainRect.setHeight(8*BZ);
        
        for (int y = 0; y < 8; y++) {
        	for (int x = 0; x < 8; x++) {
    			root.getChildren().add(squares[y][x].rect);
    			root.getChildren().add(squares[y][x].iv);
        	}
        }
        
        Button button = new Button();
        button.setLayoutX(BZ*8+25);
        button.setLayoutY(BZ*8);
        button.setText("Test");
        root.getChildren().add(button);
    
        Scene scene = new Scene(root, 8*BZ+2*Window.offset, 8*BZ+Window.offset);
        primaryStage.setScene(scene);
        
        primaryStage.setTitle(title);
        primaryStage.show();
    }
    
    public void run() {
        launch();
    }
}
