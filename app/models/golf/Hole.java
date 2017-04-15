/**
 * Created by yyyura on 02/04/17.
 */

package models.golf;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Hole extends Model {

    @Id
    private int hID;

    @Constraints.Required
    private int hNumber;

    @Constraints.Required
    private int hPar;

    @Constraints.Required
    private int diffIndex;

    @Constraints.Required
    private int score;

    @ManyToOne
    public Course course_o;

    public Hole() {
    }




    public Hole(int hID, int hNumber, int hPar, int diffIndex, int score) {
        this.hID = hID;
        this.hNumber = hNumber;
        this.hPar = hPar;
        this.diffIndex = diffIndex;
        this.score = score;
    }


    //Generic query helper for entity Computer with id Long
    public static Finder<Long, Hole> find = new Finder<Long, Hole>(Long.class, Hole.class);

    //Find all Holes in the database
    public static List<Hole> findAll() {
        return Hole.find.all();
    }


    //Getters & Setters


    public Long getCourseID() {
        return course_o.getcID();
    }

    public int gethID() {
        return hID;
    }

    public void sethID(int hID) {
        this.hID = hID;
    }

    public int gethNumber() {
        return hNumber;
    }

    public void sethNumber(int hNumber) {
        this.hNumber = hNumber;
    }

    public int gethPar() {
        return hPar;
    }

    public void sethPar(int hPar) {
        this.hPar = hPar;
    }

    public int getDiffIndex() {
        return diffIndex;
    }

    public void setDiffIndex(int diffIndex) {
        this.diffIndex = diffIndex;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    //!Getters & Setters

}
