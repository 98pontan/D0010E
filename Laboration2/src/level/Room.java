package level;

import java.awt.Color;
/**
 * A room on the level, have varibles for position x, y and size x, y. Keeps track of where it is connected to other rooms.
 *  the program use this class to create a new Room object for each room.
 * @author Pontus Eriksson Jirbratt, ponjir-7
 */
public class Room {
   public int dx;
   public int dy;
   public int posX;
   public int posY;
   public Color colorRoom;
   public Room[] connections;

   private boolean placedRoom = false;

   public Room northWall = null;
   public Room eastWall = null;
   public Room southWall = null;
   public Room westWall = null;

   public Room(int dx, int dy, Color color) {
      this.dx = dx;
      this.dy = dy;
      colorRoom = color;
      System.out.println("Rooms");
      connections = new Room[4];
   }

   public void connectNorthTo(Room r) {
      if (!placedRoom  || !r.placedRoom){
         return;
      }
      if(r == this){
         return;
      }

      northWall = r;
      connections[0] = r;
   }

   public void connectEastTo(Room r) {
      if (!placedRoom  || !r.placedRoom){
         return;
      }
      if(r == this){
         return;
      }
      eastWall = r;
      connections[1] = r;

   }

   public void connectSouthTo(Room r) {
      if (!placedRoom  || !r.placedRoom){
         return;
      }
      if(r == this){
         return;
      }
      southWall = r;
      connections[2] = r;
   }

   public void connectWestTo(Room r) {
      if (!placedRoom  || !r.placedRoom){
         return;
      }
      if(r == this){
         return;
      }
      westWall = r;
      connections[3] = r;
   }

   public void flagPlaced(){
      placedRoom = true;
   }

}