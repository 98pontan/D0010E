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
      int nodeNum1;
      int nodeNum2;
      int nodeNum3;
      int x;
      int y;
      int weight;
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
      while (scanner.hasNextLine())
      {
         if (numberOfNodes > counter)
         {
            nodeNum1 = scanner.nextInt();
            x = scanner.nextInt();
            y = scanner.nextInt();
            g.addNode(nodeNum1, x, y);
         }

         else {
            nodeNum2 = scanner.nextInt();
            nodeNum3 = scanner.nextInt();
            weight = scanner.nextInt();
            g.addEdge(nodeNum2, nodeNum3, weight);
         }
         counter++;
      }

   }
}
