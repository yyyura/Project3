package controllers;

import models.golf.HoleTest;
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
    public Result holesC() {

        //Get the list of products using HoleTest.findAll()
        List<HoleTest> products_l = HoleTest.findAll();

        // Pass the list of products to the diffindex view and render
        return ok(holesV.render(products_l));
    }
}
