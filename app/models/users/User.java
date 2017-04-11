package models.users;

import javax.persistence.*;

import play.data.validation.*;
import com.avaje.ebean.*;

//https://www.playframework.com/documentation/2.2.x/JavaGuide4

// Product entity managed by Ebean
@Entity
// specify mapped table name
@Table(name = "user")
// Map inherited classes to a single table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// Discriminator column used to define user type
@DiscriminatorColumn(name = "userType")
// This user type is user
@DiscriminatorValue("user")

public class User extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Constraints.Required
    public String loginname;

    @Constraints.Required
    public String username;

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String password;


    // Default constructor
    public User() {
    }

    // Constructor to initialise object
    public User(Long id, String loginname, String username, String email, String password) {
        this.id = id;
        this.loginname = loginname;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    //Generic query helper for entity User with unique id String
    public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);

    // Static method to authenticate based on username and password
    // Returns user object if found, otherwise NULL
    public static User authenticate(String loginname, String password) {
        // If found return the user object with matching username and password
        return find.where().eq("loginname", loginname).eq("password", password).findUnique();
    }

    // Check if a user is logged in (by id - email address)
    public static User getLoggedIn(String id) {
        if (id == null)
            return null;
        else
            // Find user by id and return object
            return find.byId(id);
    }

    // Get the user type - from the discriminator value
    // http://stackoverflow.com/questions/3005383/how-to-get-the-discriminatorvalue-at-run-time
    // http://stackoverflow.com/questions/541749/how-to-determine-an-objects-class-in-java
    @Transient
    public String getUserType() {
        DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);
        return val == null ? null : val.value();
    }

}
