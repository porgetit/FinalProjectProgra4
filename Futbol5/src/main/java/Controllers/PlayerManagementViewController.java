package Controllers;

import Connector.Delete;
import Connector.Recover;
import Models.Match;
import Models.Player;
import Views.PlayerManagementView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kevin Esguerra Cardona
 */
public class PlayerManagementViewController implements ActionListener {
    private PlayerManagementView view;
    private Match match;

    public PlayerManagementViewController(Match match) {
        view = new PlayerManagementView();
        this.match = match;

        view.ButtonSearch.addActionListener(this);
        view.ButtonNew.addActionListener(this);
        view.ButtonChange.addActionListener(this);
        view.ButtonDelete.addActionListener(this);
        view.ButtonExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();

        if (button == view.ButtonSearch) {
            // Implement search functionality
            String playerIdText = view.InputId.getText();
            if (!playerIdText.isEmpty()) {
                int playerId = Integer.parseInt(playerIdText);

                // Use Recover class to retrieve player data
                Player player = Recover.toSelectByID(playerId);

                // Update the view with the retrieved player data
                view.InputId.setText(String.valueOf(player.getId()));
                view.InputName.setText(player.getName());
            }
        } else if (button == view.ButtonNew) {
            // Open the Player Registration view
            PlayerRegistrationViewController registrationController = new PlayerRegistrationViewController();
            registrationController.init();
        } else if (button == view.ButtonChange) {
            // Implement logic to change player data
            // You can interact with the Match model or other components as needed
        } else if (button == view.ButtonDelete) {
            // Implement logic to delete a player
            String playerIdText = view.InputId.getText();
            if (!playerIdText.isEmpty()) {
                int playerId = Integer.parseInt(playerIdText);

                // Use Delete class to delete the player
                Delete.toDelete(playerId);

                // Show a popup indicating successful deletion
                new PopupViewController().init("Player deleted successfully!");

                // Clear the fields in the view after deletion
                view.InputId.setText("");
                view.InputName.setText("");
            }
        } else if (button == view.ButtonExit) {
            view.dispose();  // Close the view
        }
    }

    public void init() {
        view.setTitle("Futbol 5");
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
