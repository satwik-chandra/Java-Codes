
public class TwelveDaysOfChristmasExtended {
	public static String getOrdinalString(int dayNumber)
	{
		final String[] DAYS = {"first","second","third","fourth","fifth","sixth","seventh","eight","ninth","tenth","eleventh","twelfth"};
		return DAYS[dayNumber];
	}
	public static String getVerse(int dayCounter) 
	{
		String firstLine =  "On the _ day of Christmas,\n My lover gave to me: \n";
		String dayName = getOrdinalString(dayCounter);
		String DAYS_REGEX = "[_]";
		String verse = firstLine.replaceAll(DAYS_REGEX,dayName);
		return verse;
	}
 	public static String getChristmasGift(int counter)
	{ String christmasGift = "";
		switch(counter) {
		case 0 : christmasGift = "a Partridge in a Pear Tree"+"\n";
		break;
		case 1 : christmasGift = "Two Turtle Doves and"+"\n";
		break;
		case 2 :christmasGift =  "Three French Hens"+"\n";
		break;
		case 3 :  christmasGift = "Four Calling Birds"+"\n";
		break;
		case 4 : christmasGift = "Five Golden Rings"+"\n";
		break;
		case 5 :  christmasGift =  "Six Geese a Laying"+"\n";
		break;
		case 6 : christmasGift = "Seven Swans a Swimming"+"\n";
		break;
		case 7 :  christmasGift = "Eight Maids a Milking"+"\n";
		break;
		case 8 :christmasGift = "Nine Ladies Waiting"+"\n";
		break;
		case 9 : christmasGift =  "10 Lords a Leaping"+"\n";
		break;
		case 10 :  christmasGift = "'leven Pipers Piping"+"\n";
		break;
		case 11 :christmasGift = "12 Drummers Drumming"+"\n";
		break;
		}	return christmasGift;
		}

	
	public static void main(String[] args) {

		


		for(int counter = 0; counter<12; counter ++)
		{ 
			System.out.print(getVerse(counter));
			for(int counter2 = counter; counter2 >= 0; counter--)
			{
				System.out.print(getChristmasGift(counter2));
			}
		}


	}
}

