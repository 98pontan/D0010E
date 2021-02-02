import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Creates an arraylist of unknown size and have methods that does operations on the list.
 *
 * @author Pontus Eriksson Jirbratt
 */
public class FIFO implements Queue
{
   private ArrayList<Object> fifoList = new ArrayList<Object>();
   private int maxSize;
   private int firstIndex = 0;

   /**
    * adds an iteam to the back of the list
    * @param item
    */
   public void add(Object item)
   {
      int size;

      size = fifoList.size();
      fifoList.add(size, item);

      if (size > maxSize)
         maxSize = size;

      System.out.println("Item added");
   }

   /**
    * removes the first item in the list if the list is not empty
    */
   public void removeFirst()
   {
      if(isEmpty())
         throw new NoSuchElementException();

      try{
         fifoList.remove(firstIndex);
      }catch (NoSuchElementException e){
         System.out.println("Error no such element");
      }
   }

   /**
    * returns the first element in the list if there is elements in the list
    * @return
    */
   public Object first(){
      if (isEmpty())
         throw new NoSuchElementException();

      else
         return fifoList.get(firstIndex);

   }

   /**
    * @return the size of the list
    */

   public int size()
   {
      return fifoList.size();
   }

   /**
    * @return the maximume size the list has had since its creation
    */
   public int maxSize()
   {
      return maxSize;
   }

   /**
    * @return checks if the list is empty, if it is it will return true else false.
    */
   public boolean isEmpty()
   {
      return fifoList.isEmpty();
   }

   /**
    * creates an Object of type FIFO to cast the argument f to FIFO if f is an instance of FIFO else throw exception.
    * Checks if they are the same size if they are we will continue to check if its true else we will return false.
    * Check if when of them is null both are null set the result to true else false.
    * If the lists are not null they should be instances of the same type thus they are compared.
    * If they are equal according to all conditions it will return true else it will return false or throw an exception.
    *
    * @param f
    * @return
    */
   public boolean equals(Object f)
   {
      FIFO fifo;
      boolean result = true;

      if (f instanceof FIFO) {
         fifo = (FIFO) f;
         if (this.fifoList.size() == fifo.size())
         {
            for (int i = 0; i < this.fifoList.size(); i++)
            {
               if (this.fifoList.get(i) != null && fifo.fifoList.get(i) == null || this.fifoList.get(i) == null && fifo.fifoList.get(i) != null)
                  result = false;

               else if (this.fifoList.get(i) == null && fifo.fifoList.get(i) == null || this.fifoList.get(i).equals(fifo.fifoList.get(i)))
                  result = true;

            } //end of for
            return  result;

         }else
            return false;
      }else
         throw new ClassCastException();
   }

   /**
    * Put all the elements in the list into an string
    *
    * @return a string of all the element values beginning with the string "Queue: "
    */
   public String toString()
   {
      String listOfelements = "";

      for (Object i : fifoList) {
         listOfelements += "(" + String.valueOf(i) + ") ";
      }
      return "Queue: " + listOfelements;
   }
}

