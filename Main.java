import java.util.HashMap;

/**
 * File to access the anagram finder and print the list of words in quizwords.txt
 * CLASS: CIS222 Object Oriented Programming
 * INSTRUCTOR: Dr. Neumann
 * ASSIGNMENT: Week-Four-Lab
 * @author Isaac
 * @version 2.8.16
 */
public class Main {

    public static void main(String[] args)
    {
        System.out.println("Printing words and anagrams that start with 'v':");
	    AnagramFinder anagramFinder = new AnagramFinder();
        HashMap <String, String> wordDict = new HashMap<>();
        wordDict = anagramFinder.fillHashmap("wordList", "v");
        anagramFinder.solvePuzzle(wordDict, "quizwords");
        System.out.println("End of program.");
    }
}
