package models.Hole;

/**
 * Created by awhit on 3/31/2017.
 */
public class Hole {
    private int holeNumber;
    private int par;
    private int index;      //the difficulty of the hole, rated from 1-18 (1 being the easiest hole on the course)
    private int shots;      //the amount of shots the user took on this hole

    public Hole(int holeNumber, int par, int index) {
        this.holeNumber = holeNumber;
        this.par = par;
        this.index = index;
        this.shots = 0;
    }

    public void setShots(int shots){
        this.shots = shots;
    }
}
