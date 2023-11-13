package BlackjackGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Represents a player in the Blackjack game
public class Player {

    // Instance variables to store player information
    String name;
    List<String> hand;
    Deck deck;
    private int sumOfValues;

    // Constructor for creating a new player with a specified name and deck
    public Player(String name, Deck deck) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.deck = deck;
    }

    // Getter method for retrieving the sum of card values
    public int getSumOfValues() {
        return sumOfValues;
    }

    // Setter method for updating the sum of card values
    public void setSumOfValues(int sumOfValues) {
        this.sumOfValues = sumOfValues;
    }

    // Method for adding a card to the player's hand
    public void addCard(){
        // Draw a card from the deck and retrieve card information
        deck.drawCard();
        String card = deck.getPath().get("cards[0].code");
        String stringCardValue = deck.getPath().get("cards[0].value");

        // Convert card value to an integer
        int cardValue = intCardValue(stringCardValue);

        // Add the card to the player's hand and update the sum of values
        hand.add(card);
        sumOfValues += cardValue;

        // Update the sum of values using the setter method
        setSumOfValues(sumOfValues);
    }

    // Method to convert a string card value to an integer
    public int intCardValue(String stringCardValue){
        int cardValue;

        // Check if the card value is a face card (King, Queen, Jack)
        if (Objects.equals(stringCardValue, "KING") || Objects.equals(stringCardValue, "QUEEN") || Objects.equals(stringCardValue, "JACK")){
            cardValue = 10;
        }
        // Check if the card value is an Ace
        else if (Objects.equals(stringCardValue, "ACE")) {
            cardValue = 11;
        }
        // For numeric cards, convert the string to an integer
        else {
            cardValue = Integer.parseInt(stringCardValue);
        }

        return cardValue;
    }

    // Method to check for Aces in the hand and adjust the sum of values if necessary
    public void checkForAces(List<String> hand){
        int currentScore = getSumOfValues();

        // Check if the hand contains an Ace and if the current score is over 21
        if (hand.contains("A") && currentScore > 21){
            // Adjust the sum of values by subtracting 10 (Ace value can be 1 or 11)
            setSumOfValues(currentScore - 10);
        }
    }
}