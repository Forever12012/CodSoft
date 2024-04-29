package Assignments;

import java.util.Scanner;

// Random Number Generator

public class FirstAssignment {

	public static int guessRandomNum() 
	{
		// Generate random number from 1 to 100
		int randomNum = (int) (Math.random()*100) + 1;
		// System.out.println(randomNum);
		
		Scanner sc = new Scanner(System.in);
		int userNum;
		
		// Used count to keep track of user's guess
		int count = 0;
		
		// Used do while loop to allow the user to keep guessing until they get it right
			do {
				// take input from the user
				System.out.print("Guess the number : ");
			 	userNum = sc.nextInt();
			
				if(userNum > randomNum)
				{
					System.out.println("Too high");
				}
				else if(userNum < randomNum)
				{
					System.out.println("Too low");
				}
				else
				{
					System.out.println("Correct");
				}
				count++;
			}
			while(userNum != randomNum);
			
			if(count >= 1 && count <= 3)
			{
				System.out.println("You scored 10 points");
			}
			else if(count >= 4 &&  count <= 6)
			{
				System.out.println("You scored 7 points");
			}
			else if(count > 6)
			{
				System.out.println("You scored 3 points");
			}
			sc.close();
			return randomNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstAssignment.guessRandomNum();
	}

}
