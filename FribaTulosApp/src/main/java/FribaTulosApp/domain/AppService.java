package fribatulosapp.domain;

import FribaTulosApp.dao.CourseDao;
import FribaTulosApp.dao.ROPDao;
import FribaTulosApp.dao.PlayerDao;
import java.util.List;

/**
 * Sovelluslogiikasta vastaava luokka
 */
public class AppService {

    private PlayerDao playerDao;
    private CourseDao courseDao; //tänne kaikki ratojen tallennukset jne.. sama kuin player
    private ROPDao rOPDao; //kierrokselle oma dao ja tänne se.. pejaajat ja radat pysyviä.. kierrosta ei tarvitse säilyttää.. mutta tulokset talteen jonnekin..
    private RoundOfPlay currentROP;

    public AppService(PlayerDao pD, CourseDao cD, ROPDao rD) { //Muista lisäillä muut Daot kun ne saat tehtyä
        this.playerDao = pD;
        this.courseDao = cD;
        this.rOPDao = rD;
        this.currentROP = null;
    }

    /**
     * Uuden pelaajan luominen ohjelmaan
     *
     * @param name Luotavan pelaajan nimi
     * @return true jos kaikki meni oikein, muuten palauttaa false
     */
    public boolean createPlayer(String name) {
        Player p = new Player(name);
        try {
            playerDao.create(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Uuden radan luominen ohjelmaan
     *
     * @param name Luotavan radan nimi
     * @return true jos onnistui, muuten false
     */
    public boolean createCourse(String name, int holes) {
        Course c = new Course(name, holes);
        try {
            courseDao.create(c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Uuden kierroksen luominen
     *
     * @param course Kierroksella käytettävä rata
     * @return
     */
    public boolean createROP(Course course) { //ehkä suoraan Rata luonnissa, sitten pelaajat mukaan
        RoundOfPlay rop = new RoundOfPlay(course, -1);
        try {
            rOPDao.create(rop);
            this.currentROP = rop;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Pelaajien lisääminen kierrokselle
     *
     * @param p lisättävä pelaaja
     * @return true jos onnistui, muuten false
     */
    public boolean addPlayerToROP(Player p) throws Exception { //pelaajan lisääminen kierrokselle
        try {
            this.currentROP.addPlayer(p);
        } catch (Exception e) {
            return false;
        }
        rOPDao.save();
        return true;
    }

    /**
     * Palauttaa listan kierroksen pelaajista
     *
     * @return Lista kierrokselle lisätyistä pelaajista
     */
    public List<Player> getPlayersOnROP() {
        return currentROP.getAllPlayers(); //pi
    }

    public List<Player> getAllPlayers() {
        return playerDao.getAll();
    }

    public List<Course> getAllCourses() {
        return courseDao.getAll();
    }

    public Course getCourseByName(String name) {
        return courseDao.findByCourseName(name);
    }

    public Player getPlayerByName(String name) {
        return playerDao.findByPlayerName(name);
    }

    public String getCurrentCourseName() {
        return this.currentROP.getCourse().getName();
    }

    public void addResultForPlayer(String name, int holeNumber, int result) {
        currentROP.addResult(playerDao.findByPlayerName(name), holeNumber, result);
    }

    /**
     * Palauttaa tämänhetkisen kierroksen väylien lukumäärän
     *
     * @return
     */
    public int getNumberOfHoles() {
        return currentROP.getCourse().getNumberOfHoles();
    }

    /**
     * Sulkee kierroksen ja tallentaa tulokset
     *
     * @param c Loppuun pelattu ja suljettava kierros
     */
    public void closeROP() throws Exception {
        rOPDao.save();
        this.currentROP = null;
    }

}
