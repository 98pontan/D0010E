import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO
{
   static public void readFile(Graph g, String filename) throws IOException
   {
      Scanner scanner;
      int numberOfNodes;
      int counter = 0;
      File graph;

      try
      {
         graph = new File(filename);
         scanner = new Scanner(graph);
      } catch (IOException e)
      {
         e.printStackTrace();
         throw new IOException();
      }
      numberOfNodes = scanner.nextInt();
      System.out.println(numberOfNodes);
      while (scanner.hasNext())
      {
         if (numberOfNodes < counter)
         {

         }
      }

   }
}
