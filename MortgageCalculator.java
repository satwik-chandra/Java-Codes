/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful,l properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment:   yes my variable names are properly formatted and descriptive
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment:   yes my code is indented properly
 3. Did I implement the mainline correctly with a loop which continues using the user says "no" ?
       Mark out of 10: 10
        Comment:  yes i implement the mainline correctly with a loop which continues using the user says 'no'
 4. Did I obtain the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats ?
       Mark out of 10: 10
        Comment:  Yes,I obtain the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats
 5. Did I implement the readDoubleFromUser function correctly and in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  yes,I implement the readDoubleFromUser function correctly and in a manner that can be easily understood
 6. Did I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  yes,I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood
 7. Did I implement the calculateMonthsToRepayMortgage function correctly in a manner that can be easilyunderstood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  yes,I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood
 8. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: with utmost honesty
 Total Mark out of 100 (Add all the previous marks):
 */ 




import java.util.Scanner;	
public class MortgageCalculator {


	public static double readDoubleFromUser(String question) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println(question);
			if(scan.hasNextDouble()) {
				double userInputDouble = scan.nextDouble();
				return userInputDouble;
				}
			else
			{ System.out.println("You have entered a wrong input! Please try again");
			scan.next();
			}
		}
	}


	public static double calculateMonthlyRepayment(double mortgage, int duration, double ANNUAL_INTEREST_RATE) {
		double MonthlyRepayment = mortgage*(ANNUAL_INTEREST_RATE/12/100)/(1-(Math.pow((1+ANNUAL_INTEREST_RATE/12/100),(-1*duration*12))));
		return MonthlyRepayment;
	}
	public static int calculateMonthsToRepayMortgage(double mortgage, double ANNUAL_INTEREST_RATE,double monthlyRepayment) {

		double monthlyAnnualInterestRate = ANNUAL_INTEREST_RATE/12;
		int numberOfMonths = 0;
		for(;mortgage>=0;) {
			mortgage = mortgage *(1+(monthlyAnnualInterestRate/100)) - monthlyRepayment;
			numberOfMonths++;
		}
		return numberOfMonths;

	}

	public static void main(String[] args) {
		boolean userDecisionToContinue = true;
		while(userDecisionToContinue) {
			System.out.print("Welcome to the mortgage calculator.");
			Scanner input = new Scanner(System.in);
			double mortgage = readDoubleFromUser("Please enter the mortgage amount:");
			System.out.println("Please enter the annual interest rate (APR):");
			final double ANNUAL_INTEREST_RATE = input.nextDouble();
			System.out.println("Assuming a 20 year term, the monthly repayments would be " + calculateMonthlyRepayment(mortgage,20,ANNUAL_INTEREST_RATE));
			System.out.println("How much can you afford to pay per month?");
			final double AFFORD_TO_PAY_BY_THE_USER = input.nextDouble();
			System.out.println("If you pay "+ AFFORD_TO_PAY_BY_THE_USER + " per month your mortgage would be paid off in " + calculateMonthsToRepayMortgage(mortgage,ANNUAL_INTEREST_RATE,AFFORD_TO_PAY_BY_THE_USER)+" months");
			System.out.println("Would you like to use the mortgage calculator again (yes/no)?");
			String userInput = input.next();                              

			if (userInput.equals("no")) {
				userDecisionToContinue = false;
			}


		}

	}
}
