package FribaTulosApp.dao;

import fribatulosapp.domain.Player;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilePlayerDao implements fribatulosapp.dao.PlayerDao { //miksiköhän täytyy koko path olla?

    private List<Player> players;
    private String file;

    public FilePlayerDao(String file) throws IOException {
        players = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String parts = reader.nextLine(); //pelaajalle täytynee lisäillä jotain kuitenkin -> String[]
                Player p = new Player(parts);
                players.add(p);
            }
        } catch (Exception ex) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Player p : players) {
                writer.write(p.getName() + "\n");
            }
        }
    }

    @Override
    public Player create(Player p) throws Exception {
        players.add(p);
        save();
        return p;
    }

    @Override
    public Player findByPlayerName(String name) {
        Player toReturn = null;
        for (Player p : players) {
            if (p.getName().equals(name)) {
                toReturn = p;
            }
        }
        return toReturn;
    }

    @Override
    public List<Player> getAll() {
        return players;
    }

}
