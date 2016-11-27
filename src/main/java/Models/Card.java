package Models;

/**
 * Created by hackeru on 27/11/2016.
 */
public class Card {

    int weight;
    CardValue value;
    CardSuit suit;

    public enum CardValue {
        N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, J, Q, K, A;


        @Override
        public String toString() {
            return super.toString();
        }
    }

    public enum CardSuit {
        Spades, Hearts, Clubs, Diamonds
    }

    public Card(int n) {
        int iSuit = n / 13;
        weight = n % 13 + 1;
        switch (iSuit) {
            case 0:
                suit = CardSuit.Spades;
                break;
            case 1:
                suit = CardSuit.Hearts;
                break;
            case 2:
                suit = CardSuit.Clubs;
                break;
            default:
                suit = CardSuit.Diamonds;
        }
        if (weight == 1) value = CardValue.A;
        else if (weight == 10) value = CardValue.N10;
        else if (weight == 11) value = CardValue.J;
        else if (weight == 12) value = CardValue.Q;
        else if (weight == 13) value = CardValue.K;
        else value = CardValue.valueOf("N" + weight);
        if (weight > 10) weight = 10;
    }

    @Override
    public String toString() {
        if (value == CardValue.A) return "   A" + " of " + suit;
        else if (value == CardValue.J) return "   J" + " of " + suit;
        else if (value == CardValue.Q) return "   Q" + " of " + suit;
        else if (value == CardValue.K) return "   K" + " of " + suit;
        else return "   " + value.toString().substring(1) + " of " + suit;
    }

    public int getValue() {
        return weight;
    }

    public void Print() {
        PrintHelper.printCard(this);
    }

 }
