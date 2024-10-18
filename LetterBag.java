import java.util.*;

/**
 * The LetterBag class contains the dictionary of letters and words to be used in the game
 * @author Elyssa Grant, Gillian O'Connel, John Khalife, Sandy Alzabadani
 * @date 08/10/2024
 */
public class LetterBag {
    private static Dictionary<Letter,Integer> letters;
    private static List<Letter> letterList = new ArrayList<>(); // Maintain state across method calls
    private static Random random = new Random();


    public static void createBag(){
        letters = new Hashtable<Letter, Integer>();
        Letter letterA = new Letter('a',1);
        Letter letterB = new Letter('b',3);
        Letter letterC = new Letter('c',3);
        Letter letterD = new Letter('d',2);
        Letter letterE = new Letter('e',1);
        Letter letterF = new Letter('f',4);
        Letter letterG = new Letter('g',2);
        Letter letterH = new Letter('h',4);
        Letter letterI = new Letter('i',1);
        Letter letterJ = new Letter('j',8);
        Letter letterK = new Letter('k',5);
        Letter letterL = new Letter('l',1);
        Letter letterM = new Letter('m',3);
        Letter letterN = new Letter('n',1);
        Letter letterO = new Letter('o',1);
        Letter letterP = new Letter('p',3);
        Letter letterQ = new Letter('q',10);
        Letter letterR = new Letter('r',1);
        Letter letterS = new Letter('s',1);
        Letter letterT = new Letter('t',1);
        Letter letterU = new Letter('u',1);
        Letter letterV = new Letter('v',4);
        Letter letterW = new Letter('w',4);
        Letter letterX = new Letter('x',8);
        Letter letterY = new Letter('y',4);
        Letter letterZ = new Letter('z',10);

        letters.put(letterA,9);
        letters.put(letterB,2);
        letters.put(letterC,3);
        letters.put(letterD,4);
        letters.put(letterE,5);
        letters.put(letterF,6);
        letters.put(letterG,7);
        letters.put(letterH,8);
        letters.put(letterI,9);
        letters.put(letterJ,2);
        letters.put(letterK,3);
        letters.put(letterL,4);
        letters.put(letterM,5);
        letters.put(letterN,6);
        letters.put(letterO,7);
        letters.put(letterP,8);
        letters.put(letterQ,9);
        letters.put(letterR,2);
        letters.put(letterS,5);
        letters.put(letterT,6);
        letters.put(letterU,7);
        letters.put(letterV,8);
        letters.put(letterW,9);
        letters.put(letterX,2);
        letters.put(letterY,3);
        letters.put(letterZ,4);

        for(Enumeration<Letter> e = letters.keys();e.hasMoreElements();) {
            Letter letter = e.nextElement();
            int number = letters.get(letter);
            for (int i = 0; i < number; i++) {
                letterList.add(letter);
            }
        }

    }

    public static Letter getNextLetter(){
        if (letterList.isEmpty()) {
            return null; // No letters in the bag
        }

        int index = random.nextInt(letterList.size());
        Letter selectedLetter = letterList.get(index);

        int remainingCount = letters.get(selectedLetter) - 1;
        if (remainingCount > 0) {
            letters.put(selectedLetter, remainingCount);
        } else {
            letters.remove(selectedLetter);

        }

        letterList.remove(index); // Update the list to reflect the removal

        return selectedLetter;

    }

    public static void addLetter(Letter tempLetter) {
        letters.put(tempLetter, letters.get(tempLetter) + 1);
    }
}
