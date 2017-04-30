import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import models.golf.Round;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static models.golf.Round.calcHandicap;
import static play.test.Helpers.*;
import static org.junit.Assert.*;


/**
 *
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 *
 */
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

//    @Test
//    public void renderTemplate() {
//        Content html = views.html.index.render("Your new application is ready.");
//        assertEquals("text/html", html.contentType());
//        assertTrue(html.body().contains("Your new application is ready."));
//    }

    @Test
    public void testCalcHandicap(){
        double outHand;
        outHand = calcHandicap(6.3, 70, 72);
        assertEquals(5.5, outHand, 0.01);

//        assertEquals(5.5, outHand);
//        double roundOff = Math.round(outHand * 10.0) / 10.0;

    }
}
