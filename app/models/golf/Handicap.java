/**
 * Created by yyyura on 02/04/17.
 */

package models.golf;

import com.avaje.ebean.Model;
import models.users.Member;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Entity
public class Handicap extends Model {

    @Id
    private int handID;

    @Constraints.Required
    private double handValue;

    @Constraints.Required
    private String category;

    @Constraints.Required
    private int roundsQty;

    @Constraints.Required
    private Date date;//the amount of shots the user took on this hole

    //MANY Handicaps to ONE Member
    @ManyToOne
    public Member member_o;

    public Handicap() {
    }

    public Handicap(int handID, double handValue, String category, int roundsQty, Date date) {
        this.handID = handID;
        this.handValue = handValue;
        this.category = category;
        this.roundsQty = roundsQty;
        this.date = date;
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long, Handicap> find = new Finder<Long, Handicap>(Long.class, Handicap.class);

    //Find all Holes in the database
    public static List<Handicap> findAll() {
        return Handicap.find.all();
    }


    //Getters & Setters

    public int getHandID() {
        return handID;
    }

    public void setHandID(int handID) {
        this.handID = handID;
    }

    public double getHandValue() {
        return handValue;
    }

    public void setHandValue(double handValue) {
        this.handValue = handValue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRoundsQty() {
        return roundsQty;
    }

    public void setRoundsQty(int roundsQty) {
        this.roundsQty = roundsQty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    //!Getters & Setters

}
