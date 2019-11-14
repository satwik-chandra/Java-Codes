
/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5:5
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5:5
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 10:10
   4. Did I indent the code appropriately?
       Mark out of 10:10
   5. Did I use an appropriate loop (or loops) to produce the different verses?
       Mark out of 20: 20
   6. Did I use a switch to build up the verses?
       Mark out of 25: 25
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))?
       Mark out of 10: 10
   8. Does the program produce the correct output?
       Mark out of 10: 10
   9. How well did I complete this self-assessment?
       Mark out of 5:5
   Total Mark out of 100 (Add all the previous marks):100
 */

public class TwelveDaysOfChristmas {

	public static void main(String[] args) {
		final String [] DAYS = {"first","second","third","fourth","fifth","sixth","seventh","eight","ninth","tenth","eleventh","twelfth"};
		final String DAYS_REGEX = "[_]";
		final String FIRST_LINE = "On the _ day of Christmas,\n My lover gave to me: \n";
		for(int counter = 0; counter<= DAYS.length; counter++)
		{
			System.out.print(FIRST_LINE.replaceAll(DAYS_REGEX, DAYS[counter]));

			for (int counter2 = counter; counter2>=0; counter2--)
			{

				switch(counter2)
				{
				case 0 : System.out.print("a Partridge in a Pear Tree"+"\n");
				break;
				case 2 : System.out.print("Two Turtle Doves and"+"\n");
				break;
				case 3 : System.out.print("Three French Hens"+"\n");
				break;
				case 4 : System.out.print("Four Calling Birds"+"\n");
				break;
				case 5 : System.out.print("Five Golden Rings"+"\n");
				break;
				case 6 : System.out.print("Six Geese a Laying"+"\n");
				break;
				case 7 : System.out.print("Seven Swans a Swimming"+"\n");
				break;  
				case 8 : System.out.print("Eight Maids a Milking"+"\n");
				break;
				case 9 : System.out.print("Nine Ladies Waiting"+"\n");
				break;
				case 10 : System.out.print("10 Lords a Leaping"+"\n");
				break; 
				case 11 : System.out.print("'leven Pipers Piping"+"\n");
				break;
				case 12 : System.out.print("12 Drummers Drumming"+"\n");
				break;
				}

			}

		}

	}

}
