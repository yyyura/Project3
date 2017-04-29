package controllers.security;

import models.golf.Handicap;
import models.users.Member;
import models.users.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


import java.util.ArrayList;
import java.util.List;

// Import required classes
// http://superuser.com/questions/163818/how-to-install-rmagick-on-ubuntu-10-04
// http://im4java.sourceforge.net/
// Import models

public class RegisterCtrl extends Controller {

    // Display an empty form in the view
    public Result register() {
        // Instantiate a form object based on the User class
        Form<User> registerForm = Form.form(User.class);
        // Render the Add User View, passing the form object
        return ok(register.render(User.getLoggedIn(session().get("userID")), registerForm));   //, User.getLoggedIn(session().get("userName")))
    }//!register

    // Handle the form data when a new user is submitted
    public Result registerFormSubmit() {

        Form<User> newRegisterForm = Form.form(User.class).bindFromRequest();

        // Check for errors (based on Product class annotations)
        if (newRegisterForm.hasErrors()) {
            //Display the form again
            return badRequest(register.render(User.getLoggedIn(session().get("userID")), newRegisterForm));
        }


        else if (loginnameUsed(newRegisterForm.get().loginname) == true) {
            flash("error", "Login name already exists please try another name.");
            return badRequest(register.render(User.getLoggedIn(session().get("userID")), newRegisterForm));
        }

        else {
            User member_o = newRegisterForm.get();

//            CalcSHA cs = new CalcSHA();
//            String md = cs.calcPassword(member_o.password);
//            member_o.password = md;

            Member m1 = new Member(member_o);
            m1.save();



//            Handicap handicap = new Handicap(6.3, newRegisterForm.get());
//            handicap.save();


        }
        return redirect("/login");
    }//!registerFormSubmit




    //Check if login name is taken
    public boolean loginnameUsed(String name) {
        boolean taken = false;
        List<User> users_l = User.findAll();
        for (int i = 0; i < users_l.size(); i++) {
            if (users_l.get(i).loginname.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    //assign a null team to a user
//    public Long assignTeam(User manager) {
//        Long output = null;
//        ArrayList<Team> teams = new ArrayList();
//        for (Team t : Team.<Team>findAll()) {
//            if (t.getUserID() == null) {
//                teams.add(t);
//                teams.get(0).setUserID(manager.getid());
//                teams.get(0).update();
//                return teams.get(0).getTeamID();
//
//            }
//        }
//
//
//        return output;
//
//    }

}
