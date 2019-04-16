package fribatulosapp.domain;

import java.util.ArrayList;

// ..ja ArrayListien käytön voisi jopa miettiä... muita vaihtoehtoja..
public class Course {

    private String name;
    private int numberOfHoles;
    private int coursePar;
    ArrayList<CourseHole> holes;

    public Course(String name) {
        this.holes = new ArrayList<>();
        this.name = name;
        int defaultHoleAmount = 6;
        this.numberOfHoles = defaultHoleAmount;
        for (int x = 0; x < defaultHoleAmount; x++) {
            this.addHole();
        }
    }

    public Course(String name, int holes) {
        this.holes = new ArrayList<>();
        this.name = name;
        this.numberOfHoles = holes;
        for (int x = 0; x < holes; x++) {
            this.addHole();
        }

    }

    public void addHole() {
        this.holes.add(new CourseHole());
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