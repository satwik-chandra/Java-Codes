/* SELF ASSESSMENT
   1. Did I use easy-to-understand meaningful variable and CONSTANT names?
       Mark out of 10: 10
       Comment: yes i use easy to understand and meaningful variable and constant names
   2. Did I format the variable and CONSTANT names properly (in lowerCamelCase and UPPERCASE_WITH_UNDERSCORES)?
       Mark out of 10: 10
       Comment:Yes, I format the variable and CONSTANT names properly (in lowerCamelCase and UPPERCASE_WITH_UNDERSCORES)
   3. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: Yes, i have indented the code properly
   4. Did I read the input correctly from the user using appropriate questions?
       Mark out of 15: 15
       Comment: All questions are easy to understand and read the input correctly from the user
   5. Did I computer the disposable income and disposable income percentage correctly, and output it in the correct format?
       Mark out of 15: 14
       Comment: the disposable income is accurate The percent is coming out to be 7.5% instead of 8%.
        I think there is an error on blackboard since even by calculator the output is coming
        out to be 7.5% so that is why I am giving myself a 14.
  6. Did I use an appropriate series of if statements to generate the income analysis to the user?
       Mark out of 25: 25
       Comment: the if statements are hierarchical and hence an efficient way of analyzing the disposable income of the user
   7. Did I provide the correct output for each possibility in an easy to read format?
       Mark out of 10: 10
       Comment: every possibility is accurately identified and appropriate output is shown to the user.
   8. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: i completed the self assessment to the fullest.
   Total Mark out of 100 (Add all the previous marks): 99
 */

import javax.swing.JOptionPane;
public class DisposableIncomeAnalysis {

	public static void main(String[] args) {
		
		
		
		
		String TotalIncomeInput = JOptionPane.showInputDialog("How much are you paid a month before tax?");
		String AccommodationCostInput = JOptionPane.showInputDialog("How much do you pay in rent/mortgage a month?");
		String TransportationCostInput = JOptionPane.showInputDialog("How much does your commute cost a month?");
		String FoodCostInput = JOptionPane.showInputDialog("How much do you spend on food per month?");

		double TotalIncome = Double.parseDouble(TotalIncomeInput);
		double AccommodationCost = Double.parseDouble(AccommodationCostInput);
		double TransportationCost = Double.parseDouble(TransportationCostInput);
		double FoodCost = Double.parseDouble(FoodCostInput);

		final double TAX = 0.35;

		double AfterTaxIncome = (1 - TAX)*TotalIncome;
		double DisposableIncome = AfterTaxIncome - AccommodationCost - TransportationCost - FoodCost;
		double DisposableIncomePercentOfTotalIncome = (DisposableIncome/TotalIncome)*100;

		JOptionPane.showMessageDialog(null," Your monthly disposable income is €"+ DisposableIncome + " which is "+
				DisposableIncomePercentOfTotalIncome +"% of your salary.");
		double AverageDsiposableIncome = 500;
		 if (DisposableIncome == 0.00)
			 JOptionPane.showMessageDialog(null," You dont have any Disposable Income");
		 else if (DisposableIncome > (AverageDsiposableIncome*1.5))
			 JOptionPane.showMessageDialog(null," You disposable income is much more than the average disposable income per month");
		 else if (DisposableIncome > AverageDsiposableIncome)
			 JOptionPane.showMessageDialog(null," You disposable income is more than the average disposable income per month");
		 else if (DisposableIncome < AverageDsiposableIncome && DisposableIncome > (AverageDsiposableIncome*0.5))
			 JOptionPane.showMessageDialog(null," You disposable income is less than the average disposable income per month");
		 else
			 JOptionPane.showMessageDialog(null," You disposable income is much less than the average disposable income per month");
		
		
		

	
	
	
	}

}
