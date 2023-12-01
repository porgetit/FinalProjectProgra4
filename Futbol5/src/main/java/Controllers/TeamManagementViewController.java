package Controllers;

import Models.Match;
import Models.Player;
import Views.TeamManagementView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Controller class for the Team Management View.
 * Manages the initialization of the view and handles user actions.
 * 
 * @author Kevin Esguerra Cardona
 */
public class TeamManagementViewController implements ActionListener {
    private final TeamManagementView view;
    private final Match match;

    public TeamManagementViewController(Match match) {
        this.match = match;
        view = new TeamManagementView();

        // Set up the table with default data
        initTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void init() {
        view.setTitle("Futbol 5 - Team Management");
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    // Initialize the table with default and database data
    private void initTable() {
        // Assuming you have a method in Match or a dedicated class to retrieve player data
        ArrayList<Player> playerList = match.retrievePlayerData();

        // Create a DefaultTableModel with columns: ID, Name, State, Team
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Name", "State", "Team"}, 0);

        // Add rows to the model based on the retrieved player data
        for (int i = 0; i < 20; i++) {
            if (i < playerList.size()) {
                Player player = playerList.get(i);
                model.addRow(new Object[]{player.getId(), player.getName(), player.getSubscriptionType(), "None"});
            } else {
                // If no data available, fill with default values
                model.addRow(new Object[]{0, "No name", "No state", "None"});
            }
        }
    }
}
