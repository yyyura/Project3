/**
 * Created by yyyura on 02/04/17.
 */

package models.golf;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Hole extends Model {

    @Id
    public int id;

    @Constraints.Required
    public int holeNumber;

    @Constraints.Required
    public int par;

    @Constraints.Required
    public int diffindex;

    @Constraints.Required
    public int score;

    public Hole() {
    }

    public Hole(int id, int holeNumber, int par, int diffindex, int score) {
        this.id = id;
        this.holeNumber = holeNumber;
        this.par = par;
        this.diffindex = diffindex;
        this.score = score;
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long, Hole> find = new Finder<Long, Hole>(Long.class, Hole.class);

    //Find all Products in the database
    public static List<Hole> findAll() {
        return Hole.find.all();
    }


}
