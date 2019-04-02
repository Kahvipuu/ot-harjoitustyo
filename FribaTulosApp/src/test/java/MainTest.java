/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FribaTulosApp.Course;
import FribaTulosApp.Player;
import FribaTulosApp.RoundOfPlay;
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
public class MainTest {

    public MainTest() {
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
        assertEquals("MrNobody", this.player.getNimi());
    }



    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
