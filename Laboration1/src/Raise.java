public class Raise {
   static int recRaiseOneCount;
   static int recRaiseHalfCount;

   public static void main(String[] args) {
      for (int i = 1; i <= 4000; i++) {
         recRaiseOneCount = 0;
         recRaiseHalfCount = 0;
         recRaiseOne(1.0005, i);
         recRaiseHalf(1.0005, i);
         System.out.println(recRaiseOneCount + ":" +recRaiseHalfCount);

      }
   }

   public static double recRaiseHalf(double x, int k) {
      recRaiseHalfCount++;
      int temporaryInt;
      int exponent = (int) k/2;

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

}
