
package fribatulosapp.domain;

import fribatulosapp.dao.PlayerDao;
import java.util.List;


public class AppService {
    private PlayerDao playerDao;
    //private CourseDao CourseDao; //tänne kaikki ratojen tallennukset jne.. sama kuin player
    private List<Player> onRound; //menisikö ennemmin kierroksen Daoon sisälle
    //private ROPDao ROPDao; //kierrokselle oma dao ja tänne se.. pejaajat ja radat pysyviä.. kierrosta ei tarvitse säilyttää.. mutta tulokset talteen jonnekin..
    
    public AppService(PlayerDao pD){ //Muista lisäillä muut Daot kun ne saat tehtyä
        this.playerDao = pD;
    }
    
    public boolean createPlayer(String name){
        return false; //soon
    }

    public boolean createCourse(String name){
        return false; //sadasd
    }
    
    public boolean createROP(Course course){ //ehkä suoraan Rata luonnissa, sitten pelaajat mukaan
        return false; 
    }

    public boolean addPlayerToROP(Player p){ //pelaajan lisääminen kierrokselle
        return false;
    }
    
    public List<Player> getPlayersOnROP(){ //ehkä (Course c)
        return onRound; //pitääkö spesifioida kierros?? monta kerralla auki?
    }
    
    public void closeROP(Course c){
        // tallenna tiedot jonnekin ja sulje ROP
    }
    
}
