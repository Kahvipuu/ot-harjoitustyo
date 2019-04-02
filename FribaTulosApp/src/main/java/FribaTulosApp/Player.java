package FribaTulosApp;

// Guest/User jako tulevaisuudessa ehkä, (implements Player)
public class Player {

    String nimi;
    int tunnus;
    
    public Player(String nimi) {
        this.nimi = nimi;

    }

    public Player(String nimi, int tunnus) {
        this.nimi = nimi;
        this.tunnus = tunnus;
    }    
    
    public String getNimi() {
        return this.nimi;
    }

    public void setNImi(String nimi) {
        this.nimi = nimi;
    }

}
