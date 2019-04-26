package FribaTulosApp.dao;

import fribatulosapp.domain.Player;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * Pelaajan tiedoista ja niiden tallentamisesta vastaava luokka
 */
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

    
    /**
     * Pejaajien tallentaminen tiedostoon
     * tätä metodia ei käytetä suoraan, käytä create metodia
     * @throws Exception 
     */
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Player p : players) {
                writer.write(p.getName() + "\n");
            }
        }
    }

    
    /**
     * Uuden pelaajan tallentaminen olemassaolevien pejaajien listaan.
     * @param p Tallennettava pelaaja
     * @return palauttaa annetun pejaajan takaisin
     * @throws Exception 
     */
    @Override
    public Player create(Player p) throws Exception { //Luomisen yhteydessä voidaan antaa pelaajalle tarvittavia arvoja.
        players.add(p);
        save();
        return p;
    }

    
    /**
     * Olemassaolevan pelaajan etsintä nimellä
     * @param name Etsittävän pelaajan nimi
     * @return Palauttaa null jos pelaajaa ei löydy, tai löydetyn pelaajan
     */
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

    /**
     * Palauttaa kaikki pelaajat
     * @return Lista pelaajista
     */
    @Override
    public List<Player> getAll() {
        return players;
    }

}
