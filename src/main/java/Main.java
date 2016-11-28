import Controllers.GameController;

import java.io.IOException;

/**
 * Created by hackeru on 27/11/2016.
 */
public class Main {
    public static void main(String args[]) throws IOException {
//            Card[] cardList = new Card[]{new Card(0),new Card(13),new Card(26),new Card(39),new Card(51)};
//            PrintHelper.printCardArray(cardList);
        GameController.getInstance().play();
    }
}
