package fribatulosapp.domain;

import fribatulosapp.dao.PlayerDao;
import java.util.List;

/**
 * Sovelluslogiikasta vastaava luokka
 */
public class AppService {

    private PlayerDao playerDao;
    //private CourseDao CourseDao; //tänne kaikki ratojen tallennukset jne.. sama kuin player
    private List<Player> onRound; //menisikö ennemmin kierroksen Daoon sisälle
    //private ROPDao ROPDao; //kierrokselle oma dao ja tänne se.. pejaajat ja radat pysyviä.. kierrosta ei tarvitse säilyttää.. mutta tulokset talteen jonnekin..

    public AppService(PlayerDao pD) { //Muista lisäillä muut Daot kun ne saat tehtyä
        this.playerDao = pD;
    }

    /**
     * Uuden pelaajan luominen ohjelmaan
     *
     * @param name Luotavan pelaajan nimi
     * @return true jos kaikki meni oikein, muuten palauttaa false
     */
    public boolean createPlayer(String name) {
        return false; //soon
    }

    /**
     * Uuden radan luominen ohjelmaan
     *
     * @param name Luotavan radan nimi
     * @return true jos onnistui, muuten false
     */
    public boolean createCourse(String name) {
        return false; //sadasd
    }

    /**
     * Uuden kierroksen luominen
     *
     * @param course Kierroksella käytettävä rata
     * @return
     */
    public boolean createROP(Course course) { //ehkä suoraan Rata luonnissa, sitten pelaajat mukaan
        return false;
    }

    /**
     * Pelaajien lisääminen kierrokselle
     *
     * @param p lisättävä pelaaja
     * @return true jos onnistui, muuten false
     */
    public boolean addPlayerToROP(Player p) { //pelaajan lisääminen kierrokselle
        return false;
    }

    
    /**
     * Palauttaa listan kierroksen pelaajista
     * @return Lista kierrokselle lisätyistä pelaajista
     */
    public List<Player> getPlayersOnROP() { //ehkä (Course c)
        return onRound; //pitääkö spesifioida kierros?? monta kerralla auki?
    }

    /**
     * Sulkee annetun kierroksen ja tallentaa tulokset
     * 
     * @param c Loppuun pelattu ja suljettava kierros
     */
    
    public void closeROP(Course c) {
        // tallenna tiedot jonnekin ja sulje ROP
    }

}
