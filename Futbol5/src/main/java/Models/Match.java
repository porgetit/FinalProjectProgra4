/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Kevin Esguerra Cardona
 */
public class Match {
    private final Team teamA;
    private final Team teamB;

    public Match(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void run() {
        int lottery = new Random().nextInt(0,3);
        
        switch (lottery) {
            case 0 -> {
                teamA.addVictory();
                teamB.addDefeat();
            }
            case 1 -> {
                teamA.addDefeat();
                teamB.addVictory();
            }
            case 2 -> {
                teamA.addTie();
                teamB.addTie();
            }
        }
    }

    public ArrayList<Player> retrievePlayerData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
