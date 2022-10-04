package LottoGame;

import java.util.*;

import static LottoGame.ConsoleMessages.*;

public class LottoGame
{
    private final Scanner sc = new Scanner(System.in);
    private TreeSet<Integer> chosenNumbers, winningNumbers;


    public void PlayLotto()
    {
        ResetCurrentNumberIndex();
        chosenNumbers = new TreeSet<>();

        retrieveNumbersFromUser();

        winningNumbers = WinningNumbersGenerator.getWinningNumbersFromRange(1, 100);

        System.out.println("");

        printNumbers(chosenNumbers);
        printNumbers(winningNumbers);

        makeCommunicat("Udało się trafić " + howManyCorrectNumbers() + " liczb");
    }

    private void retrieveNumbersFromUser()
    {
        while (chosenNumbers.size() < 6)
        {
            int chosenNumber = retrieveValidNumberFromUser();
            chosenNumbers.add(chosenNumber);
        }
        sc.close();
    }

    private int retrieveValidNumberFromUser()
    {
        do
        {
            makeCommunicat(GETTING_NUMBER_FROM_USER);
            String textFormUser = sc.next();

            if (InputChecker.isInputValid(textFormUser, chosenNumbers))
            {
                IncreaseCurrentNumberIndex();
                //here "parseInt' always valid, won't generate an error
                return Integer.parseInt(textFormUser);
            }
        }
        while(true);

    }

    private int howManyCorrectNumbers()
    {
        int howManyCorrectNumbers = 0;
        for (int n : chosenNumbers)
        {
            if (winningNumbers.contains(n)) howManyCorrectNumbers++;
        }
        return howManyCorrectNumbers;
    }
}
