package models.golf;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * Created by yyyura on 18/04/17.
 * A golfer's net score is determined by subtracting the player's handicap
 * from the gross score (the number of strokes actually taken).
 * The net scores of all the competing golfers are compared
 * and (generally) the person with the lowest score wins.
 */

@Entity
public class Round extends Model{

    @Id
    private Long rID;

    //MANY Rounds to ONE Course
    @ManyToOne
    private Course course_r;

//    @Constraints.Required
//    private int roundsQty; //On One Course;



    private double grossScore;  //total strokes for playing all Holes on one course
    private double netScore;    //subtracting the player's handicap from the grossScore




}
