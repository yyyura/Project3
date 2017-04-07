package controllers;

import models.golf.HoleTest;
import play.mvc.*;
import views.html.*;
// Import required classes
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {

        //Get the list of products using HoleTest.findAll()
        List<HoleTest> products_l = HoleTest.findAll();

        // Pass the list of products to the diffindex view and render
        return ok(index.render(products_l));
    }
}
