package models.golf;

import com.avaje.ebean.Model;
import models.users.Member;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private Long rID;

    //MANY Rounds to ONE Course
    @ManyToOne
    private Course course_r;

    //MANY Rounds to ONE User
    @ManyToOne
    private Member member_r;

    //total strokes for playing all Holes on one course
    private int grossScore;

    //subtracting the player's handicap from the grossScore
    private int netScore;

    private double handicap;

    private Date roundDate;


    //Generic query helper for entity Computer with id Long
    public static Finder<Long, Round> find = new Finder<Long, Round>(Long.class, Round.class);

    //Find all Holes in the database
    public static List<Round> findAll() {
        return Round.find.all();
    }

    public Round(Long rID, Course course_r, Member member_r, int grossScore, int netScore, double handicap, Date roundDate) {
        this.rID = rID;
        this.course_r = course_r;
        this.member_r = member_r;
        this.grossScore = grossScore;
        this.netScore = netScore;
        this.handicap = handicap;
        this.roundDate = roundDate;
    }

    public void setGrossScore() {
        int totalScore = 0;

        for (Hole i : course_r.holes_l) {

            //if (course_r.getcID())
            totalScore += i.getScore();
        }
        this.grossScore = totalScore;
    }

    public int calcGrossScore() {

        int totalScore = 0;

        for (Hole i : course_r.holes_l) {

            //if (course_r.getcID())
            totalScore += i.getScore();
        }
        return totalScore;
    }



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

    public Member getMember_r() {
        return member_r;
    }

    public void setMember_r(Member member_r) {
        this.member_r = member_r;
    }


    public int getGrossScore() {
        return grossScore;
    }

    public void setGrossScore(int grossScore) {
        this.grossScore = grossScore;
    }

    public int getNetScore() {
        return netScore;
    }

    public void setNetScore(int netScore) {
        this.netScore = netScore;
    }

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

