package fribatulosapp.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class RoundOfPlay {

    Course course;
    HashMap<Player, int[]> players;

    public RoundOfPlay(Course course) {
        this.course = course;
        this.players = new HashMap<>();
    }

    public void addPlayer(Player player) {
        this.players.putIfAbsent(player, new int[course.getNumberOfHoles()]);
    }

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
