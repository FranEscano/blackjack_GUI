# Blackjack Game

This repository contains a simple implementation of a Blackjack game in Java, using Swing for the graphical user interface. The game is structured into several classes to manage the game logic, player actions, and interactions with a remote card API.

## Files and Classes

### `BlackjackGUI.java`

This class sets up the main graphical user interface (GUI) for the Blackjack game. It creates a JFrame, adds a BlackjackPanel to it, and handles the initialization of the game.

### `BlackjackPanel.java`

The `BlackjackPanel` class represents the main panel for the Blackjack game GUI. It includes a JTextArea for displaying game information and JButtons for player actions (Hit, Stand, Play Again, Close). The panel interacts with the game logic through the `BlackjackGame` class.

### `BlackjackGame.java`

The `BlackjackGame` class contains the game logic for the Blackjack game. It manages the deck, player actions, and determines the winner. This class communicates with the GUI components in the `BlackjackPanel` class.

### `Player.java`

The `Player` class represents a player in the Blackjack game. It has methods for adding a card to the player's hand, converting card values to integers, and checking for Aces. The class also interacts with the `Deck` class.

### `Deck.java`

The `Deck` class interacts with a remote card API to manage a deck of cards. It includes methods for requesting a new deck and drawing a card from the current deck.

## Getting Started

To run the Blackjack game, you can compile and execute the `BlackjackGUI.java` file. Make sure you have Java and the necessary dependencies installed.

```bash
javac BlackjackGame/BlackjackGUI.java
java BlackjackGame.BlackjackGUI
```

## Dependencies
Java
RestAssured (for interacting with the card API)
io.restassured.path.json.JsonPath

## Acknowledgments
This project was inspired by the classic Blackjack card game. The implementation uses Java and Swing for the GUI, and RestAssured for interacting with the card API.

Feel free to explore and enhance the game or use it as a starting point for your own projects!

Enjoy playing Blackjack!
