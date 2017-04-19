package models.golf;

import com.avaje.ebean.Model;
import models.users.Member;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;


/**
 * Created by yyyura on 18/04/17.
 * A golfer's net score is determined by subtracting the player's handicap
 * from the gross score (the number of strokes actually taken).
 * The net scores of all the competing golfers are compared
 * and (generally) the person with the lowest score wins.
 */

/**
 * The meaning of CascadeType.ALL is that the persistence will propagate (cascade) all EntityManager operations
 * (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities.
 * <p>
 * CascadeType.PERSIST: When persisting an entity, also persist the entities held in this field.
 * We suggest liberal application of this cascade rule,
 * because if the EntityManager finds a field that references a new entity during flush,
 * and the field does not use CascadeType.PERSIST, it is an error.
 * CascadeType.REMOVE: When deleting an entity, also delete the entities held in this field.
 * CascadeType.REFRESH: When refreshing an entity, also refresh the entities held in this field.
 * CascadeType.MERGE: When merging entity state, also merge the entities held in this field.
 */

@Entity
public class Round extends Model {

    @Id
    private Long rID;

    //MANY Rounds to ONE Course
    @ManyToOne
    private Course course_r;

    //MANY Rounds to ONE User
    @ManyToOne
    private Member member_r;

    //total strokes for playing all Holes on one course
    private double grossScore;

    //subtracting the player's handicap from the grossScore
    private double netScore;

    //private Date roundDate;


}

