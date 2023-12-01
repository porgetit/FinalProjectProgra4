/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Connector.Create;
import Views.PlayerRegistrationView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kevin Esguerra Cardona
 */
public class PlayerRegistrationViewController implements ActionListener {
    private PlayerRegistrationView view;

    public PlayerRegistrationViewController() {
        view = new PlayerRegistrationView();
        view.ButtonInsert.addActionListener(this);
        view.ButtonCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();

        if (button == view.ButtonInsert) {
            // Implement logic to insert a new player
            // You can interact with the Match model or other components as needed
            String playerName = view.InputName.getText();
            String playerState = view.StateFrequent.isSelected() ? "Frequent" : "Occasional";

            // Use Create class to insert a new player
            try {
                Create.toInsert(playerName, playerState);

                // Show a popup indicating successful insertion
                PopupViewController popupController = new PopupViewController();
                popupController.init("Player inserted successfully!");

                // Clear the fields in the view after insertion
                view.InputName.setText("");
                view.StateFrequent.setSelected(true);
                view.StateOccasional.setSelected(false);
            } catch (Exception ex) {
                // Handle exceptions related to player insertion
                ex.printStackTrace();
                PopupViewController popupController = new PopupViewController();
                popupController.init("Error inserting player. Please try again.");
            } finally {
                view.dispose();
            }

        } else if (button == view.ButtonCancel) {
            view.dispose();  // Close the view
        }
    }

    public void init() {
        view.setTitle("Futbol 5 - Player Registration");
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
