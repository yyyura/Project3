package models.users;

import com.avaje.ebean.Model;
//import models.products.*;
//import models.shopping.*;

import javax.persistence.*;

@Entity
// Map inherited classes to a single table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// This is a User of type member
@DiscriminatorValue("member")

// Member inherits from the User class
public class Member extends User {

    public double handicap;
    public int numofrounds;

    public Member(Long id, String loginname, String name, String email, String password, double handicap, int numofrounds) {
        super(id, loginname, name, email, password);
        this.handicap = handicap;
        this.numofrounds = numofrounds;
    }

    //Generic query helper for entity User with unique id String
    public static Model.Finder<String, Member> find = new Model.Finder<String, Member>(Member.class);

    // Check if a user is logged in (by id - email address)
    public static Member getLoggedIn(String id) {
        if (id == null)
            return null;
        else
            // Find user by id and return object
            return find.byId(id);
    }
}