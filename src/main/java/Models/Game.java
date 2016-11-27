package Models;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by hackeru on 27/11/2016.
 */
public class Game {

    private static Game gameInstance = null;
    private Hand playersHand;
    private Deck deck;
    private Hand dealersHand;
    private DataInputStream keyboardInput;
    private boolean didPlayerWin = false;
    private boolean isPlayerTurn = true;
    private boolean isGameEnded = false;
    private boolean didPlayerStand = false;
    private boolean didDealerStand = false;

    private Game() {
        keyboardInput = new DataInputStream(System.in);
        deck = new Deck();
    }

    public static Game getInstance() {
        if (gameInstance == null) {
            gameInstance = new Game();
        }

        return gameInstance;
    }

    public void play() throws IOException {
        System.out.println(PrintHelper.ANSI_GREEN + "Welcome to Blackjack!" + PrintHelper.ANSI_BLACK);
        initialDeal();
        while (!isGameEnded) {
            if (isPlayerTurn) {
                int action = getAction();
                switch (action) {
                    case 1:
                        PrintHelper.printYellow("Player Hit!");
                        playersHand.addCard(deck.deal());
                        playersHand.show(true);
                        didPlayerStand = false;
                        break;
                    case 2:
                        PrintHelper.printYellow("Player Stand!");
                        didPlayerStand = true;
                        break;
                }

            } else {
                if (dealersHand.getScore() < 17) {
                    dealersHand.addCard(deck.deal());
                    dealersHand.show(false);
                    didDealerStand = false;
                } else {
                    PrintHelper.printPurple("Dealer Stand!");
                    didDealerStand = true;
                }
            }
            endTurn();
            if (isGameEnded) {
                PrintHelper.printCyan("Press 1 to start again. ");
                System.out.flush();
                try {
                    int action = Integer.parseInt(keyboardInput.readLine());

                    switch (action) {
                        case 1:
                            isGameEnded = false;
                            initialDeal();
                            break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private int getAction() {
        boolean isReady = false;
        int action = -1;
        while (!isReady) {
            System.out.print("Press 1 for Hit and 2 for Stand: ");
            System.out.flush();
            try {
                action = Integer.parseInt(keyboardInput.readLine());

                switch (action) {
                    case 1:
                    case 2:
                        isReady = true;
                        break;
                    default:
                        System.out.print("Invalid input...");
                        System.out.flush();
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return action;
    }


    private void initialDeal() {
        System.out.println("New hand...");

        playersHand = new Hand();
        dealersHand = new Hand();

        for (int i = 0; i < 2; ++i) {
            playersHand.addCard(deck.deal());
        }

        dealersHand.addCard(deck.deal());
        dealersHand.show(false, true);
        playersHand.show(true, false);
    }

    private void playerWins() {
        PrintHelper.printGreen("Player Wins with:");
        System.out.println(PrintHelper.ANSI_GREEN + "---------------------");
        playersHand.printHand(true);
        System.out.println(PrintHelper.ANSI_GREEN + "---------------------" + PrintHelper.ANSI_RESET);
    }

    private void dealerWins() {
        PrintHelper.printRed("Dealer Wins");
    }

    private void endTurn() {
        if (isPlayerTurn) {
            isPlayerTurn = false;
            if (playersHand.isBusted()) {
                PrintHelper.printRed("Player's hand is Busted");
                dealerWins();
                isGameEnded = true;
            } else if (playersHand.getScore() == 21) {
                PrintHelper.printGreen("Blackjack!");
                playerWins();
                isGameEnded = true;
            }
        } else {
            isPlayerTurn = true;
            if (dealersHand.isBusted()) {
                PrintHelper.printGreen("Dealer's hand is Busted");
                playerWins();
                isGameEnded = true;
            } else if (dealersHand.getScore() == 21) {
                PrintHelper.printRed("Blackjack!");
                dealerWins();
                isGameEnded = true;
            }
        }

        if (didDealerStand && didPlayerStand) {
            if (dealersHand.getScore() > playersHand.getScore()) dealerWins();
            if (playersHand.getScore() > dealersHand.getScore()) playerWins();
            if (playersHand.getScore() == dealersHand.getScore()) dealerWins();
            isGameEnded = true;
        }
    }
}
