package com.quasar.chessgame;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Board {
    public static final Color Select = Color.YELLOW;
    public static final Color Black = Color.GREEN;
    public static final Color White = Color.WHITE;
    public static final Color Possible = Color.TEAL;
    public static int xSel = -1, ySel = -1;  // TODO: Handle this in a different way.
    boolean possibleMode = false;
        
    Square[][] squares = new Square[8][8];
    
    public Board() {
    	initialPos();
    }
    
    public void initialPos() {
    	for (int x = 0; x < 8; x++) {
    		squares[1][x] = new Square(x, 1, Pieces.pawn, Colors.black);
    		squares[6][x] = new Square(x, 6, Pieces.pawn, Colors.white);
    	}
    	
    	for (int y = 2; y <= 5; y++) {
    		for (int x = 0; x < 8; x++) {
    			squares[y][x] = new Square(x, y, Pieces.none, Colors.none);
    		}
    	}
    	
    	
    	squares[0][0] = new Square(0, 0, Pieces.rook, Colors.black);
    	squares[0][7] = new Square(7, 0, Pieces.rook, Colors.black);
    	squares[7][0] = new Square(0, 7, Pieces.rook, Colors.white);
    	squares[7][7] = new Square(7, 7, Pieces.rook, Colors.white);
    	
    	squares[0][2] = new Square(2, 0, Pieces.bishop, Colors.black);
    	squares[0][5] = new Square(5, 0, Pieces.bishop, Colors.black);
    	squares[7][2] = new Square(2, 7, Pieces.bishop, Colors.white);
    	squares[7][5] = new Square(5, 7, Pieces.bishop, Colors.white);
    	
    	squares[0][1] = new Square(1, 0, Pieces.knight, Colors.black);
    	squares[0][6] = new Square(6, 0, Pieces.knight, Colors.black);
    	squares[7][1] = new Square(1, 7, Pieces.knight, Colors.white);
    	squares[7][6] = new Square(6, 7, Pieces.knight, Colors.white);
    
    	squares[0][3] = new Square(3, 0, Pieces.queen, Colors.black);
    	squares[0][4] = new Square(4, 0, Pieces.king, Colors.black);
    	squares[7][3] = new Square(3, 7, Pieces.queen, Colors.white);
    	squares[7][4] = new Square(4, 7, Pieces.king, Colors.white);
    	
    	
    	for (Square s1[]: squares) {
    		for (Square s: s1) {
    			s.rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent event) {
						s.rect.setFill(Select);
						if (xSel >= 0 || ySel >= 0) {
							squares[ySel][xSel].resetFill();
						}
						
						Board.xSel = s.xOff; Board.ySel = s.yOff;
					}
    			});
    			
    			s.iv.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent event) {
						s.rect.setFill(Select);
						if (xSel >= 0 || ySel >= 0) {
							squares[ySel][xSel].resetFill();
						}
						
						Board.xSel = s.xOff; Board.ySel = s.yOff;
					}
    			});	
    		}
    	}
    }
    
    public void updatePossibleMoves(int x, int y) {

    }
    
    public Square[][] getSquares() {
    	return squares;
    }
}
