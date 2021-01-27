import level.Level;
import level.LevelGUI;
import level.Room;

import java.awt.*;

public class Driver {

   /**
    * initializes an object for each room and give them dimensions and a colour
    * initializes a playboard object
    * calls methods in playboard to place the rooms on the playBoard
    * calls methods to connect the rooms with each other
    * initializes the GUI object with argument playBoard and a name
    * @author Pontus Eriksson Jirbratt, ponjir-7
    */
   public static void run() {
      System.out.println("This is a print-out from the driver.");
      Room r1 = new Room(200, 50, Color.DARK_GRAY);
      Room r2 = new Room(80, 100, Color.CYAN);
      Room r3 = new Room(100, 100, Color.ORANGE);
      Room r4 = new Room(100, 100, Color.RED);
      Room r5 = new Room(100, 100, Color.MAGENTA);
      Room r6 = new Room(100, 100, Color.YELLOW);
      Room r7 = new Room(100, 100, Color.PINK);

      Level playBoard = new Level();

      playBoard.place(r1, 50, 200);
      playBoard.place(r2, 200, 500);
      playBoard.place(r3, 200, 300);
      playBoard.place(r4, 500, 180);
      playBoard.place(r5, 750, 500);
      playBoard.place(r6, 300, 500);
      playBoard.place(r7, 420, 400);
      playBoard.firstLocation(r4);

      r1.connectNorthTo(r2);
      r1.connectSouthTo(r3);
      r1.connectEastTo(r6);
      r1.connectWestTo(r2);

      r2.connectNorthTo(r3);
      r2.connectSouthTo(r1);
      r2.connectEastTo(r4);
      r2.connectWestTo(r3);

      r3.connectNorthTo(r2);
      r3.connectSouthTo(r1);
      r3.connectWestTo(r2);
      r3.connectEastTo(r4);

      r4.connectNorthTo(r2);
      r4.connectSouthTo(r5);
      r4.connectWestTo(r3);
      r4.connectEastTo(r7);

      r5.connectNorthTo(r1);
      r5.connectSouthTo(r2);

      r6.connectNorthTo(r4);
      r6.connectSouthTo(r1);

      r7.connectNorthTo(r5);


      LevelGUI gui = new LevelGUI(playBoard, "myFirstDungeon");
   }

}