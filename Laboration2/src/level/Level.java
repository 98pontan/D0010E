package level;

import java.util.ArrayList;
import java.util.Observable;
import java.awt.Rectangle;

/**
 * Places rooms on a level if they have a correct position.
 * @author Pontus Eriksson Jirbratt, ponjir-7
 */
public class Level extends Observable {

   public ArrayList<Room> placedRooms;
   private Room startRoom;
   public Room currentRoom;


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
      System.out.println(placedRooms);
      // flags that the room is placed
      r.flagPlaced();
      System.out.println("Placerat");
      return true;
   }

   public void firstLocation(Room r) {
      startRoom = r;
      currentRoom = startRoom;
   }

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