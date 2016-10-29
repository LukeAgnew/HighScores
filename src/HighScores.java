import java.util.Scanner;

public class HighScores {
	public static void main(String[] args) {
		System.out.println("How many scores would you like to maintain?");
		Scanner inputScanner = new Scanner(System.in);
		
		int numberOfScores = inputScanner.nextInt();
		
		int[] highScoreList = new int[numberOfScores];
		
		initialiseHighScores(highScoreList, numberOfScores);
		printHighScores(highScoreList, numberOfScores);
		System.out.println("Please enter a score.");
		
		while (inputScanner.hasNextInt())
		{				
			int nextScore = inputScanner.nextInt();
			boolean higher = higherThan(highScoreList, nextScore, numberOfScores);
			
			if (higher)
			{
				insertScore(highScoreList, nextScore, numberOfScores);
			}

			printHighScores(highScoreList, numberOfScores);
			System.out.println("Please enter a score:");
		}
		
		inputScanner.close();
	}
	
	public static void insertScore(int[] highScoreList, int nextScore, int numberOfScores) {
		int currentIndex = 0;
		boolean stillHigher = true;
		while (currentIndex < numberOfScores && stillHigher)
			{
				if (nextScore > highScoreList[currentIndex])
				{
					int shiftCount = numberOfScores - 1;
					while (shiftCount > currentIndex)
					{
						highScoreList[shiftCount] = highScoreList[shiftCount-1];
						shiftCount--;
					}
					highScoreList[currentIndex] = nextScore;
					stillHigher = false;
				}
				currentIndex++;
			}
		
	}
	
	public static void initialiseHighScores(int[] highScoreList, int numberOfScores) {
		int currentIndex = 0;
		
		while (currentIndex < numberOfScores) 
		{
			highScoreList[currentIndex] = 0;
			currentIndex++;
		}
		
	}
	
	public static boolean higherThan(int[] highScoreList, int nextScore, int numberOfScores) {
		int currentIndex = 0;
		boolean higher = false;
		while (currentIndex < numberOfScores)
		{			
			if (nextScore > highScoreList[currentIndex])
			{
				higher = true;
				return higher;
			}
			currentIndex++;
		}		
		return higher;
	}
	public static void printHighScores(int[] highScoreList, int numberOfScores) {
		int currentIndex = 0;
		String scoreList = "The list of High Scores is: ";
		while (currentIndex < numberOfScores)
		{
			scoreList = scoreList + highScoreList[currentIndex] + ", ";
			currentIndex++;
		}
		
		System.out.println(scoreList);
	}
}
