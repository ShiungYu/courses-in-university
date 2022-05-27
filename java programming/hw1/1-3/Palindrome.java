public class Palindrome{
    void determine(int data)//determine is palindrome or not
    {
        if(data/100000!=0||data/10000==0)
        {
            System.out.println("Number must be 5 digits");
            System.out.printf("%d is not a palindrome.%n",data);
        }
        else{
            if(data/10000==data%10 && data/1000%10==data/10%10)
            {
                System.out.printf("%d is a palindrome!!!%n",data);
            }   
            else{
                System.out.printf("%d is not a palindrome.%n",data);
            }
        }
    }
}