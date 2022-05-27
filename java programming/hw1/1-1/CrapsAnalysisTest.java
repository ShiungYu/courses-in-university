


public class CrapsAnalysisTest
{
    public static void main(String[] args)//input the data to CrapsAnalysis and output the result
    {
      CrapsAnalysis test=new CrapsAnalysis(); 
      for(int i=0;i<1000;i++)
      {
        test.StatusAssign();
      }
      int winTime=0;
      double avgTime=0.0;
      for(int i=1;i<=20;i++)
      {
           avgTime=avgTime+(CrapsAnalysis.diceRollingWonTimes[i]+CrapsAnalysis.diceRollingLostTimes[i])*i; 
           winTime=winTime+CrapsAnalysis.diceRollingWonTimes[i]; 
           System.out.printf("%d games won and %d games lost on roll #%d%n",CrapsAnalysis.diceRollingWonTimes[i],CrapsAnalysis.diceRollingLostTimes[i],i);
      }
      avgTime/=1000;
      System.out.printf("%d games won and %d games lost on rolls after the 20th roll\n\n",CrapsAnalysis.diceRollingWonTimes[21],CrapsAnalysis.diceRollingLostTimes[21]);
      System.out.printf("The chances of winning are %d / 1000 = %.2f%%%n",winTime,(float)winTime/10.0);  
      System.out.printf("The average game length is %.2f rolls.",avgTime);
    }
}