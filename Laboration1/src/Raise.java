public class Raise {
   static int recRaiseOneCount;
   static int recRaiseHalfCount;

   /**
    *
    * @param args
    */
   public static void main(String[] args) {
      recRaiseHalf(1, 7023);
      System.out.println(recRaiseHalfCount);
      /*
      for (int i = 1; i <= 10_000; i++) {
         recRaiseOneCount = 0;
         recRaiseHalfCount = 0;
         //recRaiseOne(1.0005, i);
         //recRaiseHalf(1.0005, i);
         //System.out.println(i);
         System.out.println();
         //System.out.println(recRaiseOneCount + ":" +recRaiseHalfCount);

      }

       */
   }

   public static double recRaiseHalf(double x, int k) {
      double temporaryInt;
      int exponent = k/2;

      recRaiseHalfCount++;

      if (k == 0) {
         return 1;
      }
      else if(k % 2 == 0) {
         temporaryInt = recRaiseHalf(x, exponent);
         return temporaryInt * temporaryInt;
      }
      else {
         temporaryInt = recRaiseHalf(x, exponent);
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
    * N one is exponential is konstant
    * N half is logaritmic nlogn
    */

}
