public class Raise {
   static int recRaiseOneCount;
   static int recRaiseHalfCount;

   /**
    *
    * @param args
    */
   public static void main(String[] args) {
      recRaiseOneCount = 0;
      recRaiseHalfCount = 0;

      for (int i = 1; i <= 100; i++) {
         recRaiseOne(1.0005, i);
         recRaiseHalf(1.0005, i);
         //System.out.println(i);
         System.out.println(recRaiseHalfCount);
        // System.out.println(recRaiseOneCount + ":" +recRaiseHalfCount);

      }
   }

   public static double recRaiseHalf(double x, int k) {
      int temporaryInt;
      int exponent = k/2;

      recRaiseHalfCount++;

      if (k == 0) {
         return 1;
      }
      else if(k % 2 == 0) {
         temporaryInt = (int) recRaiseHalf(x, exponent);
         return temporaryInt * temporaryInt;
      }
      else {
         temporaryInt = (int) recRaiseHalf(x, exponent);
         return temporaryInt * temporaryInt * x;
      }
   }

   public static double recRaiseOne(double x, int k) {
      recRaiseOneCount++;
      if (k==0) {
         return 1.0;
      }
      else {
         return x * recRaiseOne (x, k-1);
      }
   }
   /**
    * Task 10
    * The size of x does not matter in the running time it can be 0 or 2000 the running time is decided by the size of k
    * N one is exponential n^2
    * N half is logaritmic nlogn
    */

}
