package com.cp;

/**
 * Author: Sridhar Duraisamy
 * Class which implement Game Of Life Simulation
 *
 * Definition
 * The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of
 * which is in one of two possible states, alive or dead. Every cell interacts with its eight neighbors, which
 * are the cells that are horizontally, vertically, or diagonally adjacent.
 *
 * Rules
 * At each step in time, the following transitions occur:
 * 1. Any live cell with fewer than two live neighbors dies as if caused by underpopulation.
 * 2. Any live cell with two or three live neighbors lives on to the next generation.
 * 3. Any live cell with more than three live neighbors dies, as if by overcrowding.
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The initial pattern constitutes the seed of the system. The first generation is created by applying the
 * above rules simultaneously to every cell in the seed—births and deaths occur simultaneously, and the
 * discrete moment at which this happens is sometimes called a tick (in other words, each generation is a
 * pure function of the preceding one). The rules continue to be applied repeatedly to create further
 * generations.
 */
public class GameOfLife{
    // Two Dimensional Array Which Holds Initial State
    private int[][] lifeInUniverse;
    // Row Size
    private int rowCount;
    //Column Size
    private int colCount;
    //Step in time
    private static int stepCount;


    /**
     * Method to initialize lifeInUniverse with given row and column count.
     * If row or column is not valid index, then throw illegal argument exception.
     * With valid row and column count, method should initialize Two Dimensional Array
     * and assign random seed to the lifeInUniverse and print it.
     * @param row - initial row count of the lifeInUniverse
     * @param col - initial column count of the lifeInUniverse
     * @throws IllegalArgumentException - Throw error if row or column is invalid
     */
    public void initializeLifeInUniverse(int row, int col) throws IllegalArgumentException{
        if(row <= 0 || col <= 0){
            throw new IllegalArgumentException("Invalid row/column to initialize life in universe.");
        }
        this.rowCount = row;
        this.colCount = col;
        lifeInUniverse = new int[rowCount][colCount];
        for(int i = 0; i < rowCount ; i++){
            for(int j = 0; j < colCount; j++){
                lifeInUniverse[i][j] = (int)Math.round( Math.random());
            }
        }
        System.out.println("Original State Of Life In Universe");
        printLifeInUniverse();
    }

    /**
     * Method to display next step of life In Universe.
     */
    public void step(){
        int[][] newLifeInUniverse = new int[rowCount][colCount];
        for(int i = 0; i < rowCount ; i++){
            for(int j = 0; j < colCount; j++){
                if(isAliveByRules(i, j)){
                    newLifeInUniverse[i][j] = 1;
                }
            }
        }
        stepCount++;
        lifeInUniverse = newLifeInUniverse;
        printLifeInUniverse();
    }

    /**
     * Method to determine if cell live or not on next state.
     * Following rules must be applied to each cell current state to determine cell's next state
     * 1. Any live cell with fewer than two live neighbors dies as if caused by underpopulation.
     * 2. Any live cell with two or three live neighbors lives on to the next generation.
     * 3. Any live cell with more than three live neighbors dies, as if by overcrowding.
     * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     * @param rowIndex - current cell row position
     * @param colIndex - current cell column position
     * @return if cell is alive or not in next state
     */
    private boolean isAliveByRules(int rowIndex, int colIndex){
        int liveCount = getLiveCellCount(rowIndex, colIndex);
        if(lifeInUniverse[rowIndex][colIndex] == 1 && liveCount < 2){
            return false;
        }else if(lifeInUniverse[rowIndex][colIndex] == 1 && (liveCount == 2 || liveCount == 3)){
            return true;
        }else if(lifeInUniverse[rowIndex][colIndex] == 1 && liveCount > 3){
            return false;
        }
        return lifeInUniverse[rowIndex][colIndex] == 0 && liveCount == 3;
    }

    /**
     * Get live neighbor cell count(Live cells of all neighbors) for the current cell
     * @param rowIndex - current cell row position
     * @param colIndex - current cell column position
     * @return - live neighbor cell count
     */
    private int getLiveCellCount(int rowIndex, int colIndex){
        int liveCounts = 0;
        for(int i = rowIndex -1; i<= rowIndex+1; i++){
            for(int j = colIndex-1; j<= colIndex+1; j++) {
                if (i < 0 || i >= rowCount || j < 0 || j >= colCount || (i == rowIndex && j == colIndex)) {
                    continue;
                }
                liveCounts = liveCounts + lifeInUniverse[i][j];
            }
        }
       return liveCounts;
    }

    /**
     * Print state of life In Universe
     */
    public void printLifeInUniverse() {
        System.out.println("Life In Universe On Step: " + stepCount);
        for (int[] row : lifeInUniverse) {
            for (int col : row) {
                System.out.print(col);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
