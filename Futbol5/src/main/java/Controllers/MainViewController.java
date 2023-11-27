/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Match;
import Views.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 57312
 */
public class MainViewController implements ActionListener{
    private final MainView view;
    private final Match match;

    public MainViewController(Match match) {
        view = new MainView();
        this.match = match;
        
        view.ButtonPlayers.addActionListener(this);
        view.ButtonTeams.addActionListener(this);
        view.ButtonMatch.addActionListener(this);
        view.ButtonExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        
        if (button == view.ButtonPlayers) {
            new PlayerManagementViewController().init();
        } else if (button == view.ButtonTeams) {
            new TeamManagementViewController().init();
        } else if (button == view.ButtonMatch) {
            match.run();
            updateResults();
        } else if (button == view.ButtonExit) {
            view.dispose();
        }
    }
    
    public void init() {
        view.setTitle("Futbol 5");
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        
        updateResults();
        updatePlayers();
    }

    private void updateResults() {
        String teamAResult = "" + match.getTeamA().getVictories() + "/" + match.getTeamA().getDefeats() + "/" + match.getTeamA().getTies();
        view.TeamAResult.setText(teamAResult);
        String teamBResult = "" + match.getTeamB().getVictories() + "/" + match.getTeamB().getDefeats() + "/" + match.getTeamB().getTies();
        view.TeamBResult1.setText(teamBResult);
    }

    private void updatePlayers() {
        updatePlayersTeamA();
        updatePlayersTeamB();
    }

    private void updatePlayersTeamA() {
        
    }

    private void updatePlayersTeamB() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
