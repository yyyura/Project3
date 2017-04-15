/**
 * Created by yyyura on 14/04/17.
 */

package models.golf;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;
import scala.collection.immutable.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Course extends Model {

    @Id
    private Long cID;

    @Constraints.Required
    private String cName;

    @Constraints.Required
    private int cPar;

    @OneToMany
    public List<Hole> holes_l;

    public Course(Long cID, String cName, int cPar) {
        this.cID = cID;
        this.cName = cName;
        this.cPar = cPar;
    }


    //Generic query helper with id Long
    public static Finder<Long, Course> find = new Finder<Long, Course>(Long.class, Course.class);

    //Find all Courses in the database
    public static java.util.List<Course> findAll() {
        return Course.find.all();
    }


    //Getters & Setters
    public Long getcID() {
        return cID;
    }

    public void setcID(Long cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcPar() {
        return cPar;
    }

    public void setcPar(int cPar) {
        this.cPar = cPar;
    }
    //!Getters & Setters

}
