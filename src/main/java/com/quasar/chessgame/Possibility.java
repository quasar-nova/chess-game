package com.quasar.chessgame;

public class Possibility {
	int x, y;
	boolean capture = false;
	
	public Possibility(int x, int y, boolean capture) {
		this.x = x;
		this.y = y;
		this.capture = capture;
	}
}
