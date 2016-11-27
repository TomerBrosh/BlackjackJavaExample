package Models;

import java.awt.datatransfer.StringSelection;

import static Models.Card.CardSuit.*;

/**
 * Created by hackeru on 27/11/2016.
 */
public class PrintHelper {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void printCard(Card card) {
        switch (card.suit) {
            case Clubs:
            case Spades:
                System.out.print(ANSI_BLACK);
                break;

            case Diamonds:
            case Hearts:
                System.out.print(ANSI_RED);
                break;
        }

        System.out.println(card.toString() + ANSI_RESET);
    }

    public static void printGreen(String string) {
        System.out.println(ANSI_GREEN + string + ANSI_RESET);
    }
    public static void printRed(String string) {
        System.out.println(ANSI_RED + string + ANSI_RESET);
    }
    public static void printYellow(String string) {
        System.out.println(ANSI_YELLOW + string + ANSI_RESET);
    }
    public static void printPurple(String string) {
        System.out.println(ANSI_PURPLE + string + ANSI_RESET);
    }
    public static void printCyan(String string) {
        System.out.println(ANSI_CYAN + string + ANSI_RESET);
    }
    public static void printBlue(String string) {
        System.out.println(ANSI_BLUE + string + ANSI_RESET);
    }

    public static void PrintCardArray(Card[] cardList){
        for (Card card :
                cardList) {
            printCard(card);
        }
    }

}
