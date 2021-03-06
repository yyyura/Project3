package models.golf;

import com.avaje.ebean.Model;
import models.users.Member;
import models.users.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)//increment of the specified column(field)
    private Long rID;

    //MANY Rounds to ONE Course
    @ManyToOne
    private Course course_r;

    //MANY Rounds to ONE User
    @ManyToOne
    private User user_r;

    //total strokes for playing all Holes on one course
    private int grossScore;

    //subtracting the player's handicap from the grossScore
//    private int netScore;

    private double handicap;

    private Date roundDate;


    //Generic query helper for entity Computer with id Long
    public static Finder<Long, Round> find = new Finder<Long, Round>(Long.class, Round.class);

    //Find all Holes in the database
    public static List<Round> findAll() {
        return Round.find.all();
    }


    public Round(Course course_r, User user_r, int grossScore, double lastHandicap) {
        this.course_r = course_r;
        this.user_r = user_r;
        this.grossScore = grossScore;
        this.handicap = calcHandicap(lastHandicap, grossScore, course_r.getcPar());
        this.roundDate = new Date();
    }

//    public Round(Course course_r, User user_r, int grossScore, double handicap, Date roundDate) {
//        this.course_r = course_r;
//        this.user_r = user_r;
//        this.grossScore = grossScore;
////        this.netScore = netScore;
//        this.handicap = handicap;
//        this.roundDate = roundDate;
//    }


    //////////////

    //this method takes in the user's exact handicap, the gross score of their round, and the par of the course as parameters

    public static double calcHandicap(double exactHandicap, int grossScore, int par) {
//        double newHand;
        double roundedHC = Math.round(exactHandicap); //roundedHC is exactHandicap rounded to the nearest integer
        double netScore = grossScore - roundedHC;     //netScore is the grossScore after the roundedHC is applied
        double changeToHC;                            //this is what is what the handicap is modified by (it is calculated based on the user's score in the round)
        if (netScore > par) {
            exactHandicap += 0.1;
        } else if (netScore < par) {
            if (exactHandicap <= 28.0 && exactHandicap >= 18.0) {
                //category 3 handicap
                changeToHC = (par - netScore) * 0.3;
                exactHandicap -= changeToHC;
            } else if (exactHandicap < 18.0 && exactHandicap >= 10.0) {
                //category 2 handicap
                changeToHC = (par - netScore) * 0.2;
                exactHandicap -= changeToHC;
            } else if (exactHandicap < 10.0) {
                //category 1 handicap
                changeToHC = (par - netScore) * 0.1;
                exactHandicap -= changeToHC;
            }
        }

        return exactHandicap;
    }

    /////////////////


    //setter, getter

    public Long getrID() {
        return rID;
    }

    public void setrID(Long rID) {
        this.rID = rID;
    }

    public Course getCourse_r() {
        return course_r;
    }

    public void setCourse_r(Course course_r) {
        this.course_r = course_r;
    }

    public User getUser_r() {
        return user_r;
    }

    public void setUser_r(User user_r) {
        this.user_r = user_r;
    }

    public int getGrossScore() {
        return grossScore;
    }

    public void setGrossScore(int grossScore) {
        this.grossScore = grossScore;
    }

//    public int getNetScore() {
//        return netScore;
//    }
//
//    public void setNetScore(int netScore) {
//        this.netScore = netScore;
//    }

    public double getHandicap() {
        return handicap;
    }

    public void setHandicap(double handicap) {
        this.handicap = handicap;
    }

    public Date getRoundDate() {
        return roundDate;
    }

    public void setRoundDate(Date roundDate) {
        this.roundDate = roundDate;
    }


    //!setter, getter


}

