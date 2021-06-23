package com.cp;

import java.util.Scanner;

/**
 * Init Game Of Life Application
 * This class starts the game of life.
 */
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Initialize GameOfLife
        GameOfLife gameOfLife = new GameOfLife();
        try {
            //Start Game Of Life With Initial Data For 25x25 cell universe.
            //initializeLifeInUniverse Method will initialize matrix with default 0.
            gameOfLife.initializeLifeInUniverse(25, 25);
            //Glider Pattern: The glider is a pattern from the Game of Life that moves in diagonally at each step
            int[][] gliderPattern = {{0,1,0}, {0,0,1},{1,1,1}};
            gameOfLife.initializeGlider(gliderPattern);
            //After each step. game of life which moves diagonally.
            while(true){
                System.out.println("Do you want to proceed with next step of life in universe? \n 1. Press enter to continue or \n 2. Type 'exit' to stop \n");
                String readInput = scanner.nextLine();
                if(readInput.equalsIgnoreCase("exit")){
                    System.out.println("Game Of Life Stopped...");
                    break;
                }
                gameOfLife.step();
            }
        }catch (IllegalArgumentException e){
            System.out.println("Game Of Life Failed: " + e.getMessage());
        }
    }
}
