package models.golf;


/**
 * Created by awhit on 3/31/2017.
 */
public class Course{
    private String courseName;
    private Hole holes[];
    private int totalPar;

    public Course(String courseName) {
        this.courseName = courseName;
        this.holes = new Hole[18];
        totalPar = 0;
    }

    public void setPar() {
        for (int i = 0; i < 18; i++) {
            totalPar += holes[i].par;
        }
    }
}
