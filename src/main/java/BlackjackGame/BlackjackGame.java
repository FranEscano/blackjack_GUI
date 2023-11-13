package BlackjackGame;

import javax.swing.*;

// The main class representing the logic for the Blackjack game
public class BlackjackGame {
    // Instance variables to hold the deck and player/dealer objects
    private final Deck deck;
    private final Player player;
    private final Player dealer;

    // Instance variables to hold GUI components for interaction
    private final JTextArea textArea;
    private final JButton hitButton;
    private final JButton standButton;
    private final JButton playAgainButton;

    // Constructor for the BlackjackGame class
    public BlackjackGame(JTextArea textArea, JButton hitButton, JButton standButton, JButton playAgainButton) {
        // Initialize the deck and player/dealer objects
        this.deck = new Deck();
        this.player = new Player("Player", deck);
        this.dealer = new Player("Dealer", deck);

        // Initialize GUI components
        this.textArea = textArea;
        this.hitButton = hitButton;
        this.standButton = standButton;
        this.playAgainButton = playAgainButton;
    }

    // Method to start the Blackjack game
    public void playBlackjack() {
        // Disable the playAgainButton initially
        playAgainButton.setEnabled(false);
        // Display a welcome message in the textArea
        updateTextArea("Welcome to Blackjack!");

        // Create a new deck of cards
        deck.newDeckOfCards();

        // Show the starting cards for the player and dealer
        player.addCard();
        dealer.addCard();
        player.addCard();
        dealer.addCard();

        // Display the initial state of the game in the textArea
        updateTextArea("\nYour cards: " +player.hand);
        updateTextArea("\nYour score: " +player.getSumOfValues());
        updateTextArea("\nDealer's cards: [**, **]");
        updateTextArea("\nDealer's score: **");

    }

    // Private method to update the textArea with a given message
    private void updateTextArea(String message){
        textArea.append(message);
    }

    // Method called when the player chooses to hit
    public void playerHit(){
        // Player draws a card, updates the textArea, and checks for aces
        player.addCard();
        player.checkForAces(player.hand);
        updateTextArea("\nYou drew a car.\nYour cards: " +player.hand);
        updateTextArea("\nYour score: " +player.getSumOfValues());

        // If the player's score exceeds 21, end the game
        if (player.getSumOfValues() > 21){
            endGame();
        }
    }

    // Method called when the player chooses to stand
    public void playerStand(){
        // Dealer draws cards until their score is at least 17
        while (dealer.getSumOfValues() < 17){
            dealer.addCard();
        }

        // Display the dealer's final state and end the game
        updateTextArea("\nDealer's turn:\nDealer's cards: " +dealer.hand);
        updateTextArea("\nDealer's score: " +dealer.getSumOfValues());
        endGame();
    }

    // Private method to handle the end of the game
    private void endGame(){
        // Disable hit and stand buttons, enable playAgainButton
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
        playAgainButton.setEnabled(true);

        // Display game over message and final states of player and dealer
        updateTextArea("==================================================");
        updateTextArea("\nGame Over!\n");
        updateTextArea("You drew a car.\nYour cards: " +player.hand);
        updateTextArea("\nYour score: " +player.getSumOfValues());
        updateTextArea("\nDealer's turn:\nDealer's cards: " +dealer.hand);
        updateTextArea("\nDealer's score: " +dealer.getSumOfValues());

        // Determine the winner and display the result
        determineWinner();
    }

    // Private method to determine the winner of the game
    private void determineWinner(){
        if (player.getSumOfValues() > 21 || (dealer.getSumOfValues() <= 21 && dealer.getSumOfValues() >= player.getSumOfValues())) {
            updateTextArea("\nDealer wins!");
        } else {
            updateTextArea("\nYou are a star! Congratulations! You won!");
        }
        updateTextArea("==================================================");
    }

    // Method called when the player chooses to play the game again
    public void playAgain(){
        // Reset player and dealer states, enable hit and stand buttons, and start a new game
        player.hand.clear();
        player.setSumOfValues(0);
        dealer.hand.clear();
        dealer.setSumOfValues(0);
        hitButton.setEnabled(true);
        standButton.setEnabled(true);
        playBlackjack();
    }

}

