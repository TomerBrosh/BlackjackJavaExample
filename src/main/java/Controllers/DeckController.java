package Controllers;

import Models.Card;
import Models.Deck;

import java.util.Random;

/**
 * Created by hackeru on 27/11/2016.
 */
public class DeckController {

    private static DeckController deckController;
    private Deck deck;

    public static DeckController getInstance(Deck deck) {
        if (deckController == null) {
            deckController = new DeckController(deck);
        }
        return deckController;
    }

    private DeckController(Deck deck) {
        this.deck = deck;
        reorder();
    }

    public void reorder() {
        for (int i = 0; i < 52; ++i) {
            int a = randomCard();
            int b = randomCard();
            int temp = deck.cards[a];
            deck.cards[a] = deck.cards[b];
            deck.cards[b] = temp;
        }
    }

    private int randomCard() {
        int r = deck.random.nextInt();
        if (r < 0) r = 0 - r;
        return r % 52;
    }

    public Card deal() {
        if (deck.topCard > 51) {
            reorder();
            deck.topCard = 0;
        }
        Card card = new Card(deck.cards[deck.topCard]);
        ++deck.topCard;
        return card;
    }
}