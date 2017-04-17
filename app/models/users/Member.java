package models.users;

import com.avaje.ebean.Model;
import models.golf.Handicap;
import scala.collection.immutable.List;


import javax.persistence.*;

@Entity
// Map inherited classes to a single table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// This is a User of type member
@DiscriminatorValue("member")

// Member inherits from the User class
public class Member extends User {
    public Member(String loginname, String username, String email, String password) {
        super(loginname, username, email, password);

    }



    public Member(User m) {
        super(m.loginname, m.username, m.email, m.password);
    }

    //ONE Member to MANY Handicaps
    @OneToMany
    public List<Handicap> handicap_l;


    //Generic query helper for entity User with unique id String
    public static Model.Finder<String, Member> find = new Model.Finder<String, Member>(Member.class);


    // Check if a user is logged in (by id - loginname)
    public static Member getLoggedIn(String id) {
        if (id == null)
            return null;
        else
            // Find user by id and return object
            return find.byId(id);
    }


}