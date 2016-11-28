package Views;

import Models.Card;

import static Views.PrintHelper.*;

/**
 * Created by hackeru on 27/11/2016.
 */
public class CardView {


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
}
