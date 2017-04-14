package models.golf;

/**
 * Created by awhit on 3/31/2017.
 */
public class CourseClass{
    private String courseName;
    private HoleClass holes[];
    private int totalPar;

    public CourseClass(String courseName) {
        this.courseName = courseName;
        this.holes = new HoleClass[18];
        totalPar = 0;
    }

    public void setPar() {
        for (int i = 0; i < 18; i++) {
            totalPar += holes[i].getPar();
        }
    }
}
