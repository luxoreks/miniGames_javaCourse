package app.LottoGame;

import app.Game;

import java.util.*;

import static app.LottoGame.ConsoleMessages.*;

public class LottoGame implements Game
{
    private final Scanner sc = new Scanner(System.in);
    private TreeSet<Integer> chosenNumbers, winningNumbers;

    //chosenNumbers nie może być null;
    public LottoGame(){
        chosenNumbers = new TreeSet<>();
    }

    public void play()
    {
        ResetCurrentNumberIndex();

        chosenNumbers = retrieveNumbersFromUser();
        winningNumbers = WinningNumbersGenerator.getWinningNumbersFromRange(1, 100);

        printUserAndWinningNumbers();

        makeCommunicat("Udało się trafić " + howManyNumbersMatch() + " liczb");
    }

    private void printUserAndWinningNumbers(){
        System.out.println("");
        printNumbers(chosenNumbers);
        printNumbers(winningNumbers);
    }

    private TreeSet<Integer> retrieveNumbersFromUser()
    {
        TreeSet<Integer> numbersFromUser = new TreeSet<>();
        while (numbersFromUser.size() < 6)
        {
            numbersFromUser.add(userValidNumberInput());
        }
        sc.close();
        return numbersFromUser;
    }

    private int userValidNumberInput()
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

    private int howManyNumbersMatch()
    {
        int howManyCorrectNumbers = 0;
        for (int n : chosenNumbers)
        {
            if (winningNumbers.contains(n)) howManyCorrectNumbers++;
        }
        return howManyCorrectNumbers;
    }
}
