package models.users;
import controllers.security.CalcSHA;

// Login class 'backs' the login form
public class Login {

    public String loginname;
    public String password;

    // Validate method - invoked during error checking
    // after form based on a Login object has been submitted
    public String validate() {

        CalcSHA cs = new CalcSHA();
        String md = cs.calcPassword(this.password);
        this.password = md;

        // Call the static authenticate method in User
        if (User.authenticate(loginname, password) == null) {
            return "Invalid user or password";
        } else {
            return null;
        }
    }
}

