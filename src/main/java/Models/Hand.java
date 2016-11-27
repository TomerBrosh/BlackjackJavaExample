package Models;

/**
 * Created by hackeru on 27/11/2016.
 */
public class Hand {

    private static int MAX_CARDS = 12;

    private Card cards[];
    private int cardsAmount;

    public Hand() {
        cardsAmount = 0;
        cards = new Card[MAX_CARDS];
    }

    void addCard(Card c) {
        cards[cardsAmount] = c;
        ++cardsAmount;
    }

    void show(boolean isUser, boolean hideFirstCard) {
        String name = isUser ? "Player" : "Dealer";
        if (isUser) PrintHelper.printYellow(" " + name + ":");
        else PrintHelper.printPurple(" " + name + ":");
        for (int i = 0; i < cardsAmount; ++i) {
            if (i == 0 && hideFirstCard) PrintHelper.printRed("   Hidden");
            else PrintHelper.printCard(cards[i]);
        }
        if (isUser)
        PrintHelper.printBlue("----- " + name + "'s score: " + getScore() + " -----");
        System.out.println();

    }

    void show(boolean isUser) {
        String name = isUser ? "Player" : "Dealer";
        if (isUser) PrintHelper.printYellow(" " + name + ":");
        else PrintHelper.printPurple(" " + name + ":");
        printHand();
        PrintHelper.printBlue("----- " + name + "'s score: " + getScore() + " -----");
        System.out.println();
    }

    public void printHand(){
        for (int i = 0; i < cardsAmount - 1; ++i) {
            PrintHelper.printCard(cards[i]);
        }
        System.out.println(PrintHelper.ANSI_GREEN + " +");
        PrintHelper.printCard(cards[cardsAmount - 1]);
    }
    public void printHand(boolean didGameEnd){
        for (int i = 0; i < cardsAmount; ++i) {
            PrintHelper.printCard(cards[i]);
        }
    }



    public int getScore() {
        int points = 0;
        boolean haveAce = false;
        for (int i = 0; i < cardsAmount; ++i) {
            points += cards[i].weight;
            if (cards[i].weight == 1) haveAce = true;
        }
        if (haveAce) {
            if (points + 10 < 22) points += 10;
        }
        return points;
    }

    boolean isUnder22() {
        int points = 0;
        for (int i = 0; i < cardsAmount; ++i) points += cards[i].weight;
        if (points < 22) return true;
        else return false;
    }

    boolean isBusted() {
        if (!isUnder22()) return true;
        else return false;
    }
}
