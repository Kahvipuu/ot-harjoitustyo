/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FribaTulosApp.dao;

import fribatulosapp.domain.Course;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author parta
 */
public class FileCourseDao implements CourseDao { //Miksi tämä ymmärtää ilman koko pathia ja PlayerDao ei... 

    private List<Course> courses;
    private String file;

    public FileCourseDao(String file) throws IOException { //Käytännössä toisteista koodia, kun aivan sama kuin FilePlayerDaossa
        courses = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int holes = Integer.parseInt(parts[1]);
                Course c = new Course(parts[0], holes);  //Parien lisäilyn jälkeen olisi muutettava   
                courses.add(c);
            }
        } catch (Exception ex) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }

    }

    /**
     * Väylän tietojen tallentaminen. Metodia käytetään crate():n kautta
     *
     * @throws Exception
     */
    private void save() throws Exception { //tälle pitäisi tehdä testit, kun kuitenkin unohtaa muuttaa Coursen mukana
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Course c: courses){
                writer.write(c.getName() +";" +c.getNumberOfHoles());
            }
        }

        }

        /**
         * Uuden väylän tallentaminen olemassaolevien listaan
         *
         * @param c Tallennettava väylä
         * @return palauttaa tallennetun takaisin, tähän on varmasti joku hyvä
         * syy.. älä kysy
         * @throws Exception
         */
        @Override
        public Course create
        (Course c) throws Exception {
            courses.add(c);
            save();
            return c;
        }

        /**
         * Olemassaolevan väylän etsintä nimellä
         *
         * @param name Etsittävän väylän nimi
         * @return Palauttaa null jos väylää ei löydy, tai löydetyn väylän
         */
        @Override
        public Course findByCourseName
        (String name
        
            ) {
        Course toReturn = null;
            for (Course c : courses) {
                if (c.getName().equals(name)) {
                    toReturn = c;
                }
            }
            return toReturn;
        }

        /**
         * Palauttaa listan väylistä
         *
         * @return Lista väylista
         */
        @Override
        public List<Course> getAll
        
            () {
        return courses;
        }

    }
