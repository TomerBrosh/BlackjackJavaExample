package Models;

import java.util.Random;

/**
 * Created by hackeru on 27/11/2016.
 */
public class Deck {
    int cards[];
    int topCard;
    Random random;

    public Deck() {

        cards = new int[52];
        for (int i = 0; i < 52; ++i) cards[i] = i;
        topCard = 0;
        random = new Random();
        reorder();
    }

    public void reorder() {
        for (int i = 0; i < 52; ++i) {
            int a = randomCard();
            int b = randomCard();
            int temp = cards[a];
            cards[a] = cards[b];
            cards[b] = temp;
        }
    }

    private int randomCard() {
        int r = random.nextInt();
        if (r < 0) r = 0 - r;
        return r % 52;
    }

    Card deal() {
        if (topCard > 51) {
            reorder();
            topCard = 0;
        }
        Card card = new Card(cards[topCard]);
        ++topCard;
        return card;
    }
}