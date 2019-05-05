package fribatulosapp.domain;

// Guest/User jako tulevaisuudessa ehkä, (implements Player)
// Toistaiseksi toteutus niin että pelaajat luodaan ja ovat sitten kaikilla käytössä
/**
 * Olioluokka pelaajalle
 */
public class Player {

    String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object player) {
        if (!(player instanceof Player)) {
            return false;
        }
        Player toTest = (Player) player;
        return this.name.equals(toTest.name);
    }

}
