package LottoGame;

import java.util.TreeSet;

import static LottoGame.ConsoleMessages.*;

public class InputChecker
{
    private static final int RANGE_LIMIT = 99;
    public static boolean isInputValid(String input, TreeSet<Integer> alreadyChosenNumbers)
    {
        if(!isTextANumber(input)) {return false;}
        return isNumberCorrect(Integer.parseInt(input), alreadyChosenNumbers);
    }

    private static boolean isTextANumber(String text)
    {
        try
        {
            Integer.parseInt(text);
        }
        catch (Exception e)
        {
            makeCommunicat(NOT_A_NUMBER);
            return false;
        }

        return true;
    }

    private static boolean isNumberCorrect(int number, TreeSet<Integer> chosenNumbers)
    {
        //conditions
        if (number <= 0) {makeCommunicat(NEGATIVE_NUMBER); return false;}
        if (number > RANGE_LIMIT) {makeCommunicat(OUT_OF_RANGE); return false;}
        if (chosenNumbers.contains(number)) {makeCommunicat(DUPLICATE_NUMBER); return false;}

        return true;
    }
}
