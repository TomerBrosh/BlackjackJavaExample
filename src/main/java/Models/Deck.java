package Models;

import Controllers.DeckController;

import java.util.Random;

/**
 * Created by hackeru on 27/11/2016.
 */
public class Deck {

    public int cards[];
    public int topCard;
    public Random random;

    public Deck() {
        cards = new int[52];
        for (int i = 0; i < 52; ++i) cards[i] = i;
        topCard = 0;
        random = new Random();
    }

}