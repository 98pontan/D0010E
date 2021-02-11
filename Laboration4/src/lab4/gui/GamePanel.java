package lab4.gui;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import lab4.data.GameGrid;

/**
 * A panel providing a graphical view of the game board
 */

public class GamePanel extends JPanel implements Observer{

   private final int UNIT_SIZE = 20;
   private GameGrid grid;

   /**
    * The constructor
    *
    * @param grid The grid that is to be displayed
    */
   public GamePanel(GameGrid grid){
      this.grid = grid;
      grid.addObserver(this);
      Dimension d = new Dimension(grid.getSize()*UNIT_SIZE+1, grid.getSize()*UNIT_SIZE+1);
      this.setMinimumSize(d);
      this.setPreferredSize(d);
      this.setBackground(Color.WHITE);
   }

   /**
    * Returns a grid position given pixel coordinates
    * of the panel
    *
    * @param x the x coordinates
    * @param y the y coordinates
    * @return an integer array containing the [x, y] grid position
    */
   public int[] getGridPosition(int x, int y){
      int gridPos[];

      gridPos = new int[2];
      gridPos[0]= x / UNIT_SIZE;
      gridPos[1] = y / UNIT_SIZE;

      return gridPos;
   }

   public void update(Observable arg0, Object arg1) {
      this.repaint();
   }

   public void paintComponent(Graphics g){
      super.paintComponent(g);
      int row;
      int column;

      for (int i = 0; i < grid.getSize(); i++)
      {
         for (int j = 0; j < grid.getSize(); j++)
         {
            row = j * UNIT_SIZE;
            column = i * UNIT_SIZE;
            g.drawRect(row, column, UNIT_SIZE, UNIT_SIZE);
         }
      }

   }

}