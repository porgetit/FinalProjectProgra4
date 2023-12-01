/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Connector.Update;
import Models.Player;
import Views.PlayerEditorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kevin Esguerra Cardona
 */
public class PlayerEditorViewController implements ActionListener {
    private final PlayerEditorView view;
    private final int playerId;

    public PlayerEditorViewController(int playerId) {
        this.playerId = playerId;
        view = new PlayerEditorView();

        // Set up the initial state of the view
        Player player = getPlayerById(playerId);
        if (player != null) {
            view.InputName.setText(player.getName());
            if (player.getSubscriptionType().equalsIgnoreCase("Frequent")) {
                view.StateFrequent.setSelected(true);
            } else {
                view.StateOccasional.setSelected(true);
            }
        }

        view.ButtonUpdate.addActionListener(this);
        view.ButtonCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();

        if (button == view.ButtonUpdate && view.ButtonUpdate.getText().equals("Update")) {
            // Switch to the editing state
            view.ButtonUpdate.setText("Confirm");
            view.InputName.setEnabled(true);
            view.StateFrequent.setEnabled(true);
            view.StateOccasional.setEnabled(true);
        } else if (button == view.ButtonUpdate && view.ButtonUpdate.getText().equals("Confirm")) {
            // Perform the update operation
            String updatedName = view.InputName.getText();
            String updatedState = view.StateFrequent.isSelected() ? "Frequent" : "Occasional";

            // Use the Update class to update the player information
            Update.toUpdate(playerId, updatedName, updatedState);

            // Show a popup indicating successful update
            new PopupViewController().init("Player updated successfully!");

            // Reset the view to the initial state
            view.InputName.setEnabled(false);
            view.StateFrequent.setEnabled(false);
            view.StateOccasional.setEnabled(false);
            view.ButtonUpdate.setText("Update");
        } else if (button == view.ButtonCancel) {
            // Cancel the update operation
            view.dispose();
        }
    }

    public void init() {
        view.setTitle("Futbol 5 - Player Editor");
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.StateFrequent.setSelected(true);
    }

    // Sample method to retrieve player information by ID (replace with your actual data retrieval logic)
    private Player getPlayerById(int playerId) {
        // Replace this with your actual data retrieval logic
        // For now, returning a sample player
        return new Player(playerId, "Sample Player", "Frequent");
    }
}
