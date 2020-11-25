
public class LifeLength {
   public static void main(String[] args) {
      int first = Integer.parseInt(args[0]);
      //int second = Integer.parseInt(args[1]);
      int n = 6;
      switch(n) {

         case 1:
            task1(first);
            break;

         case 2:
            task2(first);
            break;

         case 3:
            task3();
            break;

         case 4:
            task4();
            break;

         case 6:
            task6();
            break;
      }



   }

   public static void task1(int first) {
      System.out.println(f1(first));
   }

   public static void task2(int first) {
      System.out.println(f2(first));
      System.out.println(f4(first));
      System.out.println(f8(first));
      System.out.println(f16(first));
      System.out.println(f32(first));
   }

   public static void task3() {
      System.out.println(iterateF(3,5));
      System.out.println(iterateF(42, 3));
      System.out.println(iterateF(1, 3));
   }

   public static void task4() {
      System.out.println(intsToString(15));
   }

   public static void task6() {
      System.out.println(recLifeLength(15));
   }
   /* Lifelength
    * 1 = 0
    * 2 = 1
    * 3 = 7
    * 4 = 2
    * 5 = 5
    * 6 = 8
    * 7 = 16
    * 8 = 3
    * 9 = 19
    * 10 = 6
    * 11 = 14
    * 12 = 9
    * 13 = 9
    * 14 = 17
    * 15 = 17
    */

   /* A function that calls the f1 function as long as the input/changed input value is over 1, it then
    * returns the number of iterations which is the same as the life length of the input value in the
     equation in function f1.*/
   public static int iterLifeLength(int a0) {
      int k = 1;
      int counter = 0;
      while(k < a0){
         counter++;
         a0 = f1(a0);
      }

      return counter;
   }

   /*This function is the same as iterLifeLength but uses recursion instead of a loop
    * it returns 1 every time and the new value of a0, the new a0 value depends on what the current is
    * it continues do this until the base case is met aka a0 is equal to 1. it will add all the ones returned
      giving the life length of the argument, a0. */
   public static int recLifeLength(int a0) {
      if(a0==1) {
         return 0;
      }
      else if(a0 % 2 == 0){
         return recLifeLength(a0/2) + 1;

      }
      else {
         return recLifeLength(a0*3+1) + 1;
      }
   }
   // A helper function to iterLifeLength to print the output as a string instead of an integer.
   public static String intsToString(int x) {
      String output = "The life length of " + x + " is " + iterLifeLength(x) + ".";
      return output;
   }
   // this function is the implementation of an equation, if the argument a0 is 1 return 1
   // if its even return a0 dived by 2 and else return a0 times 3 and plus 1.
   public static int f1(int a0) {
      if(a0==1) {
         return 1;
      }
      else if(a0 % 2 == 0) {
         return a0/2;
      }
      else {
         return 3*a0+1;
      }
   }
   // this function just calls f1 twice, the functions f2 to f32 works the same and call each other to
   // re-use code.
   public static int f2(int a0) {
      return f1(f1(a0));
   }

   public static int f4(int a0) {
      return f2(f2(a0));
   }

   public static int f8(int a0) {
      return f4(f4(a0));
   }

   public static int f16(int a0) {
      return f8(f8(a0));
   }

   public static int f32(int a0) {
      return f16(f16(a0));
   }

   public static int iterateF(int a0, int n) {
      for(int i = 0; i < n; i++) {
         a0 = f1(a0);
      }
      return a0;
   }
}
