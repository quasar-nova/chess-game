package com.quasar.chessgame;

import java.util.ArrayList;
import java.util.List;

public class Possibilities {
	public static List<Possibility> possible(int x, int y, Square[][] squares) {
		Pieces p = squares[y][x].piece;
		switch(p) {
		case bishop:
			break;
		case king:
			break;
		case knight:
			break;
		case none:
			break;
		case pawn:
			return possiblePawn(x, y, squares);
		case queen:
			break;
		case rook:
			break;
		default:
			break;
		}
		
		return null;
	}
		
	private static List<Possibility> possiblePawn(int x, int y, Square[][] squares) {
		List<Possibility> ret = new ArrayList<>();
		
		Colors self = squares[y][x].color;
		Colors left = null, right = null;
		
		if (self == Colors.white) {
			left = x > 0 && y < 7 ? squares[y+1][x-1].color : Colors.invalid;
			right = x < 7 && y < 7 ? squares[y+1][x+1].color : Colors.invalid;
		} else {
			
		}
		
		/* Capture */
		if (y == 7) {
			// TODO: Pawn Promotion
		} else {
			if (left != Colors.invalid && left != self && left != Colors.none) {
				ret.add(new Possibility(x-1, y+1, true));
			}
			
			if (right != Colors.invalid && right != self && right != Colors.none) {
				ret.add(new Possibility(x+1, y+1, true));
			}
		}
		
		
		/* Move */
		Colors front = y < 7 ? squares[y+1][x].color : Colors.invalid;
		if (front == Colors.none) {
			ret.add(new Possibility(x, y+1, false));
		}
		
		
		return null;
	}	
}