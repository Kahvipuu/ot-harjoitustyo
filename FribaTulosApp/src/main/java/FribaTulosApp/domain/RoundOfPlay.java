package fribatulosapp.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class RoundOfPlay {

    Course course;
    HashMap<Player, int[]> players;

    public RoundOfPlay(Course course) {
        this.course = course;
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

}
