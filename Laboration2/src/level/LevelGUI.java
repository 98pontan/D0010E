package level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.*;



import javax.swing.*;

/**
 * The GUI of the game, draws the level and rooms.
 * @author Pontus Eriksson Jirbratt, ponjir-7
 */

public class LevelGUI implements Observer {

   private Level lv;
   private Display d;
   final private int levelSizeX = 900;
   final private int levelSizeY = 700;
   private RoomToBeDrawn placedRooms[];

   /**
    * Creates a copy och level and an array of draw room objects the same size as the number of rooms
    * Initializes the JFrame and adds an observer.
    * @param level the playing field with all the rooms
    * @param name the name for the JFrame
    */
   public LevelGUI(Level level, String name) {

      this.lv = level;
      System.out.println("updated Level");
      //an array of the draw Room class  with the size of number of rooms.

      placedRooms = new RoomToBeDrawn[lv.placedRooms.size()];

      for(int i = 0; i < placedRooms.length; i++){
         placedRooms[i] = new RoomToBeDrawn(lv.placedRooms.get(i), i);
      }
      JFrame frame = new JFrame(name);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


      // depending on the size of the level
      d = new Display(lv, levelSizeX, levelSizeY);

      frame.getContentPane().add(d);
      frame.pack();
      frame.setLocation(0,0);
      frame.setVisible(true);


      lv.addObserver(this);
   }

   /**
    * each time change is set and observers is notified this method is called and repaints the GUI
    * @param arg0
    * @param arg1
    */
   public void update(Observable arg0, Object arg1) {
      d.repaint();
   }


   private class Display extends JPanel {


      public Display(Level fp, int x, int y) {
         addKeyListener(new Listener());
         setBackground(Color.GREEN);
         setPreferredSize(new Dimension(x+20,y+20));
         setFocusable(true);
      }


      /**
       * Use super on paintComponent to use opaque colors and be more free to make changes on the object
       * loops through the list of rooms to be drawn and calls drawRoom to draw them.
       * Draws the player as an gray circle in the current room.
       * @param g
       */
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         for(RoomToBeDrawn room : placedRooms){
            room.drawRoom(g);
         }
         g.setColor(Color.GRAY);
         g.drawOval(lv.currentRoom.posX, lv.currentRoom.posY, lv.currentRoom.dx, lv.currentRoom.dy);
         //room.posX, room.posY, room.dx, room.dy
      }

      /**
       * listens to the keyboard and takes input from the user
       */

      private class Listener implements KeyListener {

         /**
          * if the arrow keys are used it will call changeRoom in level to make the player change room to the direction of the pressed key
          * @param arg0
          */
         public void keyPressed(KeyEvent arg0) {
            int key = arg0.getKeyCode();

            // Left = West = 2
            if(key == KeyEvent.VK_LEFT){
               lv.changeRoom(2);
            }
            //Up = North = 0
            else if(key == KeyEvent.VK_UP){
               lv.changeRoom(0);

            }
            //Right = East = 3
            else if(key == KeyEvent.VK_RIGHT){
               lv.changeRoom(3);
            }
            //Down = South = 1
            else if(key == KeyEvent.VK_DOWN){
               lv.changeRoom(1);
            }

         }

         public void keyReleased(KeyEvent arg0) {
         }

         public void keyTyped(KeyEvent event) {
         }


      }

   }

   /**
    *  Draws the room, the doors, paths and numbers.
    */
   public class RoomToBeDrawn{
      JLabel[] doorNumbers;
      private Rectangle doors[];
      private Room room;
      private String number;

      /**
       * constructor of the class inizites the variabels, takes in the room object as an argument and the index of which room it is.
       * if there is a connection a wall then a door will be created, a number of the door will be assigned aswell as the location and font.
       * @param r
       * @param i
       */
      RoomToBeDrawn(Room r, int i){
         number = String.valueOf(i+1);
         doorNumbers = new JLabel[4];
         doors = new Rectangle[4];
         room = r;


         if (room.northWall != null){
            doors[0] = new Rectangle(room.posX+room.dx/2-5, room.posY, 12, 12);
            doorNumbers[0] = new JLabel(String.valueOf(lv.placedRooms.indexOf(room.northWall)+1));
            doorNumbers[0].setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            doorNumbers[0].setLocation(doors[0].x + doors[0].width/2, doors[0].y + doors[0].height/2);
         }

         if(room.southWall != null){
            doors[1] = new Rectangle(room.posX+room.dx/2-5, room.posY+room.dy-13, 12, 12);
            doorNumbers[1] = new JLabel(String.valueOf(lv.placedRooms.indexOf(room.southWall)+1));
            doorNumbers[1].setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            doorNumbers[1].setLocation(doors[1].x + doors[1].width/2, doors[1].y + doors[1].height/2);

         }

         if(room.eastWall != null){
            doors[2] = new Rectangle(room.posX+room.dx-13, room.posY+room.dy/2-5, 12, 12 );
            doorNumbers[2] = new JLabel(String.valueOf(lv.placedRooms.indexOf(room.eastWall)+1));
            doorNumbers[2].setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            doorNumbers[2].setLocation(doors[2].x + doors[2].width/2-2, doors[2].y + doors[2].height/2+4);
         }

         if (room.westWall != null){
            doors[3] = new Rectangle(room.posX+room.dx/16, room.posY+room.dy/2-5, 12, 12 );
            doorNumbers[3] = new JLabel(String.valueOf(lv.placedRooms.indexOf(room.westWall)+1));
            doorNumbers[3].setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            doorNumbers[3].setLocation(doors[3].x + doors[3].width/2, doors[3].y + doors[3].height/2);
         }

      }

      /**
       * Draws the rooms and looks for if its a one direction or both direction paths
       * @param g
       */
      void drawRoom(Graphics g){
         g.setColor(room.colorRoom);
         g.fillRect(room.posX, room.posY, room.dx, room.dy);

         for(int i = 0; i< doors.length; i++){
            if (doors[i] == null){
               continue;
            }
            boolean oneDirection = true;

            switch (i){
               case 0:
                  g.setColor(room.northWall.colorRoom);
                  for (Room r : room.northWall.connections){
                     if (r == room) {
                        oneDirection = false;
                        break;
                     }
                  }
                  break;

               case 1:
                  g.setColor(room.southWall.colorRoom);
                  for (Room r : room.southWall.connections){
                     if (r == room) {
                        oneDirection = false;
                        break;
                     }
                  }
                  break;
               case 2:
                  g.setColor(room.eastWall.colorRoom);
                  for (Room r : room.eastWall.connections){
                     if (r == room) {
                        oneDirection = false;
                        break;
                     }
                  }
                  break;
               case 3:
                  g.setColor(room.westWall.colorRoom);
                  for (Room r : room.westWall.connections){
                     if (r == room) {
                        oneDirection = false;
                        break;
                     }
                  }
                  break;
            }
            g.fillRect(doors[i].x, doors[i].y, doors[i].width, doors[i].height);
            g.setColor(Color.WHITE);
            g.drawRect(doors[i].x, doors[i].y, doors[i].width, doors[i].height);

            if(oneDirection){
               g.setColor(Color.PINK);
               g.drawRect(doors[i].x, doors[i].y , doors[i].width/10, doors[i].height);

            }
            else {
               g.setColor(Color.BLUE);
               g.drawRect(doors[i].x, doors[i].y, doors[i].width/10, doors[i].height);
               g.drawRect(doors[i].x + doors[i].width, doors[i].y, doors[i].width/10, doors[i].height);


            }
            drawNumbersAndPaths(g);
         }

      }

      /**
       * Draws the door numbers aswell as the paths
       * @param g
       */
      void drawNumbersAndPaths(Graphics g){
         Font comicSans;
         FontMetrics fontMetrics;

         comicSans = new Font("Comic Sans MS",Font.PLAIN,20);
         g.setFont(comicSans);
         fontMetrics = g.getFontMetrics();
         g.setColor(Color.BLACK);
         g.drawString(number,room.posX+room.dx/2-fontMetrics.stringWidth(number)/2, room.posY+(room.dy/2)+(fontMetrics.getHeight()/2)-8);


         g.setColor(Color.WHITE);
         comicSans = new Font("Comic Sans MS", Font.PLAIN,8);
         g.setFont(comicSans);

         for(int i=0;i<doorNumbers.length;i++){
            if (doorNumbers[i] == null){
               continue;
            }
            g.drawString(doorNumbers[i].getText(), doorNumbers[i].getX()-1, doorNumbers[i].getY()+1);
         }

         if (room.northWall != null){
            g.setColor(Color.black);
            g.drawLine(room.posX + room.dx/2, room.posY, room.northWall.posX + room.northWall.dx/2, room.northWall.posY);
         }

         if (room.southWall != null){
            g.setColor(Color.yellow);
            g.drawLine(room.posX + room.dx/2, room.posY + room.dy, room.southWall.posX + room.southWall.dx/2, room.southWall.posY + room.southWall.dy);
         }

         if (room.westWall != null){
            g.setColor(Color.pink);
            g.drawLine(room.posX, room.posY + room.dy/2, room.westWall.posX, room.westWall.posY + room.westWall.dy/2);
         }

         if (room.eastWall != null){
            g.setColor(Color.cyan);
            g.drawLine(room.posX + room.dx, room.posY + room.dy/2, room.eastWall.posX + (room.eastWall.dx), room.eastWall.posY + room.eastWall.dy/2);
         }

      }
   }
}