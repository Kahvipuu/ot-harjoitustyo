package fribatulosapp.domain;

import java.util.ArrayList;

/**
 * Olioluokka radalle
 */
public class Course {

    private String name;
    private int numberOfHoles;
    private int coursePar;

    public Course(String name) {
        this.name = name;
        int defaultHoleAmount = 9;
        this.numberOfHoles = defaultHoleAmount;
    }

    public Course(String name, int holes) {
        this.name = name;
        this.numberOfHoles = holes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfHoles(int numberOfHoles) {
        this.numberOfHoles = numberOfHoles;
    }

    public void setCoursePar(int coursePar) {
        this.coursePar = coursePar;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfHoles() {
        return numberOfHoles;
    }

    public int getCoursePar() {
        return coursePar;
    }

}
