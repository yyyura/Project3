package models.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// This is a User of type admin
@DiscriminatorValue("admin")

// Administrator inherits from the User class
public class Admin extends User {

    public Admin(Long id, String loginname, String name, String email, String password) {
        super(id, loginname, name, email, password);
    }
} 