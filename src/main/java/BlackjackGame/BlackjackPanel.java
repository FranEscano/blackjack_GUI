package BlackjackGame;

import javax.swing.*;
import java.awt.*;

// The class representing the main panel for the Blackjack game GUI
public class BlackjackPanel extends JPanel {

    // Instance variable to hold the BlackjackGame instance
    private final BlackjackGame blackjackGame;

    // Constructor for the BlackjackPanel
    public BlackjackPanel(){
        // Set the layout manager for this panel to BorderLayout
        setLayout(new BorderLayout());

        // Create a JTextArea for displaying game information with 10 rows and 30 columns
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        // Wrap the JTextArea in a JScrollPane for scrolling functionality
        JScrollPane scrollPane = new JScrollPane(textArea);
        // Add the JScrollPane to the center of the panel
        add(scrollPane, BorderLayout.CENTER);

        // Create a JPanel for holding buttons at the bottom of the panel
        JPanel buttonPanel = new JPanel();

        // Create buttons for Hit, Stand, Play Again, and Close
        JButton hitButton = new JButton("Hit");
        JButton standButton = new JButton("Stand");
        JButton playAgainButton = new JButton("Play Again");
        JButton closeButton = new JButton("Close");

        // Add the buttons to the buttonPanel
        buttonPanel.add(hitButton);
        buttonPanel.add(standButton);
        buttonPanel.add(playAgainButton);
        buttonPanel.add(closeButton);

        // Add the buttonPanel to the bottom of the main panel
        add(buttonPanel, BorderLayout.SOUTH);

        // Create an instance of BlackjackGame, passing in the components for interaction
        blackjackGame = new BlackjackGame(textArea, hitButton, standButton, playAgainButton);

        // Start the Blackjack game logic
        blackjackGame.playBlackjack();

        // Add action listeners for the buttons to respond to user input
        hitButton.addActionListener(e -> blackjackGame.playerHit());
        standButton.addActionListener(e -> blackjackGame.playerStand());
        playAgainButton.addActionListener(e -> blackjackGame.playAgain());
        closeButton.addActionListener(e -> System.exit(0));
    }
}
