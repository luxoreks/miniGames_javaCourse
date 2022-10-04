package LottoGame;

import java.util.*;

public class WinningNumbersGenerator
{
    private final static Random rnd = new Random();

    public static TreeSet<Integer> getWinningNumbersFromRange(int min, int max)
    {
        TreeSet<Integer> winningNumbers = new TreeSet<>();
        while (winningNumbers.size() < 6)
        {
            int number = rnd.nextInt(min, max); //preferowany zakres liczb od 1 do 99
            winningNumbers.add(number);
        }

        return winningNumbers;
    }
}
