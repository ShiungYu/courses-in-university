import java.util.Scanner;
public class PalindromeTest {
    public static void main(String[] args)//input a number
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 5-digit number: ");
        int data=input.nextInt();
        Palindrome test=new Palindrome();
        test.determine(data);
    }
}
