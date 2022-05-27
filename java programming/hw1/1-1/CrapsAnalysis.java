
import java.security.SecureRandom;

public class CrapsAnalysis
{
   // create secure random number generator for use in method rollDice
   private static final SecureRandom randomNumbers = new SecureRandom();

   // enum type with constants that represent the game status
   private enum Status {CONTINUE, WON, LOST};

   // constants that represent common rolls of the dice
   private static final int SNAKE_EYES = 2;
   private static final int TREY = 3;
   private static final int SEVEN = 7;
   private static final int YO_LEVEN = 11;
   private static final int BOX_CARS = 12;
   public static int [] diceRollingWonTimes=new int[22];
   public static int [] diceRollingLostTimes=new int[22]; 

   
   // plays one game of craps

   public void StatusAssign()
   {
        int sumOfDice=rollDice();
        int myPoint =0;
        Status gameStatus;
        switch (sumOfDice) 
        {
            case SEVEN: // win with 7 on first roll
            case YO_LEVEN: // win with 11 on first roll           
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES: // lose with 2 on first roll
            case TREY: // lose with 3 on first roll
            case BOX_CARS: // lose with 12 on first roll
                gameStatus = Status.LOST;
                break;
            default: // did not win or lose, so remember point         
                gameStatus = Status.CONTINUE; // game is not over
                myPoint = sumOfDice; // remember the point
                break;
        }   
            int time=1;
            // while game is not complete
            while (gameStatus == Status.CONTINUE) // not WON or LOST
            { 
                time++;
                sumOfDice = rollDice(); // roll dice again

                // determine game status
                if (sumOfDice == myPoint) // win by making point
                    gameStatus = Status.WON;
                else 
                    if (sumOfDice == SEVEN)
                    // lose by rolling 7 before point
                    gameStatus = Status.LOST;
            } 

            // display won or lost message
            if(time>21)
            time=21;
            if (gameStatus == Status.WON)
                diceRollingWonTimes[time]++;
            else
                diceRollingLostTimes[time]++;
   }

   // roll dice, calculate sum and display results
   public static int rollDice()
   {
      // pick random die values
      int die1 = 1 + randomNumbers.nextInt(6); // first die roll
      int die2 = 1 + randomNumbers.nextInt(6); // second die roll

      int sum = die1 + die2; // sum of die values

      // display results of this roll

      return sum; 
   }
} // end class Craps

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/