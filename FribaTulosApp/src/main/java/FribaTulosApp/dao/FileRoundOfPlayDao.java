package FribaTulosApp.dao;

import fribatulosapp.domain.Course;
import fribatulosapp.domain.Player;
import fribatulosapp.domain.RoundOfPlay;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class FileRoundOfPlayDao implements ROPDao {

    private List<RoundOfPlay> roplist;
    private String file;
    //ja jostain syystä ei tunnista playerDaoa.. eli pitäisi kaikki pakettien nimiin viittaava käsin vaihtaa lowercaseksi..

    public FileRoundOfPlayDao(String file, CourseDao courseDao, PlayerDao playerDao) throws IOException { //Edelleen toisteista koodia
        roplist = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int ordinal = Integer.parseInt(parts[0]);
                Course c = courseDao.findByCourseName(parts[1]);
                RoundOfPlay rop = new RoundOfPlay(c, ordinal);  //lisäilyn jälkeen olisi muutettavaa
                roplist.add(rop);
                addPlayerScoresFromFile(parts, rop, playerDao);
            }
        } catch (Exception ex) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    private void addPlayerScoresFromFile(String[] parts, RoundOfPlay rop, PlayerDao playerDao) {
        for (int x = 2; x < parts.length; x++) {
            String[] playerscore = parts[x].split(",");
            Player p = playerDao.findByPlayerName(playerscore[0]);
            for (int z = 1; z < playerscore.length; z++) {
                rop.addResult(p, z, Integer.parseInt(playerscore[z]));
            }
        }
    }

    /**
     * Kierroksen tietojen tallentaminen.
     *
     * @throws Exception
     */
    @Override
    public void save() throws Exception { //testit
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (RoundOfPlay rop : roplist) {
                writer.write(rop.getIdNumber() + ";" + rop.getCourse().getName());
                ArrayList<Player> players = rop.getAllPlayers();
                for (Player p : players) {
                    writer.write(";" + p.getName());
                    int[] results = rop.getAllResult(p);
                    for (int i : results) {
                        writer.write("," + i);
                    }
                }
                writer.write("\n");
            }
        }
    }

    public int newRopId() {
        return roplist.size() + 1;
    }

    @Override
    public RoundOfPlay create(RoundOfPlay rop) throws Exception {
        rop.setIdNumber(newRopId());
        roplist.add(rop);
        save();
        return rop;
    }

    @Override
    public RoundOfPlay findByROPNumber(int i) {
        RoundOfPlay toReturn = null;
        for (RoundOfPlay rop : roplist) {
            if (rop.getIdNumber() == i) {
                toReturn = rop;
            }
        }
        return toReturn;
    }

    @Override
    public List<RoundOfPlay> getAll() {
        return roplist;
    }

}
