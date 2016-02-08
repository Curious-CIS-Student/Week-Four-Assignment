import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * CLASS: CIS222 Object Oriented Programming
 * INSTRUCTOR: Dr. Neumann
 * ASSIGNMENT: Week-Four-Lab
 * AnagramFinder is a class with a collection of methods to assist one in converting a list of words in a file to
 * their anagrams starting with a certain letter. This program was adapted from code on www.codejava.net, as shown by
 * the original comment listed below:
 * This program demonstrates how to read characters from a text file
 * using a BufferedReader for efficiency.
 * @author www.codejava.net
 */
public class AnagramFinder {

    public AnagramFinder()
    {
        // Nothing to do since this is simply a collection of methods.
    }

    public HashMap fillHashmap(String filename, String startCharacter)
    {
        HashMap <String, String> wordDict = new HashMap<String, String>();
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                if(line.startsWith(startCharacter)) {
                    wordDict.put(sortWord(line), line);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordDict;
    }

    /**
     * Takes a HashMap and a filename as input. The file is assumed to be a list of words, with each new word on a new
     * line. Each line (word) in the file is printed out, along with the anagram of that word, as determined by the
     * key/value pairs in the HashMap.
     * @param inputWordDict
     * @param inputFile
     */
    public void solvePuzzle(HashMap inputWordDict, String inputFile)
    {
        try
        {
            FileReader reader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String puzzleWord;
            while ((puzzleWord = bufferedReader.readLine()) != null)
            {
                String sortedWord = sortWord(puzzleWord);
                System.out.println(puzzleWord + ": " + inputWordDict.get(sortedWord));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to take a string and return the string
     * sorted in alphabetical order.
     * @param word the word that needs to be sorted.
     * @return sortedWord the word sorted alphabetically.
     */
    private String sortWord(String word)
    {
        char[] tempChars = word.toLowerCase().toCharArray();
        Arrays.sort(tempChars);
        String sortedWord = new String(tempChars);
        return sortedWord;
    }
}
