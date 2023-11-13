package BlackjackGame;

import javax.swing.*;

// The main class for the Blackjack GUI application
public class BlackjackGUI {
    // The main method, the entry point of the program
    public static void main(String[] args) {
        // Execute the Swing GUI code in the event dispatch thread
        SwingUtilities.invokeLater(() -> {
            // Create a new JFrame (window) with the title "Blackjack Game"
            JFrame frame = new JFrame("Blackjack Game");

            // Set the default close operation to exit the program when the window is closed
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Add a new instance of BlackjackPanel to the content pane of the JFrame
            frame.getContentPane().add(new BlackjackPanel());

            // Pack the components in the JFrame to their preferred size
            frame.pack();

            // Set the location of the JFrame to the center of the screen
            frame.setLocationRelativeTo(null);

            // Make the JFrame visible to the user
            frame.setVisible(true);
        });
    }
}
