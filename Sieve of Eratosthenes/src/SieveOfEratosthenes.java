/* SELF ASSESSMENT 
   1.  createSequence:

    Did I use the correct method definition?
    Mark out of 5: 5
    Comment: yes
    Did I create an array of size n (passed as the parameter) and initialize it?
    Mark out of 5: 5
    Comment: yes
    Did I return the correct item?
    Mark out of 5: 5
    Comment: yes i returned the sequence

   2.  crossOutMultiples

    Did I use the correct method definition?
    Mark out of 5:  5
    Comment: yes
    Did I ensure the parameters are not null and one of them is a valid index into the array
    Mark out of 2:  2
    Comment: yes
    Did I loop through the array using the correct multiple?
    Mark out of 5: 5
    Comment: yes i used the correct multiple
    Did I cross out correct items in the array that were not already crossed out?
    Mark out of 3: 3
    Comment: yes

   3.  sieve   

    Did I have the correct function definition?
    Mark out of 5: 5
    Comment: yes
    Did I make calls to other methods?
    Mark out of 5: 5
    Comment: yes i called to the cross out higher multiples method
    Did I return an array with all non-prime numbers are crossed out?
    Mark out of 2: 2
    Comment: yes i returned sievedSequence

   4.  sequenceTostring  

    Did I have the correct function definition?
    Mark out of 5: 5
    Comment: yes
    Did I ensure the parameter to be used is not null?
    Mark out of 3: 3
    Comment: yes
    Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
    Mark out of 10: 10
    Comment: yes

   5.  nonCrossedOutSubseqToString  

    Did I have the correct function definition
    Mark out of 5: 5
    Comment: yes
    Did I ensure the parameter to be used is not null?  
    Mark out of 3: 3
    Comment: yes
    Did I loop through the array updating the String variable with just the non-crossed out numbers? 
    Mark out of 5: 5
    Comment: yes

   6.  main  

    Did I ask  the user for input n and handles input errors?  
    Mark out of 5: 5
    Comments: yes
    Did I make calls to other methods (at least one)?
    Mark out of 5: 5
    Comment: yes
    Did I print the output as shown in the question?  
    Mark out of 5: 5
    Comment:  yes

   7.  Overall

    Is my code indented correctly?
    Mark out of 4: 4
    Comments: yes
    Do my variable names make sense?
    Mark out of 4: 4
    Comments: yes
    Do my variable names, method names and class name follow the Java coding standard
    Mark out of 4: 4
    Comments: yes

      Total Mark out of 100 (Add all the previous marks): 100 
*/




import java.util.Scanner;
import java.lang.Math;

public class SieveOfEratosthenes {

	public boolean[] sequence;
	public int number;
	
	public static void main(String[] args) {
		SieveOfEratosthenes Sieve1 = new SieveOfEratosthenes();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter an integer that is greater than or equal to 2 -> ");
		
		while(!sc.hasNextInt())
		{
			System.out.println("Enter an integer that is greater than or equal to 2 -> ");
			sc.next();
		}
		
		Sieve1.number = sc.nextInt();
		
		Sieve1.sequence = Sieve1.createSequence(Sieve1.number - 1);
		
		System.out.println(Sieve1.sequenceToString(Sieve1.sieve(Sieve1.number)));
		System.out.println(Sieve1.nonCrossedOutSubSeqToString(Sieve1.sieve(Sieve1.number)));

	}
	
	public boolean[] createSequence(int number) {
		
		boolean[] sequence = new boolean[number];
		
		for(int index = 0; index < number; index++) 
		{
			sequence[index] = true;
		}
	
		return sequence;
	}
	
	public void crossOutHigherMultiples(boolean[] sievedSequence, int nonCrossedOutIndex) 
	{
		if(sievedSequence != null)
		{
			int index = nonCrossedOutIndex;
			index += (nonCrossedOutIndex + 2);
			
			do
			{
				sievedSequence[index] = false;
				index += (nonCrossedOutIndex + 2);
			} while((index + 2) <= number && sievedSequence[index] == true);
		}
		else
			System.out.println("Error: sievedSequence is null");
	}
	
	public boolean[] sieve(int number) {
		double highestPrime = Math.sqrt(number);
		boolean sievedSequence[] = sequence.clone();
		int nonCrossedOutIndex = 0;
		
		while((nonCrossedOutIndex + 2) <= highestPrime)
		{
			if(sequence[nonCrossedOutIndex] == true)
				crossOutHigherMultiples(sievedSequence, nonCrossedOutIndex);
			nonCrossedOutIndex++;
		}
		
		return sievedSequence;
	}
	
	public String sequenceToString(boolean[] sievedSequence) {
		
		String sequenceString = "";
		
		if(sievedSequence != null)
		{
			for(int index = 0; index < sievedSequence.length; index++)
			{
				if(sievedSequence[index] == false)
					sequenceString += (index == (sievedSequence.length - 1))? ("[" + (index + 2) + "]") : ("[" + (index + 2) + "], ");
				else
					sequenceString += (index == (sievedSequence.length - 1))? (index + 2) : ((index + 2) + ", ");
			}
		}
		else
			sequenceString = "Error: sievedSequence is null";
			
			return sequenceString;
	}
	
	public String nonCrossedOutSubSeqToString(boolean[] sievedSequence) {
		
		String nonCrossedOutSubSeqString = "";
		boolean notLastPrime = true;
		int lastPrimeIndex = sievedSequence.length - 1;
		
		if(sievedSequence != null)
		{
			while(sievedSequence[lastPrimeIndex] != notLastPrime)
			{
				lastPrimeIndex--;
			}
			
			for(int index = 0; index < sievedSequence.length; index++)
			{
				if(sievedSequence[index] == true)
					nonCrossedOutSubSeqString += (index == lastPrimeIndex)? (index + 2) : (index + 2) + ", ";
				
			}
		}
		else
			nonCrossedOutSubSeqString = "Error: sievedSequence is null";
		
		return nonCrossedOutSubSeqString;
	}

}
