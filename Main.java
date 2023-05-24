package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {


        String dataOption = args.length > 1 ? args[1] : "word";

        DataType dataType;

        switch(dataOption) {
            case "long":
                dataType = DataType.LONG;
                break;
            case "line":
                dataType = DataType.LINE;
                break;
            default:
                dataType = DataType.WORD;
        }

        switch(dataType) {
            case LONG:
                processLongs();
                break;
            case LINE:
                processLines();
                break;
            default:
                processWords();
        }




    }

    private static void processWords() {
        Scanner scanner = new Scanner(System.in);

        String longestWord = scanner.next();
        float totalWords = 1;
        float occurrencesLongestWord = 1;
        while (scanner.hasNext()) {
            String word = scanner.next();
            totalWords++;
            if (word.length() > longestWord.length()) {
                longestWord = word;
                occurrencesLongestWord = 1;
            } else if (word.length() == longestWord.length()) {
                occurrencesLongestWord++;
            }
        }

        System.out.printf("Total words: %.0f. \n", totalWords);
        float percentage = (occurrencesLongestWord * 100.0f) / totalWords;
        System.out.printf("The longest word: %s (%.0f time(s), %.0f%%).\n", longestWord, occurrencesLongestWord, percentage);
    }

    private static void processLines() {
        Scanner scanner = new Scanner(System.in);

        String longestLine = scanner.nextLine();
        float totalLines = 1;
        float occurrencesLongestLine = 1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            totalLines++;
            if (line.length() > longestLine.length()) {
                longestLine = line;
                occurrencesLongestLine = 1;
            } else if (line.length() == longestLine.length()) {
                occurrencesLongestLine++;
            }
        }

        System.out.printf("Total lines: %.0f. \n", totalLines);
        float percentage = (occurrencesLongestLine * 100.0f) / totalLines;
        System.out.printf("The greatest number:\n%s\n(%.0f time(s), %.0f%%).\n", longestLine, occurrencesLongestLine, percentage);

    }

    private static void processLongs() {
        Scanner scanner = new Scanner(System.in);

        float totalNumbers = 1;
        long maxNumber = scanner.nextLong();
        float occurrencesMaxNumber = 1;
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            // write your code here
            totalNumbers++;
            if (number > maxNumber) {
                maxNumber = number;
                occurrencesMaxNumber = 1;
            } else if (number == maxNumber) {
                occurrencesMaxNumber++;
            }
        }

        System.out.printf("Total numbers: %.0f. \n", totalNumbers);
        float percentage = (occurrencesMaxNumber * 100.0f) / totalNumbers;
        System.out.printf("The greatest number: %d (%.0f time(s), %.0f%%).\n", maxNumber, occurrencesMaxNumber, percentage);
    }
}

enum DataType {
    LONG, LINE, WORD
}