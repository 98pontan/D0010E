import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO
{
   private ArrayList<Object> fifoList = new ArrayList<Object>();
   private int maxSize;

   public void add(Object item)
   {
      int size;

      size = fifoList.size();
      fifoList.add(size, item);

      if (size > maxSize)
         maxSize = size;

      System.out.println("Item added");
   }

   public void removeFirst()
   {
      try{
         fifoList.remove(0);
      }catch (NoSuchElementException e){
         System.out.println("Error no such element");
      }
   }

   public int size()
   {
      return fifoList.size();
   }
   public int maxSize()
   {
      return maxSize;
   }

   public boolean isEmpty()
   {
      return fifoList.isEmpty();
   }

   public boolean equals(Object f)
   {
     return this == f && fifoList.equals(f);
   }

   public String toString()
   {
      String listOfelements = "";

      for (Object i : fifoList) {
         listOfelements += "(" + String.valueOf(i) + ") ";
      }
      return "Queue: " + listOfelements;
   }
}

