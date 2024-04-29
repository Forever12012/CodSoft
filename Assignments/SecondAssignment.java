package Assignments;

import java.util.Scanner;

// Student Result

public class SecondAssignment {
	
	public static void marksCalculator()
	{
		Scanner sc = new Scanner(System.in);
		
		int eng, hindi, science, maths, eco;
		
		do {
			System.out.println("Enter English Marks : ");
			eng = sc.nextInt();
		}while(eng < 0 || eng >= 100);
		
		do {
			System.out.println("Enter Hindi Marks : ");
			hindi = sc.nextInt();
		}while(hindi < 0 || hindi >= 100);
		
		do {
			System.out.println("Enter Science Marks : ");
			science = sc.nextInt();
		}while(science < 0 || science >= 100);
		
		do {
			System.out.println("Enter Maths Marks : ");
			maths = sc.nextInt();
		}while(maths < 0 || maths >= 100);
		
		do {
			System.out.println("Enter Economics Marks : ");
			eco = sc.nextInt();
		}while(eco < 0 || eco >= 100);
		
		
		int totalMarks = eng + hindi + science + maths + eco;
		double totalPercentage = totalMarks/5.0; 
		
		System.out.println("Total Marks are : " + totalMarks);
		System.out.println("Average Percentage is : " + totalPercentage);
		
		if(totalPercentage >= 90)
		{
			System.out.println("Your Grade is : A");
		}
		else if(totalPercentage >= 75 && totalPercentage < 90)
		{
			System.out.println("Your Grade is : B");
		}
		else if(totalPercentage >= 60 && totalPercentage < 75)
		{
			System.out.println("Your Graade is : C");
		}
		else if(totalPercentage >= 40 && totalPercentage < 60){
			System.out.println("Your Graade is : D");
		}
		else {
			System.out.println("You have failed the exams. Try next time !");
		}
		sc.close();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		marksCalculator();
	}

}
