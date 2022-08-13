package com.quasar.chessgame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Square {
	int xOff, yOff;
	Colors color;
	Pieces piece;
	String path;
	
	int x, y;
	
	/* JavaFX */
	Rectangle rect;
	ImageView iv;
	
	/* Events */

	
	public Square(int xOff, int yOff, Pieces p, Colors c) {
		this.piece = p;
		this.color = c;
		this.xOff = xOff;
		this.yOff = yOff;
		
		int BZ = Window.BZ;
		this.x = Window.offset+xOff*BZ;
		this.y = Window.offset+yOff*BZ;
		
		/* Rectangle */
		rect = new Rectangle();
		rect.setX(this.x);
		rect.setY(this.y);
		rect.setWidth(BZ);
		rect.setHeight(BZ);
		rect.setFill(Square.getColor(xOff, yOff));
		
		/* ImageView */
		iv = new ImageView();
		Image i;
		try {
			String path = Square.getPath(color, piece);
			if (path != null) {
				i = new Image(new FileInputStream(path));
				iv.setImage(i);
				iv.setX(this.x); iv.setY(this.y);
				
				iv.setFitWidth(Window.PZ);
				iv.setPreserveRatio(true);
			}
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public void resetFill() {
		rect.setFill(getColor(xOff, yOff));
	}
	
	public void update(Colors color, Pieces piece) {
		this.color = color;
		this.piece = piece;
	}
	
	public static String getPath(Colors color, Pieces piece) {
		String path = null;
		switch (piece) {
		case bishop:
			path = "Bishop.png";break;
		case king:
			path = "King.png";break;
		case knight:
			path = "Knight.png";break;
		case none:
			path = null; break;
		case pawn:
			path = "Pawn.png";break;
		case queen:
			path = "Queen.png";break;
		case rook:
			path = "Rook.png"; break;
		}
		
		if (color == Colors.black) {
			path = "assets/B-" + path;
		} else if (color == Colors.white) {
			path = "assets/W-" + path;
		}
		
		return path;
	}
	
	public static Paint getColor(int x, int y) {
		if (x % 2 == 0 && y % 2 == 0 || x % 2 != 0 && y % 2 != 0) {
			return Board.Black;
		} else {
			return Board.White;
		}
	}
}
