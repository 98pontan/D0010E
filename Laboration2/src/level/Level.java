package level;

import java.util.ArrayList;
import java.util.Observable;
import java.awt.Rectangle;

/**
 * The level of the game board
 * Keeps track of the rooms and handles when the player changes room.
 *
 * @author Pontus Eriksson Jirbratt, ponjir-7
 */
public class Level extends Observable {

   public ArrayList<Room> placedRooms;
   private Room startRoom;
   public Room currentRoom;

   /**
    * looks at the positions of the rooms to make sure they dont collide and if they dont collide add them to an array of room objects.
    * @param r a room to be placed
    * @param x size of the room x dimension
    * @param y size of the room in y dimension
    * @return
    */
   public boolean place(Room r, int x, int y)  {
      Rectangle tempRec = new Rectangle(x, y, r.dx, r.dy);

      //Checks if there are no rooms.
      if(placedRooms==null){
         placedRooms = new ArrayList<Room>();
      }

      //Checks if the room is out of bounds
      if (x < 0 || y < 0){
         return false;
      }

      //Checks if the rooms overlaps
      for (Room room: placedRooms) {
         Rectangle secondTempRec = new Rectangle(room.posX, room.posY, room.dx, room.dy);
         if(tempRec.intersects(secondTempRec)){
            return false;
         }
      }

      //sets the positions of the room
      r.posX = x;
      r.posY = y;
      placedRooms.add(r);
      firstLocation(r);
      //System.out.println(placedRooms);

      // flags that the room is placed
      r.flagPlaced();
      System.out.println("Placerat");
      return true;
   }

   /**
    * saves the start position and keeps track of the players current room.
    * @param r
    */
   public void firstLocation(Room r) {
      startRoom = r;
      currentRoom = startRoom;
   }

   /**
    * Change the players room and notify observers.
    * @param i
    */
   public void changeRoom(int i){
      switch (i){
         case 0:
            if(currentRoom.northWall != null){
               currentRoom = currentRoom.northWall;
               setChanged();
               notifyObservers();
            }
            break;

         case 1:
            if(currentRoom.southWall != null){
               currentRoom = currentRoom.southWall;
               setChanged();
               notifyObservers();
            }
            break;
         case 2:
            if(currentRoom.westWall != null){
               currentRoom = currentRoom.westWall;
               setChanged();
               notifyObservers();
            }
            break;
         case 3:
            if(currentRoom.eastWall != null){
               currentRoom = currentRoom.eastWall;
               setChanged();
               notifyObservers();
            }
            break;

      }
   }

}