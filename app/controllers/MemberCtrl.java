package controllers;

import controllers.security.Secured;
import controllers.security.CheckIfMember;
import models.golf.Course;
import models.golf.Handicap;
import models.golf.Hole;
import models.golf.Round;
import models.users.User;
import play.data.Form;
import play.mvc.*;
import views.html.memberViews.*;
//import views.html.memberViews.setHandicapV;

// Import required classes
import java.util.Date;
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


    public Result submitRoundC(Long courseID) {


        Date date = new Date();
        List<Hole> holeList = Hole.findAll();
        List<Course> courseList = Course.findAll();
        List<Round> roundList = Round.findAll();
        Course course = Course.find.byId(courseID);
        int grossScore = 0;

        for (Hole i : holeList) {
            if (i.getCourseID() == courseID) {
                grossScore += i.getScore();
            }
        }


//        User member_o = newRegisterForm.get();

        Round round = new Round(course, User.getLoggedIn(session().get("loginname")), grossScore, (grossScore - 72), (grossScore - 72), date);

        //    Round round = new Round(Round.find.nextId(), course, User.getLoggedIn(session().get("id")), grossScore, grossScore, 5, date);

//        Member m1 = new Member(member_o);
        round.save();


        return redirect("/listRounds");
//        return ok(roundV.render(User.getLoggedIn(session().get("loginname")), roundList));
    }


    public Result listRoundsC() {


        //Get the list of courses using Course.find.all();
        List<Round> roundList = Round.findAll();
        return ok(roundV.render(User.getLoggedIn(session().get("loginname")), roundList));
    }


    public Result listHandicapC() {


        //Get the list of courses using Course.find.all();
        List<Handicap> handicap_l = Handicap.findAll();


        return ok(handicapV.render(User.getLoggedIn(session().get("loginname")), handicap_l));
    }


    //set Handicap
    public Result setHandicapC() {

        // Instantiate a Form object based on the User class
        User currUser = User.getLoggedIn(session().get("userID"));
        Form<Handicap> inHandicapForm = Form.form(Handicap.class);//.fill(currUser);

        // Render the setHandicapV View, passing the Form object
        return ok(setHandicapV.render(currUser, inHandicapForm));

        //return redirect("/setHandicap");
    }

    public Result handicapFormSubmitC() { //Processes the set initial handicap form and saves the changes to the database

        User currUser = User.getLoggedIn(session().get("userID"));
        Form<Handicap> editHandicapForm = Form.form(Handicap.class).bindFromRequest();
        //Creates a list of Handicaps
        List<Handicap> handicap_l = Handicap.findAll();
        Handicap handicapF = editHandicapForm.get();
        if (editHandicapForm.hasErrors()) {
            return redirect("/setHandicap");
        }

        //User.getLoggedIn(session().get("loginname")).getId())
        //use loginname to get User of this session

        for (int i = 0; i < handicap_l.size(); i++) {
            if (handicap_l.get(i).getUser_h().getId() == User.getLoggedIn(session().get("loginname")).getId()) {
                handicap_l.get(i).setHandvalue(handicapF.getHandvalue());
                handicap_l.get(i).update();
            }
        }
        return redirect("/listHandicap");
    }//!submitEditHolesC


    // Handle the form data when a new user is submitted
//    public Result handicapFormSubmitC() {
//
//        Form<Handicap> editHandicapForm = Form.form(Handicap.class).bindFromRequest();
//        //Creates a list of Handicap
//
//
////        Handicap current;
////        current();
//        Handicap handicapF = editHandicapForm.get();
//        if (editHandicapForm.hasErrors()) {
//            return redirect("/setHandicap");
//        }
//
////        Handicap current;
////        current();
////        current.setHandValue(handicapF.getHandValue());
////        current.update();
//
//
//        return redirect("/");
//    }//!registerFormSubmit


    //!set Handicap


    //edit holes
    public Result editAllHolesC(Long holeID) {

        //Creates the list of holes using Hole.findAll()
        List<Hole> holes_l = Hole.findAll();

        for (int i = 0; i < holes_l.size(); i++) {
            if (holes_l.get(i).gethID() == holeID) {
                Form<Hole> editHoleForm = Form.form(Hole.class).fill(holes_l.get(i));
                return ok(editHoles.render(User.getLoggedIn(session().get("loginname")), editHoleForm, holes_l.get(i)));
            }
        }
        return redirect("/courses");
    }

    public Result submitEditHolesC(Long holeID) { //Processes the edit hole form and saves the changes to the database
        Form<Hole> editHoleForm = Form.form(Hole.class).bindFromRequest();
        //Creates a list of Holes
        List<Hole> holes_l = Hole.findAll();
        Hole hole = editHoleForm.get();
        if (editHoleForm.hasErrors()) {
            return redirect("/editAllHoles/" + holeID);
        }
        Long courseID = 0L;
        for (int i = 0; i < holes_l.size(); i++) {
            if (holes_l.get(i).gethID() == holeID) {
                holes_l.get(i).setScore(hole.getScore());
                courseID = holes_l.get(i).getCourseID();
                holes_l.get(i).update();
            }
        }
        return redirect("/oneCourse/" + courseID);
    }//!submitEditHolesC

    //!edit holes


    @Security.Authenticated(Secured.class)
    @With(CheckIfMember.class)
    public Result holesC() {

        //Creates the list of holes using Hole.findAll()
        List<Hole> holes_l = Hole.findAll();

        // Pass the list of holes to the holesV view and render
//        return ok(holesV.render(holes_l));
        return ok(holesV.render(User.getLoggedIn(session().get("loginname")), holes_l));
    }


    public Result coursesC() {
        //Get the list of courses using Course.find.all();
        List<Course> course_l = Course.findAll();
        return ok(courseV.render(User.getLoggedIn(session().get("loginname")), course_l));
    }

    //Insures user is member before allowing access
//    @Security.Authenticated(Secured.class)
    public Result oneCourseHolesC(Long courseID)//Renders a form based on the team selected by the member
    {
        List<Hole> holes_l = Hole.findAll();
//        Form<Hole> editHoleForm = Form.form(Hole.class).fill(holes_l.get(3));
        return ok(oneCourseHolesV.render(User.getLoggedIn(session().get("loginname")), holes_l, courseID));
    }


}


