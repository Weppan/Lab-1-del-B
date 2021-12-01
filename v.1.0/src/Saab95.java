import java.awt.*;

/** Creates objects that are Saab95.
 * @author madel
 * */
public class Saab95 extends Car{

    private boolean turboOn;

    /** Creates a Saab95.*/
    public Saab95(){
        super(2,125, Color.red, "Saab95", 1_495, 0,0,0);
	    turboOn = false;
    }

    /** Answers if turbo is turned on for Saab95.
     * @return boolean. true if turned on, false if turned off
     * */
    public boolean getTurboOn(){
        return turboOn;
    }

    /** Turns the turbo on for Saab95.*/
    public void setTurboOn(){
	    turboOn = true;
    }

    /** Turns the turbo off for Saab95.*/
    public void setTurboOff(){
	    turboOn = false;
    }

    /** Calculates the speed factor for Saab95.
     * @return double a speed factor
     * */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }




}
