package controllers;

import controllers.security.Secured;
import controllers.security.CheckIfMember;
import models.golf.HoleTest;
import models.users.User;
import play.mvc.*;
import views.html.memberViews.holesV;

// Import required classes
import java.util.List;

// Import required classes

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class MemberCtrl extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Security.Authenticated(Secured.class)
    @With(CheckIfMember.class)
    public Result holesC() {

        //Get the list of holes using HoleTest.findAll()
        List<HoleTest> holes_l = HoleTest.findAll();

        // Pass the list of products to the diffindex view and render
//        return ok(holesV.render(holes_l));
        return ok(holesV.render(User.getLoggedIn(session().get("loginname")), holes_l));
    }
}
