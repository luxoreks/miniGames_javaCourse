package LottoGame;

import java.util.TreeSet;

public class ConsoleMessages
{
    public static final int GETTING_NUMBER_FROM_USER = 0;
    public static final int NOT_A_NUMBER = 1;
    public static final int OUT_OF_RANGE = 2;
    public static final int NEGATIVE_NUMBER = 3;
    public static final int DUPLICATE_NUMBER = 4;


    private static int currentNumberIndex = 1;

    public static void makeCommunicat(int communicatIndex)
    {
        switch (communicatIndex) {
            case GETTING_NUMBER_FROM_USER -> System.out.print("wpisz liczbę numer " + currentNumberIndex + ": ");
            case NOT_A_NUMBER -> System.out.println("To nie jest liczba");
            case OUT_OF_RANGE -> System.out.println("Liczba spoza zakresu");
            case NEGATIVE_NUMBER -> System.out.println("Liczba musi być dodatnia");
            case DUPLICATE_NUMBER -> System.out.println("Liczba już została wybrana");
        }
    }

    public static void makeCommunicat(String communicat)
    {
        System.out.println(communicat);
    }

    public static void printNumbers(TreeSet<Integer> numbers)
    {
        for (int number : numbers)
        {
            System.out.printf("%-3s", number);
        }
        System.out.println("");
    }

    public static void IncreaseCurrentNumberIndex(){
        currentNumberIndex++;
    }

    public static void ResetCurrentNumberIndex(){
        currentNumberIndex = 1;
    }
}
