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
            //initializeLifeInUniverse Method will populate seed randomly with live or dead.
            gameOfLife.initializeLifeInUniverse(5, 5);
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
