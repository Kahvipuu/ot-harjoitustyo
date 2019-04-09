package FribaTulosApp;

// Guest/User jako tulevaisuudessa ehkä, (implements Player)
public class Player {

    String name;
    int password;
    
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

}
