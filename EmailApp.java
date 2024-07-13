// PSEUDOCODE ALGORITHM
// Project initialization
// User login
// Main Email Interface
// Compose email and send
// Configure backend
// Display success or error messages

import javax.swing.*;

public class EmailApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmailGUI emailGUI = new EmailGUI();
            emailGUI.setVisible(true);
        });
    }
}
