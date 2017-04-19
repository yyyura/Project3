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

//    @Constraints.Required
    private String category;

//    @Constraints.Required
    private int totalRoundsQty;

//    @Constraints.Required
    private Date date;

    //MANY Handicaps to ONE Member
    @ManyToOne
    public Member member_o;

    public Handicap() {
    }

    public Handicap(int handID, double handValue, String category, int totalRoundsQty, Date date) {
        this.handID = handID;
        this.handValue = handValue;
        this.category = category;
        this.totalRoundsQty = totalRoundsQty;
        this.date = date;
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long, Handicap> find = new Finder<Long, Handicap>(Long.class, Handicap.class);

    //Find all Holes in the database
    public static List<Handicap> findAll() {
        return Handicap.find.all();
    }


    public double calcHandicap() {
        double handicap = 0;



        return handicap;
    }




    //Getters & Setters
    public Member getMember_o() {
        return member_o;
    }

    public void setMember_o(Member member_o) {
        this.member_o = member_o;
    }

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
