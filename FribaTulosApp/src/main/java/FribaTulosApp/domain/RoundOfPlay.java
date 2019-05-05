package fribatulosapp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Luokka kierrokselle
 */
public class RoundOfPlay {

    Course course;
    HashMap<Player, int[]> playersNScores;
    private int idNumber;

    public RoundOfPlay(Course course, int id) {
        this.course = course;
        this.playersNScores = new HashMap<>();
        this.idNumber = id;
    }

    /**
     * Pelaajan lisääminen kierrokselle
     *
     * @param player Kierrokselle lisättävä pelaaja
     */
    public void addPlayer(Player player) {
        this.playersNScores.putIfAbsent(player, new int[course.getNumberOfHoles()]);
    }

    /**
     * Tuloksen lisääminen kierroksella olevalle pelaajalle
     *
     * @param player Pelaaja jolle tulos lisätään
     * @param holeNumber Väylän numero
     * @param result Pelaajan heittojen määrä
     */
    public void addResult(Player player, int holeNumber, int result) {
        this.playersNScores.get(player)[holeNumber] = result;
    }

    public Course getCourse() {
        return course;
    }

    public Player getPlayer(String name) {
        for (Player player : playersNScores.keySet()) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;    //saattaa joutua muokkaamaan
    }

    public ArrayList<Player> getAllPlayers() {
        ArrayList<Player> toReturn = new ArrayList<>();
        for (Player p : playersNScores.keySet()) {
            toReturn.add(p);
        }
        return toReturn;
    }

    public int getOneResult(Player player, int hole) {
        return playersNScores.get(player)[hole];
    }

    public int[] getAllResult(Player p) {
        return playersNScores.get(p);
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int i) {
        this.idNumber = i;
    }

}
