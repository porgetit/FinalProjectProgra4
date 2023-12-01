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
 * @author Kevin Esguerra Cardona
 */
public class MainViewController implements ActionListener{
    private final MainView view;
    private final Match match;
    private boolean isTeamAComplete;
    private boolean isTeamBComplete;

    public MainViewController(Match match) {
        view = new MainView();
        this.match = match;
        isTeamAComplete = false;
        isTeamBComplete = false;
        
        view.ButtonPlayers.addActionListener(this);
        view.ButtonTeams.addActionListener(this);
        view.ButtonMatch.addActionListener(this);
        view.ButtonExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        
        if (button == view.ButtonPlayers) {
            new PlayerManagementViewController(match).init();
        } else if (button == view.ButtonTeams) {
            new TeamManagementViewController(match).init();
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
        
        view.TeamAPlayer1.setText("");
        view.TeamAPlayer2.setText("");
        view.TeamAPlayer3.setText("");
        view.TeamAPlayer4.setText("");
        view.TeamAPlayer5.setText("");
        view.TeamBPlayer1.setText("");
        view.TeamBPlayer2.setText("");
        view.TeamBPlayer3.setText("");
        view.TeamBPlayer4.setText("");
        view.TeamBPlayer5.setText("");
        
        updateResults();
        updatePlayers();
        
        isAbleToRun();
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
        isAbleToRun();
    }

    private void updatePlayersTeamA() {
        try {
            view.TeamAPlayer1.setText(match.getTeamA().getPlayers().get(0).getName());
            view.TeamAPlayer2.setText(match.getTeamA().getPlayers().get(1).getName());
            view.TeamAPlayer3.setText(match.getTeamA().getPlayers().get(2).getName());
            view.TeamAPlayer4.setText(match.getTeamA().getPlayers().get(3).getName());
            view.TeamAPlayer5.setText(match.getTeamA().getPlayers().get(4).getName());
            isTeamAComplete = true;            
        } catch (IndexOutOfBoundsException e) {
            isTeamAComplete = false;
        }
    }

    private void updatePlayersTeamB() {
        try {
            view.TeamBPlayer1.setText(match.getTeamB().getPlayers().get(0).getName());
            view.TeamBPlayer2.setText(match.getTeamB().getPlayers().get(1).getName());
            view.TeamBPlayer3.setText(match.getTeamB().getPlayers().get(2).getName());
            view.TeamBPlayer4.setText(match.getTeamB().getPlayers().get(3).getName());
            view.TeamBPlayer5.setText(match.getTeamB().getPlayers().get(4).getName());
            isTeamBComplete = true;
        } catch (IndexOutOfBoundsException e) {
            isTeamBComplete = false;
        }
    }

    private void isAbleToRun() {
        if (isTeamAComplete && isTeamBComplete) {
            view.ButtonMatch.setEnabled(true);
            return;
        }
        
        view.ButtonMatch.setEnabled(false);
    }
}
