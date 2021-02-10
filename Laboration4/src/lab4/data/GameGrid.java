package lab4.data;

import java.util.Observable;

/**
 * Represents the 2-d game grid
 */

public class GameGrid extends Observable{

   int[][] gameGrid; //might be private check later
   /**
    * Constructor
    *
    * @param size The width/height of the game grid
    */
   public GameGrid(int size){
      gameGrid = new int[size][size];
      for (int i = 0; i < gameGrid.length; i++) {
         for (int j = 0; j < gameGrid.length; j++){
            gameGrid[i][j] = 0;
         }
      }

   }

   /**
    * Reads a location of the grid
    *
    * @param x The x coordinate
    * @param y The y coordinate
    * @return the value of the specified location
    */
   public int getLocation(int x, int y){
      return 1;
   }

   /**
    * Returns the size of the grid
    *
    * @return the grid size
    */
   public int getSize(){return gameGrid.length;}

   /**
    * Enters a move in the game grid
    *
    * @param x the x position
    * @param y the y position
    * @param player
    * @return true if the insertion worked, false otherwise
    */
   public boolean move(int x, int y, int player)
   {
      if (player == 1)
         return false;

      else if(gameGrid[x][y] != 0)
         return false;

      return true;
   }

   /**
    * Clears the grid of pieces
    */
   public void clearGrid()
   {
      for (int i = 0; i < gameGrid.length; i++) {
         for (int j = 0; j < gameGrid.length; j++){
            gameGrid[i][j] = 0;
         }
      }
   }

   /**
    * Check if a player has 5 in row
    *
    * @param player the player to check for
    * @return true if player has 5 in row, false otherwise
    */
   public boolean isWinner(int player)
   {
         
   }


}