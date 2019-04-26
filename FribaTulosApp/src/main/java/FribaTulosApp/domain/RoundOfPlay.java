package fribatulosapp.domain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Luokka kierrokselle
 */

public class RoundOfPlay {

    Course course;
    HashMap<Player, int[]> players;

    public RoundOfPlay(Course course) {
        this.course = course;
        this.players = new HashMap<>();
    }

    
    /**
     * Pelaajan lisääminen kierrokselle
     * @param player Kierrokselle lisättävä pelaaja
     */
    public void addPlayer(Player player) {
        this.players.putIfAbsent(player, new int[course.getNumberOfHoles()]);
    }

    
    /**
     * Tuloksen lisääminen kierroksella olevalle pelaajalle
     * @param player Pelaaja jolle tulos lisätään
     * @param holeNumber Väylän numero
     * @param result Pelaajan heittojen määrä
     */
    public void addResult(Player player, int holeNumber, int result) {
        this.players.get(player)[holeNumber] = result;
    }

    public Course getCourse() {
        return course;
    }

    public Player getPlayer(String name) {
        for (Player player : players.keySet()) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;    //saattaa joutua muokkaamaan
    }

    public int getResult(Player player, int hole) {
        return players.get(player)[hole];
    }

}
