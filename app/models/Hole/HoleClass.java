package models.Hole;

/**
 * Created by awhit on 3/31/2017.
 */
public class HoleClass {
    private int holeNumber;
    private int par;
    private int index;      //the difficulty of the hole, rated from 1-18 (1 being the easiest hole on the course)
    private int score;      //the amount of shots the user took on this hole

    public HoleClass(int holeNumber, int par, int index) {
        this.holeNumber = holeNumber;
        this.par = par;
        this.index = index;
        this.score = 0;
    }

    public int getPar() {
        return par;
    }

    public void setScore(int shots){
        this.score = shots;

    }

    public int getScore(){
        return score;
    }
}
