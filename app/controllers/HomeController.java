package controllers;

import models.*;
import play.mvc.*;
import views.html.*;
// Import required classes
import java.util.ArrayList;
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

        //Get the list of products using Product.findAll()
        List<Product> products_l = Product.findAll();

        // Pass the list of products to the index view and render
        return ok(index.render(products_l));
    }
}
