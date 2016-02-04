import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This program demonstrates how to read characters from a text file
 * using a BufferedReader for efficiency.
 * @author www.codejava.net
 *ArrayList<char> testWord = "Hello".toCharArray();
 */
        public class TextFileReadingExample3 {

            public static void main(String[] args) {
                HashMap <String, String> wordDict = new HashMap<String, String>();
                try {
                    FileReader reader = new FileReader("wordList.txt");
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    String line;

                    while ((line = bufferedReader.readLine()) != null)
                    {
                        if(line.startsWith("v")) {
                            wordDict.put(sortWord(line), line);
                        }
                    }
                    reader.close();
                    solvePuzzle(wordDict);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private static void solvePuzzle(HashMap inputHashMap)
            {
                try
                {
                    FileReader reader = new FileReader("quizWords.txt");
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String puzzleWord;
                    while ((puzzleWord = bufferedReader.readLine()) != null)
                    {
                        String sortedWord = sortWord(puzzleWord);
                        System.out.println(puzzleWord + ": " + inputHashMap.get(sortedWord));
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /**
             * Method to take a string and return the string
             * sorted in alphabetical order.
             *
             * @return
             */
            private static String sortWord(String word)
            {
                char[] tempChars = word.toLowerCase().toCharArray();
                Arrays.sort(tempChars);
                String sortedWord = new String(tempChars);
                return sortedWord;
            }
        }