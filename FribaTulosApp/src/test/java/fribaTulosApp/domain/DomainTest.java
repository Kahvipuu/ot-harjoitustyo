package fribaTulosApp.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import fribatulosapp.domain.Course;
import fribatulosapp.domain.Player;
import fribatulosapp.domain.RoundOfPlay;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author parta
 */
public class DomainTest {

    public DomainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    Player player;
    Course course;
    RoundOfPlay rop;

    @Before
    public void setUp() {
        this.player = new Player("MrNobody");
        this.course = new Course("test", 18);
        this.rop = new RoundOfPlay(course);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void creatingPlayer() {
        assertEquals("MrNobody", this.player.getName());
    }

    @Test
    public void creatingCourse() {
        assertEquals(18, this.course.getNumberOfHoles());
        assertEquals("test", this.course.getName());

    }

    @Test
    public void creatingROP() {
        assertEquals(course, this.rop.getCourse());  //milläköhän tämä testaa equalsin??
    }

    @Test
    public void addPlayerToROP() {
        this.rop.addPlayer(this.player);
        assertEquals(player, rop.getPlayer("MrNobody"));  //equals pitää laittaa kuntoon.... hätäinen string assert
    }

    @Test
    public void addResult() {
        this.rop.addPlayer(player);
        this.rop.addResult(player, 1, 5);
        this.rop.addResult(player, 1, 3);
        this.rop.addResult(player, 2, 4);
        assertEquals(3, rop.getResult(player, 1));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
