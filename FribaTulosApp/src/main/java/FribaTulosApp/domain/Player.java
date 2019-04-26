package fribatulosapp.domain;

// Guest/User jako tulevaisuudessa ehkä, (implements Player)
// Toistaiseksi toteutus niin että pelaajat luodaan ja ovat sitten kaikilla käytössä

/**
 * Olioluokka pelaajalle
 */
public class Player {

    String name;
    int password; //joo salasana pois, ei toteuteta tähän versioon.. saattoi tarvita jonkun muun "tunnuksen"??

    public Player(String name) {
        this.name = name;

    }

    public Player(String name, int password) {
        this.name = name;
        this.password = password; //mikäköhän tästä piti tulla?? oli tunnus
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object player){
        if (!(player instanceof Player)){
            return false;
        }
        Player toTest = (Player) player;
        return this.name.equals(toTest.name);
    }
    
}
