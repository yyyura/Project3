package models.users;

import com.avaje.ebean.Model;
import models.golf.Handicap;
import models.golf.Round;



import javax.persistence.*;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL)
    public List<Handicap> handicap_l;

    //ONE Member to MANY Rounds
//    @OneToMany(mappedBy = "user_r_id",cascade = CascadeType.ALL)
//    public List<Round> roundsM_l;


    //Generic query helper for entity User with unique id String
    public static Model.Finder<String, User> find = new Model.Finder<String, User>(User.class);


    // Check if a user is logged in (by id - loginname)
    public static User getLoggedIn(String id) {
        if (id == null)
            return null;
        else
            // Find user by id and return object
            return find.byId(id);
    }


}