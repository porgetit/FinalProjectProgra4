package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Esguerra Cardona
 */
public class Team {
    private List<Player> players;
    private int victories;
    private int defeats;
    private int ties;

    public Team() {
        this.players = new ArrayList<>();
        this.victories = 0;
        this.defeats = 0;
        this.ties = 0;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getVictories() {
        return victories;
    }
    
    public void addVictory() {
        victories += 1;
    }

    public int getDefeats() {
        return defeats;
    }
    
    public void addDefeat() {
        defeats += 1;
    }

    public int getTies() {
        return ties;
    }
    
    public void addTie() {
        ties += 1;
    }

    public void addPlayer(Player player) {
        if (players.size() <= 5) {
            players.add(player);
            return;
        }
        throw new IndexOutOfBoundsException("You cannot add more than 5 players to the same team");
    }

    public void removePlayer(Player player) {
        if (!players.isEmpty()) {
            players.remove(player);
            return;
        }
        throw new IndexOutOfBoundsException("You cannot remove players from an empty team");
    }
}
