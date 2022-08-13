package com.quasar.chessgame;

public class ChessGame {
    static final String VERSION = "1.0";
    
    private static void head() {
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
        }
        
        System.out.println();
    }
    
    private static void intro() {
        head();
        System.out.println("Chess Game v"+VERSION);
        head();
    }
    
    public static void main(String[] args) {
        intro();
        Window w = new Window();
        w.run();
    }
}
