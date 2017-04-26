/**
 * Created by yyyura on 02/04/17.
 */

package models.golf;

import com.avaje.ebean.Model;
import models.users.User;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Entity
public class Handicap extends Model {

    @Id
    private int handID;

    @Constraints.Required
    private double handvalue;

//    @Constraints.Required
    private String category;

//    @Constraints.Required
    private int totalRoundsQty;

//    @Constraints.Required
    private Date date;

    //ONE Handicaps to ONE Member
    @OneToOne
    public User user_h;

    public Handicap() {
    }

    public Handicap(int handID, double handValue, String category, int totalRoundsQty, Date date) {
        this.handID = handID;
        this.handvalue = handValue;
        this.category = category;
        this.totalRoundsQty = totalRoundsQty;
        this.date = date;
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long, Handicap> find = new Finder<Long, Handicap>(Long.class, Handicap.class);

    //Find all Handicap in the database
    public static List<Handicap> findAll() {
        return Handicap.find.all();
    }


    public double calcHandicap() {
        double handicap = 0;



        return handicap;
    }




    //Getters & Setters


    public User getUser_h() {
        return user_h;
    }

    public void setUser_h(User user_h) {
        this.user_h = user_h;
    }

    public int getHandID() {
        return handID;
    }

    public void setHandID(int handID) {
        this.handID = handID;
    }

    public double getHandvalue() {
        return handvalue;
    }

    public void setHandvalue(double handvalue) {
        this.handvalue = handvalue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalRoundsQty() {
        return totalRoundsQty;
    }

    public void setTotalRoundsQty(int totalRoundsQty) {
        this.totalRoundsQty = totalRoundsQty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    //!Getters & Setters

}
